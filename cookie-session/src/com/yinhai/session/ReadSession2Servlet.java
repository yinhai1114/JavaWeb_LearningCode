package com.yinhai.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 * 读取session的属性的生命周期
 */
@WebServlet(name = "ReadSession2Servlet")
public class ReadSession2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("ReadSession2 被调用...");

        //1. 获取到session
        HttpSession session = request.getSession();
        System.out.println("ReadSession2 sid= " + session.getId());
        //2. 读取session的属性
        Object u = session.getAttribute("u");
        if (u != null) {
            System.out.println("读取到session属性 u= " + (String) u);
        } else {
            System.out.println("读取不到session属性 u 说明原来的session被销毁");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
