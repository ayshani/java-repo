package dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeMain {

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime : "+localTime);

        LocalTime localTime1 =  LocalTime.of(23,23);
        System.out.println("LocalTime1 : "+localTime1);

        LocalTime localTime2 =  LocalTime.of(23,23,5);
        System.out.println("LocalTime2 : "+localTime2);

        LocalTime localTime3 =  LocalTime.of(23,23,5,100);
        System.out.println("LocalTime3 : "+localTime3);

        /*
        Getting
         */
        System.out.println("Hour :" +localTime.getHour());
        System.out.println("Minute :" +localTime.getMinute());
        System.out.println("CLOCK_HOUR_OF_DAY :" +localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println("toSecondOfDay :" +localTime.toSecondOfDay());

        /*
        modify the times
         */
        System.out.println("minus Hour :" +localTime.minusHours(2));
        System.out.println("minus Hour :" +localTime.minus(2, ChronoUnit.HOURS));
        System.out.println("MIDNIGHT Hour :" +localTime.with(LocalTime.MIDNIGHT));
        System.out.println(" HOUR_OF_DAY :" +localTime.with(ChronoField.HOUR_OF_DAY,2));
        System.out.println(" plusMinutes :" +localTime.plusMinutes(30));
        System.out.println(" withHour :" +localTime.withHour(5));

    }
}
