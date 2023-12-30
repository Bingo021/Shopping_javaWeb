<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
    <link rel="stylesheet" type="text/css" href="../css/admin_styles.css">
</head>
<body>
<header>
    <div class="container">
        <h1>商品管理</h1>
    </div>
</header>
<nav>
    <div class="container">
        <ul>
            <li><a href="#">订单管理</a></li>
            <li><a href="#">商品管理</a></li>
            <li><a href="#">用户管理</a></li>
        </ul>
    </div>
</nav>
<div class="container content">
    <h2>商品列表</h2>
    <table>
        <thead>
        <tr>
            <th>商品ID</th>
            <th>商品名称</th>
            <th>价格</th>
            <th>商品描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>Product A</td>
            <td>$50.00</td>
            <td>Description for Product A</td>
            <td>
                <a href="#" class="btn">修改</a>
                <a href="#" class="btn">删除</a>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>Product B</td>
            <td>$30.00</td>
            <td>Description for Product B</td>
            <td>
                <a href="#" class="btn">修改</a>
                <a href="#" class="btn">删除</a>
            </td>
        </tr>
        <!-- Add more rows as needed -->
        </tbody>
    </table>
    <a href="#" class="btn">查询</a>
    <a href="#" class="btn">添加新商品</a>
</div>
</body>
</html>
