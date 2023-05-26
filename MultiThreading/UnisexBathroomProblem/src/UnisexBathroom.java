import java.util.concurrent.Semaphore;

public class UnisexBathroom {

    private static final String WOMEN = "women";
    private static final String MEN = "men";
    private static final String NONE = "none";
    String inUseBy = NONE;
    int employeesInBathroom =0;
    Semaphore semaphore = new Semaphore(3);

    void maleUseBathroom(String name) throws InterruptedException {
        synchronized (this){
            while(inUseBy.equals(WOMEN)){
                this.wait();
            }
            semaphore.acquire();
            employeesInBathroom++;
            inUseBy = MEN;
        }

        useBathroom(name);
        semaphore.release();

        synchronized (this){
            employeesInBathroom--;
            if(employeesInBathroom==0){
                inUseBy = NONE;
            }
            // Since we might have just updateded the value of
            // inUseBy, we should notifyAll waiting threads
            this.notifyAll();
        }
    }

    void femaleUseBathroom(String name) throws InterruptedException {

        synchronized (this){
            while(inUseBy.equals(MEN)){
                this.wait();
            }
            semaphore.acquire();
            employeesInBathroom++;
            inUseBy = WOMEN;
        }

        useBathroom(name);
        semaphore.release();

        synchronized (this){
            employeesInBathroom--;
            if(employeesInBathroom==0){
                inUseBy = NONE;
            }
            notifyAll();
        }
    }

    void useBathroom(String name) throws InterruptedException {
        System.out.println(name +" using bathroom. TOtal current employees in bathroom now :  "+ employeesInBathroom);
        Thread.sleep(1000);
        System.out.println(name + " done using bathroom");
    }

}
