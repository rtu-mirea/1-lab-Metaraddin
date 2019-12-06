package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Suggest extends JDialog {
    private JPanel contentPane;
    private JButton buttonAdd;
    private JTextField textField1;

    public Suggest() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textField1.getText().trim().length() > 0) {
                    JOptionPane.showMessageDialog(null, Singleton.SINGLETON.songsList.vote(Singleton.SINGLETON.currentUser, textField1.getText()), "Add song", JOptionPane.PLAIN_MESSAGE);
                    Suggest.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You must choose a song!", "Add song", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        Suggest dialog = new Suggest();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
