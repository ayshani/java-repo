package com.semaphore;

public class CountingSemaphore {

    int userPermits =0;
    int maxCount;

    public CountingSemaphore(int count){
        this.maxCount =count;
    }

    public synchronized void aquire() throws InterruptedException {
        while(userPermits==maxCount)
            wait();

        userPermits++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while(userPermits==0){
            wait();
        }
        userPermits--;
        notify();
    }
}
