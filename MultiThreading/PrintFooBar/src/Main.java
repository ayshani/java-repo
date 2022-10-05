public class Main {
    public static void main(String[] args) {

        FoorBar fb = new FoorBar(3);
        Thread t1 = new FooBarThread(fb,"foo");
        Thread t2 = new FooBarThread(fb,"bar");

        t2.start();
        t1.start();
    }
}