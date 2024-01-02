package com.Shopping.service;

import com.Shopping.model.Cart;
import com.Shopping.model.Product;

public interface CartService {
    Cart getCart(int userId);

    void addToCart(int userId, Product product, int quantity);

    void updateCartItemQuantity(int userId, int productId, int quantity);

    void removeFromCart(int userId, int productId);

    void clearCart(int userId);
}

