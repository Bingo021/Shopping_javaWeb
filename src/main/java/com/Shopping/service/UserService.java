package com.Shopping.service;

import com.Shopping.model.User;

import java.util.List;

public interface UserService {
    User createUser(String username, String password, String email); // 创建用户账户

    User getUserById(int userId); // 获取用户信息

    void updateUser(int userId, String newUsername, String newEmail, String newPassword); // 更新用户信息

    void deleteUser(int userId); // 删除用户

    List<User> getAllUsers(); // 获取所有用户（管理员视角）

    // 管理员特权操作
    void grantAdminRole(int userId); // 授予管理员角色

    void revokeAdminRole(int userId); // 撤销管理员角色
}

