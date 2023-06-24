package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindingMain {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23,"India"));
        list.add(new Person("Joe", 18,"USA"));
        list.add(new Person("Ryan", 54,"China"));
        list.add(new Person("Iyan", 5,"India"));
        list.add(new Person("Ray", 63,"China"));
        //findFirst()
        //It returns an Optional describing the first element of this stream,
        // or an empty Optional if the stream is empty.

        Optional<Person> optionalPerson = list.stream()
                .filter(p-> p.getCountry().equals("India"))
                .findFirst();

        if(optionalPerson.isPresent())
            System.out.println(optionalPerson.get());

        //findAny()
        //It returns an Optional describing some element of this stream, or an empty Optional if the stream is empty.
        // Now you might be wondering why we need this method if we already have the findFirst() operation.
        //This operation is particularly useful in the case of parallel streams.

        optionalPerson = list.stream()
                .filter(p-> p.getCountry().equals("China"))
                .findAny();
        if(optionalPerson.isPresent())
            System.out.println(optionalPerson.get());

        Optional<Student> studentOptional = findAny();
        if(studentOptional.isPresent()){
            System.out.println(studentOptional.get());
        }else {
            System.out.println("student not found");
        }

        Optional<Student> studentOptional1 = findFirst();
        if(studentOptional1.isPresent()){
            System.out.println(studentOptional1.get());
        }else {
            System.out.println("student not found");
        }
    }

    public static Optional<Student> findAny(){
        return StudentDB.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .findAny();
    }

    public static Optional<Student> findFirst(){
        return StudentDB.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .findFirst();
    }
}
