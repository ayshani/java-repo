import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophersWithLimitingDiners {

    // This random variable is used for test purporses only
    private static Random random = new Random(System.currentTimeMillis());
    private Semaphore[] forks = new Semaphore[5];
    private Semaphore maxDiner = new Semaphore(4);

    public DiningPhilosophersWithLimitingDiners(){
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


    private void eat(int id) throws InterruptedException {
        // maxDiners allows only 4 philosphers to
        // attempt picking up forks.
        maxDiner.acquire();

        forks[id].acquire();
        forks[(id+1)%5].acquire();

        System.out.println("Philosopher " + id + " is eating");

        forks[id].release();
        forks[(id+1)%5].release();

        maxDiner.release();
    }

    private void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(500));
    }

    public static void startPhilosopher(DiningPhilosophersWithLimitingDiners dp, int id) throws InterruptedException {
        dp.lifeCycleOfPhilosopher(id);
    }

}
