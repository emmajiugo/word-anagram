package com.emmajiugo.utils;

import java.io.*;
import java.util.*;

public class Protector {

    public static Map<String, List<String>> findAnagramWords(List<String> words) {
        Map<String, List<String>> anagramWords = new HashMap<>();

        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Words cannot be null or empty.");
        }

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (!anagramWords.containsKey(sortedWord)) {
                anagramWords.put(sortedWord, new ArrayList<>());
            }

            anagramWords.get(sortedWord).add(word);
        }

        return anagramWords;
    }

    public static List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();

        InputStream inputStream = Protector.class.getResourceAsStream("/words-utf8.txt");

        if (inputStream == null) {
            throw new RuntimeException("Input file not found.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String wordPerLine;
            int i = 0;
            while ((wordPerLine = reader.readLine()) != null) {
                if (!wordPerLine.isEmpty()) {
                    //System.out.println(i + 1 + " " + wordPerLine); i++;
                    words.add(wordPerLine);
                }
            }
        } catch (IOException e) {
            // log error here
            throw new RuntimeException("Could not read file input.");
        }

        return words;
    }
}
