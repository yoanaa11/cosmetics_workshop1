package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.Product;
import com.company.oop.cosmetics.models.ShoppingCart;

import java.util.ArrayList;

public class CosmeticsRepositoryImpl implements CosmeticsRepository {

    private final ArrayList<Product> products;
    private final ArrayList<Category> categories;
    private final ShoppingCart shoppingCart;

    public CosmeticsRepositoryImpl() {
        products = new ArrayList<>();
        categories = new ArrayList<>();

        shoppingCart = new ShoppingCart();
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findProductByName(String productName) {
        for (Product currentProduct : this.products) {
            if (currentProduct.getName().equals(productName)) {
                return currentProduct;
            }
        }

        throw new IllegalArgumentException(String.format("Product %s does not exist!", productName));
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        for (Category currentCategory : this.categories) {
            if (currentCategory.getName().equals(categoryName)) {
                return currentCategory;
            }
        }

        throw new IllegalArgumentException(String.format("Category %s does not exist!", categoryName));
    }

    @Override
    public void createCategory(String categoryName) {
        Category category = new Category(categoryName);

        this.categories.add(category);
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        Product product = new Product(name, brand, price, gender);

        this.products.add(product);
    }

    @Override
    public boolean categoryExist(String categoryName) {
        for (Category category : this.categories) {
            if (category.getName().equals(categoryName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean productExist(String productName) {
        for (Product product : this.products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }

        return false;
    }
}
