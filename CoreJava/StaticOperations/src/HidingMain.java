public class HidingMain {

    public static void main(String[] args) {
        B obj = new B();
        B.printStatic();
        obj.printInstance();

        A objA = new B();
        objA.printInstance();
    }

}


class A{
    public static void printStatic(){
        System.out.println("in A");
    }
    public  void printInstance(){
        System.out.println("in A");
    }

    public final  void printFinal(){
        System.out.println("in A");
    }

    public float  printDecimal(){
        System.out.println("in A");
        return 1.0f;
    }

    public double  printDecimalDouble(){
        System.out.println("in A");
        return 1.0;
    }
}

class B extends A{
    public static void printStatic(){
        System.out.println("in b");
    }

    public  void printInstance(){
        System.out.println("in B");
    }


    /*
    Can't override final method
    -> compilation error
    public final  void printFinal(){
        System.out.println("in A");
    }
    */

    /*
    double is not possible as parent class A has float method return type
    -> compilation error
    public double  printDecimal(){
        System.out.println("in A");
        return 1.0f;
    }*/

    /*
    we need to give exact return type if we are overriding a method of parent class
    -> compilation error
    public float  printDecimalDouble(){
        System.out.println("in A");
        return 1.0f;
    }*/
}