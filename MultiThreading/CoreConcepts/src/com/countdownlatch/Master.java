package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Master extends Thread{

    public Master( String name){
        super(name);

    }
    @Override
    public void run() {
        System.out.println("Master Thread "+ Thread.currentThread().getName() +" stated");
        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Master Thread "+ Thread.currentThread().getName() +" finished");
    }
}
