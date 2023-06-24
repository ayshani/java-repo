package streams.terminal;

import streams.StudentDB;

import java.util.stream.Collectors;

public class StreamsJoiningMain {

    public static String joining_1(){
        return StudentDB.getAllStudents()
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.joining());
    }

    public static String joining_2(){
        return StudentDB.getAllStudents()
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.joining("-"));
    }

    public static String joining_3(){
        return StudentDB.getAllStudents()
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.joining("-","(",")"));
    }
    public static void main(String[] args) {
        System.out.println("Joining 1 : "+ joining_1());
        System.out.println("Joining 2 : "+ joining_2());
        System.out.println("Joining 3 : "+ joining_3());
    }
}
