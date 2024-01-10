package com.yinhai.furns.service.impl;

import com.yinhai.furns.dao.FurnDAO;
import com.yinhai.furns.dao.impl.FurnDAOImpl;
import com.yinhai.furns.javabean.Furn;
import com.yinhai.furns.javabean.Page;
import com.yinhai.furns.service.FurnService;

import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class FurnServiceImpl implements FurnService {
    private FurnDAO furnDAO = new FurnDAOImpl();
    //定义属性FurnDAO对象
    /**
     * 返回家居信息
     * @return
     */
    @Override
    public List<Furn> queryFurns() {
        return furnDAO.queryFurns();
    }

    @Override
    public int addFurn(Furn furn) {
        return furnDAO.addFurn(furn);
    }

    @Override
    public int deleteFurnById(int id) {
        return furnDAO.deleteFurnById(id);
    }

    @Override
    public Furn queryFurnById(int id) {
        return furnDAO.queryFurnById(id);
    }

    @Override
    public int updateFurn(Furn furn) {
        return furnDAO.updateFurn(furn);
    }

    @Override
    public Page<Furn> page(int pageNo, int pageSize) {
        Page<Furn> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDAO.getTotalRow();
        page.setTotalRow(totalRow);
        //pageTotalCount最大页数 需要通过算法计算得到
        int pageTotalCount = totalRow / pageSize;
        if(totalRow % pageSize > 0){
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);
        //private List<T> items
        //计算begin
        //private List<T> items
        //老师开始计算begin-> 小小算法
        //验证: pageNo = 1 pageSize = 3 => begin =0
        //验证: pageNo = 3 pageSize = 2 => begin =4
        //OK => 但是注意这里隐藏一个坑, 现在你看不到, 后面会暴露
        int begin = (pageNo - 1) * pageSize;
        List<Furn> pageItems = furnDAO.getPageItems(begin, pageSize);
        page.setItems(pageItems);
        //还差一个url => 分页导航，先放一放
        return page;
    }
}
