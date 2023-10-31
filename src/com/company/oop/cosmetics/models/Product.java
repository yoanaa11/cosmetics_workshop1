package com.company.oop.cosmetics.models;

import java.util.Objects;

public class Product {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name should be between 3 and 10 symbols.");
        }

        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        if (brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH) {
            throw new IllegalArgumentException("Brand should be between 2 and 10 symbols.");
        }

        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price should be non negative.");
        }

        this.price = price;
    }

    public GenderType getGender() {
        return this.gender;
    }

    private void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String print() {
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