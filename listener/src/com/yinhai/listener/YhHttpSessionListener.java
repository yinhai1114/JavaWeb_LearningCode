package com.yinhai.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebListener()
public class YhHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        //当session创建时，我们给它设置一个生命周期 30s
        session.setMaxInactiveInterval(30);
        System.out.println("YhHttpSessionListener 监听到 session创建= " +
                session.getId());
        System.out.println("用户id=" + session.getId() + " 上线");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        System.out.println("YhHttpSessionListener 监听到 session销毁= " +
                session.getId());
        System.out.println("用户id=" + session.getId() + " 离线");
    }
}
