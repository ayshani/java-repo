package dates;

import java.time.LocalDate;
import java.time.Period;

public class ComparingDatesPeriodMain {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2020,1,1);
        LocalDate localDate1 = LocalDate.of(2020,12,31);

        Period period = localDate.until(localDate1);
        System.out.println("period : "+period);
        System.out.println("getDays : "+period.getDays());
        System.out.println("getMonths : "+period.getMonths());
        System.out.println("getYears : "+period.getYears());

        Period period1 =Period.ofDays(10);
        System.out.println("period1.getDays : "+period1.getDays());

        Period period2 =Period.ofYears(10);
        System.out.println("period2 : "+period2.getYears());
        System.out.println("toTotalMonths : "+period2.toTotalMonths());

        Period period3 = Period.between(localDate,localDate1);
        System.out.println("period3 : "+ period3);
        System.out.println("period3 :  : "+ period3.getDays()  +" : "+period3.getMonths() +" : "+period3.getYears());
    }
}
