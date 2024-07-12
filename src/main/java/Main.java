import java.util.List;
import java.util.Map;

import static com.emmajiugo.utils.Protector.findAnagramWords;
import static com.emmajiugo.utils.Protector.readWordsFromFile;

public class Main {
    /**
     * Using ANATREE (Alphabetical Map)
     * https://en.wikipedia.org/wiki/Anatree
     *
     * The alphabetic map maintains a hash table of all the possible words that can be in the language (this is referred to as the lexicon).
     * For a given input string, sort the letters in alphabetic order. This sorted string maps onto a word in the hash table.
     * Hence finding the anagram requires sorting the letters and looking up the word in the hash table.
     * The sorting can be done in linear time with counting sort and hash table look ups can be done in constant time.
     * For example, given the word ANATREE, the alphabetic map would produce a mapping of
     * { AAEENRT -> {"anatree"} }.
     *
     */
    public static void main(String[] args) {
        List<String> words = readWordsFromFile();

        Map<String, List<String>> anagramWords = findAnagramWords(words);

        for (List<String> anagrams : anagramWords.values()) {
            if (anagrams.size() > 1) {
                for (String anagram : anagrams) {
                    System.out.print(anagram + " ");
                }
                System.out.println();
            }
        }
    }
}
