package com.yinhai.furns.test;

import com.yinhai.furns.dao.FurnDAO;
import com.yinhai.furns.dao.impl.FurnDAOImpl;
import com.yinhai.furns.javabean.Furn;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */

public class FurnDAOTEST {
    private FurnDAO furnDAO = new FurnDAOImpl();
    @Test
    public  void queryFurns(){
        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn :furns) {
            System.out.println(furn);
        }

    }
}
