package HandMadeSorts;

import static HelperClasses.GeneralHelpers.swap;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] a) {
        for (int i = a.length / 2 ; i >=0; --i) {
            siftdown(a, i, a.length - 1);
        }

        for (int i = a.length - 1; i > 0; --i) {
            swap(a, 0, i);
            siftdown(a, 0, i - 1);
        }
    }

    private void siftdown(int a[], int start, int end) {
        int parent = start, child;
        while (parent < end) {
            child = parent * 2 + 1;

            if (child > end) break;

            if (child + 1 <= end && a[child + 1] > a[child]) ++child;

            if (a[child] < a[parent]) break;

            swap(a, parent, child);
            parent = child;
        }
    }
}
