package com.yinhai.furns.web;

import com.yinhai.furns.javabean.Furn;
import com.yinhai.furns.javabean.Page;
import com.yinhai.furns.service.FurnService;
import com.yinhai.furns.service.impl.FurnServiceImpl;
import com.yinhai.furns.utils.DataUtils;

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
@WebServlet(name = "CustomerServlet",urlPatterns = "/customerServlet")
public class CustomerServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();
    /**
     * 分页请求家具信息的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            与原先的page相似
         */

        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用service方法, 获取Page对象
        Page<Furn> page = furnService.page(pageNo, pageSize);
        if(page.getItems().size() == 0){
            page = furnService.page(page.getPageTotalCount(), pageSize);
        }
        //将page放入到requestuest域
        request.setAttribute("page", page);
        //请求转发到furn_manage.jsp
        request.getRequestDispatcher("/views/customer/index.jsp")
                .forward(request, response);
    }
}

