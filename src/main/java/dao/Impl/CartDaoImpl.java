package dao.Impl;

import dao.CartDao;
import model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CartDaoImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "zjh", "zjh");
            preparedStatement = connection.prepareStatement("SELECT * FROM carts WHERE UserID = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToCart(int userID, int productID) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO carts (UserID, ProductID) VALUES (?, ?)");
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, productID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> getUserCart(int userID) throws SQLException {
        List<Cart> cartList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM carts WHERE UserID = ?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setProductID(resultSet.getInt("productId"));
                cart.setQuantity(resultSet.getInt("quantity"));
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return cartList; // 如果购物车为空，返回null或一个空的List。根据实际情况来调整。
    }

    @Override
    public void updateCartItemQuantity(int userID, int productID, int quantity) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE carts SET Quantity = ? WHERE UserID = ? AND ProductID = ?");
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, userID);
            preparedStatement.setInt(3, productID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void removeFromCart(int userID, int productID) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM carts WHERE UserID = ? AND ProductID = ?");
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, productID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 如果存在，则删除该产品
                preparedStatement = connection.prepareStatement("DELETE FROM carts WHERE UserID = ? AND ProductID = ?");
                preparedStatement.setInt(1, userID);
                preparedStatement.setInt(2, productID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}

