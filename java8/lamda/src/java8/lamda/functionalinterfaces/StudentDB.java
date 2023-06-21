package java8.lamda.functionalinterfaces;

import java8.lamda.functionalinterfaces.Student;

import java.util.List;
import java.util.function.Supplier;

public class StudentDB {

    public static Supplier<Student> studentSupplier = () ->{
        return new Student("A",2,8,"male" , List.of("reading", "painting"));
    };
    public static List<Student> getAllStudents(){

        // 2nd grad
        Student student1 = new Student("A",2,8,"male" , List.of("reading", "painting"));
        Student student2 = new Student("B",2,4,"female" , List.of("writing", "painting"));

        // 3rd grad
        Student student3 = new Student("C",3,6,"male" , List.of("painting"));
        Student student4 = new Student("D",3,8,"female" , List.of("playing", "painting"));

        // 4th grad
        Student student5 = new Student("E",4,2,"male" , List.of("reading", "painting"));
        Student student6 = new Student("F",5,9,"female" , List.of("gaming", "painting"));

        List<Student> studentList = List.of(student1, student2,student3,student4,student5,student6);
        return studentList;
    }
}
