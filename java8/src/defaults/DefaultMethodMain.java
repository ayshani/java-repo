package defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class DefaultMethodMain {
    public static void main(String[] args) {
        List<String>  list =  Arrays.asList("Adam","Jenny","Sam","Alex","Bob");


        // prior java 8
        Collections.sort(list);
        System.out.println(list);

        //after jaava8
        List<String>  list1 =  Arrays.asList("Adam","Jenny","Sam","Alex","Bob");
        list1.sort(Comparator.naturalOrder());
        System.out.println(list1);
        list1.sort(Comparator.reverseOrder());
        System.out.println(list1);

    }
}
