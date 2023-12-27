package service;

import model.User;

public interface UserService {
    void addUser(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    void updateUser(User user);
    void deleteUser(int userId);
}

