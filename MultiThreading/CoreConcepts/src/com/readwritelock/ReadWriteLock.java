package com.readwritelock;

public class ReadWriteLock {

    boolean isWriterLocked = false;
    int readers =0;

    public synchronized void aquireReadLock() throws InterruptedException {
        if(isWriterLocked){
            wait();
        }
        readers++;
    }

    public synchronized void releaseReadLock(){
        readers--;
        notify();
    }

    public synchronized void aquireWriteLock() throws InterruptedException {
        if(isWriterLocked ||  readers!=0){
            wait();
        }
        isWriterLocked = true;
    }

    public synchronized void releaseWriteLock(){
        isWriterLocked = false;
        notify();
    }

}
