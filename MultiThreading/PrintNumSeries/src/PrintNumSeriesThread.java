public class PrintNumSeriesThread extends Thread {
    PrintNumSeries zero;
    String method;

    public PrintNumSeriesThread(PrintNumSeries obj, String name){
        this.zero = obj;
        this.method = name;
    }

    public void run(){
        if("zero".equals(method)){
            try{
                zero.printZero();
            }catch (InterruptedException e) {

            }
        } else if("even".equals(method)){
            try{
                zero.printEven();
            }catch (InterruptedException e) {

            }
        } else if("odd".equals(method)){
            try{
                zero.printOdd();
            }catch (InterruptedException e) {

            }
        }
    }
}
