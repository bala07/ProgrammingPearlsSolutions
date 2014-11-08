package HandMadeSorts;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] a) {
        quickSortRecur(a, 0, a.length - 1);
    }

    private void quickSortRecur(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIdx = partition(a, start, end);

        quickSortRecur(a, start, pivotIdx - 1);
        quickSortRecur(a, pivotIdx + 1, end);
    }

    private int partition(int[] a, int start, int end) {
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
