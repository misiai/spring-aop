package com.misiai.d_aspect.a_xml;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("d_aspect.a_xml：Add User");
        Integer a = 1 / 0;
    }

    @Override
    public String updateUser() {
        System.out.println("d_aspect.a_xml：Update User");
        return "更新成功";
    }

    @Override
    public void deleteUser() {
        System.out.println("d_aspect.a_xml：Delete User");
    }
}
