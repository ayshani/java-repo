import java.util.HashSet;
import java.util.Set;

public class DeferredSimpleMain {
    public static void main(String[] args) throws InterruptedException {
        //DeferredSimpleMain.runTestTenCallbacks();
        DeferredSimpleMain.runLateThenEarlyCallBakc();
    }

    public static void runTestTenCallbacks() throws InterruptedException {
        Set<Thread> allThreads = new HashSet<Thread>();
        final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

        Thread service = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deferredCallbackExecutor.start();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        service.start();

        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Callback cb = new Callback(1, "Hello this is " + Thread.currentThread().getName());
                    deferredCallbackExecutor.registerCallback(cb);
                }
            });
            thread.setName("Thread "+ i);
            thread.start();
            allThreads.add(thread);
            Thread.sleep(1000);
        }

        allThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void runLateThenEarlyCallBakc() throws InterruptedException{
        final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

        Thread service = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deferredCallbackExecutor.start();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        service.start();

        Thread.sleep(3000);

        Thread lateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Callback cb = new Callback(8, "Hello this is the callback submitted first");
                deferredCallbackExecutor.registerCallback(cb);
            }
        });

        lateThread.start();
        Thread.sleep(3000);

        Thread earlyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Callback cb = new Callback(1, "Hello this is callback sumbitted second");
                deferredCallbackExecutor.registerCallback(cb);
            }
        });

        earlyThread.start();

        lateThread.join();
        earlyThread.join();
    }
}
