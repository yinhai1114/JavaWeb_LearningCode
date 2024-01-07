package com.yinhai.furns.test;

import com.yinhai.furns.javabean.Furn;
import com.yinhai.furns.service.FurnService;
import com.yinhai.furns.service.impl.FurnServiceImpl;
import org.junit.jupiter.api.Test;

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
}
