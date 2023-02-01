package com.test.shoppingcart.models;

import javax.persistence.*;

@Entity(name = "cart")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", updatable = false, nullable = false)
    private Integer cartID;

    @Column(name = "product_id")
    private Integer productID;

    private Integer quantity;

    public CartItem() {

    }

    public Integer getCartID() {
        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart ID: " + getCartID() + "\n"
            + "Product ID: " + getProductID() + "\n"
            + "Quantity: " + getQuantity() + "\n";
    }
}
