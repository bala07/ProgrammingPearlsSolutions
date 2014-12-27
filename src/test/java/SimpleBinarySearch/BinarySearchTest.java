package SimpleBinarySearch;

import HelperClasses.GeneralHelpers;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTest {
    private final int MAX_LEN = (int) 1e6;
    private final int MAX_VAL = (int) 1e8;

    final int ROUNDS = 100;

    @Test
    public void binarySearchTest() {
        BinarySearch binarySearch = new BinarySearch();
        SequentialSearch sequentialSearch = new SequentialSearch();

        for (int rounds = 0; rounds < ROUNDS; ++rounds) {
            int randomLength = (int) (Math.random() * MAX_LEN);
            int[] a = GeneralHelpers.generateArray(randomLength, MAX_VAL);
            Arrays.sort(a);
            int target = a[(int) (Math.random() * a.length)];
            assertThat(binarySearch.modifiedBinarySearch(a, target), is(sequentialSearch.search(a, target)));
        }
    }
}
