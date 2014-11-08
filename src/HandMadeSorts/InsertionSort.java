package HandMadeSorts;

public class InsertionSort implements Sort {

    public void sort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            int curElement = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > curElement) {
                a[j + 1] = a[j];
                --j;
            }

            a[j + 1] = curElement;
        }
    }
}
