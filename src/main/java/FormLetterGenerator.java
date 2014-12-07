import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Balasubramanian on 5/22/14.
 */
public class FormLetterGenerator
{
    private final String FORM_LETTER_PATH = "formLetter.txt";
    private final String PERSONS_FILE = "persons.txt";
    private final char MARKER = '$';
    private final char SEPARATOR = ' ';

    public void generateDescription() throws Exception
    {
        BufferedReader personsReader = new BufferedReader(new FileReader(PERSONS_FILE));

        String inputLine = personsReader.readLine();
        while(inputLine != null)
        {
            String[] fields = inputLine.split(" ");
            displayDescription(fields);

            System.out.println();

            inputLine = personsReader.readLine();
        }
    }

    private void displayDescription(String[] fields) throws Exception
    {
        BufferedReader formLetterReader = new BufferedReader(new FileReader(FORM_LETTER_PATH));

        String inputLine = formLetterReader.readLine();

        while(inputLine != null)
        {
            for(int idx = 0; idx < inputLine.length(); ++idx)
            {
                char letter = inputLine.charAt(idx);

                if(letter != MARKER)
                {
                    System.out.print(letter);
                }
                else
                {
                    if(idx == inputLine.length())
                    {
                        throw new Exception("Wrong form letter format");
                    }
                    else if(inputLine.charAt(idx+1) == MARKER)
                    {
                        System.out.print(MARKER);
                        ++idx;
                    }
                    else
                    {
                        String number = "";
                        for(int j = idx + 1; j < inputLine.length(); ++j)
                        {
                            char ch = inputLine.charAt(j);
                            if(!(ch >= '0' && ch <= '9'))
                            {
                                break;
                            }
                            number += ch+"";
                            ++idx;
                        }
                        int index = Integer.parseInt(number);
                        System.out.print(fields[index]);
                    }
                }
            }

            inputLine = formLetterReader.readLine();
        }

        formLetterReader.close();
    }

    public static void main(String[] args) throws Exception
    {
        FormLetterGenerator tester = new FormLetterGenerator();
        tester.generateDescription();
    }


}
