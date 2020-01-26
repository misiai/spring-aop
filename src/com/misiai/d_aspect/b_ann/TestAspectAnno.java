package com.misiai.d_aspect.b_ann;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnno {

    @Test
    public void test01() {
        String xmlPath = "com/misiai/d_aspect/b_ann/beans.xml";
        ApplicationContext ap = new ClassPathXmlApplicationContext(xmlPath);

    //    获得目标类
        UserService userService = (UserService)ap.getBean("userService");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();

    }


}
