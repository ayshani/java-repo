package java8.lamda.functionalinterfaces.consumer;

import java8.lamda.functionalinterfaces.Student;
import java8.lamda.functionalinterfaces.StudentDB;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerMain {

    public static void nameAndActivities(){
        BiConsumer<String, List<String>> biConsumer =  (name, activites) -> System.out.println(name +" : "+ activites);
        List<Student> studentList = StudentDB.getAllStudents();
        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {
        BiConsumer<String, String > consumer1 = (a,b) ->{
            System.out.println("a: "+a +" b : "+b);
        };

        consumer1.accept("java7","java8");

        BiConsumer<Integer,Integer> multiply = (a,b) -> System.out.println("Multiple: "+(a*b));
        BiConsumer<Integer,Integer> divison = (a,b) -> System.out.println("Multiple: "+(a/b));

        multiply.andThen(divison).accept(10,5);

        nameAndActivities();
    }
}
