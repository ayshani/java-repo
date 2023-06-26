package dates;

import java.time.Duration;
import java.time.Instant;

public class InstantMain {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("Instant : "+ instant);
        System.out.println("instant.getNano() : "+ instant.getNano());
        System.out.println("instant.getEpochSecond() : "+ instant.getEpochSecond());
        System.out.println("Instant.ofEpochSecond() : "+ Instant.ofEpochSecond(0));

        Instant instant1 = Instant.now();

        Duration duration = Duration.between(instant,instant1);
        System.out.println("getNano : "+ duration.getNano());

    }
}
