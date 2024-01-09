package com.yinhai.furns.dao.impl;

import com.yinhai.furns.dao.AdminDAO;
import com.yinhai.furns.dao.BasicDAO;
import com.yinhai.furns.javabean.Admin;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class AdminDAOImpl extends BasicDAO implements AdminDAO {

    @Override
    public int saveAdmin(Admin admin) {
        String sql = "INSERT INTO `admin`(`username`,`password`) " +
                "VALUES(?,MD5(?))";
        return update(sql, admin.getUsername(),
                admin.getPassword());
    }

    @Override
    public Admin queryAdminByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password` FROM `admin` " +
                " WHERE `username`=? and `password`=md5(?)";
        return (Admin) querySingle(sql, Admin.class,username,password);
    }


}
