/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex41;

//This class describes a person
public class Person {

    //Instance variables for first and last name
    private String firstName;
    private String lastName;

    //Setter for first name and last name
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getter for first name
    public String getFirstName() {
        return this.firstName;
    }

    //getter for last name
    public String getLastName() {
        return this.lastName;
    }

    //getter for full name
    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }
}
