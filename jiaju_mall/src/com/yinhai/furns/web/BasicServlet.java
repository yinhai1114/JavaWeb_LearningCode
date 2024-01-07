package com.yinhai.furns.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public abstract class BasicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决接收到的数据中文乱码问题
        request.setCharacterEncoding("utf-8");

        //System.out.println("BasicServlet doPost()");
        //获取到action的值
        //老韩提示：如果我们使用了模板模式+反射+动态绑定，要满足action的value 和 方法名一致!!!
        String action = request.getParameter("action");
        //System.out.println("action=" + action);

        //使用反射,获取当前对象的方法
        //老韩解读
        //1.this 就是请求的Servlet
        //2.declaredMethod 方法对象就是当前请求的servlet对应的"action名字" 的方法, 该方法对象(declaredMethod)
        //  是变化的,根据用户请求
        //3.使用模板模式+反射+动态机制===> 简化多个 if--else if---..
        try {
            Method declaredMethod =
                    this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            System.out.println("declaredMethod=" + declaredMethod);
            //使用方法对象，进行反射调用
            declaredMethod.invoke(this, request, response);

        } catch (Exception e) {
            //java基础->异常机制
            //将发生的异常,继续throw
            //老师心得体会: 异常机制是可以参与业务逻辑
            throw new RuntimeException(e);

        }

    }

}
