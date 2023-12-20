package com.yinhai.session;

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
 * 设置生命周期
 */
@WebServlet(name = "CreateSession2Servlet",urlPatterns = "/createSession2")
public class CreateSession2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreateSession2 被调用");
        //创建session
        HttpSession session = request.getSession();
        System.out.println("CreateSession2 sid= " + session.getId());
        //设置生命周期为 60s
        session.setMaxInactiveInterval(60);
        session.setAttribute("u", "jack");

        //回复一下浏览器
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>创建session成功, 设置生命周期60s</h1>");
        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
