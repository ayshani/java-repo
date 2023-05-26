import java.util.HashSet;
import java.util.Set;

public class BarbarMain {
    public static void main(String[] args) throws InterruptedException {
        final BarbarShopProblem barbarShopProblem = new BarbarShopProblem();

        Thread barbar = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barbarShopProblem.barbar();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        barbar.start();

        Set<Thread> set = new HashSet<>();
        for(int i=0;i<10;i++){
            Thread cust = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        barbarShopProblem.customerWalkIn();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            set.add(cust);
        }

        for(Thread t : set){
            t.start();
        }

        for(Thread t : set){
            t.join();
        }

        set.clear();
        Thread.sleep(800);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        barbarShopProblem.customerWalkIn();
                    } catch (InterruptedException ie) {

                    }
                }
            });
            set.add(t);
        }
        for (Thread t : set) {
            t.start();
        }

        barbar.join();
    }
}