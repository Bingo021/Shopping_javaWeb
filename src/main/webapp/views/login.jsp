<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录 - 网上购物系统</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="form-container">
    <form action="LoginServlet" method="post">
        <h2>用户登录</h2>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <label for="userType">登录类型:</label>
        <select id="userType" name="userType" required>
            <option value="user">用户</option>
            <option value="admin">管理员</option>
        </select>
        <br>
        <input type="submit" value="登录" class="submit-btn">
        <a href="register.jsp">注册新账户</a>
    </form>
</div>
</body>
</html>
