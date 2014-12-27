package HandMadeSorts;

import static HelperClasses.GeneralHelpers.swap;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            siftup(a, i);
        }

        for (int i = a.length - 1; i > 0; --i) {
            swap(a, 0, i);
            siftdown(a, i - 1);
        }
    }

    private void siftdown(int a[], int n) {
        int parent = 0, child;
        while (parent < n) {
            child = parent * 2 + 1;

            if (child > n) break;

            if (child + 1 <= n && a[child + 1] > a[child]) ++child;

            if (a[child] < a[parent]) break;

            swap(a, parent, child);
            parent = child;
        }
    }

    private void siftup(int[] a, int n) {
        int child = n, parent = (child - 1) / 2;
        while (child > 0 && a[child] > a[parent]) {
            swap(a, parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }
}
