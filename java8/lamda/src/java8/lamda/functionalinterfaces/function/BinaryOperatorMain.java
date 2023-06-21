package java8.lamda.functionalinterfaces.function;

import java8.lamda.functionalinterfaces.Person;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorMain {

    static BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

    static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {

        System.out.println(binaryOperator.apply(3,4));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println(maxBy.apply(4,2));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println(minBy.apply(4,2));

        Person person1 = new Person("Alex",33);
        Person person2 = new Person("Missi",10);

        BinaryOperator<Person> binaryOperator = (p1,p2) ->{
            p1.setName(p2.getName());
            p1.setAge(p2.getAge());
            return p1;
        };
        binaryOperator.apply(person1,person2);
        System.out.println("Binary operator result : "+ person1.getName() + " "+ person1.getAge());
    }
}
