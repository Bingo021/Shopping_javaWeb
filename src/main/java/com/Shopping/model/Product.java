package com.Shopping.model;

import java.math.BigDecimal;

public class Product {
    private int productID;
    private String productName;
    private BigDecimal price;
    private String description;
    private java.sql.Timestamp createTime;

    public Product(String productName, BigDecimal price, String description) {
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public Product() {

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }
}
