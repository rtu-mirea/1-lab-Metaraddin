package com.company;

public class User {
    private String name;
    private String login;
    private String password;
    private Boolean isAdmin;

    public User(String nameInp, String loginInp, String passwordInp, boolean isAdminInp) {
        name = nameInp;
        login = loginInp;
        password = passwordInp;
        isAdmin = isAdminInp;
    }

    public String getName() { return name; }

    public boolean getIsAdmin() { return isAdmin; }

    public boolean checkLogin(String loginInp) {
        if (login.equals(loginInp)) { return true; }
        return false;
    }

    public boolean checkPassword(String passwordInp) {
        if (password.equals(passwordInp)) { return true; }
        return false;
    }
}