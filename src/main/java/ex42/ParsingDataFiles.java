/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParsingDataFiles {

    public static void main(String[] args) {
        //Object creation
        ParsingDataFiles parsingDataFiles = new ParsingDataFiles();
        //Creates a list of employees
        ArrayList<Employee> employeeInputList = parsingDataFiles.getEmployeesFromFile();
        //Create output string
        String outputString = parsingDataFiles.generateOutputString(employeeInputList);
        System.out.println(outputString);
    }

    private String generateOutputString(ArrayList<Employee> employeeInputList) {
        String outputString = "Last      First     Salary\n--------------------------\n";
        outputString += generateOutputFromArrayList(employeeInputList);
        return outputString;
    }

    private String generateOutputFromArrayList(ArrayList<Employee> employeeInputList) {
        String outputString = "";
        for (int i = 0; i < employeeInputList.size(); i++) {
            outputString += employeeInputList.get(i).getLastName();
            outputString += getNumSpaces(employeeInputList.get(i).getLastName());
            outputString += employeeInputList.get(i).getFirstName();
            outputString += getNumSpaces(employeeInputList.get(i).getFirstName());
            outputString += employeeInputList.get(i).getSalary();
            outputString += "\n";
        }
        return outputString;
    }

    private String getNumSpaces(String lastNameString) {
        int numSpaces = 10 - lastNameString.length();
        String spacesString = "";
        for (int i = 0; i < numSpaces; i++) {
            spacesString += " ";
        }
        return spacesString;
    }

    private ArrayList<Employee> getEmployeesFromFile() {
        ArrayList<Employee> employeeInputList = new ArrayList<Employee>();
        try {
            //Assigns the name of the file and Scans it in
            File inputFile = new File("src/main/resources/exercise42_input.txt");
            Scanner in = new Scanner(inputFile);
            while(in.hasNextLine()) {
                String employeeInput = in.nextLine();
                Employee employee = createEmployee(employeeInput);
                employeeInputList.add(employee);
            }
        } catch(FileNotFoundException FNFE) {
            System.out.println("An error occurred while getting the file");
            FNFE.printStackTrace();
        }
        return employeeInputList;
    }

    private Employee createEmployee(String employeeInput) {
        String firstName = "";
        String lastName = "";
        String salary = "";
        int count = 0;
        //Separate into first name, last name, and salary
        for (int i = 0; i < employeeInput.length(); i++) {
            if (Character.isDigit(employeeInput.charAt(i))) {
               salary += employeeInput.charAt(i);
            } else if (Character.isAlphabetic(employeeInput.charAt(i)) && count == 0) {
                lastName += employeeInput.charAt(i);
            } else if (Character.isAlphabetic(employeeInput.charAt(i)) && count == 1) {
                firstName += employeeInput.charAt(i);
            } else {
                count += 1;
            }
        }
        Employee employee = new Employee(firstName, lastName, salary);
        return employee;
    }
}