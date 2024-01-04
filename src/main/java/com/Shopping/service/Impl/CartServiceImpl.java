package com.Shopping.service.Impl;

import com.Shopping.dao.CartDao;
import com.Shopping.dao.Impl.CartDaoImpl;
import com.Shopping.model.Cart;
import com.Shopping.model.Product;
import com.Shopping.service.CartService;
import com.Shopping.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class CartServiceImpl implements CartService {
    private final CartDao cartDao = new CartDaoImpl();
    private final ProductService productService = new ProductServiceImpl();

    public CartServiceImpl() {

    }
    @Override
    public Cart getCart(int userId) {
        try {
            List<Cart> userCarts = cartDao.getUserCart(userId);
            if (!userCarts.isEmpty()) {
                return userCarts.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addToCart(int userId, Product product, int quantity) {
        cartDao.addToCart(userId, product.getProductID());
        updateCartItemQuantity(userId, product.getProductID(), quantity);
    }

    @Override
    public void updateCartItemQuantity(int userId, int productId, int quantity) {
        try {
            cartDao.updateCartItemQuantity(userId, productId, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeFromCart(int userId, int productId) {
        try {
            cartDao.removeFromCart(userId, productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearCart(int userId) {
        cartDao.clearCart(userId);
    }
}

