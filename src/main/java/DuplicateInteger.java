import java.io.*;
import java.util.Arrays;

/**
 * Created by Balasubramanian on 5/1/14.
 */

/*
Question: Given a file containing 4.30 billion 32-bit integers, how can we find a number, which has appeared at least twice?
 */
public class DuplicateInteger
{
    public int findDuplicateInteger(String fileName) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        int[] cnt = new int[1<<16];
        int duplicatePrefix = 0;

        String inputLine = reader.readLine();
        while(inputLine != null)
        {
            int number = Integer.parseInt(inputLine);
            int prefix = (number >> 16);
            cnt[prefix]++;

            if(cnt[prefix] > (1<<16))
            {
                duplicatePrefix = (prefix << 16);
                break;
            }
        }

        fileInputStream.getChannel().position(0);
        reader = new BufferedReader(new InputStreamReader(fileInputStream));
        Arrays.fill(cnt, 0);

        inputLine = reader.readLine();
        while(inputLine != null)
        {
            int number = Integer.parseInt(inputLine);
            int suffix = (number ^ duplicatePrefix);
            if(suffix < ( 1 << 16 ))
            {
                cnt[suffix]++;
                if(cnt[suffix] > 1)
                {
                    return number;
                }
            }
        }

        reader.close();

        return -1;
    }
}
