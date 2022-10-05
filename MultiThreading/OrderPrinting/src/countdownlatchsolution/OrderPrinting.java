package countdownlatchsolution;

import common.OrderPrint;

import java.util.concurrent.CountDownLatch;

public class OrderPrinting implements OrderPrint {

    CountDownLatch latch1;
    CountDownLatch latch2;

    public OrderPrinting(){
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }
    @Override
    public void printFirst() throws InterruptedException {
            System.out.println("First countdown");
            latch1.countDown();
    }

    @Override
    public void printSecond() throws InterruptedException {
        latch1.await();
        System.out.println("Second countdown");
        latch2.countDown();
    }

    @Override
    public void printThird() throws InterruptedException {
        latch2.await();
        System.out.println("Third countdown");
    }
}
