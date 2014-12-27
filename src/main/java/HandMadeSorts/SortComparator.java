package HandMadeSorts;

import HelperClasses.GeneralHelpers;

public class SortComparator {
    private final int MAX_NUM = (int) 1e8;
    private final int MAX_LEN = (int) 1e6;

    public void compare() {
        int[] randomArray = GeneralHelpers.generateArray((int) (Math.random() * MAX_LEN), MAX_NUM);
        int[] a1 = randomArray.clone();
        int[] a2 = randomArray.clone();
        IterativeQuickSort iterativeQuickSort = new IterativeQuickSort();
        RandomizedQuickSort randomizedQuickSort = new RandomizedQuickSort();

        long randomizedQuickSortStart = System.currentTimeMillis();
        randomizedQuickSort.sort(a1);
        long randomizedQuickSortEnd = System.currentTimeMillis();

        long iterativeQuickSortStart = System.currentTimeMillis();
        iterativeQuickSort.sort(a2);
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
