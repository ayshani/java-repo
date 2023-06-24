package lamda.firstlamda;

public class RunnableLamda {

    public static void main(String[] args) {
        /*
        Before java 8
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable 1");
            }
        };
        new Thread(runnable).start();



        /*
        After java 8
         */
        Runnable runnable1 = () -> System.out.println("Runnable 2");
        new Thread(runnable1).start();

        new Thread(()->System.out.println("Runnable 3")).start();

        new Thread(()->{
            System.out.println("Runnable 4.1");
            System.out.println("Runnable 4.2");
        }).start();
    }
}
