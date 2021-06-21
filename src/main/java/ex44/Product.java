/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex44;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product (String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity () {
        return this.quantity;
    }
}
