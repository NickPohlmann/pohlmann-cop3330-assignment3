/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex42;

import ex41.Person;

public class Employee extends Person {
    private String salary;


    //Setter for salary
    public Employee(String firstName, String lastName, String salary) {
        super();
        this.salary = salary;
    }

    //getter for salary
    public String getSalary() {
        return this.salary;
    }
}
