package com.Shopping.control;

import com.Shopping.model.*;
import com.Shopping.service.*;
import com.Shopping.service.Impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/ShoppingController")
public class ShoppingController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final CartService cartService = new CartServiceImpl();
    private final DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
    private final PaymentRecordService paymentRecordService = new PaymentRecordServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            registerUser(request, response);
        } else if ("login".equals(action)) {
            loginUser(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("viewProductDetails".equals(action)) {
            viewProductDetails(request, response);
        } else if ("viewCart".equals(action)) {
            viewCart(request, response);
        } else if ("viewOrderDetails".equals(action)) {
            viewOrderDetails(request, response);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.getUserByUsername(username);

        int role = 0;
        if (user != null && user.getRole() == role && userService.checkPassword(password, user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (role == 0) {
                // 普通用户登录
                response.sendRedirect("/index.jsp");
            } else if (role == 1) {
                // 管理员登录
                response.sendRedirect("/admin.jsp");
            }
        } else {
            request.setAttribute("loginError", "用户名或密码无效");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取注册信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // 调用UserService注册用户
        userService.createUser(username, password, email);

        // 重定向到登录页面
        response.sendRedirect("/login");
    }

    private void viewProductDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取商品ID
        int productId = Integer.parseInt(request.getParameter("productId"));

        // 调用ProductService获取商品详情
        Product product = productService.getProductDetails(productId);

        // 将商品详情放入request中
        request.setAttribute("product", product);

        // 转发到商品详情页面
        request.getRequestDispatcher("/product_details.jsp").forward(request, response);
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户ID
        int userId = Integer.parseInt(request.getParameter("userId"));

        // 调用CartService获取购物车信息
        Cart cart = cartService.getCart(userId);

        // 将购物车信息放入request中
        request.setAttribute("cart", cart);

        // 转发到购物车页面
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    private void placeOrderFromCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户ID、购物车ID、收货地址ID、支付方式等信息
        int userId = Integer.parseInt(request.getParameter("userId"));
        int cartId = Integer.parseInt(request.getParameter("cartId"));
        int deliveryAddressId = Integer.parseInt(request.getParameter("deliveryAddressId"));
        String paymentMethod = request.getParameter("paymentMethod");

        // 调用OrderService处理从购物车下单的逻辑
        List<DeliveryAddress> deliveryAddress = deliveryAddressService.getDeliveryAddressesByUserId(userId);
        Order order = orderService.placeOrderFromCart(userId, cartId);

        // 重定向到订单详情页面
        response.sendRedirect("/order/" + order.getOrderID());
    }

    private void placeOrderFromProductPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户ID、商品ID、数量、收货地址ID、支付方式等信息
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int deliveryAddressId = Integer.parseInt(request.getParameter("deliveryAddressId"));
        String paymentMethod = request.getParameter("paymentMethod");

        // 调用OrderService处理从商品页面直接下单的逻辑
        List<DeliveryAddress> deliveryAddress = deliveryAddressService.getDeliveryAddressesByUserId(userId);
        Order order = orderService.placeOrderFromProductPage(userId, productId, quantity);

        // 重定向到订单详情页面
        response.sendRedirect("/order/" + order.getOrderID());
    }

    private void viewOrderDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取订单ID
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        // 调用OrderService获取订单详情
        Order order = orderService.getOrderById(orderId);

        // 将订单详情放入request中
        request.setAttribute("order", order);

        // 转发到订单详情页面
        request.getRequestDispatcher("/order_details.jsp").forward(request, response);
    }

    private void confirmReceipt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取订单ID
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        // 调用OrderService确认收货
        orderService.confirmReceipt(orderId);

        // 重定向到订单详情页面
        response.sendRedirect("/order/" + orderId);
    }

    private void cancelOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取订单ID
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        // 调用OrderService取消订单
        orderService.cancelOrder(orderId);

        // 重定向到订单详情页面
        response.sendRedirect("/order/" + orderId);
    }

    private void processPayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取订单ID、支付方式、支付金额等信息
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String paymentMethod = request.getParameter("paymentMethod");
        BigDecimal paymentAmount = new BigDecimal(request.getParameter("paymentAmount"));

        // 调用PaymentRecordService处理支付请求
        PaymentRecord paymentRecord = paymentRecordService.processPayment(orderId, paymentMethod, paymentAmount);

        // 重定向到支付记录详情页面
        response.sendRedirect("/paymentRecord/" + paymentRecord.getPaymentRecordID());
    }
}