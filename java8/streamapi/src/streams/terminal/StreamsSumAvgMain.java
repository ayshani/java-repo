package streams.terminal;

import streams.Student;
import streams.StudentDB;

import java.util.stream.Collectors;

public class StreamsSumAvgMain {

    public static int sum(){
        return StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBookes));
    }

    public static double avg(){
        return StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBookes));
    }
    public static void main(String[] args) {
        System.out.println("Summing Int : "+ sum() );
        System.out.println("Avg Int : "+ avg() );
    }
}
