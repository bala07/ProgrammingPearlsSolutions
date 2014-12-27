package HelperClasses;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;


public class GeneralHelpers {
    public static void copyIntArray(int[] source, int[] destination) {
        for (int i = 0; i < source.length; ++i) {
            destination[i] = source[i];
        }
    }

    public static int[] generateArray(int requiredLength, int maxNum) {
        int[] a = new int[requiredLength];

        for (int i = 0; i < requiredLength; ++i) {
            int randomNumber = (int) (Math.random() * maxNum);
            a[i] = randomNumber;
        }

        return a;
    }

    public static int[] generateArrayWithNegativeNumbers(int requiredLength, int maxNum) {
        int[] a = new int[requiredLength];

        for (int i = 0; i < requiredLength; ++i) {
            int randomNumber = (int) (Math.random() * maxNum);
            int sign = (int) (Math.random() * 2);

            if (sign == 1) {
                randomNumber = -randomNumber;
            }

            a[i] = randomNumber;
        }

        return a;
    }

    public static String getRandomDateString(String dateFormat) {
        DateTime dateTime;
        long currentTimeMillis = System.currentTimeMillis();
        long offset = (long) (Math.random() * currentTimeMillis);
        if ((int) (Math.random() * 2) == 0) {
            dateTime = new DateTime(currentTimeMillis - offset);
        } else {
            dateTime = new DateTime(currentTimeMillis + offset);
        }

        return DateTimeFormat.forPattern(dateFormat).print(dateTime);
    }

    public static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}
