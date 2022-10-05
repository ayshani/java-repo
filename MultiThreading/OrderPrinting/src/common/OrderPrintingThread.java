package common;

public class OrderPrintingThread extends Thread{
    private OrderPrint obj;
    private String method;

    public OrderPrintingThread(OrderPrint obj, String method){
        this.obj = obj;
        this.method = method;
    }

    public void run(){
        if("first".equals(method)){
            try{
                obj.printFirst();
            } catch (InterruptedException e){

            }
        } else if("second".equals(method)){
            try{
                obj.printSecond();
            } catch (InterruptedException e){

            }
        } else if("third".equals(method)){
            try{
                obj.printThird();
            } catch (InterruptedException e){

            }
        }
    }
}
