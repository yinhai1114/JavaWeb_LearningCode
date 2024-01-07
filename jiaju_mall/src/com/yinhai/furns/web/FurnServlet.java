package com.yinhai.furns.web;

import com.yinhai.furns.dao.BasicDAO;
import com.yinhai.furns.javabean.Furn;
import com.yinhai.furns.service.FurnService;
import com.yinhai.furns.service.impl.FurnServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebServlet(name = "FurnServlet",urlPatterns = "/manager/furnServlet")
public class FurnServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();
    /**
     * 这里我们使用前面的模板设计模式+反射+动态绑定来的调用到list方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("FurnServlet list方法被调...");
        List<Furn> furns = furnService.queryFurns();
        //把furns集合放入到request域
        req.setAttribute("furns", furns);
        //请求转发
        req.getRequestDispatcher("/views/manage/furn _manage.jsp")
                .forward(req, resp);
    }
}
