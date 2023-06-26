package dates;

import java.time.*;

public class ZonedDateTimeMain {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime =  ZonedDateTime.now();
        System.out.println("zonedDateTime : "+ zonedDateTime);
        System.out.println("getOffset : "+ zonedDateTime.getOffset());
        System.out.println("getZone : "+ zonedDateTime.getZone());
        //System.out.println("getZone : "+ ZoneId.getAvailableZoneIds());

        ZoneId.getAvailableZoneIds()
                .stream()
                .forEach(System.out::println);
        System.out.println("total Number of Zones  : "+ ZoneId.getAvailableZoneIds().size());
        System.out.println("CST     CST  : "+ ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println("Detroit EST  : "+ ZonedDateTime.now(ZoneId.of("America/Detroit")));
        System.out.println("LA      PST  : "+ ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        System.out.println("Denver  MST  : "+ ZonedDateTime.now(ZoneId.of("America/Denver")));

        System.out.println("Detroit EST using clock  : "
                + ZonedDateTime.now(Clock.system(ZoneId.of("America/Detroit"))));

        LocalDateTime localDateTime =LocalDateTime.now(ZoneId.of("America/Detroit"));
        System.out.println("localDateTime : "+ localDateTime);

        LocalDateTime localDateTime1 =LocalDateTime.now(Clock.system(ZoneId.of("America/Detroit")));
        System.out.println("localDateTime  using clock: "+ localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault());
        System.out.println("localDateTime  using instant: "+ localDateTime1);

        /*
        convert from localDate time, instant to ZonedDateTime
         */
        LocalDateTime localDateTime3 =  LocalDateTime.now();
        System.out.println("localDateTime3 : "+ localDateTime3);
        ZonedDateTime zonedDateTime1 = localDateTime3.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("zonedDateTime1 atZone : "+ zonedDateTime1);

        ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/Chicago"));
        System.out.println("zonedDateTime2 atZone : "+ zonedDateTime2);

        OffsetDateTime offsetDateTime = localDateTime3.atOffset(ZoneOffset.ofHours(-5));
        System.out.println("offsetDateTime : "+ offsetDateTime);
    }
}
