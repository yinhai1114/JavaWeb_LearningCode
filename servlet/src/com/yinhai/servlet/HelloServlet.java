package com.yinhai.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class HelloServlet implements Servlet {
    private int count = 0;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /*
         1.初始化servlet
         2.当创建HelloServlet实例时，会调用init方法
         3.该方法只会被调用1次
        */
    }

    /*
        返回ServletConfig也就是返回Servlet的配置
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*  1. service 方法处理浏览器的请求(包括get/post)
        2. 当浏览 器每次请求Servlet时，就会调用一次service
        3. 当tomcat调用该方法时，会把http请求的数据封装成实现ServletRequest接口的request对象
        4. 通过servletRequest 对象，可以得到用户提交的数据
        5. servletResponse 对象可以用于返回数据给tomcat->浏览器
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("hello world by servlet" + (++count));

        //思考->从servletRequest对象来获取请求方式->
        //1. ServletRequest 没有得到提交方式的方法
        //2. ServletRequest 看看ServletRequest子接口有没有相关方法
        //3. 老师小技巧：ctrl+alt+b => 可以看到接口的子接口和实现子类
        //4. 把servletReqeust转成 HttpServletRequest引用
        //5. 仍然是Java基础的OOP
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if("GET".equals(method)) {
            doGet(); //用doGet() 处理GET请求
        }
        else if("POST".equals(method)) {
            doPost(); //用doPost() 处理POST请求
        }

    }

    /*
     * 用于响应get请求的
     */
    public void doGet() {
        System.out.println("doGet() 被调用..");
    }

    /*
     * 用于响应post请求的
     */
    public void doPost() {
        System.out.println("doPost() 被调用..");
    }

    /*
        返回servlet信息，使用较少
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /*
       1. 该方法是在servlet销毁时，被调用
       2. 只会调用一次
     */
    @Override
    public void destroy() {

    }
}
