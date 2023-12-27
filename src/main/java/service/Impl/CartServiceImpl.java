package service.Impl;

import dao.CartDao;
import model.Cart;
import service.CartService;

import java.sql.SQLException;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao;

    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public void addToCart(int userId, int productId) {
        cartDao.addToCart(userId, productId);
    }

    @Override
    public List<Cart> getUserCart(int userId) throws SQLException {
        return cartDao.getUserCart(userId);
    }

    @Override
    public void updateCartItemQuantity(int userId, int productId, int quantity) throws SQLException {
        cartDao.updateCartItemQuantity(userId, productId, quantity);
    }

    @Override
    public void removeFromCart(int userId, int productId) throws SQLException {
        cartDao.removeFromCart(userId, productId);
    }
}

