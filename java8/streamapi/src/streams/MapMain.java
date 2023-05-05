package streams;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class MapMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Alex");
        list.add("Mike");
        list.add("Azure");

        // map() is used to convert each name to upper case.
        // Note: The map() method does not modify the original list.
        list.stream()
                .map(name -> name.toUpperCase()) //map() takes an input of Function<T, R> type.
                .forEach(System.out::println); // forEach() takes an input of Consumer type.

        list.stream()
                .mapToInt(name -> name.length())
                .forEach(System.out::println);

        List<List<String>> flatmap = new ArrayList<>();
        flatmap.add(List.of("a","b","c"));
        flatmap.add(List.of("d","e","f"));
        flatmap.add(List.of("g","h","i"));

        // filter() method do not work on stream of collections
        //This will not print anything
        flatmap.stream()
                .filter(x -> x.equals("a"))
                .forEach(System.out::println);

        //Created a stream from the list.
        // Flattened the stream.
        //Applied filter on flattened stream.
        flatmap.stream()
                .flatMap(s -> s.stream())
                .filter( x-> x.equals("a"))
                .forEach(System.out::println);

    }
}
