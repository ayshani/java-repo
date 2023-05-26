public class DpMain {
    public static void main(String[] args) throws InterruptedException {

        final DiningPhilosophersWithLimitingDiners dp = new DiningPhilosophersWithLimitingDiners();

        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DiningPhilosophersWithLimitingDiners.startPhilosopher(dp,0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread p2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DiningPhilosophersWithLimitingDiners.startPhilosopher(dp,1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread p3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DiningPhilosophersWithLimitingDiners.startPhilosopher(dp,2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread p4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DiningPhilosophersWithLimitingDiners.startPhilosopher(dp,3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread p5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DiningPhilosophersWithLimitingDiners.startPhilosopher(dp,4);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
    }
}