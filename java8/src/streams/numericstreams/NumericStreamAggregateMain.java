package streams.numericstreams;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateMain {

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1,5).sum();
        System.out.println(sum);

        OptionalInt optionalInt = IntStream.rangeClosed(1,5).max();
        OptionalInt optionalInt1 = IntStream.rangeClosed(0,0).max();
        System.out.println("Max value is :"+ (optionalInt.isPresent()? optionalInt.getAsInt(): 0));
        System.out.println("Max value is :"+ (optionalInt1.isPresent()? optionalInt1.getAsInt(): 0));

        OptionalLong optionalLong = LongStream.rangeClosed(3,5).min();
        System.out.println("Optional Long : "+ (optionalLong.isPresent()? optionalLong.getAsLong():0L));

        OptionalDouble optionalDouble = IntStream.rangeClosed(1,10).average();
        System.out.println("Optional Double average : "+ (optionalDouble.isPresent()? optionalDouble.getAsDouble():0.0));
    }
}
