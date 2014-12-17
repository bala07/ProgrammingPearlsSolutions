package Heap;

import HelperClasses.GeneralHelpers;
import org.junit.Test;

import static java.lang.Math.min;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HandMadeHeapTest {
    private final int MAX_NUM = (int) 1e6;
    private final int MAX_SIZE = (int) 1e7;
    private final int ROUNDS = 20;

    @Test
    public void shouldReturnSmallestElement() {
        for(int round = 0; round < ROUNDS; ++round) {
            int randArraySize = (int)(Math.random() * MAX_SIZE);

            HandMadeHeap heap = new HandMadeHeap(randArraySize);
            int[] randArray = GeneralHelpers.generateArray(randArraySize, MAX_NUM);
            int expectedMinVal = findMin(randArray);

            for (int val : randArray) {
                heap.insert(val);
            }

            assertThat(heap.minElement(), is(expectedMinVal));
        }
    }

    private int findMin(int[] a) {
        int minVal = a[0];
        for (int idx = 1; idx < a.length; ++idx) {
            minVal = min(minVal, a[idx]);
        }

        return minVal;
    }

}