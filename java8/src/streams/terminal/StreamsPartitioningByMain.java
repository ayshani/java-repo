package streams.terminal;

import common.Student;
import common.StudentDB;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitioningByMain {

    public static void partitioningBy1(){

        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;
        Map<Boolean, List<Student>> map =  StudentDB.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate));

        System.out.println("partitioningMap : "+ map);
    }

    public static void partitioningBy2(){

        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;
        Map<Boolean, Set<Student>> map =  StudentDB.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));

        System.out.println("partitioningMap : "+ map);
    }
    public static void main(String[] args) {
        partitioningBy1();

        System.out.println();
        System.out.println();
        partitioningBy2();
    }
}
