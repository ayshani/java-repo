package java8.lamda.functionalinterfaces.supplier;

import java8.lamda.functionalinterfaces.Student;
import java8.lamda.functionalinterfaces.StudentDB;

import java.util.List;
import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () ->{
            return new Student("A",2,8,"male" , List.of("reading", "painting"));
        };

        System.out.println("Student supplier : "+studentSupplier.get());

        Supplier<List<Student>> listSupplier = () -> StudentDB.getAllStudents();
        System.out.println("List Student Supplier : "+ listSupplier.get());
    }
}
