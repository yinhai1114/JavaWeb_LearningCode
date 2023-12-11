package com.yinhai.servlet.servletcontext_;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = getServletContext();
        System.out.println("OrderServletContext=" + servletContext
                + "运行类型" +servletContext.getClass());
        //从servletContext获取visit_count属性k-v
        Object visit_count = servletContext.getAttribute("visit_count");
        if(visit_count == null){
            //说明是第一次访问网站
            servletContext.setAttribute("visit_count" , 1);
            visit_count = 1;
        }else{
           //说明是第二次以后
           visit_count = Integer.parseInt(visit_count + "") + 1;
           servletContext.setAttribute("visit_count" , visit_count);
        }
        //输出显示
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>该网站被访问的次数是 "+ visit_count + "</h1>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
