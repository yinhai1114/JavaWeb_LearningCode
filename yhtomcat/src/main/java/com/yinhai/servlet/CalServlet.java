package com.yinhai.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "CalServlet",urlPatterns = "/calServlet")
public class CalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strnum1 = request.getParameter("num1");
        String strnum2 = request.getParameter("num2");
        int num1 = 0;
        int num2 = 0;
        int sum = -1;
        try {
            num1 = Integer.parseInt(strnum1);
            num2 = Integer.parseInt(strnum2);
            System.out.println("res = " + num1 + num2);
            sum = num1 + num2;
        } catch (NumberFormatException e) {
            System.out.println("form wrong , continue");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (!(sum == -1)) {
            writer.print("<h1> res = " + sum + "</h1>");

        }else{
            writer.print("<h1> wrong date please try again!!  </h1>");
        }
        writer.flush();
        writer.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
