package com.yinhai.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebFilter(filterName = "YhFilterConfig",urlPatterns = "/abc/*",initParams = {
        @WebInitParam(name = "ip",value = "127.0"),
        @WebInitParam(name = "port",value = "8888")
})
public class YhFilterConfig implements Filter {
    private String ip; //从配置获取的ip

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("YhFilterConfig init() 被调用..");
        //通过filterConfig 获取相关的参数
        String filterName = filterConfig.getFilterName();
        ip = filterConfig.getInitParameter("ip");
        ServletContext servletContext = filterConfig.getServletContext();
        //可以获取到该filter所有的配置参数名
        Enumeration<String> initParameterNames =
                filterConfig.getInitParameterNames();

        //遍历枚举
        while (initParameterNames.hasMoreElements()) {
            System.out.println("名字=" + initParameterNames.nextElement());
        }

        System.out.println("filterName= " + filterName);
        System.out.println("ip= " + ip);
        System.out.println("servletContext= " + servletContext);


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //通过forbidden ip 来进行控制
        //先获取到访问ip
        String remoteAddr = servletRequest.getRemoteAddr();//获得访问客户端的IP
        String localAddr = servletRequest.getLocalAddr();//获得本机IP
        System.out.println(localAddr);
        System.out.println(remoteAddr);
        if(remoteAddr.contains(ip)) {
            System.out.println("封杀该网段..");
            servletRequest.getRequestDispatcher("/login.jsp").
                    forward(servletRequest,servletResponse);
            return; //直接返回
        }

        //继续访问目标资源
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

