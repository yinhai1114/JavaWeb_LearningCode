package com.yinhai.furns.service;

import com.yinhai.furns.javabean.Admin;


/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public interface AdminService {
    //注册用户
    public boolean registerMember(Admin admin);
    /**
     * 根据登录传入的member信息，返回对应的在DB中的member对象
     * @param admin 是根据用户登录构建一个member
     * @return 返回的是对应的db中的member对象，如果不存在,返回null
     */
    public Admin login(Admin admin);
}
