package streams.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapMain {

    public static List<Integer> mapTOObject(){
        return IntStream.rangeClosed(1,5)
                .mapToObj((i) -> new Integer(i))
                .collect(Collectors.toList());
    }

    public static long mapTOLong(){
        return IntStream.rangeClosed(1,5)
                .mapToLong((i) -> i)
                .sum();
    }

    public static double mapTODouble(){
        return IntStream.rangeClosed(1,5)
                .mapToDouble((i) -> i)
                .sum();
    }
    public static void main(String[] args) {
        System.out.println(mapTOObject());
        System.out.println(mapTOLong());
        System.out.println(mapTODouble());
    }
}
