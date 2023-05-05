package streams;

import java.util.ArrayList;
import java.util.List;

public class FilterMain {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,13,45,67,24);
        // Created a stream from the list
        //filter operation to get only numbers greater than 10
        // Printing each number in the list after filtering.
        list.stream()
                .filter(num -> num>10)
                .forEach(System.out::println);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alex", 34));
        personList.add(new Person("Missi", 56));
        personList.add(new Person("Sacha", 8));
        personList.add(new Person("Ryan", 44));
        personList.add(new Person("Iyan", 5));
        personList.add(new Person("Ray", 63));

        // stream on custom objects
        // We are filtering out those persons whose age is more than 10 and less than 50
        personList.stream()
                .filter(person -> person.getAge()>10 && person.getAge()<50)
                .forEach(System.out::println);

        // Stream chaining
        personList.stream()
                .filter(person -> person!=null) // Filtering the object where name is not null
                .filter(person -> person.getAge()>10)// Filtering the objects where age is greater than 10
                .filter(person -> person.getAge()<50)// Filtering the objects where age is less than 50
                .forEach(System.out::println);
    }
}

class Person {
    String name;
    int age;
    String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, String country){
        this(name,age);
        this.country =country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
