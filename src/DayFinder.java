import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Balasubramanian on 5/21/14.
 */
public class DayFinder
{
    private String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    public String getDay(String date)
    {
        int day = Integer.parseInt(date.split(" ")[0]);
        int month = Integer.parseInt(date.split(" ")[1]);
        int year = Integer.parseInt(date.split(" ")[2]);

        int startDayOfYear = ((year-1) + (year-1)/4 - (year-1)/100 + (year-1)/400 + 1) % 7;
        System.out.println(startDayOfYear);

        int offsetFromStartOfYear = 0;

        for(int idx = 1; idx < month; ++idx)
        {
            offsetFromStartOfYear += getTotalDaysInTheMonth(idx, year) % 7;
        }
        System.out.println(offsetFromStartOfYear);

        offsetFromStartOfYear += day-1;

        int dayOfWeek = (startDayOfYear + offsetFromStartOfYear) % 7;

        return days[dayOfWeek];
    }

    public String getDayUsingSakamoto(String date)
    {
        int[] t = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        int day = Integer.parseInt(date.split(" ")[0]);
        int month = Integer.parseInt(date.split(" ")[1]);
        int year = Integer.parseInt(date.split(" ")[2]);

        if(month < 3)
        {
            year--;
        }

        return days[(year + year/4 - year/100 + year/400 + day + t[month-1])%7];
    }

    private int getTotalDaysInTheMonth(int month, int year)
    {
        int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int totalDays = months[month];

        if(month == 2 && isLeapYear(year))
        {
            totalDays++;
        }

        return totalDays;
    }

    private boolean isLeapYear(int year)
    {
        return (year % 4 == 0 && ( year % 100 != 0 || year % 400 == 0));
    }

    public static void main(String[] args)
    {
        DayFinder tester = new DayFinder();

        String date = "26 01 1950";

        String day1 = tester.getDay(date);
        String day3 = tester.getDayUsingSakamoto(date);

        System.out.println(day1 + " "  + day3);
    }
}
