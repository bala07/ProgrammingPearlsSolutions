package HandMadeSorts;

import java.util.Arrays;

import static HelperClasses.GeneralHelpers.*;
import static HelperClasses.OutputHelpers.*;

public class InsertionSort {

    private static final int MAX_NUM = 10000;
    private static final int MAX_LENGTH = 100000;

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.test();
    }

    public void test() {
        int a[] = generateArray((int)(Math.random() * MAX_LENGTH), MAX_NUM);

        int[] a1 = a.clone();
        int[] a2 = a.clone();

        Arrays.sort(a1);
        insertionSort(a2);

        if(!compareIntegerArrays(a1, a2)) {
            System.out.println("Your sort is incapable of sorting correctly!!!");
        }
        else {
            System.out.println("Your sort worked beautifully!!!");
        }
    }

    public void insertionSort(int[] a) {
        for(int i = 1; i < a.length; ++i) {
            int curElement = a[i];
            int j = i-1;
            while(j >= 0 && a[j] > curElement) {
                a[j+1] = a[j];
                --j;
            }

            a[j+1] = curElement;
        }
    }
}
