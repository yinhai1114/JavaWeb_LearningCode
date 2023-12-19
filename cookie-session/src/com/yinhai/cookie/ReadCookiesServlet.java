package com.yinhai.cookie;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 * 读取浏览器cookie信息
 */
@WebServlet(name = "ReadCookiesServlet", urlPatterns = "/readCookies")
public class ReadCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("be invoke readCookiesServlet");
        //1. 通过request对象读取cookie信息
        Cookie[] cookies = request.getCookies();
        //2. 遍历cookie
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                System.out.println("cookie name= " + cookie.getName()
                        + " value= " + cookie.getValue());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);
    }
}
