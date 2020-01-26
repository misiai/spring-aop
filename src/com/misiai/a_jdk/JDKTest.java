package com.misiai.a_jdk;

import org.junit.Test;

public class JDKTest {

    @Test
    public void test01() {
        UserService userService = MyBeanFactory.createUser();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
