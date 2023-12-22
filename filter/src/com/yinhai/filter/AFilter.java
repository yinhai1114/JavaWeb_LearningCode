package com.yinhai.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebFilter(filterName = "AFilter",urlPatterns = "/admin/*")
public class AFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("AFilter---> 线程id=" +
                Thread.currentThread().getId());

        System.out.println("AFilter doFilter 的前置代码...");
        System.out.println("执行 AFilter doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("AFilter doFilter 的后置代码...");
    }

    @Override
    public void destroy() {

    }
}

