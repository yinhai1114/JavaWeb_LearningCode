package com.yinhai.thread;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class T2DAO {

    public void update(){
        Object o = T1.threadLocal1.get();
        System.out.println("T2DAO取出了线程关联的对象" + o);
        //获取当前线程名字
        String name = Thread.currentThread().getName();
        System.out.println("在T2DAO的update()线程是" + name);
    }
}
