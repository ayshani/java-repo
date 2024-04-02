package com.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new
                Runnable() {
                    @Override
                    public void run() {
                        System.out.println("ALl Threads have arrived at the barrier. Let's continue execution..");
                    }
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "Thread-A");
        Thread t2 = new Thread(new Task(cyclicBarrier), "Thread-B");
        Thread t3 = new Thread(new Task(cyclicBarrier), "Thread-C");

        t1.start();
        t3.start();
        t2.start();


    }
}
