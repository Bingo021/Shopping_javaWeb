<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>购你所购|今日特惠</title>
    <meta name="keywords" content="全球购，海外购">
    <link rel="shortcut icon" href="favicon1.png" />
    <link rel="stylesheet" type="text/css" href="views/styles.css">
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
<body>
<header>
    <div class="content">
        <div class="nav">
            <a href="index.jsp"><img src="images/logo1.png"/></a>
            <ul>
                <li><a href="#">首页</a>
                    <div>
                        <p><a href="index.jsp">美妆个护</a></p>
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
            <span class="a3"><a href="denglu.html">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="zhuce.html">注册</a></span>
        </div>
    </div>
</header>
<nav class="banner">
    <ul>
        <li><img src="images/woman-in-fur-under-neon.jpg" alt=""></li>
        <li><img src="images/blank-colored-t-shirts.jpg" alt=""></li>
        <li><img src="images/t-shirt-store.jpg" alt=""></li>
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
            <img src="images/woman-in-flower-blossoms.jpg" alt="">
            <h3>婉约大方</h3>
            <p>$9999</p>
        </div>
        <div class="content_box_1">
            <img src="images/fashion-model-in-fur.jpg" alt="">
            <h3>时尚潮流</h3>
            <p>$9999</p>
        </div>
        <div class="content_box_1">
            <img src="images/model-in-gold-fashion.jpg" alt="">
            <h3>职场个性</h3>
            <p>$9999</p>
        </div>
        <div class="content_box_1">
            <img src="images/happy-woman.jpg" alt="">
            <h3>阳光活泼</h3>
            <p>$4999</p>
        </div>
        <div class="content_box_1">
            <img src="images/young-woman-posing-at-carnival.jpg" alt="">
            <h3>温柔气质</h3>
            <p>$6999</p>
        </div>
        <div class="content_box_1">
            <img src="images/woman-in-summer-fashion.jpg" alt="">
            <h3>朋克牛仔</h3>
            <p>$5999</p>
        </div>
    </div>
</div>
<div class="link">
    <h1>品牌链接</h1>
    <ul>
        <li><a href="#"><img src="images/CHANEL.jpg" alt=""></a></li>
        <li><a href="#"><img src="images/GUCCI.jpg" alt=""></a></li>
        <li><a href="#"><img src="images/LV.jpg" alt=""></a></li>
        <li><a href="#"><img src="images/CELINE.jpg" alt=""></a></li>
        <li><a href="#"><img src="images/Cartier.jpg" alt=""></a></li>
        <li><a href="#"><img src="images/Dior.jpg" alt=""></a></li>
        <li><a href="#"><img src="images/Salvatore.jpg" alt=""></a></li>
    </ul>
</div>
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
</body>
</html>