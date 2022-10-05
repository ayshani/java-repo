import java.util.concurrent.Semaphore;

public class PrintNumSeries {

    private int n;
    private Semaphore zeroSem, oddSem,evenSem;

    public PrintNumSeries(int n)
    {
        this.n = n;
        zeroSem =  new Semaphore(1);
        evenSem = new Semaphore(0);
        oddSem = new Semaphore(0);
    }

    public void printZero() throws InterruptedException {
        for(int i=0;i<n;i++){
            zeroSem.acquire();
            System.out.print("0");
            (i%2==0? oddSem : evenSem).release();
        }
    }

    public void printOdd() throws InterruptedException {
        for(int i = 1;i<=n;i+=2){
            oddSem.acquire();
            System.out.print(i);
            zeroSem.release();
        }
    }

    public void printEven() throws InterruptedException {
        for(int i = 2;i<=n;i+=2){
            evenSem.acquire();
            System.out.print(i);
            zeroSem.release();
        }
    }
}
