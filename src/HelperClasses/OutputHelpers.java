package HelperClasses;

/**
 * Created with IntelliJ IDEA.
 * User: "Balasubramanian"
 * Date: 4/24/14
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class OutputHelpers {
    public static void printIntArray(int[] a)
    {
        for(int i=0; i<a.length; ++i)
        {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}