
public class FooBarThread extends Thread {

    FoorBar fooBar;
    String method;

    public FooBarThread(FoorBar fooBar, String method){
        this.fooBar = fooBar;
        this.method = method;
    }

    public void run(){
        if("foo".equals(method)){
            fooBar.foo();
        } else if("bar".equals(method)){
            fooBar.bar();
        }
    }
}
