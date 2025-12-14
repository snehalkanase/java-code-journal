package com.library.userservice;

import com.library.common.ConsoleUtils;
import com.library.models.Role;
import com.library.models.User;

public class UserController {
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();

    public User login() {
        String username = ConsoleUtils.readString("username: ");
        String password = ConsoleUtils.readString("password: ");

        return userServiceImpl.login(username, password);
    }

    public void register(){
        String fullName = ConsoleUtils.readString("Full Name: ");
        String username = ConsoleUtils.readString("Username: ");
        String password = ConsoleUtils.readString("Password: ");
        String regNo = ConsoleUtils.readString("RegNo: ");
        Role role = null;

        while(role == null){
            try{
                String roleInput = ConsoleUtils.readString("Role (ADMIN/STUDENT): ").toUpperCase();
                role = Role.valueOf(roleInput);
            }catch (IllegalArgumentException e){
                System.out.println("Invalid Role. Please Enter ADMIN or STUDENT.");
            }
        }
        String roleString = role.name();

        userServiceImpl.register(fullName, username, password, roleString, regNo);
        System.out.println("User registered successfully.");
    }
}
