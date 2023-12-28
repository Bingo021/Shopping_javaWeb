<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情 - 网上购物系统</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>商品详情</h1>
    <!-- 商品详细信息 -->
    <div class="product-detail">
        <img src="product1.jpg" alt="Product 1">
        <h3>商品1</h3>
        <p>价格：$20.00</p>
        <p>详细描述：这是商品1的详细描述。</p>
        <!-- 加入购物车按钮 -->
        <form action="CartServlet" method="post">
            <input type="hidden" name="productId" value="1">
            <input type="number" name="quantity" value="1" min="1">
            <input type="submit" value="加入购物车">
        </form>
    </div>
</div>
</body>
</html>
