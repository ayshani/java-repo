package streams.optional;

import streams.Employee;
import streams.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalMain1 {
    Map<Integer, Employee> employeeMap = new HashMap<>();

    public Optional<Employee> getEmployee(int employeeId){
        return Optional.ofNullable(employeeMap.get(employeeId));
    }
    public static void main(String[] args) {
        OptionalMain1 obj = new OptionalMain1();
        Optional<Employee> employee = obj.getEmployee(123);
        //The isPresent() method is used to check if the optional contains a value or if it is null.
        //
        //The method isPresent() returns the value true in case the id of the Optional objects contains a non-null
        // value. Otherwise, it returns a false value.
        if(employee.isPresent()){
            // We use get() method to get the value from Optional.
            System.out.println(employee.get().getName());
        } else{
            System.out.println("No employee returned.");
        }

        //We can create an empty optional using the empty() method.
        // The optional created through empty() will contain a null value.
        Optional<Person> person = Optional.empty();

        //We can create an Optional object that has a non-null value using of() method. If we create an Optional
        // using the of() method and the value is null, then it will throw a Null Pointer Exception.
        Person person1 = new Person("Abc",23);
        Optional<Person> personOptional = Optional.of(person1);

        //If while creating the Optional, you are not sure if the value is null or not null, then use the ofNullable()
        // method. If a non-null value is passed in Optional.ofNullable(), then it will return the Optional,
        // containing the specified value. Otherwise, it will return an empty Optional.
        Optional<Person> personOptional1 = Optional.ofNullable(person1);

        obj.populateEmployee();
        Optional<Employee> employee1 = obj.getEmployee(123);
        employee1.ifPresent(System.out::println);

        // This method returns the value present in the optional. If no value is present,
        // then a default value provided as a parameter is returned.
        Optional<String> stringOptional = Optional.ofNullable(null);
        System.out.println(stringOptional.orElse("Default String"));

        // This method returns the value present in the optional. If no value is present, then the
        // value calculated from the supplier provided as a parameter is returned.
        System.out.println(stringOptional.orElseGet(OptionalMain1::getDefaultValue));

        try{
            System.out.println(stringOptional.orElseThrow(() -> new Exception(" Resource not found")));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        Optional<String> stringOptional1 = Optional.ofNullable("orange");
        // Since the filter condition is matched, this will return the optional.
        System.out.println(stringOptional1.filter(str -> str.equals("orange")));
        // Since the filter condition is not matched, this will return empty optional.
        System.out.println(stringOptional1.filter(str -> str.equals("apple")));

        // Creating an Optional of Employee object.
        Optional<Employee> optional = Optional.of(new Employee("Adam", 54, 20000));
        //As per Java docs, “if a value is present, apply the provided mapping function to it, and if the result
        // is non-null, return an Optional describing the result. Otherwise, return an empty Optional.”
        optional
                .map(emp -> emp.getSalary()) // Fetching the salary from employee object.
                .filter(sal -> sal > 10000) // Checking if the salary is greater than 10000.
                .ifPresent(System.out::println);


        optional.flatMap(emp -> emp.getSalaryOptional())
                .filter(sal -> sal > 10000)
                .ifPresent(System.out::println);
    }

    public void populateEmployee(){
        employeeMap.put(123, new Employee("Alex", 23, 277899));
    }

    public static String getDefaultValue(){
        return " static default vale";
    }
}
