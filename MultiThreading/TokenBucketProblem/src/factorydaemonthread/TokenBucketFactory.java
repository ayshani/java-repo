package factorydaemonthread;

public class TokenBucketFactory {

    // Force users to interact with the factory
    // only through the static methods
    private TokenBucketFactory(){

    }

    public static TokenBucketFilter makeTokenBucketFilter(int capacity) throws InterruptedException{
        MultiThreadedTokenBucketFilter multiThreadedTokenBucketFilter = new MultiThreadedTokenBucketFilter(capacity);
        multiThreadedTokenBucketFilter.initialize();
        return multiThreadedTokenBucketFilter;
    }

    private static class MultiThreadedTokenBucketFilter extends TokenBucketFilter{

        private long possibleTokens =0;
        private final int MAX_COUNT;
        private final int ONE_SECOND = 1000;

        public MultiThreadedTokenBucketFilter(int maxCount){
            this.MAX_COUNT = maxCount;
        }

        public void initialize(){
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
}
