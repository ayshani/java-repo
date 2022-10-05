public class FoorBar {

    private int n;
    private int flag;

    public FoorBar(int n){
        this.n =n;
        this.flag =0;
    }

    public void foo(){
        for(int i=1;i<=this.n;i++){
            synchronized(this){
                while(flag==1)
                {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {

                    }
                }

                System.out.print("Foo");
                flag =1;
                this.notifyAll();
            }
        }
    }

    public void bar(){
        for(int i=1;i<=this.n;i++){
            synchronized(this){
                while(flag==0)
                {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {

                    }
                }

                System.out.println("Bar");
                flag =0;
                this.notifyAll();
            }
        }
    }
}
