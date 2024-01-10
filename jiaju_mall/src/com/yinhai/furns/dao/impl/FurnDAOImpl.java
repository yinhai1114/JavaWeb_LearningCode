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
                " FROM furn";
        return queryMulti(sql,Furn.class);
    }

    @Override
    public int addFurn(Furn furn) {
        String sql = "INSERT INTO furn(`id`,`name`,maker,price,sales,stock,img_path)\n" +
                " VALUES(NULL,?,?,?,?,?,?)";
        return update(sql,furn.getName(),
                furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath());
    }

    @Override
    public int deleteFurnById(int id) {
        String sql = "DELETE FROM furn WHERE id = ?";
        return update(sql,id);
    }

    @Override
    public Furn queryFurnById(int id) {
        String sql = "SELECT `id`,`name`,maker,price,sales,stock,img_path imgPath\n" +
                " FROM furn WHERE `id` = ?";
        return (Furn) querySingle(sql,Furn.class,id);
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql = "UPDATE furn SET `name` = ?, `maker` = ?, `price` = ?, sales = ?" +
                " , stock = ?, `img_path` = ?" +
                " WHERE id = ?";
        return update(sql,furn.getName(),furn.getMaker(),
                furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath(),furn.getId());
    }

    @Override
    public int getTotalRow() {
        String sql = "SELECT COUNT(*) FROM furn";
        // return (int) queryScalar(sql); => 会报转换异常
        return ((Number) queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageItems(int begin, int pageSize) {
        String sql = "SELECT `id`,`name`,maker,price,sales,stock,img_path imgPath\n" +
                " FROM furn LIMIT ?,?";
        return queryMulti(sql,Furn.class,begin,pageSize);
    }


}
