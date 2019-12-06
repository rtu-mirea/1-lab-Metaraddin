package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAppWindow {
    private JList list1;
    private JButton changeUserButton;
    private JPanel panel1;
    private JButton endDayButton;
    private JButton deleteSongButton;
    private JButton suggestASongButton;

    public MainAppWindow() {
        upd();
        changeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
                upd();
            }
        });
    }

    private void upd() {
        if (Singleton.SINGLETON.currentUser == null) {
            list1.setEnabled(false);
            endDayButton.setEnabled(false);
            deleteSongButton.setEnabled(false);
            suggestASongButton.setEnabled(false);
        }
        else if (Singleton.SINGLETON.currentUser.getIsAdmin()) {
            list1.setEnabled(true);
            suggestASongButton.setEnabled(false);
            deleteSongButton.setEnabled(false);
            endDayButton.setEnabled(true);
        }
        else {
            list1.setEnabled(true);
            updList();
            suggestASongButton.setEnabled(true);
            deleteSongButton.setEnabled(true);
            endDayButton.setEnabled(false);
        }
    }

    private void updList() {
        DefaultListModel listModel = new DefaultListModel();
        list1.setModel(listModel);
        for (int i = 0; i < Singleton.SINGLETON.userList.getSize(); i++) {
            listModel.addElement(Singleton.SINGLETON.userList.getUser(i).getName());
        }
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.SINGLETON;
        Singleton.SINGLETON.userList.registration("Admin", "admin", "admin", true);
        //LoginWindow loginWindow = new LoginWindow();
        //loginWindow.setVisible(true);
        JFrame mainAppWindow = new JFrame("Main App Window");
        mainAppWindow.setContentPane(new MainAppWindow().panel1);
        mainAppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainAppWindow.pack();
        mainAppWindow.setVisible(true);
    }
}
