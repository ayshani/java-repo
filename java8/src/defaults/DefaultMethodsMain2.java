package defaults;

import common.Student;
import common.StudentDB;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodsMain2 {

    static Consumer<Student> studentConsumer = student -> System.out.println(student);
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);

    public static void sortByNames(List<Student> students){
        System.out.println("After sort : ");

        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        students.sort(nameComparator);
        //System.out.println(students);
        students.forEach(studentConsumer);
    }

    public static void sortByGpa(List<Student> students){
        System.out.println("After sort GPA: ");
        Comparator<Student> gpaComparator = Comparator.comparing(Student::getGpa);
        students.sort(gpaComparator);
        students.forEach(studentConsumer);
    }

    public static void comparatorChain(List<Student> students){
        System.out.println("After comparator chain sort :");
        students.sort(gradeComparator.thenComparing(nameComparator));
        students.forEach(studentConsumer);
    }

    public static void sortWithNullValuesFirst(List<Student> students){
        System.out.println("After sortWithNullValues first:");
        Comparator<Student> studentComparator =  Comparator.nullsFirst(nameComparator);
        students.sort(studentComparator);
        students.forEach(studentConsumer);
    }

    public static void sortWithNullValuesLast(List<Student> students){
        System.out.println("After sortWithNullValues last :");
        Comparator<Student> studentComparator =  Comparator.nullsLast(nameComparator);
        students.sort(studentComparator);
        students.forEach(studentConsumer);
    }
    public static void main(String[] args) {
        List<Student> students = StudentDB.getAllStudents();
        System.out.println("Before sort : ");
        students.forEach(studentConsumer);

        /*sortByNames(StudentDB.getAllStudents());
        sortByGpa(students);
        comparatorChain(students);
        */
        sortWithNullValuesFirst(students);
        sortWithNullValuesLast(students);
    }
}
