<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册 - 网上购物系统</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon1.png"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles2.css">
</head>
<body>
<div class="w">
    <header>
        <div class="logo">
            <a href="${pageContext.request.contextPath}/index.jsp"> <img
                    src="${pageContext.request.contextPath}/images/logo1.png" alt=""></a>
        </div>
    </header>
    <div class="registerarea">
        <h3>注册新用户
            <div class="login">我有账号，去<a href="${pageContext.request.contextPath}/views/login.jsp">登陆</a></div>
        </h3>
        <div class="reg_form">
            <form action="../Shopping?action=register" method="post">
                <ul>
                    <li><label>用户名：</label> <input type="text" required name="username" class="inp"></li>
                    <li><label>Email：</label> <input type="text" required name="email" class="inp"></li>
                    <li><label>登录密码：</label> <input type="password" required name="password" class="inp"></li>
                    <li class="safe">安全程度 <em class="ruo">弱</em> <em class="zhong">中</em> <em
                            class="qiang">强</em></li>
                    <li><label for="">确认密码：</label> <input type="password" required name="password" class="inp">
                    </li>
                    <li class="agree"><input type="checkbox" required name="" id="">
                        同意协议并注册 <a href="#">《知晓用户协议》</a>
                    </li>
                    <li>
                        <input type="submit" value="完成注册" class="btn">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
</html>