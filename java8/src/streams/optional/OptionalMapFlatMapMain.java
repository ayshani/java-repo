package streams.optional;

import common.Student;
import common.StudentDB;
import streams.Bike;

import java.util.Optional;

public class OptionalMapFlatMapMain {

    //filter
    public static void optionalFilter(){
        Optional<Student> studentOptional =
        Optional.ofNullable(StudentDB.studentSupplier.get());
        studentOptional.filter(student -> student.getGpa()>=3.9)
                .ifPresent(student -> System.out.println(student));
    }

    //Map
    public static void optionalMap(){
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDB.studentSupplier.get());
        if(studentOptional.isPresent()){
             Optional<String> stringOptional =  studentOptional.filter(student -> student.getGpa()>=3.9)
                    .map(Student::getName);
            System.out.println(stringOptional.get());
        }
    }
    //flatmap
    public static void optionalFLatMap(){
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDB.studentSupplier.get());
        Optional<String > nameOptional =  studentOptional
                .filter(student -> student.getGpa()>=3.9)
                .flatMap(Student::getBike)
                .map(Bike::getName);
        nameOptional.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFLatMap();
    }

}
