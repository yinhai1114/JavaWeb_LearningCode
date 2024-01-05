package com.yinhai.furns.web;

import com.yinhai.furns.javabean.Member;
import com.yinhai.furns.service.MemberService;
import com.yinhai.furns.service.impl.MemberServiceImpl;
import com.yinhai.furns.utils.JDBCUtilsByDruid;

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
@WebServlet(name = "RegisterServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        String email = request.getParameter("user-email");
        if(!memberService.isExistsUsername(username)){
            System.out.println(username + "用户可用" + password + email);
            Member member = new Member(null,username,password,email);
            if (memberService.registerMember(member)) {
                request.getRequestDispatcher("/views/member/register_ok.jsp").forward(request,response);
                JDBCUtilsByDruid.commit();
            }else {
                request.getRequestDispatcher("/views/member/register_fail.jsp").forward(request,response);
            }
        }else{
            System.out.println("用户存在 重新登录");
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
