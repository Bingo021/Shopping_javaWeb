package com.Shopping.service.Impl;

import com.Shopping.dao.UserDao;
import com.Shopping.model.User;
import com.Shopping.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String username, String password, String email) {
        return null;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public void updateUser(int userId, String newUsername, String newEmail, String newPassword) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void grantAdminRole(int userId) {

    }

    @Override
    public void revokeAdminRole(int userId) {

    }
}

