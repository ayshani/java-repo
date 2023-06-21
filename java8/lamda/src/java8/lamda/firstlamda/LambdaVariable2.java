package java8.lamda.firstlamda;

import java.util.function.Consumer;

public class LambdaVariable2 {


    public static void main(String[] args) {
        int value=4;

        Consumer<Integer> c1 = (i) -> {
            //value++; // cant update the value getting used in lambda
            System.out.println(value+i);
        };

        //value=6; // this is also not allowed
        c1.accept(4);
    }
}
