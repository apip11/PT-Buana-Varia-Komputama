package com.test.shoppingcart.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", updatable = false, nullable = false)
    private Integer productID;

    private String name;
    private BigDecimal price;

    @Column(name = "in_stock")
    private Integer inStock;

    protected Product() {

    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product ID: " + getProductID() + "\n"
            + "Name: " + getName() + "\n"
            + "Price: " + getPrice() + "\n"
            + "In Stock: " + getInStock() + "\n";
    }
}
