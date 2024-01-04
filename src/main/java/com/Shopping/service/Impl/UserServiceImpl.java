package com.Shopping.service.Impl;

import com.Shopping.dao.Impl.UserDaoImpl;
import com.Shopping.dao.UserDao;
import com.Shopping.model.User;
import com.Shopping.service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    public UserServiceImpl() {

    }

    @Override
    public User createUser(String username, String password, String email, int role) {
        User newUser = new User(username, password, email, role);
        userDao.addUser(newUser);

        return newUser;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public void updateUser(int userId, String newUsername, String newEmail, String newPassword) {
        User existingUser = userDao.getUserById(userId);

        if (existingUser != null) {
            // 更新用户信息，确保新的用户名和邮箱不为空
            existingUser.setUsername(newUsername != null ? newUsername : existingUser.getUsername());
            existingUser.setEmail(newEmail != null ? newEmail : existingUser.getEmail());

            if (newPassword != null) {
                existingUser.setPassword(newPassword);
            }

            userDao.updateUser(existingUser);
        }
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUsersByRole();
    }

    @Override
    public void grantAdminRole(int userId) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            user.setRole(1);
            userDao.updateUser(user);
        }
    }

    @Override
    public void revokeAdminRole(int userId) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            user.setRole(0);
            userDao.updateUser(user);
        }
    }
}

