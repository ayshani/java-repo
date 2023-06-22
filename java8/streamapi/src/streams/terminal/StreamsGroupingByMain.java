package streams.terminal;

import streams.Student;
import streams.StudentDB;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsGroupingByMain {

    public static void groupByGender(){
        Map<String, List<Student>> studentMap =  StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(studentMap);
    }

    public static void customizedGroupBy(){
        Map<String, List<Student>> studentMap =  StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE"
                ));
        System.out.println(studentMap);
    }

    public static void twoLevel_1(){
        Map<Integer, Map<String,List<Student>>> map =  StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE")));

        System.out.println(map);
    }

    public static void twoLevel_2(){
        Map<String, Integer> map =  StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.summingInt(Student::getNoteBookes)));

        System.out.println(map);
    }

    public static void threeLevel_1(){
        LinkedHashMap<String, Set<Student>> map =  StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));

        System.out.println(map);
    }

    public static void calculateTopGpa(){
        Map<Integer, Optional<Student>> mapOptional = StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));

        System.out.println(mapOptional);

        Map<Integer, Student> mapOptional1 = StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)),Optional::get)));

        System.out.println(mapOptional1);
    }

    public static void calculateLeastGpa(){
        Map<Integer, Optional<Student>> mapOptional = StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.minBy(Comparator.comparing(Student::getGpa))));

        System.out.println(mapOptional);

        Map<Integer, Student> mapOptional1 = StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)),Optional::get)));

        System.out.println(mapOptional1);
    }

    public static void main(String[] args) {
        groupByGender();

        System.out.println();
        System.out.println();

        customizedGroupBy();

        System.out.println();
        System.out.println();
        twoLevel_1();

        System.out.println();
        System.out.println();
        twoLevel_2();

        System.out.println();
        System.out.println();
        threeLevel_1();

        System.out.println();
        System.out.println();
        calculateTopGpa();

        System.out.println();
        System.out.println();
        calculateLeastGpa();
    }
}
