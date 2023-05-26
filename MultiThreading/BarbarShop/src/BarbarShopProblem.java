import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BarbarShopProblem {

    final int CHAIRS =3;
    int waitingCustomers =0;
    int hairCutsGiven = 0;
    ReentrantLock lock = new ReentrantLock();

    Semaphore waitForCustomerToEnter = new Semaphore(0);
    Semaphore waitForBarbarToGetReady = new Semaphore(0);
    Semaphore waitForBarbarToCutHair = new Semaphore(0);
    Semaphore waitForCustomerToLeave = new Semaphore(0);

    void customerWalkIn() throws InterruptedException {
        lock.lock();
        if(waitingCustomers==CHAIRS){
            System.out.println("Customer walks out, all chairs occupied.");
            lock.unlock();
            return;
        }

        waitingCustomers++;
        lock.unlock();

        waitForCustomerToEnter.release();
        waitForBarbarToGetReady.acquire();

        // The chair in the waiting area becomes available
        lock.lock();
        waitingCustomers--;
        lock.unlock();

        waitForBarbarToCutHair.acquire();
        waitForCustomerToLeave.release();


    }

    void barbar() throws InterruptedException {
        while(true){
            waitForCustomerToEnter.acquire();
            waitForBarbarToGetReady.release();
            hairCutsGiven++;
            System.out.println("Barber cutting hair..." + hairCutsGiven);
            Thread.sleep(50);
            waitForBarbarToCutHair.release();
            waitForCustomerToLeave.acquire();
        }
    }
}
