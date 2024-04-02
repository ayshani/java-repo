public class FutureCallableMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(" total sum : "+Demonstration.pollingStatusAndCancelTasks(10));
        Demonstration.threadPool.shutdown();
    }
}