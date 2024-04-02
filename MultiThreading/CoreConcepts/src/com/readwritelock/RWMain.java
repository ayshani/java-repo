package com.readwritelock;

public class RWMain {
    public static void main(String[] args) throws Exception{
        System.out.println("Read Write Lock !");

        final ReadWriteLock  readWriteLock= new ReadWriteLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Attempting to acquire write lock in t1 at :" + System.currentTimeMillis());
                    readWriteLock.aquireWriteLock();
                    System.out.println("write lock acquired in t1 at :" + System.currentTimeMillis());
                    for(;;){
                        Thread.sleep(500);
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
                    System.out.println("Attempting to acquire write lock in t2 at :" + System.currentTimeMillis());
                    readWriteLock.aquireWriteLock();
                    System.out.println("write lock acquired in t2 at :" + System.currentTimeMillis());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread tReader1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Attempting to acquire read lock in tReader1 at :" + System.currentTimeMillis());
                    readWriteLock.aquireReadLock();
                    System.out.println("read lock acquired in tReader1 at :" + System.currentTimeMillis());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread tReader2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Attempting to release read lock in tReader2 at :" + System.currentTimeMillis());
                readWriteLock.releaseReadLock();
                System.out.println("read lock released in tReader2 at :" + System.currentTimeMillis());
            }
        });

        tReader1.start();
        t1.start();
        Thread.sleep(3000);
        tReader2.start();
        Thread.sleep(1000);
        t2.start();
        tReader1.join();
        tReader2.join();
        t2.join();
    }
}