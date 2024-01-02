package com.Shopping.service.Impl;

import com.Shopping.service.CartService;

import java.math.BigDecimal;

public class CartServiceImpl implements CartService {
    @Override
    public void addToCart(int userId, int productId, int quantity) {

    }

    @Override
    public void removeFromCart(int userId, int productId) {

    }

    @Override
    public BigDecimal calculateCartTotal(int userId) {
        return null;
    }

    @Override
    public void clearCart(int userId) {

    }

    @Override
    public void addToCartFromProductPage(int userId, int productId, int quantity) {

    }
}

