/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex46;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        WordFrequencyCounter wordFrequencyCounter = new WordFrequencyCounter();

        String inputFromFile = wordFrequencyCounter.getStringFromFile();
        HashMap<String, Integer> frequencyHashMap = wordFrequencyCounter.createHashMap(inputFromFile);
        String outputString = wordFrequencyCounter.generateOutputString(frequencyHashMap,inputFromFile);
        System.out.println(outputString);
    }

    private String generateOutputString(HashMap<String, Integer> frequencyHashMap, String inputFromFile) {
        String outputString = "";
        for (int i = 0; i < frequencyHashMap.size(); i++) {
            ArrayList<String> word = getListOfKeys(inputFromFile);
            outputString += word.get(i);
            outputString += ":";
            outputString += getSpaces(word.get(i));
            outputString += getStars(frequencyHashMap, word.get(i));
            outputString += "\n";
        }
        return outputString;
    }

    private ArrayList<String> getListOfKeys(String inputFromFile) {
        String[] inputFromFileArray = inputFromFile.split("\\s+");
        ArrayList<String> listOfKeys = new ArrayList<String>();
        for (int i = 0; i < inputFromFileArray.length; i++) {
            if (!listOfKeys.contains(inputFromFileArray[i])) {
                listOfKeys.add(inputFromFileArray[i]);
            }
        }
        return listOfKeys;
    }

    private String getStars(HashMap<String, Integer> frequencyHashMap, String word) {
        String stars = "";
        int numStars = frequencyHashMap.get(word);
        for (int i = 0; i < numStars; i++) {
            stars += "*";
        }
        return stars;
    }

    private String getSpaces(String word) {
        String spaces = "";
        int numSpaces = 10 - word.length();
        for (int i = 0; i < numSpaces; i++) {
            spaces += " ";
        }
        return spaces;
    }

    private String getStringFromFile() {
        String originalString = "";
        try {
            originalString = new String(Files.readAllBytes(Paths.get("/Users/nicholaspohlmann/IdeaProjects/pohlmann-cop3330-assignment3/src/main/resources/exercise46_input.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return originalString;
    }

    private HashMap<String, Integer> createHashMap(String inputFromFile) {
        HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();
        String[] inputFromFileArray = inputFromFile.split("\\s+");
        for (int i = 0; i < inputFromFileArray.length; i++) {
            if (!frequencyMap.containsKey(inputFromFileArray[i])) {
                frequencyMap.put(inputFromFileArray[i], 1);
            } else {
                int count = frequencyMap.get(inputFromFileArray[i]) + 1;
                frequencyMap.replace(inputFromFileArray[i], count);
            }
        }
        return frequencyMap;
    }
}
