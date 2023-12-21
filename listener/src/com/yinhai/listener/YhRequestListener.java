package com.yinhai.listener;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebListener
public class YhRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("YhRequestListener 监听到 request对象创建");
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("记录访问日志....");
        System.out.println("访问IP= " + servletRequest.getRemoteAddr());
        System.out.println("访问的资源= " + ((HttpServletRequest)servletRequest).getRequestURL());
    }
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("YhRequestListener 监听到 request对象被销毁");
    }
}
