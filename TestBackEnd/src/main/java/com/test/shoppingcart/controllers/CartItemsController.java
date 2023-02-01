package com.test.shoppingcart.controllers;

import com.test.shoppingcart.models.CartItem;
import com.test.shoppingcart.repositories.CartItemRepository;
import com.test.shoppingcart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartItemsController {
    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/cart")
    public String index(Model model) {
        Long itemsInCart = cartItemRepository.count();
        List<Map> cart = cartItemRepository.getItems();
        BigDecimal cartTotal = cartItemRepository.cartTotal();
        Map<String, Object> itemData = new HashMap<>();

        model.addAttribute("itemData", itemData);
        model.addAttribute("cartItems", cart);
        model.addAttribute("cartTotal", cartTotal);
        model.addAttribute("itemsInCart", itemsInCart);
        return "cart";
    }

    @PostMapping("/cart")
    public String add(@ModelAttribute("cartItem") CartItem cartItem) {
        Integer productID = cartItem.getProductID();
        Integer addingToCart = cartItem.getQuantity();
        Integer currentlyInStock = productRepository
            .getOne(productID)
            .getInStock();
        boolean exists = cartItemRepository
            .existsCartItemByProductID(productID);

        if (exists == false) {
            cartItemRepository.saveAndFlush(cartItem);
        } else {
            Integer currentQuantity = cartItemRepository.
                findOneByProductID(productID).
                getQuantity();
            Integer newQuantity = currentQuantity + addingToCart;
            cartItemRepository.add(newQuantity, productID);
        }

        Integer newInStock = currentlyInStock - addingToCart;
        productRepository.decrementStock(newInStock, productID);

        return "redirect:/";
    }

    @PatchMapping(
        value = "/cart/{id}",
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public String update(@PathVariable("id") Integer cartID, @RequestParam Map<String, Object> itemData) {
        if (Integer.parseInt((String)itemData.get("newQty")) == 0) {
            cartItemRepository.deleteById(cartID);
        }

        itemData.remove("_method");
        itemData.put("cartID", cartID);
        cartItemRepository.updateQty(itemData);
        productRepository.updateStock(itemData);

        return "redirect:/cart";
    }
}
