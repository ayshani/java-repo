package streams.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableMain {

    public static Optional<String> ofNullable(){
        Optional<String> stringOptional = Optional.ofNullable("hello");
        return stringOptional;
    }

    public static Optional<String> of(){
        Optional<String> stringOptional = Optional.of("hello");
        return stringOptional;
    }

    public static Optional<String> empty(){
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(ofNullable());
        System.out.println(of());
        System.out.println(empty());

    }
}
