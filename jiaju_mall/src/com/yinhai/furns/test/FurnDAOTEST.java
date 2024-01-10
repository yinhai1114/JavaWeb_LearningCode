package com.yinhai.furns.test;

import com.yinhai.furns.dao.FurnDAO;
import com.yinhai.furns.dao.impl.FurnDAOImpl;
import com.yinhai.furns.javabean.Furn;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
    @Test
    public void addFurn(){
        Furn furn = new Furn(null,"沙发","银海家具",new BigDecimal(99.99)
                ,100,10,"assets/images/product-image/3.jpg");
        System.out.println(furnDAO.addFurn(furn));
    }
    @Test
    public void getTotalRow(){
        System.out.println(furnDAO.getTotalRow());
    }
    @Test
    public void getPageItems(){
        List<Furn> pageItems = furnDAO.getPageItems(0, 3);
        for (Furn pageItem : pageItems) {
            System.out.println(pageItem);
        }
    }
}
