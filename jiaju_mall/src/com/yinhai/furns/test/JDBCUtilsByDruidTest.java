package com.yinhai.furns.test;

import com.yinhai.furns.utils.JDBCUtilsByDruid;

import java.sql.Connection;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class JDBCUtilsByDruidTest {
    public static void main(String[] args) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println("this connection" + connection);
        JDBCUtilsByDruid.close(null,null,connection);


    }
}
