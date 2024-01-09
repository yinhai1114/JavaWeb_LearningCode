package com.yinhai.furns.dao.impl;

import com.yinhai.furns.dao.BasicDAO;
import com.yinhai.furns.dao.FurnDAO;
import com.yinhai.furns.javabean.Furn;

import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class FurnDAOImpl extends BasicDAO implements FurnDAO {
    @Override
    public List<Furn> queryFurns() {
        String sql = "SELECT `id`,`name`,maker,price,sales,stock,img_path imgPath\n" +
                "\tFROM furn";
        return queryMulti(sql,Furn.class);
    }

    @Override
    public int addFurn(Furn furn) {
        String sql = "INSERT INTO furn(`id`,`name`,maker,price,sales,stock,img_path)\n" +
                "\tVALUES(NULL,?,?,?,?,?,?)";
        return update(sql,furn.getName(),
                furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath());
    }
}
