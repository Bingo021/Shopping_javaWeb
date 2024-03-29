package com.Shopping.dao.Impl;

import com.Shopping.dao.CartDao;
import com.Shopping.model.Cart;
import com.Shopping.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CartDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "zjh", "zjh");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Cart> getUserCart(int userID) throws SQLException {
        List<Cart> cartList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select a.CartID, a.UserID, a.ProductID, a.Quantity, a.CreateTime, b.ProductName,b.Price from carts a left join products b on a.ProductID = b.ProductID WHERE a.UserID = ?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setProductID(resultSet.getInt("ProductId"));
                cart.setQuantity(resultSet.getInt("Quantity"));

                Product product = new Product();
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getBigDecimal("Price"));
                cart.setCartProduct(product);
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cartList;
    }

    @Override
    public Cart getCart(int cartID) throws SQLException {
        Cart cart = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM carts WHERE CartID = ?");
            preparedStatement.setInt(1, cartID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cart = new Cart();
                cart.getUserID(resultSet.getInt("UserId"));
                cart.setProductID(resultSet.getInt("ProductId"));
                cart.setQuantity(resultSet.getInt("Quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cart;
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
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
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
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void clearCart(int userID) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM carts WHERE UserID = ?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 如果存在，则删除该产品
                preparedStatement = connection.prepareStatement("DELETE FROM carts WHERE UserID = ?");
                preparedStatement.setInt(1, userID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

