package com.Shopping.dao;

import com.Shopping.model.User;

public interface UserDao {
    void addUser(User user);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    void updateUser(User user);

    void deleteUser(int userID);
}
