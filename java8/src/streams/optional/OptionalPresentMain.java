package streams.optional;

import java.util.Optional;

public class OptionalPresentMain {

    public static void main(String[] args) {
        //isPresent
        Optional<String> optional = Optional.ofNullable("hello");
        Optional<String> optional1 = Optional.ofNullable(null);
        System.out.println(optional.isPresent());
        System.out.println(optional1.isPresent());
        if(optional.isPresent()){
            System.out.println(optional.get());
        }

        optional.ifPresent(System.out::println);
    }
}
