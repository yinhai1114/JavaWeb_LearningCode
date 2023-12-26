package com.yinhai.thread;

import com.sun.javafx.tk.Toolkit;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class T1 {
    //创建ThreadLocal对象 做成static
    public static ThreadLocal<Object> threadLocal1 = new ThreadLocal<>();
    //Task是线程类 是内部类
    public static class Task implements Runnable{

        @Override
        public void run() {
            Dog dog = new Dog();
            Pig pig = new Pig();
            //给threadLocal1对象放入set dog
            System.out.println("t1 task 放入这只狗" + dog);
            /*
                public void set(T value) {
                    //1. 获取当前线程, 关联到当前线程!
                    Thread t = Thread.currentThread();
                    //2. 通过线程对象, 获取到ThreadLocalMap
                    //这个线程管理多个ThreadLocal
                    //   ThreadLocalMap 类型是 ThreadLocal.ThreadLocalMap(一个静态内部类)
                    ThreadLocalMap map = getMap(t);
                    //3. 如果map不为null, 将数据(dog,pig..) 放入map - key:threadLocal value:存放的数据（对象）
                    //   从这个源码我们已然看出一个threadlocal只能关联一个数据，如果再set, 就会替换
                    //4. 如果map为null, 就创建一个和当前线程关联的ThreadLocalMap, 并且该数据放入
                    if (map != null)
                        map.set(this, value);
                    else
                        createMap(t, value);
                }

             */
            threadLocal1.set(dog);//放到这个线程里 就跟这个线程相关的
            System.out.println("在T1内的Task内部类run 方法中的线程=" + Thread.currentThread().getName());
            new T1Service().update();
        }
    }
    public static void main(String[] args) {
        new Thread((new Task())).start();
    }
}
