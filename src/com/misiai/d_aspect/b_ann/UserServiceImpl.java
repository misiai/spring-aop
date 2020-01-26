package com.misiai.d_aspect.b_ann;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("d_aspect.b_ann：Add User");
    }

    @Override
    public String updateUser() {
        System.out.println("d_aspect.b_ann：Update User");
        // int i = 1 / 0;
        return "更新成功";
    }

    @Override
    public void deleteUser() {
        System.out.println("d_aspect.b_ann：Delete User");
    }
}
