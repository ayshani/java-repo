package defaults;

import java.util.List;

public class MultiplierImpl implements Multiplier{

    @Override
    public int multiply(List<Integer> integers) {
        return integers.stream()
                .reduce(1, (x,y) -> x*y);
    }

    public int size(List<Integer> integers){
        System.out.println("Inside MultiplierImpl :");
        return integers.size();
    }
}
