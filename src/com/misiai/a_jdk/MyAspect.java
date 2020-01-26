package com.misiai.a_jdk;

public class MyAspect {

    public void before() {
        System.out.println("前置方法");
    }

    public void after() {
        System.out.println("后置方法");
    }
}
