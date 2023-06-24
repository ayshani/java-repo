package streams.numericstreams;

import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamMain {

    public static int sumOfNnumbers(List<Integer> integerList){
        return integerList.stream()
                .reduce(0,(x,y) -> x+y);
    }

    public static int sumOfNnumbersIntStreams(List<Integer> integerList){

        return IntStream.rangeClosed(1,6).sum();
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,4,5,6);

        System.out.println(sumOfNnumbers(integerList));
        System.out.println("Using Int Streams : "+sumOfNnumbers(integerList));
    }
}
