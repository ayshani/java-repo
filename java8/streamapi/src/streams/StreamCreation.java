package streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7);
        stream.forEach(System.out::println);
        List<String> list = List.of("a","b","c","d");
        Stream<String> stringStream = list.stream();
        stringStream.forEach(System.out::println);
    }
}
