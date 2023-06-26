package dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateMain {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Local Date : "+ localDate);

        LocalDate localDate1 = LocalDate.of(2023, 07,17);
        System.out.println("Local Date1 : "+ localDate1);

        LocalDate localDate2 = LocalDate.ofYearDay(2018,02);
        System.out.println("Local Date2 : "+ localDate2);

        /*
        Get values from local date
         */
        System.out.println("Month : "+ localDate.getMonth());
        System.out.println("Month : "+ localDate.getMonthValue());
        System.out.println("Day of week : "+ localDate.getDayOfWeek());
        System.out.println("Day of year : "+ localDate.getDayOfYear());
        System.out.println("day of Month using get : "+ localDate.get(ChronoField.DAY_OF_MONTH));

        /*
        modifying local date
         */
        System.out.println("plus days : "+localDate.plusDays(2));
        System.out.println("plus months : "+localDate.plusMonths(2));
        System.out.println("minus days : "+localDate.minusDays(2));
        System.out.println("with year : "+localDate.withYear(2024));
        System.out.println("with year using chronofield  : "+localDate.with(ChronoField.YEAR,2025));
        System.out.println("with year using temporalAdjuster  : "+localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("minus years using minus : "+localDate.minus(2, ChronoUnit.YEARS));

        /*
        Additional support
         */
        System.out.println("leap year  : "+ localDate.isLeapYear());
        System.out.println("leap year  : "+ LocalDate.of(2020,01,21).isLeapYear());
        System.out.println("Equals : "+ localDate.equals(localDate1));
        System.out.println("Before : "+ localDate.isBefore(localDate1));
        System.out.println("After : "+ localDate1.isAfter(localDate));

        /*
        unsupported
         */
        //System.out.println("minus years using minus : "+localDate.minus(1, ChronoUnit.MINUTES));
        System.out.println("Is minute supported: "+localDate.isSupported(ChronoUnit.MINUTES));

    }
}
