package dao;

import model.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    Product getProductById(int productID);

    List<Product> getAllProducts();

    List<Product> getProductsByName(String productName);

    void updateProduct(Product product);

    void deleteProduct(int productID);
}
