package streams.optional;

import streams.Student;

import java.util.Optional;

public class OptionalMain {

    public static String getStudentName(){
       //Student student =  StudentDB.studentSupplier.get();
        Student student = null;
        if(student!=null){
            return student.getName();
        }else{
            return null;
        }
    }

    public static Optional<String> getStudentnameOptional(){
        //Optional<Student> studentOptional =  Optional.ofNullable(StudentDB.studentSupplier.get());
        Optional<Student> studentOptional =  Optional.ofNullable(null);
        if(studentOptional.isPresent()){
            return studentOptional.map(Student::getName);
        }
        return Optional.empty();
    }
    public static void main(String[] args) {
        String name = getStudentName();
        if(name != null)
            System.out.println("length of studnet name : "+ name.length());
        else
            System.out.println("name not found");

        Optional<String> nameOptional = getStudentnameOptional();
        if(nameOptional.isPresent())
            System.out.println(nameOptional.get().length());
        else
            System.out.println("name not found");
    }
}
