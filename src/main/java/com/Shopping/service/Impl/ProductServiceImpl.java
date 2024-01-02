package com.Shopping.service.Impl;

import com.Shopping.dao.ProductDao;
import com.Shopping.model.Product;
import com.Shopping.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl() {

        productDao = null;
    }

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(String productName, BigDecimal price, String description) {
        Product newProduct = new Product(productName, price, description);
        productDao.addProduct(newProduct);
        return newProduct;
    }

    @Override
    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public void updateProductByAdmin(int productId, BigDecimal newPrice, String newDescription) {
        Product existingProduct = productDao.getProductById(productId);

        if (existingProduct != null) {
            existingProduct.setPrice(newPrice != null ? newPrice : existingProduct.getPrice());
            existingProduct.setDescription(newDescription != null ? newDescription : existingProduct.getDescription());

            productDao.updateProduct(existingProduct);
        }
    }

    @Override
    public void removeProductByAdmin(int productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    public List<Product> getFeaturedProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productDao.getProductsByName(keyword);
    }

    @Override
    public Product getProductDetails(int productId) {
        return productDao.getProductById(productId);
    }
}
