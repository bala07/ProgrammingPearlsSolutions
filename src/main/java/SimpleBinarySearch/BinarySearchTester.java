package SimpleBinarySearch;

import java.util.Arrays;

/**
 * Created by Balasubramanian on 5/25/14.
 */
public class BinarySearchTester
{
    final int MAX_ARRAY_SIZE = 1000;
    final int MAX_ARRAY_VALUE = (int)1e6;
    final int NUMBER_OF_TESTS = 100;

    public boolean test(BinarySearch binarySearch, SequentialSearch sequentialSearch)
    {
        for(int times = 0; times < NUMBER_OF_TESTS; ++times)
        {
            if(!testUtil(binarySearch, sequentialSearch))
            {
                return false;
            }
        }

        return true;
    }

    private boolean testUtil(BinarySearch binarySearch, SequentialSearch sequentialSearch)
    {
//        int[] a = getRandomArray();
        int[] a = { 1, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 9};
        Arrays.sort(a);

//        int target = a[(int)(Math.random() * a.length)];
        int target = 2;

        return binarySearch.modifiedBinarySearch(a, target) == sequentialSearch.search(a, target);
    }

    private int[] getRandomArray()
    {
        int arraySize = (int)(Math.random() * MAX_ARRAY_SIZE);

        int[] a= new int[arraySize];
        for(int i = 0; i < arraySize; ++i)
        {
            a[i] = (int)(Math.random() * MAX_ARRAY_VALUE);
        }

        return a;
    }

    public static void main(String[] args)
    {
        BinarySearch binarySearch = new BinarySearch();
        SequentialSearch sequentialSearch = new SequentialSearch();
        BinarySearchTester binarySearchTester = new BinarySearchTester();

        if(binarySearchTester.test(binarySearch, sequentialSearch))
        {
            System.out.println("Your binary search is perfect!");
        }
        else
        {
            System.out.println("Your binary search is buggy!!");
        }
    }

}
