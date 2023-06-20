package java8.lamda.comparator;

import java.util.Comparator;

public class ComparatorLamda {
    public static void main(String[] args) {
        /*
        Before java 8
         */
        Comparator<Integer> integerComparator =  new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 0 -> o1==o2
                // -1 -> o1<o2
                // 1  -> o1>o2
                return o1.compareTo(o2);
            }
        };
        System.out.println("Comparator : " + integerComparator.compare(3,2));
        /*
        After java 8
         */

        Comparator<Integer> integerComparator1 = (Integer a, Integer b) ->  a.compareTo(b) ;
        System.out.println("Comparator  lamda: " + integerComparator1.compare(3,2));

        Comparator<Integer> integerComparator2 = (a, b) ->  a.compareTo(b) ;
        System.out.println("Comparator  lamda short: " + integerComparator2.compare(3,2));

    }
}
