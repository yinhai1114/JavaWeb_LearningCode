package com.yinhai.furns.web;

import com.yinhai.furns.dao.BasicDAO;
import com.yinhai.furns.javabean.Furn;
import com.yinhai.furns.service.FurnService;
import com.yinhai.furns.service.impl.FurnServiceImpl;
import com.yinhai.furns.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

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
        // String uname = request.getParameter("name");
        // String maker = request.getParameter("maker");
        // String price = request.getParameter("price");
        // String sales = request.getParameter("sales");
        //
        //
        // String stock = request.getParameter("stock");
        // String defaultPath = "assets/images/product-image/default.jpg";
        // Furn furn = new Furn(null, uname, maker, new BigDecimal(price), new Integer(sales), new Integer(stock), defaultPath);
        //我们可以对获取的到数据, 进行一个校验
        //1. 使用java的正则表达式来验证 sales是一个正整数
        //2. 如果没有通过校验，则直接返回furn_add.jsp -> request.setAttribute("mes","xx")
        //3. 这里可以直接进行转换
        //try {
        //    int i = Integer.parseInt(sales);
        //}catch (NumberFormatException e) {
        //    //System.out.println("转换异常...");
        //    req.setAttribute("mes", "销量数据格式不对...");
        //    //返回到furn_add.jsp
        //    req.getRequestDispatcher("/views/manage/furn_add.jsp")
        //            .forward(req, resp);
        //    return;
        //}

        //String stock = req.getParameter("stock");
        //图片的路径 imgPath 使用默认即可
        //Furn furn = null;
        //try {
        //    furn = new Furn(null, name, maker, new BigDecimal(price),
        //            new Integer(sales), new Integer(stock), "assets/images/product-image/default.jpg");
        //} catch (NumberFormatException e) {
        //    req.setAttribute("mes", "添加数据格式不对...");
        //    //返回到furn_add.jsp
        //    req.getRequestDispatcher("/views/manage/furn_add.jsp")
        //            .forward(req, resp);
        //    return;
        //}

        //后面我们会学习SpringMVC -> 专门的用于数据校验的规则/框架 JSR303... Hibernate Validator
        //这里我们使用第二种方式, 完成将前端提交的数据， 封装成Furn的Javabean对象
        //使用BeanUtils完成javabean对象的自动封装.
        //
        // Furn furn = new Furn();
        // try {
        //    //讲 req.getParameterMap() 数据封装到furn 对象
        //    //使用反射将数据封装, 有一个前提就是表单提交的数据字段名
        //    //<input name="maker" style="width: 90%" type="text" value=""/>
        //    //需要和封装的Javabean的属性名一致
        //    BeanUtils.populate(furn, request.getParameterMap());
        // } catch (Exception e) {
        //    e.printStackTrace();
        // }
        // 自动将提交的数据，封装到Furn对象
        Furn furn =
                DataUtils.copyParamToBean(request.getParameterMap(), new Furn());
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
