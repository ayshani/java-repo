import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeferredCallbackExecutor {

    PriorityQueue<Callback> pq = new PriorityQueue<>((a,b) -> (int) (a.executeAt-b.executeAt));
    // Lock to guard critical sections
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition newCallackArrived = reentrantLock.newCondition();
    // Run by the Executor Thread
    public void start() throws InterruptedException {
        long sleepFor = 0;
        while(true){
            // lock the critical section
            reentrantLock.lock();

            // if no item in the queue, wait indefinitely for one to arrive
            while(pq.size()==0){
                newCallackArrived.await();
            }

            // loop till all callbacks have been executed
            while(pq.size()!=0){
                // find the minimum time execution thread should
                // sleep for before the next callback becomes due
                sleepFor = findSleepForDuration();

                // If the callback is due break from loop and start
                // executing the callback
                if(sleepFor<=0){
                    break;
                }

                // sleep until the earliest due callback can be executed
                newCallackArrived.await(sleepFor, TimeUnit.MILLISECONDS);
            }

            // Because we have a min-heap the first element of the queue
            // is necessarily the one which is due.
            Callback cb = pq.poll();
            System.out.println(
                    "Executed at " + System.currentTimeMillis() / 1000 + " required at " + cb.executeAt / 1000
                            + ": message:" + cb.message);

            // Don't forget to unlock the critical section
            reentrantLock.unlock();
        }
    }

    private long findSleepForDuration() {
        long currentTime = System.currentTimeMillis();
        return pq.peek().executeAt -currentTime;
    }

    // Called by Consumer Threads to register callback
    public void registerCallback(Callback callback){
        reentrantLock.lock();
        pq.offer(callback);
        newCallackArrived.signal();
        reentrantLock.unlock();
    }


}
