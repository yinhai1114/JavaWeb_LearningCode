package com.yinhai.servlet.response.homework;

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
public class WebUtils {

    public static int parseString(String str) {
        int num = 0;
        try {
            num = Integer.parseInt(str);//
        } catch (NumberFormatException e) {
            //这个异常不会throw 给 tomcat
            System.out.println("输入的str格式不正确...");
        }

        return num;
    }
}

