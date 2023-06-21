package java8.lamda.functionalinterfaces.predicate;

import java8.lamda.functionalinterfaces.Student;
import java8.lamda.functionalinterfaces.StudentDB;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerMain {

    Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;
    Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    BiPredicate<Integer,Double> biPredicate = (grade,gpa) -> grade>=3 && gpa>=3.9;
    BiConsumer<String , List<String >> biConsumer = (name, activities)-> System.out.println(name +" : "+activities);

    Consumer<Student> studentConsumer = (student -> {
        /*if(p1.and(p2).test(student)){
            biConsumer.accept(student.getName(),student.getActivities());
        }*/

        if(biPredicate.test(student.getGradeLevel(), student.getGpa())){
            biConsumer.accept(student.getName(),student.getActivities());
        }
    });

    public  void printNameAndActivites(List<Student> studentList){
        studentList.forEach(studentConsumer);
    }
    public static void main(String[] args) {
        List<Student> studentList = StudentDB.getAllStudents();
        new PredicateConsumerMain().printNameAndActivites(studentList);
    }
}
