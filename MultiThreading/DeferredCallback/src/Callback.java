public class Callback {
    long executeAt;
    String message;

    public Callback(long executeAfter, String message){
        this.executeAt = System.currentTimeMillis() + executeAfter*1000;
        this.message = message;
    }
}
