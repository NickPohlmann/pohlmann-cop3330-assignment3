/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex46;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        WordFrequencyCounter wordFrequencyCounter = new WordFrequencyCounter();

        String inputFromFile = wordFrequencyCounter.getStringFromFile();

    }

    private String getStringFromFile() {
        String originalString = new String(Files.readAllBytes(Paths.get("/Users/nicholaspohlmann/IdeaProjects/pohlmann-cop3330-assignment3/src/main/resources/exercise46_input.txt")));
        return originalString;
    }
}
