import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophersWithOrderingOfPickupOfFork {

    // This random variable is used for test purporses only
    private static Random random = new Random(System.currentTimeMillis());
    private Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophersWithOrderingOfPickupOfFork(){
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
    Ordering of fork pick-up
    ---------------------------

    Another solution is to make any one of the philosophers pick-up the left fork first instead of the right one.
    If this gentleman successfully acquires the left fork then, it implies:

    The philosopher sitting next to the left-handed gentleman can't acquire his right fork, so he's blocked from
    eating since he must first pick up the fork to the right of him (already held by the left-handed philosopher).
    The blocked philosopher's left fork is free to be picked up by another philosopher.

    The left-handed philosopher may acquire his right fork implying no deadlock since he already picked up his left
    fork first. Or if he's unable to acquire his right fork, then the gentleman previous to the left-handed philosopher
    in an anti-clockwise direction will necessarily have had acquired both his right and left forks and will eat.
    Again, not resulting in a deadlock.

    It doesn't matter which philosopher is chosen to be left-handed and made to pick up his left fork first
    instead of the right one since its a circle. In our solution, we select the philosopher with id=3 as the
    left-handed philosopher.
     */
    private void eat(int id) throws InterruptedException {

        // We randomly selected the philosopher with
        // id 3 as left-handed. All others must be
        // right-handed to avoid a deadlock.
        if(id==3){
            acquireForkLeftHanded(3);
        } else {
            acquireForkForRightHanded(id);
        }

        forks[id].acquire();
        forks[(id+1)%5].acquire();

        System.out.println("Philosopher " + id + " is eating");

        forks[id].release();
        forks[(id+1)%5].release();
    }

    void acquireForkForRightHanded(int id) throws InterruptedException {
        forks[id].acquire();
        forks[(id + 1) % 5].acquire();
    }

    // Left-handed philosopher picks the left fork first and then
    // the right one.
    void acquireForkLeftHanded(int id) throws InterruptedException {
        forks[(id + 1) % 5].acquire();
        forks[id].acquire();
    }

    private void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(500));
    }

}
