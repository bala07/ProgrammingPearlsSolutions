package Heap;

public class HandMadeHeap {
    int[] a;
    int size = 0;

    public HandMadeHeap(int size) {
        a = new int[size + 1];
    }

    public void insert(int element) {
        if (size == a.length - 1) {
            System.out.println("Heap overflow!");
            return;
        }

        a[++size] = element;
        siftUp();
    }

    public int minElement() {
        if (size == 0) {
            System.out.println("Heap underflow!");
            return -1;
        }

        int retVal = a[1];
        a[1] = a[size--];
        siftDown();

        return retVal;
    }

    private void siftDown() {
        int parent, child;
        for (parent = 1; (child = 2 * parent) <= size; parent = child) {
            if (child + 1 <= size && a[child + 1] < a[child]) {
                ++child;
            }

            if (a[parent] <= a[child]) {
                break;
            }

            swap(a, parent, child);
        }
    }

    private void siftUp() {
        int parent, child;
        for (child = size; child > 1 && a[parent = child / 2] > a[child]; child = parent) {
            swap(a, parent, child);
        }
    }

    private void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

}
