<%@ page import="com.Shopping.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>商品详情 - 网上购物系统</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon1.png"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles1.css">
</head>
<header>
    <div class="container">
        <div class="nav">
            <a href="${pageContext.request.contextPath}/index.jsp"> <img
                    src="${pageContext.request.contextPath}/images/logo1.png" alt=""></a>
            <ul>
                <li><a href="#">首页</a>
                    <div>
                        <p><a href="${pageContext.request.contextPath}/index.jsp">美妆个护</a></p>
                        <p><a href="#">食品保健</a></p>
                        <p><a href="#">母婴用品</a></p>
                        <p><a href="#">服饰鞋包</a></p>
                        <p><a href="#">生活/数码</a></p>
                    </div>
                </li>
                <li><a href="#">全球精选</a>
                </li>
                <li><a href="#">进口超市</a>
                </li>
                <li><a href="#">海外直购</a>
                </li>
                <li><a href="#">购买与服务</a>
                    <div>
                        <p><a href="#">产品导购</a></p>
                        <p><a href="#">产品购买</a></p>
                        <p><a href="#">服务与支持</a></p>
                        <p><a href="#">会员尊享</a></p>
                    </div>
                </li>
                <li><a href="#"> 关于</a>
                    <div>
                        <p><a href="#">会员尊享</a></p>
                        <p><a href="#">投资者关系</a></p>
                        <p><a href="#">品牌资讯</a></p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="search">
            <label>
                <input type="text" placeholder="" class="a1">
            </label>
            <button class="a2"><a href="#">搜索</a></button>
            <span class="a3">
                <%if (session.getAttribute("user") != null) { %>
                <li><a href="#">欢迎，<%= ((User) session.getAttribute("user")).getUsername() %></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/views/cart.jsp">我的购物车</a>
                    &nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/views/order.jsp">订单</a>
                </li>
                <% } else { %>
                <li><a href="${pageContext.request.contextPath}/views/login.jsp">登录</a>
                    &nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/views/register.jsp">注册</a>
                </li>
                <% } %>
            </span>
        </div>
    </div>
</header>
<body>
<div class="container content">
    <h2>商品详情</h2>
</div>
</body>
<footer>
    <div class="container">
        <div class="footer">
            <div class="w">
                <div class="footer1">
                    <h3>全球购</h3>
                    <ul>
                        <li><a href="#">全球购首页</a></li>
                        <li><a href="#">相关资讯</a></li>
                        <li><a href="#">中国体验店</a></li>
                    </ul>
                </div>
                <div class="footer1">
                    <h3>国际产品</h3>
                    <ul>
                        <li><a href="#">服饰</a></li>
                        <li><a href="#">奢侈品</a></li>
                        <li><a href="#">代购门店</a></li>
                    </ul>
                </div>
                <div class="footer1">
                    <h3>购买与服务</h3>
                    <ul>
                        <li><a href="#">产品导购</a></li>
                        <li><a href="#">产品购买</a></li>
                        <li><a href="#">服务与支持</a></li>
                        <li><a href="#">会员尊享</a></li>
                    </ul>
                </div>
                <div class="footer1">
                    <h3>关于全球购</h3>
                    <ul>
                        <li><a href="#">海外品牌</a></li>
                        <li><a href="#">投资者关系</a></li>
                        <li><a href="#">相关资讯 </a></li>
                    </ul>
                </div>
                <div class="footer1">
                    <h3>售后服务</h3>
                    <ul>
                        <li><a href="#">客服</a></li>
                        <li><a href="#">售后平台</a></li>
                        <li><a href="#">售后维权</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>
</html>

