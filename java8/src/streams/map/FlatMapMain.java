package streams.map;

import common.Student;
import common.StudentDB;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlatMapMain {

    public static List<String> getStudentActivities(){
       List<String> activities =  StudentDB.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());
       return activities;
    }

    public static long getStudentActivitiesCount(){
        long activityCount =  StudentDB.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
        return activityCount;
    }
    public static void main(String[] args) {
        System.out.println(getStudentActivities());
        System.out.println(getStudentActivitiesCount());
    }
}
