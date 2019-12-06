package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndDay extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;

    public EndDay() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    JOptionPane.showMessageDialog(null, Singleton.SINGLETON.songsList.result(Integer.parseInt(textField1.getText())), "Add song", JOptionPane.PLAIN_MESSAGE);
                    EndDay.this.dispose();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "You must enter a number!", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        EndDay dialog = new EndDay();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setModal(true);
        System.exit(0);
    }
}
