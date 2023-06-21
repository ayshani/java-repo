package java8.lamda.functionalinterfaces.methodreference;

import java8.lamda.functionalinterfaces.Student;
import java8.lamda.functionalinterfaces.StudentDB;

import java.util.Comparator;
import java.util.function.Consumer;

public class ConsumerMethodReferenceMain {

    static Consumer<Student> c1 = student -> System.out.println(student);
    static Consumer<Student> cMethodReference = System.out::println;
    static Consumer<Student> cMethodReference1 = Student::printListOfActivites;
    public static void main(String[] args) {
        StudentDB.getAllStudents().forEach(c1);
        StudentDB.getAllStudents().forEach(cMethodReference);
        StudentDB.getAllStudents().forEach(cMethodReference1);
    }
}
