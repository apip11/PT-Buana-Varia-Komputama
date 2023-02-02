package com.test.shoppingcart.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public class ProductCustomRepositoryImpl implements ProductCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void updateStock(Map itemData) {
        Integer currentQty = Integer.parseInt(
            (String)itemData.get("currentQty")
        );

        Integer newQty = Integer.parseInt(
            (String)itemData.get("newQty")
        );

        Integer inStock = Integer.parseInt(
            (String)itemData.get("inStock")
        );

        Integer productID = Integer.parseInt(
            (String)itemData.get("productID")
        );

        Integer difference = currentQty - newQty;
        Integer newInStock = inStock + difference;

        em.createQuery(
            "UPDATE products p " +
                "SET inStock = :newInStock " +
                "WHERE p.productID = :productID"
        ).setParameter("newInStock", newInStock)
            .setParameter("productID", productID)
        .executeUpdate();
    }
}
