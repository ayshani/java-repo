package java8.lamda.functionalinterfaces.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
Function is a category of functional interfaces that takes an object of type T and returns an object of type R.

 */
public class FunctionMain {
    public static void main(String[] args) {
        // R apply(T t)#
        //It takes one argument of type T as input and returns a value of type R.
        Function<String, Integer> lengthFunction = s-> s.length();
        System.out.println("String length : "+ lengthFunction.apply("this is a test"));

        //compose(Function<? super V, ? extends T> before)#
        //Returns a composed function that first applies the function provided as a parameter on the input,
        // and then applies the function on which it is called, to the result.
        Function<Integer,Integer> increment = i -> i+10;
        Function<Integer,Integer> multiply = x-> x*2;
        System.out.println("Compose result : "+increment.compose(multiply).apply(3));

        /*
        andThen(Function<? super R,? extends V> after)
        This method returns a composed function that first applies the function on which it is called on the input,
        and then applies the function provided as parameter, to the result.
         */
        System.out.println("andThen result : "+ increment.andThen(multiply).apply(3));

        /*
        BiFunction<T,U,R>
        The BiFunction<T, U, R> is similar to Function<T, R> interface; the only difference is that the BiFunction
        interface takes in two parameters and returns an output.
         */
        BiFunction<Integer,Integer,Integer> add = (x,y) -> x+y;
        System.out.println("BiFUnction result : "+ add.apply(3,4));
    }
}
