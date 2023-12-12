package com.yinhai.servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebServlet(name = "Homework01",urlPatterns = "/homeworkServlet")
public class HomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("homeworkServlet be invoked...");
        /***********************************
         *  获取和请求参数相关信息, 注意要求在返回数据前，获取参数
         ***********************************/

        //解决接收参数的中文乱码问题,写在 getParameter前.
        request.setCharacterEncoding("utf-8");
        //1. 获取表单的数据[单个数据]
        //username=1&pwd1=&pwd2=&sport=zq&sport=sq&gender=male&city=cd&myfile=
        String username = request.getParameter("username");
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String myfile = request.getParameter("myfile");
        //2. 获取表单一组数据
        System.out.println("username= " + username);
        System.out.println("pwd1= " + pwd1);
        System.out.println("pwd2= " + pwd2);
        System.out.println("gender= " + gender);
        System.out.println("city= " + city);
        //增强for循环的快捷键 iter->回车即可
        String[] sport = request.getParameterValues("sport");
        System.out.print("sport = ");
        for (String s : sport) {
            System.out.print(s);
        }
        System.out.println();
        //获取电脑操作系统
        String header = request.getHeader("User-Agent");
        String regStr = "\\((.+)\\)";//分组
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(header);
        matcher.find();
        String group = matcher.group(1);
        String[] split = group.split(";");
        String system = split[0];
        String bit = split[1];


        //返回接收到的信息， 给浏览器回显
        //本质就是在http响应头，加上 Content-Type: text/html;charset=utf-8
        //说 text/html 表示返回的数据类型，浏览器会根据这个类型来解析数据
        // text/plain 表示返回的数据，请浏览器使用文本方式解析
        // application/x-tar 表示返回的是文件，浏览器就会以下载文件的方式处理
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>提交的用户名= " + username + "</h1>");
        writer.print("<h1>操作系统= " + system + "</h1>");
        writer.print("<h1>操作系统= " + bit + "</h1>");
        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
