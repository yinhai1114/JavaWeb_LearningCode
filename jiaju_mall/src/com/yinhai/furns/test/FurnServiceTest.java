package com.yinhai.furns.test;

import com.yinhai.furns.javabean.Furn;
import com.yinhai.furns.javabean.Page;
import com.yinhai.furns.service.FurnService;
import com.yinhai.furns.service.impl.FurnServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class FurnServiceTest {

    private FurnService furnService = new FurnServiceImpl();
    @Test
    public void queryFurns(){
        List<Furn> furns = furnService.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }
    @Test
    public void queryFurn(){
        Furn furn = furnService.queryFurnById(2);
        System.out.println(furn);
    }
    @Test
    public void updateFurn(){
        Furn furn = new Furn(3,"update修改的沙发","银海家具",new BigDecimal(99.99)
                ,100,10,"assets/images/product-image/3.jpg");
        System.out.println(furnService.updateFurn(furn));

    }
    @Test
    public void test(){
        Furn furn = new Furn(3,"update修改的沙发","银海家具",new BigDecimal(99)
                ,100,10,"");
        Furn furn2 = new Furn(3,"update修改的沙发","银海家具",new BigDecimal(99)
                ,100,10,null);
        System.out.println(furn);
        System.out.println(furn2);
    }
    @Test
    public void page(){
        Page<Furn> page = furnService.page(1, 3);
        System.out.println(page);
    }
}
