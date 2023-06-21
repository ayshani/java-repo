package streams;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;

public class StreamMinMaxMain {

    public static int getMax(List<Integer> integerList){
        return integerList.stream()
                .reduce(0, (x,y)-> x>y?x:y);
    }

    public static Optional<Integer>  getMin(List<Integer> integerList){
        return integerList.stream()
                .reduce( (x,y)-> x<y?x:y);
    }

    public static Optional<Integer> getMaxOptional(List<Integer> integerList){
        return integerList.stream()
                .reduce((x,y)-> x>y?x:y);
    }

    public static void main(String[] args) {
        List<Integer> integerList= List.of(6,7,8,9,10);
        List<Integer> integerList1= List.of();

        System.out.println("max: "+getMax(integerList));
        Optional<Integer> integerOptional =  getMaxOptional(integerList1);
        if(integerOptional.isPresent())
            System.out.println("max: "+integerOptional.get());
        else
            System.out.println("No max value is present");

        System.out.println("min: "+ getMin(integerList));
        Optional<Integer> minOptional =  getMin(integerList1);
        if(minOptional.isPresent())
            System.out.println("min : "+minOptional.get());
        else
            System.out.println("No min value is present");
    }
}
