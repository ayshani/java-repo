package streams.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamMain {

    public static  long checkPerformance(Supplier<Integer> supplier, int noOfTimes){

        long startTime = System.currentTimeMillis();
        for(int i=0;i<noOfTimes;i++){
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    public static int seqSum(){
        return IntStream.rangeClosed(1,1000000)
                .sum();
    }

    public static int parallelSum(){
        return IntStream.rangeClosed(1,1000000)
                .parallel()
                .sum();
    }
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("Seq sum : "+checkPerformance(ParallelStreamMain::seqSum, 20));
        System.out.println("Parallel sum : "+checkPerformance(ParallelStreamMain::parallelSum, 20));


    }
}
