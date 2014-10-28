package HelperClasses;

/**
 * Created by Balasubramanian on 5/7/14.
 */
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
}
