package com.company;

public class Main {

    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
        if (currentUser.getIsAdmin()) {
            System.out.printf("admin");
        } else {
            System.out.println("Not admin");
        }
    }
}
