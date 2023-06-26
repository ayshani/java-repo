package dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalTimeMain {

    public static void parseTime(){
        String time  ="13:00";
        LocalTime localTime = LocalTime.parse(time);
        System.out.println("LocalTime : "+ localTime);

        LocalTime localTime1 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("LocalTime1 : "+ localTime1);

        /*
        custom defined format
         */
        String time1  ="14*00";
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("HH*mm");
        LocalTime localTime2 = LocalTime.parse(time1, dateTimeFormatter);
        System.out.println("localTime2 : "+ localTime2);

        String time2  ="14*00*02";
        DateTimeFormatter dateTimeFormatter1 =  DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime localTime3 = LocalTime.parse(time2, dateTimeFormatter1);
        System.out.println("localTime3 : "+ localTime3);
    }

    public static void formatTime(){
        DateTimeFormatter dateTimeFormatter1 =  DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime localTime = LocalTime.now();
        String format = localTime.format(dateTimeFormatter1);
        System.out.println("format : "+ format);
    }

    public static void main(String[] args) {
        parseTime();
        formatTime();
    }
}
