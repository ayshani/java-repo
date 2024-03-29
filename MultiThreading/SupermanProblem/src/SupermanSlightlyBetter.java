public class SupermanSlightlyBetter {

    private static SupermanSlightlyBetter superman;
    private SupermanSlightlyBetter(){

    }

    public static SupermanSlightlyBetter getInstance(){
        // Check if object is uninitialized
        if(superman==null) {

            // Now synchronize on the class object, so that only
            // 1 thread gets a chance to initialize the superman
            // object. Note that multiple threads can actually find
            // the superman object to be null and fall into the
            // first if clause
            synchronized (SupermanSlightlyBetter.class) {

                // Must check once more if the superman object is still
                // null. It is possible that another thread might have
                // initialized it already as multiple threads could have
                // made past the first if check.
                if (superman == null) {
                    return new SupermanSlightlyBetter();
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
