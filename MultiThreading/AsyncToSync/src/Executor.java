public class Executor {

    public void asynchronousExecution(Callback callback) throws Exception {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            callback.done();
        }
        );
        t.start();
    }
}
