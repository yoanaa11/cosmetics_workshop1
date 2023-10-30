package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 15;

    private String name;
    private ArrayList<Product> products;

    public Category(String name) {
        setName(name);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name should be between 2 and 15 symbols.");
        }

        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        if (!this.products.remove(product)) {
            throw new IllegalArgumentException("Product not found in category.");
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append("#Category: " + this.name).append("\n");

        boolean isFound = false;

        for (Product product : this.products) {
                sb.append(product.print());
                isFound = true;
        }

        if (!isFound) {
            sb.append(" #No product in this category");
        }

        return sb.toString();
    }
}