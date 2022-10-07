public class FizzBuzzThread extends Thread{
    MultithreadedFizzBuzz obj;
    String method;

    public FizzBuzzThread(MultithreadedFizzBuzz obj, String method){
        this.obj = obj;
        this.method = method;
    }

    public void run(){
        if("fizz".equals(method)){
            try {
                obj.fizz();
            } catch (InterruptedException e) {

            }
        } else if("buzz".equals(method)){
            try {
                obj.buzz();
            } catch (InterruptedException e) {

            }
        } else if("fizzbuzz".equals(method)){
            try {
                obj.fizzbuz();
            } catch (InterruptedException e) {

            }
        } else if("num".equals(method)){
            try {
                obj.num();
            } catch (InterruptedException e) {

            }
        }
    }
}
