package streams;

import java.util.List;
import java.util.Optional;

public class StreamLimitSkipMain {

    public static Optional<Integer> limit(List<Integer> integerList){
        return integerList.stream()
                .limit(3)
                .reduce((x,y) -> x+y);
    }

    public static Optional<Integer> skip(List<Integer> integerList){
        return integerList.stream()
                .skip(3)
                .reduce((x,y) -> x+y);
    }
    public static void main(String[] args) {
        List<Integer> integerList= List.of(6,7,8,9,10);
        Optional<Integer> limitResult = limit(integerList);
        if(limitResult.isPresent()){
            System.out.println(limitResult.get());
        }

        Optional<Integer> skipResult = skip(integerList);
        if(skipResult.isPresent()){
            System.out.println(skipResult.get());
        }
    }
}
