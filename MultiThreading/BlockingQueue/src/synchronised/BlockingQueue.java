package synchronised;

public class BlockingQueue<T> {
    T[] array;
    int size, capacity, head, tail;
    Object lock = new Object();

    public BlockingQueue(int capacity){
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public  void enqueue(T item) throws InterruptedException {
        synchronized (lock){
            while(size==capacity){
                lock.wait();
            }

            if(tail==capacity){
                tail =0;
            }

            array[tail] = item;
            tail++;
            size++;

            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        T item = null;

        synchronized (lock){
            if(size==0){
                lock.wait();
            }
            if(head==capacity){
                head= 0;
            }

            item = array[head];
            array[head] = null;
            head++;
            size--;

            lock.notifyAll();
        }
        return item;
    }
}
