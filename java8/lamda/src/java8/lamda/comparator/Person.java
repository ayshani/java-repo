package java8.lamda.comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Person {
    private String name;
    private int age;
    private String country;
    private int yearOfService;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public Person(String name, int age, int yearOfService) {
        this.name = name;
        this.age = age;
        this.yearOfService = yearOfService;
    }
}
