package com.senla.courses.brest.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class WordsSorter {
    private ArrayList<String> words;

    public WordsSorter(String line) {
        setWords(line);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();

        WordsSorter sorter = new WordsSorter(line);
        System.out.println("Words count - " + sorter.getWordsCount());
        sorter.printWords();
    }

    private void setWords(String line) {
        words = new ArrayList<>();
        String[] array = line.split(" ");
        for (String word : array) {
            words.add(firstUpperCase(word));
        }
        Collections.sort(words);
    }

    public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public int getWordsCount() {
        return words.size();
    }

    public void printWords() {
        if (!(words==null)) {
            System.out.println("Printing sorted words: ");
            words.forEach(System.out::println);
        }
    }


}
