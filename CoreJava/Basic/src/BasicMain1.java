import java.util.ArrayList;
import java.util.List;

public class BasicMain1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        A obj = new A();
        obj.print("abc",10);
        obj.print("dgvc",Integer.valueOf(10));

        final List<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println(list.size());
    }
}

class A{
    void print(String str, int i){
        System.out.println("method1");
    }

    void print(String str, Integer i){
        System.out.println("method2");
    }
}