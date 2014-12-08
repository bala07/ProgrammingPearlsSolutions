package HandMadeSets;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class BitVectorSet implements ISet {

    private final int INT_SIZE = 32;
    private final int SHIFT = 5;
    private final int MASK = 0x1F;

    private int[] a;
    private int size;

    public BitVectorSet(int maxNum) {
        a = new int[maxNum / INT_SIZE + 1];
        size = 0;
    }

    @Override
    public void insert(int element) {
        if ((a[element >> SHIFT] & (1 << (element & MASK))) == 0) {
            a[element >> SHIFT] |= (1 << (element & MASK));
            ++size;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Integer> report() {
        List<Integer> numbers = newArrayList();
        for (int num = 0; num < a.length * INT_SIZE; ++num) {
            if ((a[num >> SHIFT] & (1 << (num & MASK))) != 0) {
                numbers.add(num);
            }
        }

        return numbers;
    }
}
