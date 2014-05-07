package HelperClasses;

/**
 * Created by Balasubramanian on 5/7/14.
 */
public class GeneralHelpers
{
    public static void copyIntArray(int[] source, int[] destination)
    {
        for(int i=0; i<source.length; ++i)
        {
            destination[i] = source[i];
        }
    }
}
