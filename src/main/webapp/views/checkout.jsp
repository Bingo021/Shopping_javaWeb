<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单支付</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
        }

        .payment-container {
            max-width: 800px;
            margin: 20px auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        select, input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        .qr-code {
            text-align: center;
            margin-top: 20px;
            width: 200px;
            height: 200px;
            border: 1px solid #ccc;
            overflow: hidden;
        }

        img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        footer {
            text-align: center;
            padding: 10px;
            background-color: #333;
            color: white;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<header>
    <h1>订单支付</h1>
</header>

<div class="payment-container">
    <label for="payment-method">选择支付方式：</label>
    <select id="payment-method" name="payment-method" onchange="showQRCode()">
        <option value="alipay">支付宝</option>
        <option value="wechat">微信支付</option>
    </select>

    <label for="amount">支付金额：</label>
    <input type="text" id="amount" name="amount" placeholder="支付金额">

    <div class="qr-code" id="qr-code">
        <!-- 这里将根据选择的支付方式显示对应的收款二维码 -->
    </div>

    <button onclick="scanCode()">扫码支付</button>
</div>

<footer>
    <p>&copy; 2024 网上购物系统</p>
</footer>

<script>
    function showQRCode() {
        var paymentMethod = document.getElementById("payment-method").value;
        var qrCodeContainer = document.getElementById("qr-code");

        // 清空容器内容
        qrCodeContainer.innerHTML = "";

        // 创建 img 元素
        var qrCodeImg = document.createElement("img");
        qrCodeImg.src = "../images/" + paymentMethod + ".jpg";
        qrCodeImg.alt = paymentMethod + "支付二维码";

        // 将 img 元素添加到容器中
        qrCodeContainer.appendChild(qrCodeImg);
    }

    function scanCode() {
        // 这里可以添加扫码支付的逻辑，例如调用相应的扫码支付库
        alert('调用扫码支付');
    }

    // 初始化时显示默认的二维码
    showQRCode();
</script>

</body>
</html>
