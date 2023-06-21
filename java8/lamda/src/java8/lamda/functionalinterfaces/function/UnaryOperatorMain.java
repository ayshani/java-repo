package java8.lamda.functionalinterfaces.function;

import java8.lamda.functionalinterfaces.Person;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/*
The UnaryOperator<T> interface represents a function that takes one argument of type T and returns a value of the same
type. This is similar to the Function interface, which is a parent to the UnaryOperator interface.

The UnaryOperator does not define any new abstract methods. Since it extends the Function interface from the same
package, it extends apply() method
 */
public class UnaryOperatorMain {

    static UnaryOperator<String> unaryOperator = (s) -> s.concat("Default");
    public static void main(String[] args) {
        System.out.println(unaryOperator.apply("Hello"));
        Person person = new Person();
        UnaryOperator<Person> operator = (p) ->{
            p.setName("Ravi");
            p.setAge(40);
            return p;
        };
        operator.apply(person);
        System.out.println("Person name : "+ person.getName()+" ,person Age : "+ person.getAge());

        IntUnaryOperator operator1 = num -> num * num;

        System.out.println(operator1.applyAsInt(25));
    }
}

