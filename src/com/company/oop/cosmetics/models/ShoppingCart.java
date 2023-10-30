package com.company.oop.cosmetics.models;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        if (!this.products.remove(product)) {
            throw new IllegalArgumentException(String.format("Shopping cart does not contain product with name %s!", product));
        }
    }

    public boolean containsProduct(Product product) {
        return this.products.contains(product);
    }

    public double totalPrice() {
        double totalSum = 0;

        for (Product product : this.products) {
            totalSum += product.getPrice();
        }

        return totalSum;
    }
}