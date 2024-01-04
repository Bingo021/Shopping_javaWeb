package com.Shopping.service;

import com.Shopping.model.Cart;
import com.Shopping.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface CartService {
    List<Cart> getCart(int userId) throws SQLException;

    Cart getCartbyCartId(int cartId);

    void addToCart(int userId, Product product, int quantity);

    void updateCartItemQuantity(int userId, int productId, int quantity);

    void removeFromCart(int userId, int productId);

    void clearCart(int userId);
}

