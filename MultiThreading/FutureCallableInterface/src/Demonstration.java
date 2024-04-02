import java.util.concurrent.*;
public class Demonstration {

    static ExecutorService threadPool = Executors.newFixedThreadPool(5);

    static int pollingStatusAndCancelTasks(final int n){
        int result =-1;
        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum =0;
                // wait for 10 milliseconds
                Thread.sleep(10);
                for(int i=1;i<=n;i++){
                    sum+= i;
                }
                return sum;
            }
        };

        Callable<Void> randomTask = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                // go to sleep for an hours
                Thread.sleep(3600 * 1000);
                return null;
            }
        };

        Future<Integer> sum = threadPool.submit(sumTask);
        Future<Void> random = threadPool.submit(randomTask);

        // Before we poll for completion of second task,
        // cancel the second one
        random.cancel(true);

        while(!sum.isDone()){
            System.out.println("Waiting for sum to be computed");
        }
        try {
            result = sum.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Second task is cancelled : "+ random.isCancelled());
        return result;
    }
}
