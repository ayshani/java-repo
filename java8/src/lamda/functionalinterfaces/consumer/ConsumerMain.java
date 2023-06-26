package lamda.functionalinterfaces.consumer;

import common.Student;
import common.StudentDB;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerMain {

    static Consumer<Student> c1 = (s) -> System.out.println(s);
    static Consumer<Student> c2 = (s) -> System.out.print(s.getName());
    static Consumer<Student> c3 = (s) -> System.out.println(s.getActivities());

    public static void main(String[] args) {
        Consumer<String> stringConsumer = s-> System.out.println(s);
        stringConsumer.accept("Hello world");

        Consumer<String> stringConsumer1 = s-> System.out.println(s.toUpperCase());
        stringConsumer1.accept("Hello world");

        Consumer<Integer> integerConsumer = i -> System.out.println("int value = " +i);
        integerConsumer.accept(13);

        //The andThen() method, which is a default method in the Consumer interface is used for chaining.
        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane.");

        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from Canada.");

        consumer1.andThen(consumer2).accept("Hello. ");

        BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + s2);
        greet.accept("Hello", "World");

        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();

    }

    public static void printName(){
        List<Student> studentList  = StudentDB.getAllStudents();
        studentList.forEach(c1);
    }

    public static void printNameAndActivities(){
        List<Student> studentList  = StudentDB.getAllStudents();
        studentList.forEach(c2.andThen(c3)); // consumer chaining
    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition...........");
        List<Student> studentList  = StudentDB.getAllStudents();
        studentList.forEach((student -> {
            if(student.getGradeLevel()>=3 && student.getGpa()>=3){
                c2.andThen(c3).accept(student);
            }
        }));
    }
}
