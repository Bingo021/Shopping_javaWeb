<%--
  Created by IntelliJ IDEA.
  User: Rum
  Date: 2023/12/23
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>订单详情</h2>
<p><%= order.getOrderStatus() %></p> <!-- 显示订单状态 -->
<p><%= order.getOrderDate() %></p> <!-- 显示订单日期价格</th>
        </tr>
        <%
            // 假设存在一个方法来获取订单中的商品并存储在List中
            List<OrderDetail> orderDetails = getOrderDetails(order.getOrderID());
            for (OrderDetail detail : orderDetails) { %>
                <tr>
                    <td><%= detail.getProduct().getProductName() %></td>
                    <td><%= detail.getQuantity() %></td>
                    <td><%= detail.getPrice() %></td>
                </tr>
            <% } %>
    </table>
    <p><%= order.getTotalPrice() %></p> <!-- 显示总价格 -->
<!-- 其他订单详情信息 -->
</body>
</html>
