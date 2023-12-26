<%@ page import="model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rum
  Date: 2023/12/23
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<%@ include file="menu.jsp" %> <!-- 假设存在一个用于导航的menu.jsp文件 -->
<h2>商品列表</h2>
<ul>
    <%
        // 假设存在一个方法来获取所有商品并存储在List中
        List<Product> Products = getProducts();
        for (Product product : Products) { %>
    <li><%= product.getProductName() %> - <%= product.getPrice() %></li>
    <% } %>
</ul>
</body>
</html>
