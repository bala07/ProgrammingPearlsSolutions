import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Balasubramanian on 5/25/14.
 */
public class Test
{
    static final int MAX_VALUE = (int)1e6;
    public static void main(String[] args) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        writer.write("Hello world!");

        writer.close();
    }

    public void program(int x)
    {
        while( x != 1 )
        {
            if(x % 2 == 0)
            {
                x /= 2;
            }
            else
            {
                System.out.print(x + " => ");
                x = 3 * x + 1;
                System.out.println(x);
            }
        }
    }
}
