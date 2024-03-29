<%@ page import="com.Shopping.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>网上购物系统</title>
    <meta name="keywords" content="全球购，海外购">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon1.png"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles1.css">
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var index = 0;
            var images = document.querySelectorAll('.banner img');
            var totalImages = images.length;

            function showImage(i) {
                images[i].style.display = 'block';
            }

            function hideImages() {
                for (var i = 0; i < totalImages; i++) {
                    images[i].style.display = 'none';
                }
            }

            function nextImage() {
                hideImages();
                index = (index + 1) % totalImages;
                showImage(index);
            }

            function prevImage() {
                hideImages();
                index = (index - 1 + totalImages) % totalImages;
                showImage(index);
            }

            showImage(index);

            setInterval(nextImage, 3000);
        });
    </script>
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
                    &nbsp;&nbsp;&nbsp;&nbsp;<a href="Shopping?action=viewCart&userId=${user.userID}">我的购物车</a>
                    &nbsp;&nbsp;|&nbsp;&nbsp;<a href="Shopping?action=viewOrder&userId=${user.userID}">订单</a>
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
<nav class="banner">
    <ul>
        <li><img src="${pageContext.request.contextPath}/images/index1.jpg" alt=""></li>
        <li><img src="${pageContext.request.contextPath}/images/index2.jpg" alt=""></li>
        <li><img src="${pageContext.request.contextPath}/images/index3.jpg" alt=""></li>
    </ul>
    <div class="btn">
        <span></span>
        <span></span>
        <span></span>
    </div>
</nav>
<div class="content">
    <div class="w">
        <h1><a href="#">时尚精品</a></h1>
        <ul>
            <li><a href="#">国际品牌</a></li>
            <li><a href="#">超级巨星</a></li>
            <li><a href="#">青春风尚</a></li>
            <li><a href="#">成熟大气</a></li>
            <li><a href="#">居家休闲</a></li>
            <li><a href="#">魅力臻选</a></li>
        </ul>
    </div>
    <div class="content_box">
        <div class="content_box_1">
            <img src="${pageContext.request.contextPath}/images/1.jpg" alt="">
            <h3>婉约大方</h3>
            <p>$9999</p>
        </div>
        <div class="content_box_1">
            <img src="${pageContext.request.contextPath}/images/2.jpg" alt="">
            <h3>时尚潮流</h3>
            <p>$9999</p>
        </div>
        <div class="content_box_1">
            <img src="${pageContext.request.contextPath}/images/3.jpg" alt="">
            <h3>职场个性</h3>
            <p>$9999</p>
        </div>
        <div class="content_box_1">
            <img src="${pageContext.request.contextPath}/images/4.jpg" alt="">
            <h3>阳光活泼</h3>
            <p>$4999</p>
        </div>
        <div class="content_box_1">
            <img src="${pageContext.request.contextPath}/images/5.jpg" alt="">
            <h3>温柔气质</h3>
            <p>$6999</p>
        </div>
        <div class="content_box_1">
            <img src="${pageContext.request.contextPath}/images/6.jpg" alt="">
            <h3>朋克牛仔</h3>
            <p>$5999</p>
        </div>
    </div>
</div>
<div class="link">
    <h1>品牌链接</h1>
    <ul>
        <li><a href="#"><img src="${pageContext.request.contextPath}/images/CHANEL.jpg" alt=""></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/images/GUCCI.jpg" alt=""></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/images/LV.jpg" alt=""></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/images/CELINE.jpg" alt=""></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/images/Cartier.jpg" alt=""></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/images/Dior.jpg" alt=""></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/images/Salvatore.jpg" alt=""></a></li>
    </ul>
</div>
</body>
<footer>
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
</footer>
</html>