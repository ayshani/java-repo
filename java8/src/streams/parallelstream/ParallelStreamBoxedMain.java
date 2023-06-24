package streams.parallelstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamBoxedMain {

    public static int sequentialSum(List<Integer> list){
        long startTime = System.currentTimeMillis();
        int sum =  list.stream().reduce(0, (x,y) -> x+y);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time : "+ (endTime-startTime));
        return sum;
    }

    public static int parallelSum(List<Integer> list){
        long startTime = System.currentTimeMillis();
        int sum =  list.stream().parallel().reduce(0, (x,y) -> x+y);
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel time : "+ (endTime-startTime));
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> ints =IntStream.rangeClosed(1,10000).boxed().collect(Collectors.toList());
        sequentialSum(ints);
        parallelSum(ints);
    }
}
