public class SimpleBarrier {

    int count =0;
    int maxCount =0;

    public SimpleBarrier(int count){
        this.maxCount =count;
    }

    public synchronized void await() throws InterruptedException {
        count++;
        if(count==maxCount){
            notifyAll();
            count =0;
        }else{
            wait();
        }
    }
}
