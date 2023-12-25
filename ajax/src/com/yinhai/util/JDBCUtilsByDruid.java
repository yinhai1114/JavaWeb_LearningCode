package com.yinhai.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    // 测试连接
    // public static void main(String[] args) throws SQLException {
    //     Connection connection = JDBCUtilsByDruid.getConnection();
    //     System.out.println(connection);
    // }
    // 在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            //目前是Java方式启动
            //所以我们要获取src目录下的文件需要使用 类加载器
            //原先是JavaSe方式获取 现在是JavaWeb方式
            // InputStream resourceAsStream = JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));

            //properties.load(new FileInputStream("ajax/src/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接, 再次强调： 在数据库连接池技术中，close 不是真的断掉连接
    //而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
