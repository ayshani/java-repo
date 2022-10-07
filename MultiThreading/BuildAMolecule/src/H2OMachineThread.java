import java.security.PublicKey;

public class H2OMachineThread extends Thread{
    H2OMachine molecule;
    String atom;

    public H2OMachineThread(H2OMachine molecule, String atom){
        this.molecule = molecule;
        this.atom = atom;
    }

    public void run(){
        if("H".equals(atom)){
            molecule.hydrogenAtom();
        } else if("O".equals(atom)){
            molecule.OxygenAtom();
        }
    }
}
