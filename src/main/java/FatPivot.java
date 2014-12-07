import HelperClasses.GeneralHelpers;
import HelperClasses.OutputHelpers;

public class FatPivot {
    private static final int MAX_LEN = 15;
    private static final int MAX_VALUE = 100;

    public void partition(int[] a) {
        int pivot = a[a.length - 1];
        int lessThanPivotIdx = -1, equalToPivotIdx = a.length - 1;
        for (int idx = 0; idx < equalToPivotIdx; ++idx) {
            if (a[idx] < pivot) {
                ++lessThanPivotIdx;
                swap(a, lessThanPivotIdx, idx);
            } else if (a[idx] == pivot) {
                --equalToPivotIdx;
                swap(a, equalToPivotIdx, idx);
                --idx;
            }
        }

        System.out.println("lessThanPivotIdx = " + lessThanPivotIdx);
        System.out.println("equalToPivotIdx = " + equalToPivotIdx);
        reverse(a, lessThanPivotIdx + 1, a.length - 1);

    }

    private void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int len = (int) (Math.random() * MAX_LEN);
        int[] a = GeneralHelpers.generateArray(len, MAX_VALUE);
//        int[] a = new int[]{34, 64, 128, 34, 4, 2, 8, 16, 32, 34};

        System.out.println("Before partition => ");
        OutputHelpers.printIntArray(a);

        new FatPivot().partition(a);

        System.out.println("After partition => ");
        OutputHelpers.printIntArray(a);
    }
}
