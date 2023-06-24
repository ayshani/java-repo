package streams.terminal;

import streams.StudentDB;

import java.util.stream.Collectors;

public class StreamsCountingMain {

    public static long count(){
        return StudentDB.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.counting());
    }
    public static void main(String[] args) {
        System.out.println(count());
    }
}
