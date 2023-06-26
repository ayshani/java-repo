package lamda.functionalinterfaces.predicate;

import common.Student;
import common.StudentDB;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudent {

    public static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;
    public static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    public static void filterStudentsByGrades(){
        List<Student> studentList = StudentDB.getAllStudents();

        studentList.forEach( student -> {
            if (p1.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudentsByGpa(){
        System.out.println("filterStudentsByGpa-----------");
        List<Student> studentList = StudentDB.getAllStudents();

        studentList.forEach( student -> {
            if (p2.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudents(){
        System.out.println("filterStudents-----------");
        List<Student> studentList = StudentDB.getAllStudents();

        studentList.forEach( student -> {
            if (p1.and(p2).test(student)){
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {
        filterStudentsByGrades();
        filterStudentsByGpa();
        filterStudents();
    }
}
