import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberSeatingProblem {

    private int republicans =0;
    private int democrats =0;

    private Semaphore demsWaiting = new Semaphore(0);
    private Semaphore repubWaiting = new Semaphore(0);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    ReentrantLock lock = new ReentrantLock();

    void drive(){
        System.out.println("Uber Ride on Its wayyyy... with ride leader " + Thread.currentThread().getName());
        System.out.flush();
    }
    void seatDemocrat() throws InterruptedException, BrokenBarrierException {
        boolean rideLeader =  false;
        lock.lock();

        democrats++;
        if(democrats==4){
            demsWaiting.release(3);
            democrats-=4;
            rideLeader = true;
        } else if(democrats == 2 && republicans >=2){
            demsWaiting.release(1);
            repubWaiting.release(2);
            democrats-=2;
            republicans-=2;
            rideLeader =true;
        } else{
            lock.unlock();
            demsWaiting.acquire();
        }

        seated();
        cyclicBarrier.await();

        if(rideLeader){
            drive();
            lock.unlock();
        }
    }

    void seated(){
        System.out.println(Thread.currentThread().getName() + "  seated");
        System.out.flush();
    }
    void seatRepublican() throws InterruptedException, BrokenBarrierException {
        boolean rideLeader = false;
        lock.lock();
        republicans++;
        if(republicans==4){
            repubWaiting.release(3);
            republicans-=4;
            rideLeader = true;
        } else if(republicans==2 && democrats>=2){
            repubWaiting.release(1);
            demsWaiting.release(2);
            rideLeader= true;
            democrats-=2;
            republicans-=2;
        } else{
            lock.unlock();
            repubWaiting.acquire();
        }

        seated();
        cyclicBarrier.await();

        if(rideLeader){
            drive();
            lock.unlock();
        }
    }
}
