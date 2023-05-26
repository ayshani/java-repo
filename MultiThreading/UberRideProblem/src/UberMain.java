import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

public class UberMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        final UberSeatingProblem uberSeatingProblem = new UberSeatingProblem();
        Set<Thread> allThreads = new HashSet<Thread>();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        uberSeatingProblem.seatDemocrat();
                    } catch (InterruptedException | BrokenBarrierException ie) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Democrat_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(50);
        }

        for (int i = 0; i < 14; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        uberSeatingProblem.seatRepublican();
                    } catch (InterruptedException | BrokenBarrierException ie) {
                        System.out.println("We have a problem");

                    }
                }
            });
            thread.setName("Republican_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(20);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }
}