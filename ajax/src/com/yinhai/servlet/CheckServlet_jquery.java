package com.yinhai.servlet;

import com.google.gson.Gson;
import com.yinhai.bean.User;
import com.yinhai.service.UserService;

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
@WebServlet(name = "CheckServlet_jquery",urlPatterns = "/checkServletJq")
public class CheckServlet_jquery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("be invoked.....");
        String username = request.getParameter("username");
        System.out.println("ajax Jquery =" + username);
        Gson gson = new Gson();
        //验证业务接入到DB
        // User dbusername = new UserService().getUserByName("king");

        response.setContentType("text/json;charset=utf-8");
        //接受jquery发送的ajax数据
        if ("king".equals(username)) {

            User user = new User(100, "king", "abc", "king@sohu.com");
            response.getWriter().write(gson.toJson(user));

            // response.getWriter().write(gson.toJson(dbusername));

        } else {
            //返回一个不存在的User=> 这里老师是有设计
            User user = new User(-1, "", "", "");
            response.getWriter().write(gson.toJson(user));
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
