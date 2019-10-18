package com.company;

import java.util.ArrayList;

public class CUserList {
    private ArrayList<CUser> users;

    public CUserList() {
        users = new ArrayList<CUser>();
    }

    public String registration(String name, String login, String password, boolean isAdmin) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).checkLogin(login)) {
                return "Login already taken.";
            }
        }
        users.add(new CUser(name, login, password, isAdmin));
        return "Registration completed successfully.";
    }

    public CUser enter(String login, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).checkLogin(login)) {
                if (users.get(i).checkPassword(password)) {
                    return users.get(i);
                }
            }
        }
    }
}
