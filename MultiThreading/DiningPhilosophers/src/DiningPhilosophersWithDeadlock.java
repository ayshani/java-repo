import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophersWithDeadlock {

    // This random variable is used for test purporses only
    private static Random random = new Random(System.currentTimeMillis());
    private Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophersWithDeadlock(){
        for(int i=0;i<5;i++){
            forks[i] = new Semaphore(1);
        }
    }

    // Represents how a philosopher lives his life
    public void lifeCycleOfPhilosopher(int id) throws InterruptedException {
        while(true){
            contemplate();
            eat(id);
        }
    }

    /*
    If you run the above code eventually, it'll at some point end up in a deadlock.
    Realize if all the philosophers simultaneously grab their left fork, none would be able to eat.
     */
    private void eat(int id) throws InterruptedException {
        forks[id].acquire();
        forks[(id+1)%5].acquire();

        System.out.println("Philosopher " + id + " is eating");

        forks[id].release();
        forks[(id+1)%5].release();
    }

    private void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(500));
    }
}
