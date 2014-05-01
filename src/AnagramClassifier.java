import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Balasubramanian on 5/1/14.
 */
public class AnagramClassifier
{
    public void classifyAnagrams(String[] words)
    {
        HashMap<String, ArrayList<String>> anagramGroups = new HashMap<>();

        for(String word : words)
        {
            String signature = getSignature(word);
            if(anagramGroups.containsKey(signature))
            {
                ArrayList<String> wordList = anagramGroups.get(signature);
                wordList.add(word);
            }
            else
            {
                ArrayList<String> wordList = new ArrayList<String>();
                wordList.add(word);
                anagramGroups.put(signature, wordList);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry : anagramGroups.entrySet())
        {
            System.out.println("-----------------");
            ArrayList<String> wordList = entry.getValue();
            for(String word : wordList)
            {
                System.out.print(word + " ");
            }

            System.out.println();

        }

    }

    private String getSignature(String word)
    {
        char[] charactersInWord = word.toCharArray();
        Arrays.sort(charactersInWord);

        return new String(charactersInWord);
    }

    public static void main(String[] args)
    {
        AnagramClassifier tester = new AnagramClassifier();
        tester.classifyAnagrams(new String[] { "abcd", "bcda", "foo", "bar", "ofo", "hello", "dcab" });
    }
}
