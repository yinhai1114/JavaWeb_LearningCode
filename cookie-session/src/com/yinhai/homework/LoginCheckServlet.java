package com.yinhai.homework;

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
@WebServlet(name = "LoginCheckServlet",urlPatterns = "/loginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        if ("666666".equals(pwd)){
            //登录成功 将session存入
            HttpSession session = request.getSession();
            session.setAttribute("loginuser",username);

            //请求转发到ManageServlet
            request.getRequestDispatcher("/manageServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
