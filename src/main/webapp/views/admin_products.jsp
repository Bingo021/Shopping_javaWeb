<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员商品管理</title>
    <link rel="stylesheet" type="text/css" href="path/to/your/styles.css">
</head>
<body>
<h2>管理员商品管理</h2>

<!-- 商品列表 -->
<div class="product-list">
    <!-- 示例商品 -->
    <div class="product-item">
        <img src="path/to/product/image.jpg" alt="Product Image" class="product-image">
        <h3>Product Name</h3>
        <p>Price: $19.99</p>
        <p>Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        <a href="editProduct.jsp?productId=1">编辑商品</a>
        <a href="deleteProductServlet?productId=1">删除商品</a>
    </div>

    <!-- 添加更多商品项... -->
</div>

<!-- 搜索框 -->
<form>
    <input type="text" placeholder="Search products...">
    <button>Search</button>
</form>
</body>
</html>

