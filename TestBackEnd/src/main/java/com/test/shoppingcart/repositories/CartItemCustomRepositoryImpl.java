package com.test.shoppingcart.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CartItemCustomRepositoryImpl implements CartItemCustomRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public BigDecimal cartTotal() {
        TypedQuery<Map> query = em.createQuery(
            "SELECT new map (" +
                "p.price as price, c.quantity as quantity" +
                ") " +
                "FROM cart c INNER JOIN products p " +
                "ON c.productID = p.productID",
            Map.class
        );

        List<Map> pricesAndQuantities = query.getResultList();

        BigDecimal total = BigDecimal.valueOf(0);

        for (Map item : pricesAndQuantities) {
            BigDecimal price = (BigDecimal)item.get("price");
            Integer intQuantity = (Integer)item.get("quantity");
            BigDecimal quantity = BigDecimal.valueOf(intQuantity);
            total = total.add(price.multiply(quantity));
        }

        return total;
    }

    @Override
    @Transactional
    public void updateQty(Map<String, Object> itemData) {
        Integer newQty = Integer.parseInt(
            (String)itemData.get("newQty")
        );

        Integer cartID = (Integer)itemData.get("cartID");

        em.createQuery(
            "UPDATE cart c " +
                "SET c.quantity = :newQty " +
                "WHERE c.cartID = :cartID"
        ).setParameter("newQty", newQty)
            .setParameter("cartID", cartID)
            .executeUpdate();
    }
}
