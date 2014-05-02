import HelperClasses.OutputHelpers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Balasubramanian on 5/2/14.
 */
public class TelephoneDirectory
{
    private HashMap<Integer, String> letterMap = new HashMap<>();

    public TelephoneDirectory()
    {
        populateLetterMap();
    }

    void findAllWordMatches(String numberPressed)
    {
        ArrayList<String> matchedWords = new ArrayList<>();

        findWordMatches(numberPressed, 0, matchedWords, "");

        OutputHelpers.printStringArrayList(matchedWords);
    }

    private void findWordMatches(String numberPressed, int idx, ArrayList<String> matchedWords, String currentWord)
    {
        if(idx == numberPressed.length())
        {
            matchedWords.add(currentWord);
            return;
        }

        int digit = Integer.parseInt(numberPressed.charAt(idx) + "");

        if(!letterMap.containsKey(digit))
        {
            throw new IllegalArgumentException();
        }

        String characterList = letterMap.get(digit);

        for(int i=0; i<characterList.length(); ++i)
        {
            char ch = characterList.charAt(i);
            findWordMatches(numberPressed, idx + 1, matchedWords, currentWord + ch + "");
        }

        return;
    }

    private void populateLetterMap()
    {
        letterMap.put(2, "abc");
        letterMap.put(3, "def");
        letterMap.put(4, "ghi");
        letterMap.put(5, "jkl");
        letterMap.put(6, "mno");
        letterMap.put(7, "pqrs");
        letterMap.put(8, "tuv");
        letterMap.put(9, "wxyz");
    }

    public static void main(String[] args)
    {
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.findAllWordMatches("23");
    }
}
