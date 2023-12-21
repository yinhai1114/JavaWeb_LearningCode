package com.yinhai;

import javax.servlet.ServletContext;
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
 */
@WebServlet(name = "HiServlet",urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //给servletContext 对象操作属性
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("name", "你好！！！！！！！！");
        servletContext.setAttribute("name", "你好1");
        servletContext.setAttribute("name", "你好2");
        servletContext.setAttribute("name", "你好3");
        servletContext.setAttribute("name", "你好4");
        servletContext.setAttribute("name", "你好5");
        servletContext.setAttribute("name", "你好6");
        servletContext.setAttribute("name", "你好7");
        servletContext.setAttribute("name", "你好8");
        servletContext.setAttribute("name", "你好9");
        servletContext.removeAttribute("name");

        //获取session对象
        //Filter

        HttpSession session = request.getSession();
        session.setAttribute("age", 100);
        session.setAttribute("age", 400);
        session.removeAttribute("age");

        System.out.println("HiServlet 处理完毕....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
