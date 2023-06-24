package streams.parallelstream;

import java.util.stream.IntStream;

public class SumClient {

    public static void main(String[] args) {
        Sum sum = new Sum();
        IntStream.rangeClosed(1,10000)
                .parallel()
                .forEach(sum::performSum);
        System.out.println(sum.getTotal());
        //33171033
        //40819543
        //46775492

        // Everytime we run , we ll get different sum as we are using total as mutable variable
        // which is getting race condition. Hence do not use parallel() for mutable variables
    }
}
