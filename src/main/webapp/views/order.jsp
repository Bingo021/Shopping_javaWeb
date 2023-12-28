<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单详情 - 网上购物系统</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>订单详情</h1>
    <!-- 订单详细信息 -->
    <div class="order-details">
        <!-- 订单商品1 -->
        <div class="order-item">
            <img src="product1.jpg" alt="Product 1">
            <h3>商品1</h3>
            <p>价格：$20.00</p>
            <p>数量：2</p>
        </div>
        <!-- 更多订单商品... -->
    </div>
    <!-- 总金额 -->
    <p>总金额：$40.00</p>
    <!-- 收货地址信息 -->
    <div class="delivery-address">
        <h2>收货地址</h2>
        <p>姓名：张三</p>
        <p>电话：1234567890</p>
        <p>地址：北京市朝阳区XXX街道</p>
    </div>
    <!-- 支付记录信息 -->
    <div class="payment-record">
        <h2>支付记录</h2>
        <p>支付方式：支付宝</p>
        <p>支付金额：$40.00</p>
        <p>支付状态：已支付</p>
        <p>支付时间：2023-01-01 12:00:00</p>
    </div>
</div>
</body>
</html>
