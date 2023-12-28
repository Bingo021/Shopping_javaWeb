<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车 - 网上购物系统</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>购物车</h1>
    <!-- 购物车列表展示 -->
    <div class="cart-list">
        <!-- 购物车商品1 -->
        <div class="cart-item">
            <img src="product1.jpg" alt="Product 1">
            <h3>商品1</h3>
            <p>价格：$20.00</p>
            <p>数量：2</p>
            <!-- 更新购物车按钮 -->
            <form action="CartServlet" method="post">
                <input type="hidden" name="productId" value="1">
                <input type="number" name="quantity" value="2" min="1">
                <input type="submit" value="更新购物车">
            </form>
            <!-- 从购物车移除按钮 -->
            <form action="CartServlet" method="post">
                <input type="hidden" name="productId" value="1">
                <input type="hidden" name="action" value="remove">
                <input type="submit" value="从购物车移除">
            </form>
        </div>
        <!-- 更多购物车商品... -->
    </div>
    <!-- 结算按钮 -->
    <form action="CheckoutServlet" method="post">
        <input type="submit" value="结算">
    </form>
</div>
</body>
</html>
