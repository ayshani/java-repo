public class Demonstration {
    public static void main(String[] args) throws  Exception{
        SynchronousExecutor se = new SynchronousExecutor();
        se.asynchronousExecution(() ->{
            System.out.println("I am done");
                }

        );
        System.out.println("Main Thread exiting!");
    }
}