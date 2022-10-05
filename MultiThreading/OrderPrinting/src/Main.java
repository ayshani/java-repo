import common.OrderPrint;
import common.OrderPrintingThread;
import notifywaitsolution.OrderPrinting;

// https://www.educative.io/courses/java-multithreading-for-senior-engineering-interviews/B8Yz93o3w4Y
public class Main {
    public static void main(String[] args) {

        System.out.println("Notify Wait Solution ----------");
        OrderPrint obj = new OrderPrinting();

        OrderPrintingThread t1 = new OrderPrintingThread(obj,"first");
        OrderPrintingThread t2 = new OrderPrintingThread(obj,"second");
        OrderPrintingThread t3 = new OrderPrintingThread(obj,"third");

        t1.start();
        t2.start();
        t3.start();


        System.out.println("Count Down latch Solution ----------");

        obj = new countdownlatchsolution.OrderPrinting();

        t1 = new OrderPrintingThread(obj,"first");
        t2 = new OrderPrintingThread(obj,"second");
        t3 = new OrderPrintingThread(obj,"third");

        t1.start();
        t2.start();
        t3.start();
    }
}