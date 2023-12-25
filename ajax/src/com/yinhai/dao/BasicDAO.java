package com.yinhai.dao;


import com.yinhai.util.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.xml.ws.handler.Handler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 * 开发BasicDAO是其他DAO的父类
 */
public class BasicDAO<T> {

    private QueryRunner qr = new QueryRunner();

    //开发通用的增删改查方法
    public int dml(String sql , Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {//将编译异常 -> 运行异常 抛出
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
    //返回多个对象(即查询的结果是多行)，针对任意表
    /**
     *
     * @param sql sql 语句，可以有 ?
     * @param clazz 传入一个类的Class对象 比如 Actor.class
     * @param parameters 传入 ? 的具体的值，可以是多个
     * @return 根据Actor.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz),parameters);

        } catch (SQLException e) {//将编译异常 -> 运行异常 抛出
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }

    }

    //查询单行结果 的通用方法
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz),parameters);

        } catch (SQLException e) {//将编译异常 -> 运行异常 抛出
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行单列 即返回单值的方法
    public Object queryScalar(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(),parameters);

        } catch (SQLException e) {//将编译异常 -> 运行异常 抛出
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
