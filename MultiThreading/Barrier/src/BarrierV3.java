public class BarrierV3 {

    int count =0;
    int released =0;
    int maxCount =0;

    public BarrierV3(int count){
        this.maxCount =count;
    }

    public synchronized void await() throws InterruptedException {
        if(count==maxCount)
            wait();
        count++;
        if(count==maxCount){
            notifyAll();
            released =maxCount;
        }else{
            while(count<maxCount)
                wait();
        }
        released--;
        if(released==0){
            count =0;
            notifyAll();
        }
    }

}

