package com.ecommerce.model;

import java.math.BigDecimal;

public class Product {
    private int id, stock;
    private String name, description, imageUrl, category;
    private BigDecimal price;

    public Product(int id, String name, String description, BigDecimal price, String imageUrl, String category, int stock) {
        this.id=id; this.name=name; this.description=description; this.price=price;
        this.imageUrl=imageUrl; this.category=category; this.stock=stock;
    }
    public int getId(){return id;} public String getName(){return name;}
    public String getDescription(){return description;} public BigDecimal getPrice(){return price;}
    public String getImageUrl(){return imageUrl;} public String getCategory(){return category;}
    public int getStock(){return stock;}
}
