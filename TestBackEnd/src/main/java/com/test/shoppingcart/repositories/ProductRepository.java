package com.test.shoppingcart.repositories;

import com.test.shoppingcart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer>, ProductCustomRepository {
    @Transactional
    @Modifying
    @Query("UPDATE products p SET p.inStock = :newInStock WHERE p.productID = :productID")
    void decrementStock(
        @Param("newInStock") Integer newInStock,
        @Param("productID") Integer productID
    );
}
