package HandMadeSorts;

public class SortComparator {
    private RandomizedQuickSort randomizedQuickSort;
    private IterativeQuickSort iterativeQuickSortEnd;
    private SortTester sortTester;

    public SortComparator() {
        randomizedQuickSort = new RandomizedQuickSort();
        iterativeQuickSortEnd = new IterativeQuickSort();
        sortTester = new SortTester();
    }

    public void compare() {
        long randomizedQuickSortStart = System.currentTimeMillis();
        sortTester.test(new RandomizedQuickSort());
        long randomizedQuickSortEnd = System.currentTimeMillis();

        long iterativeQuickSortStart = System.currentTimeMillis();
        sortTester.test(new IterativeQuickSort());
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
