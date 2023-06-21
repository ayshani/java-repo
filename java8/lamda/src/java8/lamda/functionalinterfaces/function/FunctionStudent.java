package java8.lamda.functionalinterfaces.function;

import java8.lamda.functionalinterfaces.Student;
import java8.lamda.functionalinterfaces.StudentDB;
import java8.lamda.functionalinterfaces.predicate.PredicateStudent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudent {
    static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if(PredicateStudent.p1.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        }
        );
        return studentGradeMap;
    });
    public static void main(String[] args) {
        System.out.println(studentFunction.apply(StudentDB.getAllStudents()));
    }
}
