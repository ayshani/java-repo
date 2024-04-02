package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread{

    private CountDownLatch countDownLatch;


    public Worker(CountDownLatch countDownLatch, String name){
        super(name);
        this.countDownLatch=countDownLatch;

    }
    @Override
    public void run() {
        System.out.println("Worker Thread "+ Thread.currentThread().getName() +" stated");
        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Worker Thread "+ Thread.currentThread().getName() +" finished");
        countDownLatch.countDown();
    }
}
