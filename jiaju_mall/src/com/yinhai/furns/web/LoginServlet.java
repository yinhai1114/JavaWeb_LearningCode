package com.yinhai.furns.web;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.yinhai.furns.javabean.Member;
import com.yinhai.furns.service.MemberService;
import com.yinhai.furns.service.impl.MemberServiceImpl;

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
@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        if (!memberService.isExistsUsername(username)){
            System.out.println("用户不存在");
            request.setAttribute("msg","用户不存在");
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
            return;
        }
        if(memberService.login(new Member(null,username,password,null)) == null){
            System.out.println("密码错误 重新登录");
            request.setAttribute("msg","密码错误 重新登录");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
            return;
        }
        System.out.println("登录成功");
        request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
