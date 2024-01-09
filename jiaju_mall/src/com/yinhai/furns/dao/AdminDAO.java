package com.yinhai.furns.dao;

import com.yinhai.furns.javabean.Admin;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public interface AdminDAO {
    //提供一个保存Member对象到数据库/表member表
    public int saveAdmin(Admin admin);

    /**
     * 根据用户名和密码返回Member
     * @param username 用户名
     * @param password 密码
     * @return 返回的对象，如果不存在，返回null
     *
     */
    public Admin queryAdminByUsernameAndPassword
    (String username, String password);
}
