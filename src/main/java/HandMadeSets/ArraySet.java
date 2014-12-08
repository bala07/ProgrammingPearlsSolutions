package HandMadeSets;

import java.util.ArrayList;
import java.util.List;

public class ArraySet implements ISet {
    int a[];
    int size;

    public ArraySet(int maxSize) {
        a = new int[maxSize];
        size = 0;
    }

    @Override
    public void insert(int element) {
        if(size == a.length) {
            System.out.println("The array is full");
            return;
        }

        int idx = getIndexForElement(element);

        if(a[idx] == element) {
            return;
        }

        for(int i = size-1; i >= idx; --i) {
            a[i+1] = a[i];
        }

        a[idx] = element;
        ++size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Integer> report() {
        List<Integer> list = new ArrayList<>();
        for(int idx = 0; idx < size; ++idx) {
            list.add(a[idx]);
        }

        return list;
    }

    private int getIndexForElement(int element) {
        int low = 0, high = size-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == element) {
                return mid;
            }

            if(element < a[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}
