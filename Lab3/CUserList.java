package com.company;

import java.util.ArrayList;

public class CUserList {
    private ArrayList<CUser> users;

    public CUserList() {
        users = new ArrayList<CUser>();
    }

    public CUser getUser(int ind) { return users.get(ind); }

    public boolean registration(String name, String login, String password, boolean isAdmin) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).checkLogin(login)) {
                return false;
            }
        }
        users.add(new CUser(name, login, password, isAdmin));
        return true;
    }

    public int enter(String login, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).checkLogin(login)) {
                if (users.get(i).checkPassword(password)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
