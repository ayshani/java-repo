public class Superman {

    private static volatile Superman superman;
    private Superman(){

    }

    public static Superman getInstance(){
        if(superman==null) {
            synchronized (Superman.class) {
                if (superman == null) {
                    return new Superman();
                }
            }
        }
        return superman;
    }

    // Object method
    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}
