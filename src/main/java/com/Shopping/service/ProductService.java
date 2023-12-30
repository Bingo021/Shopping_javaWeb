package com.Shopping.service;

import com.Shopping.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product createProduct(String productName, BigDecimal price, String description);
    Product getProductById(int productId);
    void updateProductByAdmin(int productId, BigDecimal newPrice, String newDescription); // 更新商品信息（管理员特权）
    void removeProductByAdmin(int productId); // 下架商品（管理员特权）

    List<Product> getFeaturedProducts(); // 获取推荐商品（用于主页展示）
    List<Product> searchProducts(String keyword); // 搜索商品

    // 获取商品详情
    Product getProductDetails(int productId);

}

