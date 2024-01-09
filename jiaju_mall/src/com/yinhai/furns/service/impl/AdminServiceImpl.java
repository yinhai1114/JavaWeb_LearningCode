package com.yinhai.furns.service.impl;

import com.yinhai.furns.dao.AdminDAO;
import com.yinhai.furns.dao.impl.AdminDAOImpl;
import com.yinhai.furns.javabean.Admin;

import com.yinhai.furns.service.AdminService;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDAOImpl();
    @Override
    public boolean registerMember(Admin admin) {
        return adminDAO.saveAdmin(admin) == 1 ? true : false;

    }

    @Override
    public Admin login(Admin admin) {
        return adminDAO.queryAdminByUsernameAndPassword
                (admin.getUsername(), admin.getPassword());
    }
}
