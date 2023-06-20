package java8.lamda.functionalinterfaces.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = s-> System.out.println(s);
        stringConsumer.accept("Hello world");

        Consumer<String> stringConsumer1 = s-> System.out.println(s.toUpperCase());
        stringConsumer1.accept("Hello world");

        Consumer<Integer> integerConsumer = i -> System.out.println("int value = " +i);
        integerConsumer.accept(13);

        //The andThen() method, which is a default method in the Consumer interface is used for chaining.
        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane.");

        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from Canada.");

        consumer1.andThen(consumer2).accept("Hello. ");

        BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + s2);
        greet.accept("Hello", "World");
    }
}
