package com.yinhai.furns.service.impl;

import com.yinhai.furns.dao.FurnDAO;
import com.yinhai.furns.dao.impl.FurnDAOImpl;
import com.yinhai.furns.javabean.Furn;
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
}
