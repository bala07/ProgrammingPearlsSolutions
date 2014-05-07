import HelperClasses.GeneralHelpers;
import HelperClasses.OutputHelpers;

/**
 * Created by Balasubramanian on 5/7/14.
 */
public class EquationSolving
{
    private int k;
    private int[] constants = null;
    private int[] aValues = null;

    public EquationSolving(int k, int[] constants, int[] aValues)
    {
        this.k = k;
        this.constants = constants;
        this.aValues = aValues;
    }

    public void compute(int n)
    {
        int[] result = new int[n];
        GeneralHelpers.copyIntArray(aValues, result);


        for(int i=k; i<n; ++i)
        {
            int value = 0;
            for(int j=0; j<k; ++j)
            {
                value += constants[j] * result[i-j-1];
            }

            result[i] = value;
        }

        OutputHelpers.printIntArray(result);
    }

    public static void main(String[] args)
    {
        EquationSolving tester = new EquationSolving(5, new int[] { 1, 2, 3, 4, 5 }, new int[] { 10, 11, 12 ,13, 14 });

        tester.compute(10);
    }

}
