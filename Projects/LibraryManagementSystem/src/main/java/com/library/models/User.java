package com.library.models;

public class User {
    private int id;
    private String fullName;
    private String username;
//    private String password;
    private String role;
    private String regNo;

    public User(int id, String fullName, String username, String role, String regNo) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
//        this.password = password;
        this.role = role;
        this.regNo = regNo;
    }
    public int getId() {
        return id;
    }
    public String getRole() {
        return role;
    }
}
