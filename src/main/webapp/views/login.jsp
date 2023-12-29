<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录 - 网上购物系统</title>
    <link href="../images/favicon1.png" rel="shortcut icon"/>
    <link href="../css/styles2.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="w">
    <header>
        <div class="logo">
            <a href="../index.jsp"> <img alt="" src="../images/logo1.png"></a>
        </div>
    </header>
    <div class="registerarea">
        <h3>登录用户
            <div class="login">我没有账号，去<a href="register.jsp">注册</a></div>
        </h3>
        <div class="reg_form">
            <form action="">
                <ul>
                    <li><label for="">用户名：</label><input class="inp" name="username" required type="text"></li>
                    <li><label for="">密码：</label><input class="inp" name="password" required type="password"></li>
                    <li><label for="">登录类型：</label><select class="inp" name="userType">
                        <option value="user">用户</option>
                        <option value="admin">管理员</option>
                    </select></li>
                    <li class="agree"><input id="" name="" type="checkbox">
                        记住密码并登录
                    </li>
                    <li>
                        <input class="btn" type="submit" value="登录账号">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
</html>