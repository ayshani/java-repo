package semaphore;

public class CountingSemaphore {

    int usedPermits, maxCount;

    public CountingSemaphore(int maxCount){
        this.maxCount =maxCount;
        this.usedPermits =0;
    }

    public CountingSemaphore(int maxCount, int initialPermits){
        this.maxCount =maxCount;
        this.usedPermits = this.maxCount -initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while(usedPermits == maxCount){
            wait();
        }
        notify();
        usedPermits++;
    }

    public synchronized void release() throws InterruptedException {
        while(usedPermits == 0){
            wait();
        }
        notify();
        usedPermits--;
    }

}
