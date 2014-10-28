import HelperClasses.GeneralHelpers;
import HelperClasses.OutputHelpers;

/**
 * Created by Balasubramanian on 6/24/14.
 */
public class MaxSumSubArray
{

    private static final int MAX_ARRAY_LENGTH = 15;
    private static final int MAX_ARRAY_VALUE = (int)1e2;

    public Result bruteForceMethod(int[] a)
    {
        Result finalResult = new Result();

        for(int i=0; i<a.length; ++i)
        {
            int sum = 0;
            int curMax = Integer.MIN_VALUE;
            for(int j=i; j<a.length; ++j)
            {
                sum += a[j];
                curMax = Math.max(curMax, a[j]);
                if(sum > finalResult.maxSum)
                {
                    finalResult.start = i;
                    finalResult.end = j;
                    finalResult.maxSum = sum;
                    finalResult.maxNum = curMax;
                }
            }
        }

        return finalResult;
    }

    public Result kadaneMethod(int a[])
    {
        Result finalResult = new Result();

        int curStart = -1, curEnd = -1;
        int maxSoFar = 0, maxEndHere = 0;
        int curMaxNum = Integer.MIN_VALUE;

        for(int i=0; i<a.length; ++i)
        {
            maxEndHere += a[i];
            if(maxEndHere < 0)
            {
                curStart = curEnd = -1;
                maxEndHere = 0;
                curMaxNum = Integer.MIN_VALUE;
            }
            else
            {
                if(curStart == -1)
                {
                    curStart = i;
                }
                curEnd = i;
                curMaxNum = Math.max(curMaxNum, a[i]);
            }

            if(maxSoFar < maxEndHere)
            {
                maxSoFar = maxEndHere;
                finalResult.start = curStart;
                finalResult.end = curEnd;
                finalResult.maxSum = maxSoFar;
                finalResult.maxNum = curMaxNum;
            }
        }

        return finalResult;

    }

    public int divideAndConquerMethod(int[] a)
    {
        return divideAndConquerMethodRecur(a, 0, a.length-1);
    }

    private int divideAndConquerMethodRecur(int[] a, int start, int end)
    {
        if(start > end)
        {
            return 0;
        }

        if(start == end)
        {
            return Math.max(0, a[start]);
        }

        int mid = (start + end) / 2;

        int leftHalfMax = divideAndConquerMethodRecur(a, start, mid);
        int rightHalfMax = divideAndConquerMethodRecur(a, mid + 1, end);

        int sum = 0;
        int leftContiguousMax = 0;
        int rightContiguousMax = 0;

        for(int i = mid; i >= 0; --i)
        {
            sum += a[i];
            leftContiguousMax = Math.max(sum, leftContiguousMax);
        }

        sum = 0;
        for(int i = mid+1; i <= end; ++i)
        {
            sum += a[i];
            rightContiguousMax = Math.max(sum, rightContiguousMax);
        }

        return Math.max(Math.max(leftHalfMax, rightHalfMax), leftContiguousMax + rightContiguousMax);
    }

    public static void main(String[] args)
    {
        MaxSumSubArray tester = new MaxSumSubArray();

        int arrayLength = (int)(Math.random() * MAX_ARRAY_LENGTH);
        int maxArrayValue = (int)(Math.random() * MAX_ARRAY_VALUE);

        int[] a = GeneralHelpers.generateArrayWithNegativeNumbers(arrayLength, maxArrayValue);

        OutputHelpers.printIntArray(a);

        Result bruteForceMethodOutput = tester.bruteForceMethod(a);
        Result kadaneMethodOutput = tester.kadaneMethod(a);

        OutputHelpers.printDashes(35);
        System.out.println("Brute force method output :");
        System.out.printf("Start = %d \nEnd = %d \nMaxSum = %d\nMaxNum = %d\n", bruteForceMethodOutput.start, bruteForceMethodOutput.end, bruteForceMethodOutput.maxSum, bruteForceMethodOutput.maxNum);
        OutputHelpers.printDashes(35);
        System.out.println("Kadane's method output :");
        System.out.printf("Start = %d \nEnd = %d \nMaxSum = %d\nMaxNum = %d\n", kadaneMethodOutput.start, kadaneMethodOutput.end, kadaneMethodOutput.maxSum, kadaneMethodOutput.maxNum);
        OutputHelpers.printDashes(35);

        if(isEqual(bruteForceMethodOutput, kadaneMethodOutput))
        {
            System.out.println("PROGRAM PASSED");
        }
        else
        {
            System.out.println("PROGRAM FAILED");
        }
    }

    private static boolean isEqual(Result result1, Result result2)
    {
        return result1.start == result2.start &&
               result1.end == result2.end &&
               result1.maxSum == result2.maxSum &&
               result1.maxNum == result2.maxNum;
    }

    public class Result
    {
        public int start;

        public int end;

        public int maxSum;

        public int maxNum;

        public Result()
        {
            start = end = -1;
            maxSum = 0;
            maxNum = Integer.MAX_VALUE;
        }
    }
}
