package com.misiai.c_spring_01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test01() {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*获得代理类id*/
        UserService userService = (UserService) ap.getBean("proxyFactoryBean");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
