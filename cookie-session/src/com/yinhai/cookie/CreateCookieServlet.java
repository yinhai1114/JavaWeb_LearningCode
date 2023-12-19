package com.yinhai.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebServlet(name = "CreateCookieServlet",urlPatterns = "/createCookie")
public class CreateCookieServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("be invoke...");
        //1. 创建一个Cookie对象
        //1) username 该cookie的名字 是唯一, 可以理解成是key
        //2) hsp : 该cookie的值
        //3) 可以创建多个cookie，老师就创建了一个
        //4) 这是cookie在服务器端, 还没有到浏览器
        Cookie cookie = new Cookie("username", "yinhai");
        Cookie cookie2 = new Cookie("email", "yinhai@qq.com");

        response.setContentType("text/html;charset=utf-8");
        //2. 将cookie发送给浏览器, 让浏览器将该cookie保存
        response.addCookie(cookie);
        response.addCookie(cookie2);

        PrintWriter writer = response.getWriter();
        writer.println("<h1>创建cookie成功~</h1>");
        writer.flush();
        writer.close();


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
