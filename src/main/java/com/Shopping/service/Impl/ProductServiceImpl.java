package com.Shopping.service.Impl;

import com.Shopping.model.Product;
import com.Shopping.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public Product createProduct(String productName, BigDecimal price, String description) {
        return null;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public void updateProductByAdmin(int productId, BigDecimal newPrice, String newDescription) {

    }

    @Override
    public void removeProductByAdmin(int productId) {

    }

    @Override
    public List<Product> getFeaturedProducts() {
        return null;
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return null;
    }

    @Override
    public Product getProductDetails(int productId) {
        return null;
    }
}
