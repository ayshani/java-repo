package streams;

class Person {
    String name;
    int age;
    String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, String country) {
        this(name, age);
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
