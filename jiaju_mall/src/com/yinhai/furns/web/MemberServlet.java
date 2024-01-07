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
@WebServlet(name = "MemberServlet", urlPatterns = "/memberServlet")
public class MemberServlet extends BasicServlet {
    private MemberService memberService = new MemberServiceImpl();

    /**
     * 处理会员的注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("======MemberServlet register()========");
        //接收用户注册信息-> 一定要去看前端页面字段..
        //用户名
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        String email = request.getParameter("user-email");
        //获取用户提交验证码
        String code = request.getParameter("code");
        //从session中获取到验证码
        // String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //立即删除session验证码->防止该验证码被重复使用
        // request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //如果token为空，并且和用户提交的验证码一致,就继续
        // if (token != null && token.equalsIgnoreCase(code)) {
            //判断这个用户名是不是可用
            if (!memberService.isExistsUsername(username)) {
                //注册
                //System.out.println("用户名 " + username + " 不存在, 可以注册");
                //构建一个Member对象
                Member member = new Member(null, username, password, email);
                if (memberService.registerMember(member)) {
                    //请求转发
                    request.getRequestDispatcher("/views/member/register_ok.jsp")
                            .forward(request, response);
                } else {
                    //请求转发
                    request.getRequestDispatcher("/views/member/register_fail.jsp")
                            .forward(request, response);
                }

            } else {
                //返回注册页面
                //后面可以加入提示信息...
                request.getRequestDispatcher("/views/member/login.jsp")
                        .forward(request, response);
            }
        // } else { //验证码不正确
        //     request.setAttribute("msg", "验证码不正确~");
        //     //如果前端需要回显某些数据
        //     request.setAttribute("username", username);
        //     request.setAttribute("email", email);
        //     //带回一个信息 要显示到注册选项页
        //     request.setAttribute("active", "register");
        //     request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        // }

    }

    /**
     * 处理会员登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("======MemberServlet login()========");
        //System.out.println("LoginServlet 被调用..");
        //老韩说明:如果在登录页面, 用户没有输入内容，就直接提交，后台接收到的是""
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        Member member = memberService.login(new Member(null, username, password, null));
        if (member == null) { //用户没有在DB
            //System.out.println(member + " 登录失败...");
            //把登录错误信息,放入到request域 => 如果忘了，可以看servlet / jsp
            request.setAttribute("msg", "用户名或者密码错误");
            request.setAttribute("username", username);
            //页面转发
            request.getRequestDispatcher("/views/member/login.jsp")
                    .forward(request, response);
        } else { //用户在DB
            //System.out.println(member + " 登录成功~...");

            //将得到member对象放入到session
            request.getSession().setAttribute("member", member);
            //老师做了一个简单处理
            if ("admin".equals(member.getUsername())) {
                request.getRequestDispatcher("/views/manage/manage_menu.jsp")
                        .forward(request, response);
            } else {
                request.getRequestDispatcher("/views/member/login_ok.jsp")
                        .forward(request, response);
            }
        }

    }
}
