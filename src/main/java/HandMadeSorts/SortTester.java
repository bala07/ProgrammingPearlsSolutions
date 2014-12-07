package HandMadeSorts;

import java.util.Arrays;

import static HelperClasses.GeneralHelpers.generateArray;
import static HelperClasses.OutputHelpers.compareIntegerArrays;

public class SortTester {
    private static final int MAX_LENGTH = 10000;
    private static final int MAX_NUM = (int) 1e6;

    public static void main(String[] args) {
        new SortTester().test(new IterativeQuickSort());
    }

    public void test(Sort sorter) {
        int a[] = generateArray((int) (Math.random() * MAX_LENGTH), MAX_NUM);

        int[] a1 = a.clone();
        int[] a2 = a.clone();

        Arrays.sort(a1);
        sorter.sort(a2);

        if (!compareIntegerArrays(a1, a2)) {
            System.out.println("Your sort is incapable of sorting correctly!!!");
        } else {
            System.out.println("Your sort worked beautifully!!!");
        }
    }

}
