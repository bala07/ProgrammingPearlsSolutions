package HandMadeSorts;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static HelperClasses.GeneralHelpers.generateArray;

public class HeapSortTest {
    private final int MAX_LENGTH = 10000;
    private final int MAX_NUM = (int) 1e6;
    private final int ROUNDS = 10000;

    @Test
    public void heapSortTest() {
        for(int round = 0; round < ROUNDS; ++round) {
            Sort sorter = new HeapSort();
            int a[] = generateArray((int) (Math.random() * MAX_LENGTH), MAX_NUM);

            int[] a1 = a.clone();
            int[] a2 = a.clone();

            Arrays.sort(a1);
            sorter.sort(a2);

            Assert.assertArrayEquals(a1, a2);
        }
    }
}
