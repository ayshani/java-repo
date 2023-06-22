package java8.lamda.functionalinterfaces.function;

import java8.lamda.functionalinterfaces.Student;
import java8.lamda.functionalinterfaces.StudentDB;
import java8.lamda.functionalinterfaces.predicate.PredicateStudent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionMain {

    static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> biFunction = ((students, studentPredicate) -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if (studentPredicate.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    });
    public static void main(String[] args) {
        System.out.println(biFunction.apply(StudentDB.getAllStudents(), PredicateStudent.p2));
    }
}