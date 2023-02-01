package com.test.shoppingcart.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CartItemCustomRepository {
    BigDecimal cartTotal();

    void updateQty(Map<String, Object> itemData);
}
