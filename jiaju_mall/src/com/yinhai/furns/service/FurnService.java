package com.yinhai.furns.service;

import com.yinhai.furns.javabean.Furn;

import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public interface FurnService {
    public List<Furn> queryFurns();
    public int addFurn(Furn furn);
}
