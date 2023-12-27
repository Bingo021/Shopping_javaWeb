package control;

import dao.Impl.*;
import model.Cart;
import model.Product;
import model.User;
import service.*;
import service.Impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/shopping-cart")
public class ShoppingCartController extends HttpServlet {
    private final UserService userService;
    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final DeliveryAddressService deliveryAddressService;
    private final PaymentRecordService paymentRecordService;

    public ShoppingCartController() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
        this.productService = new ProductServiceImpl(new ProductDaoImpl());
        this.cartService = new CartServiceImpl(new CartDaoImpl());
        this.orderService = new OrderServiceImpl(new OrderDaoImpl());
        this.orderDetailService = new OrderDetailServiceImpl(new OrderDetailDaoImpl());
        this.deliveryAddressService = new DeliveryAddressServiceImpl(new DeliveryAddressDaoImpl());
        this.paymentRecordService = new PaymentRecordServiceImpl(new PaymentRecordDaoImpl());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "register":
                registerUser(request, response);
                break;
            case "login":
                loginUser(request, response);
                break;
            // 添加其他操作的 case
            default:
                response.getWriter().println("Invalid action");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "getAllProducts":
                getAllProducts(request, response);
                break;
            case "getUserCart":
                getUserCart(request, response);
                break;
            // 添加其他操作的 case
            default:
                response.getWriter().println("Invalid action");
        }
    }

    // 注册用户
    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(username, password, email);
        userService.addUser(user);

        response.getWriter().println("User registered successfully");
    }

    // 用户登录
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            response.getWriter().println("Login successful");
        } else {
            response.getWriter().println("Invalid username or password");
        }
    }

    // 获取所有商品
    private void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Product> products = productService.getAllProducts();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(products);
    }

    // 获取用户购物车
    private void getUserCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        try {
            List<Cart> userCart = cartService.getUserCart(userId);

            // 将购物车信息返回给前端，可以使用 JSON 格式
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(userCart);
        } catch (SQLException e) {
            response.getWriter().println("Failed to retrieve user cart");
        }
    }

    // 添加其他控制器方法...

}

