package HandMadeSets;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Math.ceil;

public class BinSet implements ISet {
    Node[] bins;
    private int binCount = 0;
    private int numbersPerBin = 0;
    private int size = 0;

    public BinSet(int maxValue, int maxElements) {
        this.bins = new Node[maxElements];
        binCount = maxElements;
        numbersPerBin = (int) ceil(maxValue * 1.0 / maxElements);
    }

    @Override
    public void insert(int element) {
        int binIdx = element / numbersPerBin;
        bins[binIdx] = recursiveInsert(bins[binIdx], element);
    }

    private Node recursiveInsert(Node cur, int element) {
        if(cur == null) {
            ++size;
            return new Node(element);
        }

        if(element == cur.value) {
            return cur;
        }

        if(element > cur.value) {
            cur.next = recursiveInsert(cur.next, element);
            return cur;
        }

        Node newNode = new Node(element);
        newNode.next = cur;
        ++size;

        return newNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Integer> report() {
        List<Integer> numbers = newArrayList();
        for(int idx = 0; idx < bins.length; ++idx) {
            Node cur = bins[idx];
            while(cur != null) {
                numbers.add(cur.value);
                cur = cur.next;
            }
        }

        return numbers;
    }

    private class Node {
        int value;
        Node next;

        private Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
