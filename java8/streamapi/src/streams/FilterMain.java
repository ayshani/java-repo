package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        filterStudents().forEach(System.out::println);
    }

    public static List<Student> filterStudents(){
        return StudentDB.getAllStudents().stream()
                .filter(student -> student.getGender().equals("female"))
                .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.toList());
    }
}

