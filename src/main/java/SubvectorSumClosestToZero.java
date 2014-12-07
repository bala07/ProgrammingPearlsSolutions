import HelperClasses.GeneralHelpers;
import HelperClasses.OutputHelpers;

import java.util.Arrays;

/**
 * Created by Balasubramanian on 7/9/14.
 */
public class SubvectorSumClosestToZero
{
    public int efficientMethod(int[] a)
    {
        int[] cumulativeSum = new int[a.length];
        cumulativeSum[0] = a[0];
        for(int i=1; i<a.length; ++i)
        {
            cumulativeSum[i] = cumulativeSum[i-1] + a[i];
        }

        Arrays.sort(cumulativeSum);
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<a.length - 1; ++i)
        {
            minDiff = Math.min(minDiff, Math.abs(cumulativeSum[i] - cumulativeSum[i+1]));
        }

        for(int i=0; i<a.length; ++i)
        {
            minDiff = Math.min(minDiff, Math.abs(a[i]));
        }

        return minDiff;
    }

    public int bruteForceMethod(int[] a)
    {
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<a.length; ++i)
        {
            int sum = 0;
            for(int j=i; j<a.length; ++j)
            {
                sum += a[j];
                minDiff = Math.min(minDiff, Math.abs(sum));
            }
        }

        return minDiff;
    }

    public static void main(String[] args)
    {
        SubvectorSumClosestToZero tester = new SubvectorSumClosestToZero();

        int[] a = GeneralHelpers.generateArrayWithNegativeNumbers(1000, 248394);

        int bruteForceMethodResult = tester.bruteForceMethod(a);
        int efficientMethodResult = tester.efficientMethod(a);

        OutputHelpers.printDashes(30);
        System.out.println("Brute-force method result: " + bruteForceMethodResult);
        OutputHelpers.printDashes(30);
        System.out.println("Efficient method result: " + efficientMethodResult);
        OutputHelpers.printDashes(30);

        if(bruteForceMethodResult == efficientMethodResult)
        {
            System.out.println("Solution passed!!");
        }
        else
        {
            System.out.println("Solution failed");
        }
    }
}
