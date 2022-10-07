import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class H2OMachine {

    Object sync;
    String[] molecule;
    int count;

    public H2OMachine(){
        sync = new Object();
        molecule = new String[3];
        count=0;
    }

    public void hydrogenAtom(){
        synchronized (sync){
            while(Collections.frequency(Arrays.asList(molecule),"H")==2){
                try {
                    sync.wait();
                } catch (InterruptedException e) {

                }
            }

            molecule[count] = "H";
            count++;
            if(count==3){
                for(String e : molecule){
                    System.out.print(e);
                }
                Arrays.fill(molecule,null);
                count=0;
            }
            sync.notifyAll();
        }
    }

    public void OxygenAtom(){
        synchronized (sync){
            while(Collections.frequency(Arrays.asList(molecule),"O")==1){
                try {
                    sync.wait();
                } catch (InterruptedException e) {

                }
            }

            molecule[count] = "O";
            count++;
            if(count==3){
                for(String e : molecule){
                    System.out.print(e);
                }
                Arrays.fill(molecule,null);
                count=0;
            }
            sync.notifyAll();
        }
    }
}
