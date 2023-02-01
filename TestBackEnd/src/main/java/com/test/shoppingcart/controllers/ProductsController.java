package com.test.shoppingcart.controllers;

import com.test.shoppingcart.models.CartItem;
import com.test.shoppingcart.models.Product;
import com.test.shoppingcart.repositories.CartItemRepository;
import com.test.shoppingcart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/")
    public String products(Model model) {
        List<Product> products = productRepository.findAll(
            Sort.by(Sort.Direction.ASC, "productID")
        );

        Long itemsInCart = cartItemRepository.count();

        CartItem cartItem = new CartItem();
        model.addAttribute("products", products);
        model.addAttribute("cartItem", cartItem);
        model.addAttribute("itemsInCart", itemsInCart);
        return "products";
    }
}
