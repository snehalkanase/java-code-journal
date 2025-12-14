package com.library.userservice;

import com.library.models.User;

public class UserServiceImpl implements UserService{

    private final UserDAO userDAO = new UserDAO();
    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    @Override
    public void register(String fullName, String username, String password, String role, String regNo) {
        userDAO.register(fullName, username, password, role, regNo);
    }
}
