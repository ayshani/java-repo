package java8.lamda.functionalinterfaces;

import java8.lamda.comparator.Person;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateMain {
    public static void main(String[] args) {
        Person person = new Person("Alex",23,20);

        // create a normal predicate
        //It returns true if age is greater than 18.
        Predicate<Person> normalPredicate = p -> p.getAge()>18;

        boolean eligibleForVoting = PredicateDemo.isPersonEligibleForVoting(person,normalPredicate);
        System.out.println("Person is eligible for voting: " + eligibleForVoting);

        // and predicate
        Predicate<Person> greaterThan18 = p -> p.getAge()>18;
        Predicate<Person> lessThan60 = p -> p.getAge()<60;

        Predicate<Person> andPredicate = greaterThan18.and(lessThan60);

        boolean eligibleForMembership = PredicateDemo.isPersonEligibleForVoting(person,andPredicate);
        System.out.println("Person is eligible for membership: " + eligibleForMembership);

        // or Predicate - check for retirement age <60 and service year >30
        Predicate<Person> serviceYearGreatrThan30 = p -> p.getYearOfService()>30;
        Predicate<Person> ageGreaterThan60 = p -> p.getAge() >60;

        Predicate<Person> orPredicate = ageGreaterThan60.or(serviceYearGreatrThan30);

        boolean eligibleForRetirement = PredicateDemo.isPersonEligibleForRetirement(person,orPredicate);
        System.out.println("Person is eligible for retirement: " + eligibleForRetirement);

        // negatePredicate
        Predicate<Integer> numberGreateThan10 = p -> p >10;
        boolean isLessThan10 = PredicateDemo.isNumberLessThanTen(numberGreateThan10);
        System.out.println("Number less than 10: " + isLessThan10);

        // isEqual Predicate
        Predicate<String > equalPredicate = Predicate.isEqual("Hello");
        System.out.println(equalPredicate.test("Welcome"));


        // BiPredicate
        boolean eligibleForVotingBiPredicate = PredicateDemo.isPersonEligibleForVoting(person,18,
                (p,minAge) -> {
                    return person.getAge()>minAge;
                });
        System.out.println("Person eligible for Voting BiPredicate : " + eligibleForVotingBiPredicate);

        // Supplier predicate
        Supplier<Person> supplier = () -> new Person("Zombie" ,23,30);
        boolean eligibleForVotingThroughSupplier = PredicateDemo.isPersonEligibleForVoting(supplier,greaterThan18);
        System.out.println("Person : "+  supplier.get().getName() + " is eligible for voting through supplier : " + eligibleForVotingThroughSupplier);

    }
}
