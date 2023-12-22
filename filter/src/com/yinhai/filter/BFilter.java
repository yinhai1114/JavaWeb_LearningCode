package com.yinhai.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebFilter(filterName = "BFilter",urlPatterns = "/admin/*")
public class BFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("BFilter---> 线程id=" +
                Thread.currentThread().getId());

        System.out.println("BFilter doFilter 的前置代码...");

        System.out.println("执行 BFilter doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("BFilter doFilter 的后置代码...");
    }

    @Override
    public void destroy() {

    }
}