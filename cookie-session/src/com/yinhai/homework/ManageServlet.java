package com.yinhai.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebServlet(name = "ManageServlet",urlPatterns = "/manageServlet")
public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断该用户/会话是否登录过
        HttpSession session = request.getSession();
        Object loginuser = session.getAttribute("loginuser");
        if(loginuser == null){//说明该用户没有登录
            //重新登录  请求重定向
            String contextPath = request.getContextPath();
            System.out.println("有个未经允许的访问");
            response.sendRedirect(contextPath + "/userlogin.html");
            return;
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>用户管理页面</h1>");
        writer.println("welcome admin!!!");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
