import HelperClasses.OutputHelpers;

/**
 * Created by Balasubramanian on 5/1/14.
 */
public class RotatingArray
{
    public void rotateUsingJugglingAlgorithm(int[] a, int rotateDistance)
    {
        int totalElementsMoved = 0;
        int buffer = 0;
        int startPos = 0;

        while(totalElementsMoved < a.length)
        {
            int prevPos = startPos;
            int curPos = (prevPos + rotateDistance) % a.length;
            buffer = a[startPos];

            while(curPos != startPos)
            {
                a[prevPos] = a[curPos];
                prevPos = curPos;
                curPos = (curPos + rotateDistance) % a.length;
                ++totalElementsMoved;
            }

            a[prevPos] = buffer;
            ++totalElementsMoved;
            ++startPos;
        }
    }

    public void rotateUsingReversalAlgorithm(int[] a,int rotateDistance)
    {
        reverseArray(a, 0, rotateDistance - 1);
        reverseArray(a, rotateDistance, a.length - 1);
        reverseArray(a, 0, a.length - 1);
    }

    private void reverseArray(int[] a, int start, int end)
    {
        while(start < end)
        {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;

            ++start;
            --end;
        }
    }

    public static void main(String[] args)
    {
        RotatingArray tester = new RotatingArray();
        int[] a = new int[] { 1, 2, 3, 4, 5 };

        OutputHelpers.printIntArray(a);

        tester.rotateUsingReversalAlgorithm(a, 2);

        OutputHelpers.printIntArray(a);
    }
}
