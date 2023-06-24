package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
reduction operations#

Reduction stream operations are those operations that reduce the stream into a single value. The operations that
we are going to discuss in this lesson are immutable operations because they reduce the result into a single-valued
immutable variable. Given a collection of objects, we may need to get the sum of all the elements, the max element,
or any other operation which gives us a single value as a result. This can be achieved through reduction operations.

Before we discuss all the reduction operations in detail, let’s first look at some key concepts of reduction:

Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty.
Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element
of the stream.
Combiner – a function used to combine the partial result of the reduction operation when

the reduction is parallelized.

or there’s a mismatch between the types of the accumulator arguments and the types of the accumulator implementation.
 */
public class ReductionMain {
    public static void main(String[] args) {


        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Dave", 23,20000));
        list.add(new Employee("Joe", 18,40000));
        list.add(new Employee("Ryan", 54,100000));
        list.add(new Employee("Iyan", 5,34000));
        list.add(new Employee("Ray", 63,54000));

        //Optional<T> reduce(BinaryOperator<T> accumulator)
        Optional<Integer> totalSalary = list.stream()
                .map(p-> p.getSalary())//We are converting the Stream of Employees to Stream of salaries.
                .reduce((p,q) -> p+q);

        if(totalSalary.isPresent()){
            System.out.println("The total salary is " + totalSalary.get());
        }
        int total = list.stream()
                .mapToInt(p-> p.getSalary())
                .sum();
        System.out.println("The total salary using mapToInt is " + total);

        //T reduce(T identity, BinaryOperator<T> accumulator)
        //As per Java docs, this method “performs a reduction on the elements of this stream,
        // using the provided identity value and an associative accumulation function, and returns the reduced value.”
        //
        //This method has an extra ‘identity’ parameter. It is the initial value of reduction.
        // It is the default result of reduction if there are no elements in the stream. That’s the reason,
        // this version of the reduce method doesn’t return Optional because it would at least return the
        // identity element.

        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);

        int totalSum = numList.stream()
                .reduce(5, (partialSum, num) -> num+partialSum);
        System.out.println("The total sum is " + totalSum);

        List<Integer> integers = List.of(1,3,5,7);
        List<Integer> integers1 = List.of();
        System.out.println(performMultiplication(integers));

        Optional<Integer> result =  performMultiplicationWithoutIdentity(integers);
        System.out.println(result.isPresent());
        System.out.println(result.get());

        Optional<Integer> result2 =  performMultiplicationWithoutIdentity(integers1);
        if(result2.isPresent())
            System.out.println(result2.get());
        Optional<Student> studentOptional = getHighestGPAStudent();
        if(studentOptional.isPresent()){
            System.out.println(studentOptional.get());
        }
    }

    public static int performMultiplication(List<Integer> integers){
        return integers.stream()
                .reduce(1, (a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integers){
        return integers.stream()
                .reduce( (a,b) -> a*b);

    }

    public static Optional<Student> getHighestGPAStudent(){
        return StudentDB.getAllStudents().stream()
                .reduce((s1,s2) -> s1.getGpa()>s2.getGpa()?s1:s2);
    }
}
