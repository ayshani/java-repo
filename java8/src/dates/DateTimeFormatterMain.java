package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterMain {

    public static void parseLocalDate(){
        /*
        String to localDate
         */
        String date = "2023-06-26";
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("localDate : "+ localDate);

        LocalDate localDate1 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate1 : "+ localDate1);

        String date1 = "20230626";
        LocalDate localDate2 = LocalDate.parse(date1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("localDate2 : "+ localDate2);

        /*
        Custom defined date format
         */
        String date3 = "2023|06|26";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate3 = LocalDate.parse(date3,dateTimeFormatter);
        System.out.println("localDate3 : "+ localDate3);

        String date4 = "2023/06/26";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate4 = LocalDate.parse(date4,dateTimeFormatter1);
        System.out.println("localDate4 : "+ localDate4);
    }

    public static void formatLocalDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(dateTimeFormatter);
        System.out.println("format1 : "+format1);
    }
    public static void main(String[] args) {
        parseLocalDate();
        formatLocalDate();
    }
}
