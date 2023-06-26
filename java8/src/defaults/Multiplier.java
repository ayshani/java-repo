package defaults;

import java.util.List;

public interface Multiplier {

    int multiply(List<Integer> integers);

    default int size(List<Integer> integers){
        System.out.println("Inside Multiplier Interface");
        return integers.size();
    }

    static boolean isEmpty(List<Integer> integers){
        return integers!=null && integers.size()>0;
    }
}
