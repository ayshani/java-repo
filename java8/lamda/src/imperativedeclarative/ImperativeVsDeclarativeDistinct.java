package imperativedeclarative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeVsDeclarativeDistinct {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,3,4,5,5,6,7,7,7);

        /*
        Imperative
         */
        List<Integer> unique = new ArrayList<>();
        for(int i=0;i<integerList.size();i++){
            if(!unique.contains(integerList.get(i))){
                unique.add(integerList.get(i));
            }
        }

        System.out.println(unique);

        /*
        Declarative
         */
        List<Integer> unique1 = integerList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(unique1);
    }
}
