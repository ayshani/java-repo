package streams;

import java.util.List;
import java.util.function.Supplier;

public class StudentDB {

    public static Supplier<Student> studentSupplier = () ->{
        return new Student("A",2,8,"male" , List.of("reading", "painting"));
    };
    public static List<Student> getAllStudents(){

        // 2nd grad
        Student student1 = new Student("Adam",2,8,"male" , List.of("reading", "painting"), 11);
        Student student2 = new Student("Ravi",2,4,"female" , List.of("writing", "painting"),12);

        // 3rd grad
        Student student3 = new Student("Anuj",3,6,"male" , List.of("painting"),10);
        Student student4 = new Student("Harry",3,8,"female" , List.of("playing", "painting"), 9);

        // 4th grad
        Student student5 = new Student("Cali",4,2,"male" , List.of("reading", "painting"),15);
        Student student6 = new Student("June",5,9,"female" , List.of("gaming", "painting"), 14);

        List<Student> studentList = List.of(student1, student2,student3,student4,student5,student6);
        return studentList;
    }
}
