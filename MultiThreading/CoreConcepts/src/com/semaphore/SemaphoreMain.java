package com.semaphore;

import com.semaphore.CountingSemaphore;

public class SemaphoreMain {

    public static void main(String[] args) throws InterruptedException {
        final CountingSemaphore semaphore = new CountingSemaphore(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<10;i++){
                        semaphore.aquire();
                        System.out.println("Ping " + i);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<10;i++){
                        semaphore.release();
                        System.out.println("Pong " + i);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}
