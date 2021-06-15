/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSorter {

    public static void main(String[] args) {
        NameSorter nameSorter = new NameSorter();
        ArrayList<String> namesFromFile = nameSorter.getNamesFromFile();

    }

    private void sortNamesFromFile(ArrayList<String> namesFromFile) {
        namesFromFile.sort(String::compareToIgnoreCase);
    }

    /**
     *
     * @return
     */
    private ArrayList<String> getNamesFromFile() {
        ArrayList<String> namesFromFile = new ArrayList<String>();
        try {
            File inputFile = new File("exercise41_input.txt");
            Scanner in = new Scanner(inputFile);
            while(in.hasNextLine()) {
                String name = in.nextLine();
                namesFromFile.add(name);
            }
        } catch(FileNotFoundException FNFE) {
            System.out.println("An error occurred while getting the file");
            FNFE.printStackTrace();
        }
        return namesFromFile;
    }
}
