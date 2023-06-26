package streams;

import common.Student;
import common.StudentDB;

public class StreamMapReduceMain {

    private static int getAllNotBooks(){
        return StudentDB.getAllStudents().stream()
                .filter(student -> student.getGradeLevel()>=3)
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getNoteBookes)
                //.reduce(0,(intermediate,value) -> intermediate+value);
                .reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        System.out.println(getAllNotBooks());
    }
}
