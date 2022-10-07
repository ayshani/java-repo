public class Main {
    public static void main(String[] args) {

        H2OMachine molecule = new H2OMachine();

        H2OMachineThread t1 = new H2OMachineThread(molecule,"H");
        H2OMachineThread t2 = new H2OMachineThread(molecule,"O");
        H2OMachineThread t3 = new H2OMachineThread(molecule,"O");
        H2OMachineThread t4 = new H2OMachineThread(molecule,"H");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}