<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品列表 - 网上购物系统</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>商品列表</h1>
    <!-- 商品列表展示 -->
    <div class="product-list">
        <!-- 商品1 -->
        <div class="product">
            <img src="product1.jpg" alt="Product 1">
            <h3>商品1</h3>
            <p>价格：$20.00</p>
            <a href="productDetail.jsp?id=1">查看详情</a>
        </div>
        <!-- 商品2 -->
        <div class="product">
            <img src="product2.jpg" alt="Product 2">
            <h3>商品2</h3>
            <p>价格：$30.00</p>
            <a href="productDetail.jsp?id=2">查看详情</a>
        </div>
        <!-- 更多商品... -->
    </div>
</div>
</body>
</html>
