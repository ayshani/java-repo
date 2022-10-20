public class AgeLimitException extends Exception{
    String msg;

    public AgeLimitException(){
        msg  = "okay";
    }
    public AgeLimitException(String message){
        super(message);
        this.msg = message;
        System.out.println(message);

    }
}
