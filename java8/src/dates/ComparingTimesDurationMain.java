package dates;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

// Duration is only for time related things
// if u pass Date relate dthings, it ll not give any compilation issue, but you will get RuntimeException
public class ComparingTimesDurationMain {
    public static void main(String[] args) {
        LocalTime localTime  = LocalTime.of(7,20);
        LocalTime localTime1  = LocalTime.of(8,20);

        long diff = localTime.until(localTime1, ChronoUnit.MINUTES);
        System.out.println("diff: "+diff);

        Duration duration = Duration.between(localTime,localTime1);
        System.out.println("duration : "+duration);
        System.out.println("toMinutes : "+duration.toMinutes());

        Duration duration1 = Duration.ofHours(3);
        System.out.println("duration1 : "+duration1);
        System.out.println("toMinutes : "+duration1.toMinutes());

    }
}
