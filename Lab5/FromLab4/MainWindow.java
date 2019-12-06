package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel panel1;
    private JList list1;
    private JButton addTestButton;
    private JButton removeTestButton;
    private JButton getMaximumScoreButton;
    private JButton getDifficultyButton;
    private JButton saveToFileButton;
    private JButton readFromFileButton;
    private JButton exitButton;

    public MainWindow() {
        addTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddTestWindow addTestWindow = new AddTestWindow();
                addTestWindow.setVisible(true);
                updList();
            }
        });
        removeTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (list1.getSelectedIndex() >= 0 && list1.getSelectedIndex() < Singleton.SINGLETON.testList.getSize()) {
                    Singleton.SINGLETON.testList.removeTest(list1.getSelectedIndex());
                    updList();
                }
            }
        });
        getMaximumScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (list1.getSelectedIndex() >= 0 && list1.getSelectedIndex() < Singleton.SINGLETON.testList.getSize()) {
                    JOptionPane.showMessageDialog(null, Singleton.SINGLETON.testList.getTest(list1.getSelectedIndex()).maximumScore , "Maximum Score", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        getDifficultyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (list1.getSelectedIndex() >= 0 && list1.getSelectedIndex() < Singleton.SINGLETON.testList.getSize()) {
                    JOptionPane.showMessageDialog(null, Singleton.SINGLETON.testList.getTest(list1.getSelectedIndex()).difficulty , "Maximum Score", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String result;
                if (Singleton.SINGLETON.testList.saveToFileFos("testList.txt")) { result = "Successful save."; }
                else { result = "Error during save."; }
                JOptionPane.showMessageDialog(null, result , "Save to File", JOptionPane.PLAIN_MESSAGE);
            }
        });
        readFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Singleton.SINGLETON.testList.saveAllFromList(Singleton.SINGLETON.testList.readFromFileFis("testList.txt"));
                updList();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(1);
            }
        });
    }

    private void updList() {
        DefaultListModel listModel = new DefaultListModel();
        list1.setModel(listModel);
        for (int i = 0; i < Singleton.SINGLETON.testList.getSize(); i++) {
            listModel.addElement(Singleton.SINGLETON.testList.getTest(i).theme);
        }
    }

    public static void main(String[] args) {
        JFrame mainAppWindow = new JFrame("Main Window");
        mainAppWindow.setContentPane(new MainWindow().panel1);
        mainAppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainAppWindow.pack();
        mainAppWindow.setVisible(true);
    }
}
