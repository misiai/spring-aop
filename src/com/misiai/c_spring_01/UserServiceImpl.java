package com.misiai.c_spring_01;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("Add User");
    }

    @Override
    public void updateUser() {
        System.out.println("Update User");
    }

    @Override
    public void deleteUser() {
        System.out.println("Delete User");
    }
}
