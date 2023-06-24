package streams.parallelstream;

import streams.Student;
import streams.StudentDB;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamPipelineMain {

    public static List<String>  sequentialGetStudentActivites(){
        long startTime = System.currentTimeMillis();

        List<String > activities =  StudentDB.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time : "+ (endTime-startTime));
        return activities;
    }

    public static List<String>  parallelGetStudentActivites(){
        long startTime = System.currentTimeMillis();

        List<String > activities =  StudentDB.getAllStudents()
                .stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel time : "+ (endTime-startTime));
        return activities;
    }

    public static void main(String[] args) {
        sequentialGetStudentActivites();
        parallelGetStudentActivites();

    }
}
