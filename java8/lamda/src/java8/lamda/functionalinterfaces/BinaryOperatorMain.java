package java8.lamda.functionalinterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorMain {

    public static void main(String[] args) {
        Person person1 = new Person("Alex",33);
        Person person2 = new Person("Missi",10);

        BinaryOperator<Person> binaryOperator = (p1,p2) ->{
            p1.name = p2.name;
            p1.age =p2.age;
            return p1;
        };
        binaryOperator.apply(person1,person2);
        System.out.println("Binary operator result : "+ person1.getName() + " "+ person1.getAge());
    }
}
