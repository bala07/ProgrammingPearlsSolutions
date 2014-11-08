package HandMadeSorts;

import java.util.Stack;

public class IterativeQuickSort implements Sort {

    @Override
    public void sort(int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(a.length - 1);
        stack.push(0);

        while (!stack.empty()) {
            int start = stack.pop();
            int end = stack.pop();

            if (start >= end) {
                continue;
            }

            int pivotIdx = partition(a, start, end);

            stack.push(pivotIdx - 1);
            stack.push(start);

            stack.push(end);
            stack.push(pivotIdx + 1);
        }
    }

    private int partition(int[] a, int start, int end) {
        int randomPivotIdx = (int) (Math.random() * (end - start + 1)) + start;
        swap(a, randomPivotIdx, end);
        int pivot = a[end];
        int j = start - 1;
        for (int i = start; i <= end; ++i) {
            if (a[i] <= pivot) {
                ++j;
                swap(a, i, j);
            }
        }

        return j;
    }

    private void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}
