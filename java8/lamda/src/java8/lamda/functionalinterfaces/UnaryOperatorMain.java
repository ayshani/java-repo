package java8.lamda.functionalinterfaces;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/*
The UnaryOperator<T> interface represents a function that takes one argument of type T and returns a value of the same
type. This is similar to the Function interface, which is a parent to the UnaryOperator interface.

The UnaryOperator does not define any new abstract methods. Since it extends the Function interface from the same
package, it extends apply() method
 */
public class UnaryOperatorMain {

    public static void main(String[] args) {
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

class Person{
    String name;
    int age;

    Person() {
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
