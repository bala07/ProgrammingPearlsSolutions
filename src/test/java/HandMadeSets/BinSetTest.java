package HandMadeSets;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Math.random;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinSetTest {
    private final int MAX_SIZE = 10000;
    private final int MAX_NUM = (int)1e6;
    private final int ROUNDS = 1000;

    private ISet set;

    @Test
    public void test() {
        for(int round = 0; round < ROUNDS; ++round) {
            set = new BinSet(MAX_NUM, MAX_SIZE);
            Set<Integer> numberSet = new HashSet<>();

            for(int idx = 0; idx < MAX_SIZE; ++idx) {
                int element = (int) (random() * MAX_NUM);
                set.insert(element);
                numberSet.add(element);
            }
            List<Integer> setCollection = set.report();
            List<Integer> numbers = newArrayList(numberSet);
            Collections.sort(numbers);

            assertThat(setCollection.size(), is(numberSet.size()));
            assertThat(setCollection, is(numbers));
        }
    }

}