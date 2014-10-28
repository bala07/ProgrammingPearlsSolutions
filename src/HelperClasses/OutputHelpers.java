package HelperClasses;

import java.util.ArrayList;

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

    public static void printStringArrayList(ArrayList<String> list)
    {
        System.out.println("------------------");
        for(String word : list)
        {
            System.out.println(word + " ");
        }

        System.out.println("\n------------------");
    }

    public static void printCharMatrix(char[][] matrix)
    {
        for(int i=0; i<matrix.length; ++i)
        {
            for(int j=0; j<matrix[0].length; ++j)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printDashes(int count)
    {
        for(int i=0; i<count; ++i)
        {
            System.out.print('-');
        }

        System.out.println();
    }

    public static void printSequence(char character, int times)
    {
        for(int i=0; i<times; ++i)
        {
            System.out.print(character);
        }

        System.out.println();
    }

    public static <T> void printArray(T[] a)
    {
        for(int i=0; i<a.length; ++i)
        {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

}
