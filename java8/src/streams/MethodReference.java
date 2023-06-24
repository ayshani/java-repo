package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {

    public static int getLength(String s){
        return s.length();
    }

    public  int getInstanceLength(String s){
        return s.length();
    }
    public static void main(String[] args) {
        Consumer<String> consumer1 = s-> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;
        Function<Person, Integer> function1 = p -> p.getAge();
        Function<Person, Integer> function2 = Person::getAge;

        List<String> list = new ArrayList<>();
        list.add("Alex");
        list.add("Missi");
        list.add("Lov");
        list.add("Mike");

        //The syntax to use static methods as method reference is ClassName::MethodName.
        // Code without using static method reference.
        list.stream()
                .mapToInt(str -> MethodReference.getLength(str))
                .forEach(System.out::println);

        // Code with static method reference.
        list.stream()
                .mapToInt(MethodReference::getLength)
                .forEach(System.out::println);

        //The syntax to use the instance method as a method reference is ReferenceVariable::MethodName
        // Code without instance method reference.
        MethodReference mr = new MethodReference();
        list.stream()
                .mapToInt(str -> mr.getInstanceLength(str))
                .forEach(System.out::println);

        // Code with instance method reference.
        list.stream()
                .mapToInt(mr::getInstanceLength)
                .forEach(System.out::println);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex",34,20000));
        employees.add(new Employee("Wiki",12,34522));
        employees.add(new Employee("Mike",20,26764));
        employees.add(new Employee("Missi",30,111000));

        //Instance method of an arbitrary object
        // Code without using method reference
        int totalSalary1 = employees.stream()
                .mapToInt(employee -> employee.getSalary())
                .sum();

        // Code with method reference
        int totalSalary2 = employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();

        System.out.println("The total Salary : "+ totalSalary2);

        //Constructor references
        List<String> nameList = new ArrayList<>();
        nameList.add("Dave");
        nameList.add("Missi");
        nameList.add("Wiki");
        nameList.add("Mike");

        // Code without constructor reference
        nameList.stream()
                .map(name -> new Employee(name))
                .forEach(System.out::println);

        // Code with constructor reference
        nameList.stream()
                .map(Employee::new)
                .forEach(System.out::println);


    }
}

