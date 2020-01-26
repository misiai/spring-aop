package com.misiai.d_aspect.b_ann;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类，具有多个通知
 */
@Component
@Aspect
public class MyAspect {


    @Pointcut("execution(* com.misiai.d_aspect.b_ann.UserServiceImpl.*(..))")
    public void myPointCut() {

    }

    /**
     * 前置通知
     * 切入点当前有效
     */
    // @Before(value = "myPointCut()")
    public void before(JoinPoint joinPoint) {
        /*JoinPoint，传递参数，有一些类的信息
         * 比如获得方法名:joinPoint.getSignature().getName()
         * */
        System.out.println("前置通知 aspect，" + joinPoint.getSignature().getName());
    }

    /**
     * 后置返回
     */
    // @AfterReturning(value = "myPointCut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("后置返回通知：" + ret);
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    // @Around(value = "myPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {


        /*这里可以放前置通知*/
        System.out.println("环绕方法-前置通知");
        //    手动执行目标方法

        Object proceed = joinPoint.proceed();

        System.out.println("环绕方法-后置通知");
        /*这里可以放后置/后置返回通知*/
        return proceed;
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After(value = "myPointCut()")
    public void after(JoinPoint joinPoint) {
        /*比如这里还可以获得参数*/
        System.out.println("after 参数：" + Arrays.asList(joinPoint.getArgs()));
        System.out.println("后置通知 aspect");
        System.out.println("====================");
    }

    //抛出异常通知
    // @AfterThrowing(value = "myPointCut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("抛出异常通知：" + throwable.getMessage());
    }
}
