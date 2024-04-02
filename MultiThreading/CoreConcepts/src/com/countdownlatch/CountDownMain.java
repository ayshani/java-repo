package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownMain {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Worker worker1 = new Worker(countDownLatch,"Worker-A");
        Worker worker2 = new Worker(countDownLatch,"Worker-B");

        worker1.start();
        worker2.start();

        countDownLatch.await();

        Master master = new Master("Master");
        master.start();
    }
}
