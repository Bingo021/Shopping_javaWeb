package service;

import model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    Product getProductById(int productId);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String productName);
    void updateProduct(Product product);
    void deleteProduct(int productId);
}

