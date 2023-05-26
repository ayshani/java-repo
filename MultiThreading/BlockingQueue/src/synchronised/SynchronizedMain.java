package synchronised;

import synchronised.BlockingQueue;

public class SynchronizedMain {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Integer> q = new BlockingQueue<>(5);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<50;i++){
                        q.enqueue(i);
                        System.out.println("enqueued : "+ i);
                    }
                } catch(InterruptedException e){

                }
            }
        }

        );

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<25;i++){
                        System.out.println("Thread 2 dequeued : "+ q.dequeue());
                    }
                } catch(InterruptedException e){

                }
            }
        }

        );

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<25;i++){
                        System.out.println("Thread 3 dequeued : "+ q.dequeue());
                    }
                } catch(InterruptedException e){

                }
            }
        }

        );

        t1.start();
        Thread.sleep(4000);
        t2.start();

        t2.join();

        t3.start();
        t1.join();
        t3.join();
    }
}