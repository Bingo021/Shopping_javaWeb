package com.Shopping.service;

import com.Shopping.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product createProduct(String productName, BigDecimal price, String description);

    Product getProductById(int productId);

    void updateProductByAdmin(int productId, BigDecimal newPrice, String newDescription);

    void removeProductByAdmin(int productId);

    List<Product> getFeaturedProducts();

    List<Product> searchProducts(String keyword);

    Product getProductDetails(int productId);

}

