package com.yinhai.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebFilter(filterName = "TopicFilter",urlPatterns = "/homework/*",initParams = {
        @WebInitParam(name = "forbiddenword",value = "apple,hello,hi")
})
public class TopicFilter implements Filter {

    //属性-> 存放禁用词
    private String[] forbiddenWords = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取禁用词
        String forbiddenword = filterConfig.getInitParameter("forbiddenword");
        forbiddenWords = forbiddenword.split(",");
        for (String forbiddenWord : forbiddenWords) {
            System.out.println("禁用词 = " + forbiddenWord);
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //解决从topic.jsp 提交的中文乱码问题
        servletRequest.setCharacterEncoding("utf-8");

        //判断评论是不是有禁用词
        String content = servletRequest.getParameter("content");
        //循环遍历一把，看看有没有禁用词
        for (String forbiddenWord : forbiddenWords) {//java基础
            if (content.contains(forbiddenWord)) {
                //返回topic.jsp
                servletRequest.setAttribute("errorInfo", "你输入的有禁用词");
                servletRequest.getRequestDispatcher("/topic.jsp")
                        .forward(servletRequest, servletResponse);
                return;//返回
            }
        }

        //继续到目标
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
