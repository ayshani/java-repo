package java8.lamda.functionalinterfaces.predicate;

import java8.lamda.comparator.Person;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateDemo {
    public static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    public static boolean isNumberLessThanTen(Predicate<Integer> predicate){
        return predicate.negate().test(14);
    }

    public static boolean isPersonEligibleForMemership(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    public static boolean isPersonEligibleForRetirement(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    public static boolean isPersonEligibleForVoting(Person person, Integer minAge, BiPredicate<Person,Integer> predicate){
        return predicate.test(person,minAge);
    }

    public static boolean isPersonEligibleForVoting(Supplier<Person> supplier, Predicate<Person> predicate){
        return predicate.test(supplier.get());
    }

}
