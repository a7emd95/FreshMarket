package com.example.freshmarket.models;

import java.util.List;

public class Category {

    private String id;
    private String name;
    private String categoryImg;
    private List<Product> products = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Category() {
    }

    public Category(String name, String categoryImg) {
        this.name = name;
        this.categoryImg = categoryImg;
    }

    /**
     *
     * @param name
     * @param id
     * @param categoryImg
     * @param products
     */

    public Category(String id, String name, String categoryImg, List<Product> products) {
        super();
        this.id = id;
        this.name = name;
        this.categoryImg = categoryImg;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
