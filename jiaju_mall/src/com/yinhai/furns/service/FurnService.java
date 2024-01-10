package com.yinhai.furns.service;

import com.yinhai.furns.javabean.Furn;
import com.yinhai.furns.javabean.Page;

import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public interface FurnService {
    public List<Furn> queryFurns();
    public int addFurn(Furn furn);
    public int deleteFurnById(int id);
    public Furn queryFurnById(int id);
    public int updateFurn(Furn furn);
    /**
     * 根据传入的pageNo和 pageSize , 返回对应的page对象
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Furn> page(int pageNo,int pageSize);
}
