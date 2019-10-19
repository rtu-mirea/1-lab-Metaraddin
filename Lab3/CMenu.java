package com.company;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CMenu {
    private CSongsList songs;
    private CUserList users;
    private CUser current;

    public CMenu() {
        songs = new CSongsList();
        users = new CUserList();
    };

    public void enter() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Login: ");
        String login = scan.next();
        System.out.print("Password: ");
        String password = scan.next();
        int user = users.enter(login,password);
        if (user != -1) {
            current = users.getUser(user);
            System.out.println("Welcome, " + current.getName() + "!");
        } else {
            System.out.println("Authorization Failed");
        }
        showMainMenu();
    }

    private void showAdminMenu() {
        System.out.println("1 - End day\n2 - Change user\n0 - Exit");
        int task = -1;
        while (task != 0) {
            Scanner scan = new Scanner(System.in);
            task = scan.nextInt();
            switch (task) {
                case(1):
                    System.out.print("List lenght: ");
                    songs.result(scan.nextInt());
                    break;
                case(2):
                    enter();
                    break;
                case(0):
                    System.out.println("Bye-Bye!");
                    break;
            }
        }
    }

    private void showFanMenu() {
        System.out.println("1 - Suggest a song\n\n2 - View all songs\n3 - Change user\n0 - Exit");
        int task = -1;
        while (task != 0) {
            Scanner scan = new Scanner(System.in);
            task = scan.nextInt();
            switch (task) {
                case(1):
                    System.out.print("Enter song title: ");
                    if (songs.vote(current, scan.next())) {
                        System.out.println("You voted.");
                    } else {
                        System.out.println("Your vote was first.");
                    }
                    break;
                case(2):
                    System.out.println(songs.print());
                    break;
                case(3):
                    enter();
                    break;
                case(0):
                    System.out.println("Bye-Bye!");
                    break;
            }
        }
    }

    private void showMainMenu() {
        if (current.getIsAdmin()) {
            showAdminMenu();
        } else {
            showFanMenu();
        }
    }
}
