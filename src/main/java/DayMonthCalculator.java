/**
 * Created by Balasubramanian on 5/6/14.
 */

/*
Question : Given a year and day of the year, return the month and the day of the month
Eg: 61st day of 2004 is 1st day of March
 */
public class DayMonthCalculator
{
    private int[] daysOfMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private String[] monthNames = { "January",
                                    "February",
                                    "March",
                                    "April",
                                    "May",
                                    "June",
                                    "July",
                                    "August",
                                    "September",
                                    "October",
                                    "November",
                                    "December"
                                   };

    private int totalDaysInTheYear = 365;

    private int totalMonthsInYear = 12;

    public void calculateDayAndMonth(int year, int day)
    {
        if(isLeapYear(year))
        {
            totalDaysInTheYear++;
            daysOfMonths[1]++;
        }

        if(day <= 0 || day > totalDaysInTheYear)
        {
            System.out.println("Invalid day number!");
            return;
        }

        for(int idx = 0; idx < totalMonthsInYear; ++idx)
        {
            if(day <= daysOfMonths[idx])
            {
                System.out.println("Day: " + day + "\nMonth: " + monthNames[idx]);
                break;
            }

            day -= daysOfMonths[idx];
        }

        return;
    }

    private boolean isLeapYear(int year)
    {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static void main(String[] args)
    {
        DayMonthCalculator tester = new DayMonthCalculator();

        tester.calculateDayAndMonth(2004, 366);
    }
}
