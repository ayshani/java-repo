package daemonthreadconstructor;

public class MultiThreadedTokenBucketFilter {

    private long possibleTokens =0;
    private final int MAX_COUNT;
    private final int ONE_SECOND = 1000;

    public MultiThreadedTokenBucketFilter(int maxCount){
        this.MAX_COUNT = maxCount;

        // Never start a thread in a constructor
        Thread dt =  new Thread(
                () ->{
                    try {
                        daemonThread();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                );
        dt.setDaemon(true);
        dt.start();
    }

    private void daemonThread() throws InterruptedException {
        while(true){
            synchronized (this){
                if(possibleTokens<MAX_COUNT){
                    possibleTokens++;
                }
                this.notify();
            }

            Thread.sleep(1000);
        }
    }

    public void getToken() throws InterruptedException {
        synchronized (this){
            while(possibleTokens==0){
                wait();
            }
            possibleTokens--;
        }
        System.out.println("Granting "+ Thread.currentThread().getName() +" token at : "+ System.currentTimeMillis()/1000);
    }
}

