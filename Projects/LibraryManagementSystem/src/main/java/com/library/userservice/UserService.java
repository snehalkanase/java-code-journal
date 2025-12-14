package com.library.userservice;

import com.library.models.User;

public interface UserService {
    User login(String username, String password);
    void register(String fullName, String username, String password, String role, String regNo);
}
