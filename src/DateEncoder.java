import HelperClasses.BitHelper;
import HelperClasses.GeneralHelpers;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import static java.lang.Integer.parseInt;


// Encoding a date value within an integer(32 bits)
public class DateEncoder {
    private final int YEAR_OFFSET = 0;
    private final int DAY_OFFSET = 15;
    private final int MONTH_OFFSET = 20;
    private final String dateFormat = "MMddyyyy";

    public static void main(String[] args) {
        DateEncoder dateEncoder = new DateEncoder();
        dateEncoder.test();
    }

    private void test() {
        String date = GeneralHelpers.getRandomDateString(dateFormat);
        System.out.println("date = " + date);

        int encodedDate = encode(date);

        String decodedDate = decode(encodedDate);
        System.out.println("decodedDate = " + decodedDate);

        assert(date == decodedDate);
    }

    private int encode(String date) {
        int year = parseInt(date.substring(4, dateFormat.length()));
        int day = parseInt(date.substring(2, 4));
        int month = parseInt(date.substring(0, 2));

        return ((year << YEAR_OFFSET) | (day << DAY_OFFSET) | (month << MONTH_OFFSET));
    }

    private String decode(int encodedDate) {
        int year = BitHelper.getBitsBetweenInclusive(encodedDate, DAY_OFFSET - 1, 0);
        int day = BitHelper.getBitsBetweenInclusive(encodedDate, MONTH_OFFSET - 1, DAY_OFFSET);
        int month = BitHelper.getBitsBetweenInclusive(encodedDate, 31, MONTH_OFFSET);

        return DateTimeFormat.forPattern(dateFormat).print(new DateTime(year, month, day, 0, 0, 0));
    }
}
