package com.yinhai.tomcat.servlet;

import com.yinhai.tomcat.http.YhRequest;
import com.yinhai.tomcat.http.YhResponse;

import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public abstract class YhHttpServlet implements YhServlet {
    @Override
    public void service(YhRequest request, YhResponse response) throws IOException {
        //老师说明 equalsIgnoreCase 比较字符串内容是相同，不区别大小写
        if("GET".equalsIgnoreCase(request.getMethod())) {
            //这里会有动态绑定
            this.doGet(request,response);
        } else if("POST".equalsIgnoreCase(request.getMethod())) {
            this.doPost(request,response);
        }
    }

    //这里我们使用的了模板设计模式 => java 基础的 抽象类专门讲过模板设计模式
    //让HspHttpServlet 子类 HspCalServlet 实现

    public abstract void doGet(YhRequest request, YhResponse response) throws IOException;
    public abstract void doPost(YhRequest request, YhResponse response) throws IOException;
}
