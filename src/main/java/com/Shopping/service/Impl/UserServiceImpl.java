package com.Shopping.service.Impl;

import com.Shopping.dao.UserDao;
import com.Shopping.model.User;
import com.Shopping.service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        userDao = null;
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(String username, String password, String email, int role) {
        String hashedPassword = hashPassword(password);

        User newUser = new User(username, hashedPassword, email, role);
        userDao.addUser(newUser);

        return newUser;
    }

    @Override
    public User getUserByUsername(String username) {
        if (userDao != null) {
            return userDao.getUserByUsername(username);
        } else {
            return null;
        }
    }

    @Override
    public boolean checkPassword(String enteredPassword, String storedHashedPassword) {
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }

    @Override
    public void updateUser(int userId, String newUsername, String newEmail, String newPassword) {
        User existingUser = userDao.getUserById(userId);

        if (existingUser != null) {
            // 更新用户信息，确保新的用户名和邮箱不为空
            existingUser.setUsername(newUsername != null ? newUsername : existingUser.getUsername());
            existingUser.setEmail(newEmail != null ? newEmail : existingUser.getEmail());

            if (newPassword != null) {
                // 假设密码需要进行加密存储
                existingUser.setPassword(hashPassword(newPassword));
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
        // 假设你的用户表中有一个角色字段，可以设置用户角色为管理员
        User user = userDao.getUserById(userId);
        if (user != null) {
            user.setRole(1);
            userDao.updateUser(user);
        }
    }

    @Override
    public void revokeAdminRole(int userId) {
        // 假设你的用户表中有一个角色字段，可以取消用户的管理员角色
        User user = userDao.getUserById(userId);
        if (user != null) {
            user.setRole(0);
            userDao.updateUser(user);
        }
    }

    // 密码需要进行加密存储
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}

