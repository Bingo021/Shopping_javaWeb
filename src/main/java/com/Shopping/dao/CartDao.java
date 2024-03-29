package com.Shopping.dao;

import com.Shopping.model.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    void addToCart(int userID, int productID);

    List<Cart> getUserCart(int userID) throws SQLException;

    Cart getCart(int cartID) throws SQLException;

    void updateCartItemQuantity(int userID, int productID, int quantity) throws SQLException;

    void removeFromCart(int userID, int productID) throws SQLException;

    void clearCart(int userId);
}
