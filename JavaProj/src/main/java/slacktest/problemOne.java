package slacktest;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class problemOne {

    public static void main(String args[]) {

        solution(2014, "April", "May", "Wednesday");
    }

    public static int solution(int Y, String A, String B, String W) {
        // write your code in Java SE 8
        try{
            Date startDate = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(A);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.set(Calendar.YEAR,Y);

            startDate = calendar.getTime();

            int s = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);


            calendar = Calendar.getInstance();
            Date endDate = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(B);
            calendar.setTime(endDate);
            calendar.set(Calendar.YEAR,Y);
            calendar.setFirstDayOfWeek(Calendar.SUNDAY);

            endDate = calendar.getTime();
            int j = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);

            int smonth = startDate.getMonth();
            int eMonth = endDate.getMonth();
            int weeks = 0;

            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(startDate);
            calendar1.setFirstDayOfWeek(Calendar.MONDAY);
            while(smonth<=eMonth)
            {
                weeks += calendar1.getActualMaximum(Calendar.WEEK_OF_MONTH);
                smonth++;
                calendar1.add(Calendar.MONTH,1);
            }

            System.out.println(weeks +"  -  Total" );

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy");
            String start = formatter.format(startDate);
            String end = formatter.format(endDate);
            System.out.println(start +"  -  " + end);


        }catch (Exception e)
        {}






        return 1;
    }
}
