package streams;

import common.Student;
import common.StudentDB;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7);
        stream.forEach(System.out::println);
        List<String> list = List.of("a","b","c","d");
        Stream<String> stringStream = list.stream();
        stringStream.forEach(System.out::println);

        // Student name and their activities in a Map
        Predicate<Student> studentGradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> studentGpaPredicate = student -> student.getGpa()>=3.9;
        Map<String, List<String>> studentMap =  StudentDB.getAllStudents().stream()
                // this is used to check which values are passing by to next intermediate operation
                .peek(System.out::println)
                .filter(studentGradePredicate)// Stream<Student>
                .peek(student -> System.out.println("After first filter : "+ student))
                .filter(studentGpaPredicate)// Stream<Student>
                .peek(student -> System.out.println("After second filter : "+ student))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));// Map<Name,List<Activities>>
        System.out.println(studentMap);
        System.out.println("----------");

        Map<String, Student> studentMap1 =  StudentDB.getAllStudents().parallelStream()
                //.filter(student -> student.getGradeLevel()>=3)
                .filter(studentGradePredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, student -> student));
        System.out.println(studentMap1);

    }
}
