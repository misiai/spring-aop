package com.misiai.b_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyBeanFactory {

    public static UserServiceImpl createUser() {
        //1.目标类
        final UserServiceImpl userService = new UserServiceImpl();

        //2.切面类
        final MyAspect myAspect = new MyAspect();

        //3.1核心类
        Enhancer enhancer = new Enhancer();
        //3.2创建目标类的子类，要确定父类
        enhancer.setSuperclass(userService.getClass());

        /*

          3.3设置回调函数,此接口等价jdk中的 InvocationHandler
          参数1-3和之前的invoke一样，

         */

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                //前置
                myAspect.before();

                Object result = method.invoke(userService, objects);

                //后置
                myAspect.after();

                return result;
            }
        });

        //3.4创建代理
        UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();


        return proxyService;
    }
}
