package com.yinhai.thread;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class T1Service {
    public void update(){
        Object o = T1.threadLocal1.get();
        /*
         * public T get() {
         *          //1. 先得到当前的线程对象
         *         Thread t = Thread.currentThread();
         *         //2.通过线程获取到对应的ThrealLocalMap
         *         ThreadLocalMap map = getMap(t);
         *         if (map != null) {
         *              //3. 如果map不为空, 根据当前的 threadlocal对象，得到对应的Entry
         *             ThreadLocalMap.Entry e = map.getEntry(this);
         *             //4. 如果e 不为null
         *             if (e != null) {
         *                 @SuppressWarnings("unchecked")
         *                 //返回当前threadlocal关联的数据value
         *                 T result = (T)e.value;
         *                 return result;
         *             }
         *         }
         *         return setInitialValue();
         *     }
         *
         */
        System.out.println("T1Service取出了线程关联的对象" + o);
        //获取当前线程名字
        String name = Thread.currentThread().getName();
        System.out.println("在T1Service的update()线程是" + name);

        //调用T2DAO的update方法
        new T2DAO().update();
    }
}
