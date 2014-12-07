import HelperClasses.GeneralHelpers;
import HelperClasses.OutputHelpers;

import java.util.Arrays;

public class KthSmallestElement {

    private static final double MAX_LEN = 10;
    private static final int MAX_NUM = 1000;

    public static void main(String[] args) {
        KthSmallestElement tester = new KthSmallestElement();
        tester.test();

    }

    public void test() {
        int[] a = GeneralHelpers.generateArray((int) (Math.random() * MAX_LEN), MAX_NUM);
        int K = (int) (Math.random() * a.length + 1);

        System.out.println("K = " + K);
        int[] a1 = a.clone();
        int[] a2 = a.clone();

        Arrays.sort(a1);
        int expectedResult = a1[K - 1];

        int receivedResult = a2[findKthSmallestElement(a2, K)];


        System.out.println("expectedResult = " + expectedResult);
        System.out.println("receivedResult = " + receivedResult);

        if (expectedResult == receivedResult) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public int findKthSmallestElement(int[] a, int K) {
        return find(a, 0, a.length - 1, K);
    }

    private int find(int[] a, int start, int end, int K) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            return start;
        }

        int pivotIdx = partition(a, start, end);
        int curRank = pivotIdx + 1 - start;

        if (curRank == K) {
            return pivotIdx;
        } else if (curRank > K) {
            return find(a, start, pivotIdx - 1, K);
        } else {
            return find(a, pivotIdx + 1, end, K - curRank);
        }
    }

    private int partition(int[] a, int start, int end) {
        int j = start - 1;
        int pivot = a[end];
        for (int idx = start; idx < end; ++idx) {
            if (a[idx] <= pivot) {
                ++j;
                swap(a, idx, j);
            }
        }

        swap(a, ++j, end);

        return j;
    }

    private void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }


}
