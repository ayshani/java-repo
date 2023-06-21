package streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreams {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");

        for(String name : names){
            System.out.println(name);
        }

        for(String name : names){
            System.out.println(name);
        }

        names.remove(0);
        System.out.println(names);

        //cant do addition or modification in streams.
        //list.stream().

        Stream<String> nameStreams  = names.stream();
        nameStreams.forEach(System.out::println);
        // cant access same stream again
        nameStreams.forEach(System.out::println);
    }
}
