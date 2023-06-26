package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeMain {

    public static void main(String[] args) {
        LocalDateTime localDateTime =  LocalDateTime.now();
        System.out.println("localDateTime : "+localDateTime);

        LocalDateTime localDateTime1 =  LocalDateTime.of(2023,03,21,
                23,10,20,5555902);
        System.out.println("localDateTime1 : "+localDateTime1);

        LocalDateTime localDateTime2 =  LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("localDateTime2 : "+localDateTime2);

        /*Getting
         */

        System.out.println("Hour : "+localDateTime.getHour());
        System.out.println("getMinute : "+localDateTime.getMinute());
        System.out.println("getDayOfMonth : "+localDateTime.getDayOfMonth());
        System.out.println("DAY_OF_MONTH : "+localDateTime.get(ChronoField.DAY_OF_MONTH));

        /*
        modifying
         */
        System.out.println("plusHours : "+localDateTime.plusHours(2));
        System.out.println("minusDays : "+localDateTime.minusDays(2));
        System.out.println("withMonth : "+localDateTime.withMonth(2));

        /*
        converting LocalDate, LocalTime to localDateTime and vice versa
         */
        LocalDate localDate = LocalDate.of(2020,01,01);
        System.out.println("atTime : "+ localDate.atTime(4,30));
        LocalTime localTime = LocalTime.of(2,30);
        System.out.println("atDate : "+ localTime.atDate(localDate));

        LocalDateTime localDateTime3 =  localTime.atDate(localDate);
        System.out.println("toLocalDate : "+ localDateTime3.toLocalDate());
        System.out.println("toLocalTime : "+ localDateTime3.toLocalTime());
    }
}
