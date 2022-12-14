package java8.lamda.firstlamda;

public class WellWisher {
    public static void greet(Greetings greetings){
        greetings.greet();
    }
    public static void main(String[] args) {

        greet(() -> System.out.println("Namaste"));
    }
}