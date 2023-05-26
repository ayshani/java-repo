package factorydaemonthread;

import daemonthreadconstructor.MultiThreadedTokenBucketFilter;

import java.util.HashSet;
import java.util.Set;

public class FactoryMain {
    public static void main(String[] args) throws InterruptedException {
        Set<Thread> threadSet = new HashSet<>();

        TokenBucketFilter tokenBucketFilter = TokenBucketFactory.makeTokenBucketFilter(1);
        //Thread.sleep(10000);
        for(int i=0;i<15;i++){
            Thread thread = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                tokenBucketFilter.getToken();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
            );

            thread.setName("Thread "+ i);
            threadSet.add(thread);
        }

        threadSet.forEach(thread -> thread.start());
        threadSet.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
