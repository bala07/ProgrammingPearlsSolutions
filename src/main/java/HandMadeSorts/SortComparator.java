package HandMadeSorts;

import HelperClasses.GeneralHelpers;

public class SortComparator {
    private static final int MAX_NUM = (int) 1e8;
    private final int MAX_LEN = (int) 1e6;
    private RandomizedQuickSort randomizedQuickSort;
    private IterativeQuickSort iterativeQuickSortEnd;

    public SortComparator() {
        randomizedQuickSort = new RandomizedQuickSort();
        iterativeQuickSortEnd = new IterativeQuickSort();
    }

    public void compare() {
        int[] randomArray = GeneralHelpers.generateArray((int) (Math.random() * MAX_LEN), MAX_NUM);
        int[] a1 = randomArray.clone();
        int[] a2 = randomArray.clone();

        long randomizedQuickSortStart = System.currentTimeMillis();
        new RandomizedQuickSort().sort(a1);
        long randomizedQuickSortEnd = System.currentTimeMillis();

        long iterativeQuickSortStart = System.currentTimeMillis();
        new IterativeQuickSort().sort(a2);
        long iterativeQuickSortEnd = System.currentTimeMillis();

        long timeForIterativeQuickSort = (iterativeQuickSortEnd - iterativeQuickSortStart);
        long timeForRandomizedQuickSort = (randomizedQuickSortEnd - randomizedQuickSortStart);

        System.out.println("timeForIterativeQuickSort = " + timeForIterativeQuickSort);
        System.out.println("timeForRandomizedQuickSort = " + timeForRandomizedQuickSort);

        if (timeForIterativeQuickSort < timeForRandomizedQuickSort) {
            System.out.println("Iterative quick sort wins!!!");
        } else if (timeForIterativeQuickSort > timeForRandomizedQuickSort) {
            System.out.println("Randomized quick sort wins!!!");
        } else {
            System.out.println("It is a draw!!!");
        }
    }

    public static void main(String[] args) {
        new SortComparator().compare();
    }
}
