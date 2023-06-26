package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTimeMain {
    public static void parseLocalDateTime(){
        String dateTime = "2023-06-26T14:33:33";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        System.out.println("localDateTime : "+ localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("localDateTime1 : "+ localDateTime1);

        /*
        custom format
         */
        String dateTime1 = "2023-06-26T14|33|33";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime1,dateTimeFormatter);
        System.out.println("localDateTime2 : "+localDateTime2);

        String dateTime2 = "2023-06-26abc14|33|33";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss");
        LocalDateTime localDateTime3 = LocalDateTime.parse(dateTime2,dateTimeFormatter1);
        System.out.println("localDateTime3 : "+localDateTime3);

    }
    public static void formatLocalDateTime(){
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(dateTimeFormatter1);
        System.out.println("format : "+format);
    }

    public static void main(String[] args) {
        parseLocalDateTime();
        formatLocalDateTime();
    }
}
