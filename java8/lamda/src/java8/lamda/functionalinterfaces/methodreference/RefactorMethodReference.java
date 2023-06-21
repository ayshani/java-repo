package java8.lamda.functionalinterfaces.methodreference;

import java8.lamda.functionalinterfaces.Student;
import java8.lamda.functionalinterfaces.StudentDB;

import java.util.function.Predicate;

public class RefactorMethodReference {

    public static boolean greaterThanGradeLevel(Student student){
        return student.getGradeLevel() >=3;
    }
    static Predicate<Student> p1 = RefactorMethodReference::greaterThanGradeLevel;
    public static void main(String[] args) {
        System.out.println(p1.test(StudentDB.studentSupplier.get()));
    }
}
