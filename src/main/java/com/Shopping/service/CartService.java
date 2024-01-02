package com.Shopping.service;

import java.math.BigDecimal;

public interface CartService {
    void addToCart(int userId, int productId, int quantity);

    void removeFromCart(int userId, int productId);

    BigDecimal calculateCartTotal(int userId);

    void clearCart(int userId);

    // 从商品详细页面直接加入购物车
    void addToCartFromProductPage(int userId, int productId, int quantity);
}

