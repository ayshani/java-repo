package streams.terminal;

import common.Student;
import common.StudentDB;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsMinByMaxByMain {
    public static Optional<Student> minBy1(){
        return StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> maxBy1(){
        return StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static void main(String[] args) {
        System.out.println("Min By : "+ (minBy1().isPresent()? minBy1().get(): null));
        System.out.println("Max By : "+ (maxBy1().isPresent()? maxBy1().get(): null));
    }
}
