/*
What if the creation of Superman is a very resource-intensive effort after all he's coming from planet Krypton.
We would really like to only create Superman once we need him. Or in programming-speak, we want to lazily
initialize Superman

 */
public class SupermanWithFlaws {

    private static SupermanWithFlaws superman;
    private SupermanWithFlaws(){

    }

    /*
    As any reader of this course should realize by now (if I have done a good job of teaching) that the
    getInstance() method would fail miserably in a multi-threaded scenario. A thread can context switch out just
    before it initializes the Superman, causing later threads to also fall into the if clause and end up creating
    multiple superman objects.
     */
    public static SupermanWithFlaws getInstance(){
        if(superman==null){
            return new SupermanWithFlaws();
        }
        return superman;
    }

    // Object method
    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}
