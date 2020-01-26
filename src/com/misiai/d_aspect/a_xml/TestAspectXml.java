package com.misiai.d_aspect.a_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectXml {

    @Test
    public void test01() {
        String xmlPath = "com/misiai/d_aspect/a_xml/beans.xml";
        ApplicationContext ap = new ClassPathXmlApplicationContext(xmlPath);

    //    获得目标类
        UserService userService = (UserService)ap.getBean("userService");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();

    }


}
