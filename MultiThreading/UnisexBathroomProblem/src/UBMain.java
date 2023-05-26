public class UBMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Unisex Bathroom!");

        final UnisexBathroom unisexBathroom = new UnisexBathroom();

        Thread women1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lalita");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread male1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Ravi");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread male2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Akash");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread male3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Sam");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread male4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Rohan");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        women1.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();

        women1.join();
        male1.join();
        male2.join();
        male4.join();
        male3.join();
    }
}