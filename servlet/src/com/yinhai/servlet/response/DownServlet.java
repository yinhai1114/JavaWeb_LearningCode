package com.yinhai.servlet.response;

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
@WebServlet(name = "DownServlet",urlPatterns = "/downServlet")
public class DownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // System.out.println("DownServlet 被调用");
        // response.setContentType("application/x-tar;charset=utf-8");
        // PrintWriter writer = response.getWriter();
        // writer.print("hi");
        // writer.flush();
        // writer.close();

        //完成了自己业务
        //发出请求重定向-> DownServletNew
        //1. sendRedirect 本质就会 返回 302 状态码 Location: /servlet/downServletNew
        //2. 因此 302和 /servlet/downServletNew 是浏览器解析，而不是服务器
        //3. 浏览器在解析 /servlet/downServletNew => http://localhost:8080/servlet/downServletNew
        //4. 动态获取到application context
        String contextPath = getServletContext().getContextPath();
        System.out.println("contextPath= " + contextPath);
        //response.sendRedirect("/servlet/downServletNew");
        response.sendRedirect(contextPath + "/downServletNew");
        //response.sendRedirect("http://www.baidu.com");

        //第二种重定向的写法
        // System.out.println("第二种方式重定向...");
        // response.setStatus(302); //设置http响应的状态码
        // //设置http响应的 Location: /servlet/downServletNew
        // response.setHeader("Location", "/servlet/downServletNew");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

