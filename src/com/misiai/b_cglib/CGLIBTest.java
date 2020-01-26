package com.misiai.b_cglib;

import org.junit.Test;

public class CGLIBTest {

    @Test
    public void test01() {
        UserServiceImpl userService = MyBeanFactory.createUser();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
