package SimpleBinarySearch;

/**
 * Created by Balasubramanian on 5/25/14.
 */
public class BinarySearch
{
    public int search(int[] a, int target)
    {
        int low=0, high = a.length-1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            if(a[mid] == target)
            {
                return mid;
            }
            else if(a[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return -1;
    }

    // returns the first occurrence of the target element
    public int modifiedBinarySearch(int[] a, int target)
    {
        int low = 0, high = a.length-1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(a[mid] == target)
            {
                if(mid == 0 || a[mid-1] < target)
                {
                    return mid;
                }

                high = mid-1;
            }
            else if(a[mid] < target)
            {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

