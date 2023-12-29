package com.Shopping.service;

import com.Shopping.model.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartService {
    void addToCart(int userId, int productId);

    List<Cart> getUserCart(int userId) throws SQLException;

    void updateCartItemQuantity(int userId, int productId, int quantity) throws SQLException;

    void removeFromCart(int userId, int productId) throws SQLException;
}

