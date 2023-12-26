<%--
  Created by IntelliJ IDEA.
  User: Rum
  Date: 2023/12/23
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
<%@ include file="menu.jsp" %> <!-- 假设存在一个用于导航的menu.jsp文件 -->
<h2><%= product.getProductName() %></h2>
<p><%= product.getDescription() %></p>
<!-- 其他商品详情信息 -->
<p><button onclick="addToCart('<%= product.getProductID() %>')">加入购物车</button></p> <!-- 使用JavaScript添加到购物车 -->
</body>
</html>
