package defaults;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> integerList = Arrays.asList(1,3,5);
        System.out.println("multiply : "+multiplier.multiply(integerList));
        System.out.println("Size : "+multiplier.size(integerList));
        System.out.println("isEmpty : "+Multiplier.isEmpty(integerList));

    }
}
