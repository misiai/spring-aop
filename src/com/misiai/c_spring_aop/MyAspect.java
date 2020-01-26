package com.misiai.c_spring_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类中确定通知，需要实现不同接口，接口就是规范，从而就确定方法名称。
 * 采用环绕通知 MethodInterceptor
 */
public class MyAspect implements MethodInterceptor {


     //采用环绕通知
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 前置
        System.out.println("前置444");
        // 手动执行方法
        Object object = methodInvocation.proceed();
        // 后置
        System.out.println("后置444");
        return object;
    }
}
