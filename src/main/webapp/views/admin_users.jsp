<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="../css/admin_styles.css">
</head>
<body>
<header>
    <div class="container">
        <h1>用户管理</h1>
    </div>
</header>
<nav>
    <div class="container">
        <ul>
            <li><a href="admin_orders.jsp">订单管理</a></li>
            <li><a href="admin_products.jsp">商品管理</a></li>
            <li><a href="admin_users.jsp">用户管理</a></li>
        </ul>
    </div>
</nav>
<div class="container content">
    <h2>用户列表</h2>
    <table>
        <thead>
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>Email</th>
            <th>注册时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>user1</td>
            <td>user@example.com</td>
            <td>2023-01-01 10:00:00</td>
            <td>
                <a href="#" class="btn">修改</a>
                <a href="#" class="btn">删除</a>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>user2</td>
            <td>user2@example.com</td>
            <td>2023-01-02 12:30:00</td>
            <td>
                <a href="#" class="btn">修改</a>
                <a href="#" class="btn">删除</a>
            </td>
        </tr>
        <!-- Add more rows as needed -->
        </tbody>
    </table>
    <a href="#" class="btn">查询</a>
</div>
</body>
</html>
