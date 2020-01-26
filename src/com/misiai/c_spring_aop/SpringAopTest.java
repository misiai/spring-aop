package com.misiai.c_spring_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopTest {

    @Test
    public void test01() {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*获得代理类id*/
        UserService userService = (UserService) ap.getBean("userService");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
