package com.Shopping.dao.Impl;

import com.Shopping.dao.ProductDao;
import com.Shopping.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProductDaoImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "zjh", "zjh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProduct(Product product) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO products (ProductName, Price, Description) VALUES (?, ?, ?)");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
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
    public Product getProductById(int productID) {
        Product product = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE ProductID = ?");
            preparedStatement.setInt(1, productID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setDescription(resultSet.getString("Description"));
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
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getInt("Price"));
                product.setDescription(resultSet.getString("Description"));
                product.setCreateTime(resultSet.getTimestamp("CreateTime"));
                products.add(product);
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
        return products;
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        List<Product> products = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE ProductName = ?");
            preparedStatement.setString(1, productName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getInt("Price"));
                product.setDescription(resultSet.getString("Description"));
                product.setCreateTime(resultSet.getTimestamp("CreateTime"));
                products.add(product);
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
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE products SET ProductName = ?, Price = ?, Description = ? WHERE ProductID = ?");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getProductID());
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
    public void deleteProduct(int productID) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM products WHERE ProductID = ?");
            preparedStatement.setInt(1, productID);
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
}
