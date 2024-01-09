package com.yinhai.furns.web;

import com.yinhai.furns.javabean.Admin;
import com.yinhai.furns.service.AdminService;
import com.yinhai.furns.service.impl.AdminServiceImpl;

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
@WebServlet(name = "AdminServlet",urlPatterns = "/adminServlet")
public class AdminServlet extends BasicServlet {
    private AdminService adminService = new AdminServiceImpl();
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin(null, username, password);

        if(adminService.login(admin) == null){
            System.out.println("管理员不存在");
            request.getRequestDispatcher("/views/manage/manage_login.jsp").forward(request,response);
            return;
        }
        request.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(request,response);

    }
}
