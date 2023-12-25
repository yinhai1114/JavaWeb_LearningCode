package com.yinhai.service;

import com.yinhai.bean.User;
import com.yinhai.dao.UserDAO;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
//提供业务方法 比如获得User
public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User getUserByName(String username){

        return userDAO.querySingle("select * from `user` where username=?",User.class,username);

    }
    public void insertUserName(String username,String pwd,String email){
        userDAO.dml("INSERT INTO `user`(?,?,?,?)",null,username,pwd,email);
    }
}
