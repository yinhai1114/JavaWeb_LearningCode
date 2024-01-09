package com.yinhai.furns.test;

import com.yinhai.furns.javabean.Admin;
import com.yinhai.furns.service.AdminService;
import com.yinhai.furns.service.impl.AdminServiceImpl;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class AdminTest {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        Admin admin = new Admin(null,"yinhai","yinhai");
        Admin login = adminService.login(admin);
        System.out.println(login);
    }
}
