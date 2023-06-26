package streams;

import common.Student;
import common.StudentDB;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorMain {

    public static List<Student> sortByNames(){
        return StudentDB.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> sortByGpa(){
        return StudentDB.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> sortByGpaDesc(){
        return StudentDB.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println("Students sorted by name-----");
        sortByNames().forEach(System.out::println);
        System.out.println("Students sorted by GPA-----");
        sortByGpa().forEach(System.out::println);
        System.out.println("Students sorted by GPA Reversed -----");
        sortByGpaDesc().forEach(System.out::println);
    }
}
