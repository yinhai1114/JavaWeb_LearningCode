package com.yinhai.t1;

public class A<T> {
    protected A() {
        System.out.println("A的protected A()被调用...");
    }
    A(String str){
        System.out.println("A的默认A被调用 只在本类可用");
    }
}
