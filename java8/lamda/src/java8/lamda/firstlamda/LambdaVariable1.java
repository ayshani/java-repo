package java8.lamda.firstlamda;

import java.util.function.Consumer;

public class LambdaVariable1 {

    static int value=4;
    public static void main(String[] args) {
        int i=0;
        Consumer<Integer> consumer = (i1) -> System.out.println(i1);


        Consumer<Integer> consumer1 = (i1) -> {
            value++;
            System.out.println(value+i1);
        };
        consumer1.accept(4);
        value=6;
        consumer1.accept(4);

    }
}
