import java.io.Serializable;

public class DemoObject implements Serializable {

    private String name;
    private int age;

    // transient and static doesn't get serialized and hence not deserialized
    private  transient int car;
    private static int books;

    public DemoObject(String name, int age, int car, int books){
        this.name =name;
        this.age = age;
        this.car =car;
        books = books;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public static int getBooks() {
        return books;
    }

    public static void setBooks(int books) {
        DemoObject.books = books;
    }

    @Override
    public String toString() {
        return "DemoObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
