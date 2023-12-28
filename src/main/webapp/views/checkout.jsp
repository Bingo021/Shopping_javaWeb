<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>结算 - 网上购物系统</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>订单结算</h1>

    <!-- 显示购物车中的商品信息 -->
    <div class="cart-items">
        <h2>购物车商品</h2>
        <table>
            <thead>
            <tr>
                <th>商品名称</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>商品1</td>
                <td>$20.00</td>
                <td>2</td>
                <td>$40.00</td>
            </tr>
            <!-- 更多购物车商品... -->
            </tbody>
        </table>
    </div>

    <!-- 显示总金额 -->
    <div class="total-amount">
        <h2>总金额</h2>
        <p>$40.00</p>
    </div>

    <!-- 显示收货地址信息 -->
    <div class="delivery-address">
        <h2>收货地址</h2>
        <p>姓名：张三</p>
        <p>电话：1234567890</p>
        <p>地址：北京市朝阳区XXX街道</p>
    </div>

    <!-- 选择支付方式 -->
    <div class="payment-method">
        <h2>选择支付方式</h2>
        <form action="PlaceOrderServlet" method="post">
            <label for="paymentMethod">支付方式：</label>
            <select id="paymentMethod" name="paymentMethod" required>
                <option value="支付宝">支付宝</option>
                <option value="微信支付">微信支付</option>
                <!-- 更多支付方式... -->
            </select>
            <br>
            <input type="submit" value="确认支付">
        </form>
    </div>
</div>
</body>
</html>
