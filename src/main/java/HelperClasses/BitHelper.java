package HelperClasses;

public class BitHelper {
    private static final int INT_SIZE = 32;

    public static int getBitsBetweenInclusive(int number, int start, int end) {
        int result = ((number & (~0 >>> (INT_SIZE - 1 - start))) >> end);
        return result;
    }

    public static int getBit(int number, int idx) {
        if ((number & (1 << idx)) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setBit(int number, int idx) {
        return (number | (1 << idx));
    }

    public static void printBitFormat(int number) {
        for (int idx = INT_SIZE - 1; idx >= 0; --idx) {
            if ((number & (1 << idx)) == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }

        System.out.println();
    }
}
