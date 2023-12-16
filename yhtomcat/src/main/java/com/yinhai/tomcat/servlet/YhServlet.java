package com.yinhai.tomcat.servlet;

import com.yinhai.tomcat.http.YhRequest;
import com.yinhai.tomcat.http.YhResponse;

import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public interface YhServlet {
    void init() throws Exception;

    void service(YhRequest request, YhResponse response) throws IOException;

    void destroy();
}
