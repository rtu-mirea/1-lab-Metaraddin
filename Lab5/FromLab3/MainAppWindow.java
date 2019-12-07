package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

public class MainAppWindow extends JFrame {
    private JList list1;
    private JButton changeUserButton;
    private JPanel panel1;
    private JButton endDayButton;
    private JButton voteForSelectedButton;
    private JButton suggestASongButton;
    private JButton exitButton;

    public MainAppWindow() {
        upd();
        changeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoginWindow loginWindow = new LoginWindow(MainAppWindow.this);
                loginWindow.setVisible(true);
                upd();
            }
        });
    panel1.addFocusListener(new FocusAdapter() { } );
        suggestASongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Suggest suggest = new Suggest();
                suggest.setVisible(true);
                updList();
            }
        });
        voteForSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (list1.getSelectedIndex() >= 0 && list1.getSelectedIndex() < Singleton.SINGLETON.songsList.getSize()) {
                    JOptionPane.showMessageDialog(null, Singleton.SINGLETON.songsList.vote(Singleton.SINGLETON.currentUser, Singleton.SINGLETON.songsList.getSong(list1.getSelectedIndex()).getName()), "Vote", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        endDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EndDay endDay = new EndDay();
                endDay.setVisible(true);
                updList();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    private void upd() {
        if (Singleton.SINGLETON.currentUser == null) {
            list1.setEnabled(false);
            clearList();
            endDayButton.setEnabled(false);
            voteForSelectedButton.setEnabled(false);
            suggestASongButton.setEnabled(false);
        }
        else if (Singleton.SINGLETON.currentUser.getIsAdmin()) {
            clearList();
            list1.setEnabled(true);
            suggestASongButton.setEnabled(false);
            voteForSelectedButton.setEnabled(false);
            endDayButton.setEnabled(true);
        }
        else {
            list1.setEnabled(true);
            updList();
            suggestASongButton.setEnabled(true);
            voteForSelectedButton.setEnabled(true);
            endDayButton.setEnabled(false);
        }
    }

    private void updList() {
        DefaultListModel listModel = new DefaultListModel();
        list1.setModel(listModel);
        for (int i = 0; i < Singleton.SINGLETON.songsList.getSize(); i++) {
            listModel.addElement(Singleton.SINGLETON.songsList.getSong(i).getName());
        }
    }

    private void clearList() {
        list1.removeAll();
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.SINGLETON;
        Singleton.SINGLETON.userList.registration("Admin", "admin", "admin", true);
        Singleton.SINGLETON.userList.registration("test", "test", "test", false);
        Singleton.SINGLETON.userList.registration("test2", "test2", "test2", false);
        JFrame mainAppWindow = new JFrame("Main App Window");
        mainAppWindow.setContentPane(new MainAppWindow().panel1);
        mainAppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainAppWindow.pack();
        mainAppWindow.setVisible(true);
    }
}
