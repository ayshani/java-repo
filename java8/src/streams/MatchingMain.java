package streams;

import common.StudentDB;

import java.util.ArrayList;
import java.util.List;

/*
There are mainly three matching functions available in Stream. These are:

anyMatch()
allMatch()
noneMatch()

 */
public class MatchingMain {
    public static void main(String[] args) {
        //anyMatch()
        //It takes a predicate as input and return
        //true if at least one element matches the criteria.
        //false if no element matches the criteria.
        //false if the stream is empty.

        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23,"India"));
        list.add(new Person("Joe", 18,"USA"));
        list.add(new Person("Ryan", 54,"Canada"));
        list.add(new Person("Iyan", 5,"India"));
        list.add(new Person("Ray", 63,"China"));

        boolean anyCanadian = list.stream()
                .anyMatch( p-> p.getCountry().equals("Canada"));

        System.out.println("Is there any resident of Canada: " + anyCanadian);

        //allMatch()
        //It takes a predicate as input and returns
        //true if all elements match the criteria.
        //true if the stream is empty.
        //false if even a single element does not match the criteria.

        anyCanadian = list.stream()
                .allMatch(p -> p.getCountry().equals("Canada"));
        System.out.println("Are there all resident of Canada: " + anyCanadian);

        //noneMatch()
        //It takes a predicate as input and returns
        //true if no elements of the stream match the provided predicate.
        //true if the stream is empty.
        //false if even a single element matches the criteria.
        boolean anyRussian = list.stream()
                .noneMatch(p-> p.getCountry().equals("Russia"));
        System.out.println("Are there no resident of Russia: " + anyRussian);

        System.out.println("-------------");
        System.out.println(allMatch());
        System.out.println("-------------");
        System.out.println(anyMatch());
        System.out.println("-------------");
        System.out.println(noneMatch());

    }

    public static boolean allMatch(){
        return StudentDB.getAllStudents()
                .stream()
                .allMatch(student -> student.getGpa()>=3.9);
    }

    public static boolean anyMatch(){
        return StudentDB.getAllStudents()
                .stream()
                .anyMatch(student -> student.getGpa()==2);
    }

    public static boolean noneMatch(){
        return StudentDB.getAllStudents()
                .stream()
                .noneMatch(student -> student.getGpa()==2);
    }
}
