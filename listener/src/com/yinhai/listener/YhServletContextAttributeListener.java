package com.yinhai.listener; /**
 * @author 银小海
 * @email yinhai14@qq.com
 * @version 1.0
 */

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class YhServletContextAttributeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("HspServletContextAttributeListener 监听到添加属性.."
                + servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue() );
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("HspServletContextAttributeListener 监听到删除属性.."
                + servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue() );
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("HspServletContextAttributeListener 监听到修改属性.."
                + servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue() );

    }
}
