
package com.senla.courses.brest.task4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordsCounter {
    private Map<String, Integer> words = new HashMap<>();

    public static void main(String[] args) throws IOException {
        WordsCounter counter = new WordsCounter();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            counter.setText(reader);
            counter.getWordCount(counter.enterWord(reader));
        }
    }

    public void setWords(String line) {
        String[] lines = line.split(" ");
        for (String word : lines) {
            String line2 = word.replaceAll("\\W[^а-яА-Я]]", "").toLowerCase();
            if (words.containsKey(line2)) {
                words.put(line2, words.get(line2)+1);
            } else {
                words.put(line2, 1);
            }
        }
    }

    public void setText(BufferedReader reader) throws IOException {
        System.out.println("The program reads the text until an empty string is entered.");
        System.out.println("Please enter the text: ");
            String line;
            while ((line = reader.readLine()).length() > 0) {
                setWords(line);
            }
    }

    public int getWordCount(String word) {
        String a = word.toLowerCase();
        System.out.printf("The word \"%s\" appears in the text %d times", word, words.getOrDefault(a, 0));
        return words.getOrDefault(a, 0);
    }

    public String enterWord(BufferedReader reader) throws IOException {
        System.out.println("Please enter the word: ");
        return reader.readLine();
    }

}

