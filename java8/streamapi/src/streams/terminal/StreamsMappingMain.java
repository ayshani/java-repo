package streams.terminal;

import streams.Student;
import streams.StudentDB;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMappingMain {

    public static void main(String[] args) {
        List<String> studentNames =  StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));
        System.out.println("nameList : "+studentNames);

        Set<String> studentNames1 =  StudentDB.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
        System.out.println("nameSet : "+studentNames1);

        studentNames  = StudentDB.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        // through first op, we cna avoid additonal intermediate op which is shown in last command.
    }
}
