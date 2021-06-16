/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex41;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSorter {

    public static void main(String[] args) {
        //Object Creation
        NameSorter nameSorter = new NameSorter();
        //create arrayList of person and store names from file
        ArrayList<Person> namesFromFile = nameSorter.getNamesFromFile();
        //From the arrayList sort it by last name then first name
        nameSorter.sortArrayList(namesFromFile);
        //Print to file
        nameSorter.printToFile(namesFromFile);
    }

    //This will print to a file
    private void printToFile(ArrayList<Person> namesFromFile) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("exercise41_output.txt", true), true);
            out.write(String.format("Total of %d names\n-----------------\n", namesFromFile.size()));
            for (int i = 0; i < namesFromFile.size(); i++) {
                out.write(namesFromFile.get(i).getFullName());
                out.write("\n");
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //This function will take in an ArrayList and sort it alphabetically
    private void sortArrayList(ArrayList<Person> namesFromFile) {
        for (int i = 0; i < namesFromFile.size(); i++) {
            for (int j = i + 1; j < namesFromFile.size(); j ++) {
                if (namesFromFile.get(i).getFullName().compareTo((namesFromFile.get(j).getFullName())) > 0) {
                    Person temp = namesFromFile.get(i);
                    namesFromFile.set(i, namesFromFile.get(j));
                    namesFromFile.set(j, temp);
                }
            }
        }
    }

    //This function will read names off of a text file and read into a arrayList of person
    private ArrayList<Person> getNamesFromFile() {
        //create new list
        ArrayList<Person> namesFromFile = new ArrayList<Person>();
        //Try catch for if the file doesn't work
        try {
            //Assigns the name of the file and Scans it in
            File inputFile = new File("src/main/resources/exercise41_input.txt");
            Scanner in = new Scanner(inputFile);
            //While loop till no next line
            while(in.hasNextLine()) {
                //Read in last name and first name
                String name = in.nextLine();
                //get back a person from createPerson
                Person person = createPerson(name);
                //Add new person to arraylist
                namesFromFile.add(person);
            }
        } catch(FileNotFoundException FNFE) {
            System.out.println("An error occurred while getting the file");
            FNFE.printStackTrace();
        }
        return namesFromFile;
    }

    //Takes in the name as lastName, firstName and breaks it into firstName and lastName
    private Person createPerson(String name) {
        //Splits the input string into an array containing firstName and lastName
        String[] nameArray = name.split(", ");
        //Create new person
        Person person = new Person(nameArray[1], nameArray[0]);
        return person;
    }
}
