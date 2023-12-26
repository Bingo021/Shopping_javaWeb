<%--
  Created by IntelliJ IDEA.
  User: Rum
  Date: 2023/12/23
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>购物车</h
    <th>数量</th>
    <th>操作</th>
    </tr>
        <%
                // 假设存在一个方法来获取购物车中的商品并存储在List中
                List<Cart> carts = getCartItems();
                for (Cart cart : carts) { %>
    <tr>
        <td><%= cart.getProduct().getProductName() %></td>
        <td><%= cart.getQuantity() %></td>
        <td><button onclick="removeFromCart('<%= cart.getProductID() %>')">移除</button></td>
    </tr>
        <% } %>
    </table>
    <input type="submit" value="结算">
    </form>
</body>
</html>
