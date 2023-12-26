package control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 在这里进行用户验证逻辑，例如从数据库中查询用户信息并进行比较
        // 如果验证通过，则将用户信息存储到HttpSession中，并重定向到目标页面
        // 如果验证失败，则返回错误信息给用户

        HttpSession session = request.getSession();
        if (username != null && password != null) {
            // 假设验证通过，将用户信息存储到HttpSession中
            session.setAttribute("username", username);
            response.sendRedirect("target_page.jsp"); // 重定向到目标页面
        } else {
            // 验证失败，返回错误信息给用户
            request.setAttribute("errorMessage", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response); // 转发到登录页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求，例如重定向到登录页面
        response.sendRedirect("login.jsp"); // 重定向到登录页面
    }
}