package com.company.oop.cosmetics.models;

import java.util.Objects;

public class Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_MIN_LENGTH = 2;
    public static final int BRAND_MAX_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private GenderType gender;
    // "Each product in the system has name, brand, price and gender."

    public Product(String name, String brand, double price, GenderType gender) {
        // finish the constructor and validate data
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name should be between 3 and 10 symbols.");
        }

        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH) {
            throw new IllegalArgumentException("Brand should be between 2 and 10 symbols.");
        }

        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price should be non negative.");
        }

        this.price = price;
    }

    public GenderType getGender() {
        return this.gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String print() {
        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(" #%s %s%n", this.name, this.brand));
        sb.append(String.format(" #Price: $%.2f%n", this.price));
        sb.append(String.format(" #Gender: %s%n", this.gender));
        sb.append(" ===");

        return sb.toString();
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;

        if (p == null || getClass() != p.getClass()) return false;

        Product product = (Product) p;

        return Double.compare(this.getPrice(), product.getPrice()) == 0 &&
                Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getBrand(), product.getBrand()) &&
                this.getGender() == product.getGender();
    }
}