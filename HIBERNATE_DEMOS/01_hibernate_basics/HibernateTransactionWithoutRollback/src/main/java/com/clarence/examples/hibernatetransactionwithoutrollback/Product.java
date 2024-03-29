/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clarence.examples.hibernatetransactionwithoutrollback;

/**
 *
 * @author constantin
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private double price;

    public Product() {
        super();
    }

    public Product(String name, String description, double price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
