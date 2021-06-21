/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordFinder {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        WordFinder wordFinder = new WordFinder();
        String outputFileName = wordFinder.getOutputFileName();
        String originalFileString = wordFinder.getOriginalString();
        String newString = wordFinder.getNewString(originalFileString);
        System.out.println(newString);
    }

    private String getNewString(String originalFileString) {
        String newString = "";
        String[] originalStringArray = originalFileString.split(" ");
        for (int i = 0; i < originalStringArray.length; i++) {
            if (originalStringArray[i].contains("utilize")) {
                newString += "use";
                newString += " ";
            } else {
                newString += originalStringArray[i];
                newString += " ";
            }
        }
        return newString;
    }

    private String getOriginalString() throws IOException {
        String originalString = new String(Files.readAllBytes(Paths.get("/Users/nicholaspohlmann/IdeaProjects/pohlmann-cop3330-assignment3/src/main/resources/exercise45_input.txt")));
        return originalString;
    }

    private String getOutputFileName() {
        System.out.print("What would you like the output file name to be? ");
        String fileName = in.nextLine();
        return fileName;
    }
}
