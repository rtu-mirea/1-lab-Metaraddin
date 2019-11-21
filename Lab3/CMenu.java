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
        users.registration("Admin", "admin", "admin", true);
    };

    public void startMenu() {
        Scanner scan = new Scanner(System.in);
        int task = -1;
        while (task != 0) {
            System.out.println("1 - Sing Up\n2 - Sign In\n0 - Exit");
            task = scan.nextInt();
            switch (task) {
                case(1):
                    registration();
                    break;
                case(2):
                    enter();
                    break;
                case(0):
                    break;
            }
        }
    }

    private void registration() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scan.next();
        System.out.print("Login: ");
        String login = scan.next();
        System.out.print("Password: ");
        String password = scan.next();
        if(users.registration(name, login, password, false)) {
            System.out.println("Registration completed successfully.");
        } else {
            System.out.println("Login already taken.");
        }
        startMenu();
    }

    private void enter() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Login: ");
        String login = scan.next().trim();
        System.out.print("Password: ");
        String password = scan.next();
        int user = users.enter(login,password);
        if (user != -1) {
            current = users.getUser(user);
            System.out.println("Welcome, " + current.getName() + "!");
            showMainMenu();
        } else {
            System.out.println("Authorization Failed");
            startMenu();
        }
    }

    private void showAdminMenu() {
        int task = -1;
        Scanner scan = new Scanner(System.in);
        while (task != 0) {
            System.out.println("1 - End day\n2 - Change user\n0 - Exit");
            task = scan.nextInt();
            switch (task) {
                case(1):
                    System.out.print("List lenght: ");
                    System.out.println(songs.result(scan.nextInt()));
                    break;
                case(2):
                    startMenu();
                    break;
                case(0):
                    System.out.println("Bye-Bye!");
                    break;
            }
        }
    }

    private void showFanMenu() {
        int task = -1;
        Scanner scan = new Scanner(System.in);
        while (task != 0) {
            System.out.println("1 - Suggest a song\n2 - View all songs\n3 - Change user\n0 - Exit");
            task = scan.nextInt();
            switch (task) {
                case(1):
                    System.out.print("Enter song title: ");
                    System.out.println(songs.vote(current, scan.next()));
                    break;
                case(2):
                    System.out.println(songs.print());
                    break;
                case(3):
                    startMenu();
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
