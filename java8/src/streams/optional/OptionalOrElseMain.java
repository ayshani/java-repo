package streams.optional;

import common.Student;
import common.StudentDB;

import java.util.Optional;

public class OptionalOrElseMain {

    // orElse
    public static String orElse(){
        //Optional<Student> studentoptional = Optional.ofNullable(StudentDB.studentSupplier.get());
        Optional<Student> studentoptional = Optional.ofNullable(null);
        String name  = studentoptional.map(Student::getName).orElse("Default");
        return name;
    }

    // orElseGet
    public static String orElseGet(){
        Optional<Student> studentoptional = Optional.ofNullable(StudentDB.studentSupplier.get());
        //Optional<Student> studentoptional = Optional.ofNullable(null);
        String name  = studentoptional.map(Student::getName).orElseGet(()->"Default");
        return name;
    }

    // orElseThrow
    public static String orElseThrow(){
        //Optional<Student> studentoptional = Optional.ofNullable(StudentDB.studentSupplier.get());
        Optional<Student> studentoptional = Optional.ofNullable(null);
        String name  = studentoptional.map(Student::getName).orElseThrow(()->new RuntimeException("No data available"));
        return name;
    }

    public static void main(String[] args) {
        System.out.println(orElse());
        System.out.println(orElseGet());
        System.out.println(orElseThrow());
    }
}
