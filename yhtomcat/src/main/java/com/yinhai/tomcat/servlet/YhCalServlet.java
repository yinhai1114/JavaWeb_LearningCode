package com.yinhai.tomcat.servlet;

import com.yinhai.tomcat.http.YhRequest;
import com.yinhai.tomcat.http.YhResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class YhCalServlet extends YhHttpServlet {
    @Override
    public void doGet(YhRequest request, YhResponse response) throws IOException {
        doPost(request,response);
    }

    @Override
    public void doPost(YhRequest request, YhResponse response) throws IOException {
        String strnum1 = request.getParameter("num1");
        String strnum2 = request.getParameter("num2");
        int num1 = 0;
        int num2 = 0;
        int sum = -1;
        try {
            num1 = Integer.parseInt(strnum1);
            num2 = Integer.parseInt(strnum2);
            sum = num1 + num2;
            System.out.println("res = " + sum);

        } catch (NumberFormatException e) {
            System.out.println("form wrong , continue");
        }
        // response.setContentType("text/html;charset=utf-8"); response内已经做了
        OutputStream outputStream = response.getOutputStream();
        if (!(sum == -1)) {
            outputStream.write((YhResponse.respHeader + "<h1> res = " + sum + "</h1>").getBytes());

        }else{
            outputStream.write((YhResponse.respHeader + "<h1> wrong date please try again!!  </h1>").getBytes());
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }
}
