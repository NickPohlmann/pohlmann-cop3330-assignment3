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

        ArrayList<Employee> employeeInputList = parsingDataFiles.getEmployeesFromFile();

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
            if (Character.isDigit(employeeInput.charAt(i)) {
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