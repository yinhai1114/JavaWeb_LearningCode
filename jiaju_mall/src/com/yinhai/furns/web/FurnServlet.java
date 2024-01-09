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
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
@WebServlet(name = "FurnServlet",urlPatterns = "/manage/furnServlet")
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
        System.out.println("FurnServlet list方法被调...");
        List<Furn> furns = furnService.queryFurns();
        //把furns集合放入到request域
        req.setAttribute("furns", furns);
        for (Furn furn : furns) {
            System.out.println(furn);
        }
        //请求转发
        req.getRequestDispatcher("/views/manage/furn_manage.jsp")
                .forward(req, resp);
    }
    protected  void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //获取家居信息
        String uname = request.getParameter("name");
        String maker = request.getParameter("maker");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");
        String defaultPath = "assets/images/product-image/default.jpg";
        Furn furn = new Furn(null, uname, maker, new BigDecimal(price), new Integer(sales), new Integer(stock), defaultPath);
        System.out.println(furn);
        furnService.addFurn(furn);

        //老师说明: 因为这里使用请求转发, 当用户刷新页面时, 会重新发出一次添加请求
        // request.getRequestDispatcher("/manage/furnServlet?action=list")
        //        .forward(request, response);
        //就会造成数据重复提交： 解决方案使用 重定向即可.
        //因为重定向实际是让浏览器重新发请求, 所以我们回送的url , 是一个完整url
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
    }
}
