package com.misiai.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

    public static UserService createUser() {
        //1.目标类
        final UserService userService = new UserServiceImpl();

        //2.切面类
        final MyAspect myAspect = new MyAspect();

        /**
         * 3.代理类，将目标类（切入点）和切面类（通知）结合-->切面
         *
         * Proxy.newProxyInstance
         * 参数1：类加载器 动态代理类，运行时创建，
         *      一般情况下，当前类.class.getClassLoad();
         *      目标实例.getClass().getClassLoader();
         *
         * 参数2：代理类需要实现的所有接口
         * 参数3：InvocationHandler，处理实现类
         *      invoke方法，代理类的每一个方法执行时，都将调用一次invoke
         *      参数31：Object proxy：代理对象
         *      参数32：Method method：代理对象当前执行的方法的描述对象（反射
         *      參数33：object[]args：方法实际参数
         */
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 执行切面类前置方法
                        myAspect.before();
                        Object result = method.invoke(userService, args);//返回的是函数的执行结果（返回值）
                        // 后置方法
                        myAspect.after();
                        return result;
                    }
                }
        );


        return proxyService;
    }
}
