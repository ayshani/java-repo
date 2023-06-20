package imperativedeclarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {
        /*
        Imperative way of getting summations
        External iterations
        how we are getting the results
        need to be careful with multithreaded env
         */
        int sum =0;
        for(int i=0;i<500;i++){
            sum+=i;
        }
        System.out.println(sum);

        /*
        Declarative way of getting summations
        Internal iterations
        focus on the result, don't care about how
        for multithreaded env, we can add another method
         */

        int sumI = IntStream.rangeClosed(0,500)
              //  .parallel()
                .sum();
        System.out.println(sumI);
    }
}
