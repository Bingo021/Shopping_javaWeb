package control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // 在这里，你应该调用服务层的方法来验证用户名是否已存在，以及密码是否匹配，我这里简单演示，直接返回true或false。
        boolean isValidUser = true; // 你可以根据实际情况调整。
        if (isValidUser) {
            // 在这里，你应该调用服务层的方法来创建新用户。
            HttpSession session = request.getSession();
            session.setAttribute("username", username); // 将用户名存储在session中，以便在后续的请求中使用。
            response.sendRedirect("home.jsp"); // 注册成功后重定向到主页。
        } else {
            out.println("用户名已存在或密码不匹配！"); // 打印错误消息。
            response.sendRedirect("register.jsp"); // 注册失败后重定向回注册页面。
        }
    }
}