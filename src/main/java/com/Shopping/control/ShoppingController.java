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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Shopping")
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
        System.out.println("action="+action);

        if ("register".equals(action)) {
            registerUser(request, response);
        } else if ("login".equals(action)) {
            loginUser(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Doget action="+action );
        if ("viewProductDetails".equals(action)) {
            viewProductDetails(request, response);
        } else if ("viewCart".equals(action)) {
            viewCart(request, response);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));

        User user = userService.getUserByUsername(username);

        if (user != null && user.getRole() == role && (password.equals(user.getPassword()))) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (role == 0) {
                // 普通用户登录
                response.sendRedirect("index.jsp");
            } else if (role == 1) {
                // 管理员登录
                System.out.println("验证管理员");
                response.sendRedirect( "views/admin.jsp");
            }
        }
        else
        {
            System.out.println("用户名密码无效");
            request.setAttribute("loginError", "用户名或密码无效");
            response.sendRedirect("views/login.jsp");
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        userService.createUser(username, password, email);

        response.sendRedirect("views/login.jsp");
    }

    private void viewProductDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));

        Product product = productService.getProductDetails(productId);

        request.setAttribute("product", product);

        request.getRequestDispatcher("views/product.jsp").forward(request, response);
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Cart> cart = null;
        try {
            cart = cartService.getCart(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("cartList", cart);
        request.getRequestDispatcher("views/cart.jsp").forward(request, response);
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