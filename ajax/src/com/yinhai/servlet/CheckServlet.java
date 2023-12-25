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
@WebServlet(name = "CheckServlet",urlPatterns = "/checkServlet")
public class CheckServlet extends HttpServlet {

    //定义一个UserService属性
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("CheckUserServlet 被调用....");

        //接收ajax提交的数据
        String uname = request.getParameter("uname");
        System.out.println("uname= " + uname);


        response.setContentType("text/html;charset=utf-8");
        // 到DB查询
        // 如果有就返回user对象，否则，返回的是null
        User user = userService.getUserByName(uname);
        System.out.println(user);
        // String user = "";
        if (user != null) {//说明用户名存在..,返回该user的json格式数据字符串
            Gson gson = new Gson();
            String strUser = gson.toJson(user);
            System.out.println(strUser);
            response.getWriter().write(strUser);

        } else {
            response.getWriter().write("");
        }



        // // 假定用户名为 king , 就不可用, 其它用户名可以
        // if("king".equals(uname)) {//不能使用king用户名
        //    //后面这个信息，是从DB获取
        //    User king = new User(100, "king", "666", "king@sohu.com");
        //    //把 king 转成 json字符串
        //    String strKing = new Gson().toJson(king);
        //    //返回
        //    response.getWriter().write(strKing);
        // } else {
        //    //如果用户名可以用，返回""
        //    response.getWriter().write("");
        //
        // }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
