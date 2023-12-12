package com.yinhai.servlet.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebServlet(name = "CheckServlet",urlPatterns = "/checkServlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("checkServlet be invoked...");
        //根据用户名来确定该用户是什么身份
        String username = request.getParameter("username");
        //注意：如果是同一个request对象(请求转发)，那么可以在不同的servlet中，使用getParameter
        if ("tom".equals(username)) {
            //分配
            request.setAttribute("role", "管理员");
        } else {
            request.setAttribute("role", "普通用户");
        }

        //获取分发器
        //        1. /manageServlet写的是 要转发的servlet的url
        //        2. 会被解析成http://localhost:8080/servlet/manageServlet
        //        3. forward(request, response) 表示把当前servlet的request对象和response对象，传递给下一个servlet使用

        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/manageServlet");

        requestDispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
