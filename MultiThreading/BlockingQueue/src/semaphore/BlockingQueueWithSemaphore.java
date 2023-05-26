package semaphore;

public class BlockingQueueWithSemaphore<T> {
    T[] array;
    int size , capacity, head, tail;

    CountingSemaphore semProducer;
    CountingSemaphore semConsumer;
    CountingSemaphore semLock;

    public BlockingQueueWithSemaphore(int capacity){
        this.capacity =capacity;
        array =  (T[]) new Object[capacity];
        this.size =0;
        this.head =0;
        this.tail =0;
        semLock = new CountingSemaphore(1,1);
        semProducer = new CountingSemaphore(capacity, capacity);
        semConsumer = new CountingSemaphore(capacity,0);
    }

    public void enqueue(T item) throws InterruptedException {
        semProducer.acquire();
        semLock.acquire();

        if(tail==capacity)
            tail =0;

        array[tail] = item;
        size++;
        tail++;

        semLock.release();
        semConsumer.release();
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        semConsumer.acquire();
        semLock.acquire();

        if(head ==capacity)
            head =0;

        item = array[head];
        array[head] = null;
        head++;
        size--;

        semLock.release();
        semProducer.release();
        return item;
    }
}
