import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

/**
 * Created by Balasubramanian on 5/19/14.
 */
public class DaysCounter
{
    private int[] daysOfMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private final int MONTHS = 12;
    private final String SEPARATOR = " ";
    private int startDate, startMonth, startYear, endDate, endMonth, endYear;

    public int countDays(String startDate, String endDate)
    {
        populateStartAndEndDateProperties(startDate, endDate);

        int totalDays = 0;

        totalDays += countDaysInYearsBetweenStartAndEndYears();

        totalDays += countDaysBetweenMonthsInSameYear(
                this.startDate,
                startMonth,
                (endYear == startYear) ? this.endDate : getTotalDaysInTheMonth(11, startYear),
                (endYear == startYear) ? endMonth : 11,
                startYear
        );

        if(startYear != endYear)
        {
            totalDays += countDaysBetweenMonthsInSameYear(1, 0, this.endDate, endMonth, endYear);
        }

        return totalDays;
    }

    private void populateStartAndEndDateProperties(String startDate, String endDate)
    {
        String[] tokens = startDate.split(SEPARATOR);

        this.startDate = Integer.parseInt(tokens[0]);
        startMonth = Integer.parseInt(tokens[1]);
        startYear = Integer.parseInt(tokens[2]);

        tokens = endDate.split(SEPARATOR);

        this.endDate = Integer.parseInt(tokens[0]);
        endMonth = Integer.parseInt(tokens[1]);
        endYear = Integer.parseInt(tokens[2]);
    }

    private int countDaysInYearsBetweenStartAndEndYears()
    {
        int daysCount = 0;

        for(int year = startYear+1; year < endYear; ++year)
        {
            daysCount += getTotalDaysInYear(year);
        }

//        System.out.println(daysCount);

        return daysCount;
    }

    private int getTotalDaysInTheMonth(int month, int year)
    {
        if(month != 1)
        {
            return daysOfMonths[month];
        }
        else
        {
            if(isLeapYear(year))
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
    }

    private int getTotalDaysInYear(int year)
    {
        return isLeapYear(year) ? 366 : 365;
    }

    private int countDaysBetweenMonthsInSameYear(int startDate, int startMonth, int endDate, int endMonth, int year)
    {
        int daysBetweenStartAndEndMonths = 0;

        for(int month = startMonth + 1; month < endMonth; ++month)
        {
            daysBetweenStartAndEndMonths += getTotalDaysInTheMonth(month, year);
        }

        int daysInStartMonth = (startMonth == endMonth) ? endDate - startDate + 1 : totalDaysLeftInAMonth(startDate, startMonth, year);

        int daysInEndMonth = (startMonth == endMonth) ? 0 : endDate;

        return daysBetweenStartAndEndMonths + daysInStartMonth + daysInEndMonth;
    }

    private int totalDaysLeftInAMonth(int startDate, int month, int year)
    {
        int endDay = daysOfMonths[month];

        if(month == 1 && isLeapYear(year))
        {
            ++endDay;
        }

        return endDay - startDate + 1;
    }

    private boolean isLeapYear(int year)
    {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static void main(String[] args) throws Exception
    {
        DaysCounter tester = new DaysCounter();

        String startDateForMyFunction = "23 08 2012";
        String startDateForLibraryFunction = "22 08 2012";
        String endDate = "04 10 2032";

        int outputFromMyFunction = tester.countDays(startDateForMyFunction, endDate);
        int outputFromUsingLibrary = tester.countDaysUsingLibrary(startDateForLibraryFunction, endDate);

        System.out.println(outputFromMyFunction + " " + outputFromUsingLibrary);
    }

    public int countDaysUsingLibrary(String startDate, String endDate) throws Exception
    {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        Date date1 = myFormat.parse(startDate);
        Date date2 = myFormat.parse(endDate);

        long diff = date2.getTime() - date1.getTime();

        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }


}
