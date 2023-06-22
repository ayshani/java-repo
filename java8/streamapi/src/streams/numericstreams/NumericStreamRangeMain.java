package streams.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangeMain {

    public static void main(String[] args) {
        IntStream intStream =  IntStream.range(1,50);
        System.out.println(intStream.count());

        IntStream.range(1,50).forEach(value -> System.out.print(value+", "));
        System.out.println("Range count : "+IntStream.range(1,50).count());
        System.out.println("Range closed count : "+IntStream.rangeClosed(1,50).count());
        IntStream.rangeClosed(1,50).forEach(value -> System.out.print(value+", "));

        System.out.println("Long Range closed count : "+LongStream.rangeClosed(1,50).count());
        LongStream.rangeClosed(1,50).forEach(value -> System.out.print(value+", "));
        System.out.println();
        IntStream.range(1,50).asDoubleStream().forEach(value -> System.out.print(value+", "));
    }
}
