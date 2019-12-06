package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JDialog {
    Singleton singleton;

    private JLabel labelLogin = new JLabel("Login: ");
    private JLabel labelPassword = new JLabel("Password: ");
    private JTextField inputLogin = new JTextField("", 5);
    private JTextField inputPassword = new JTextField("", 5);
    private JButton buttonEnter = new JButton("Enter");
    private JButton buttonRegistration = new JButton("Registration");

    public LoginWindow(JFrame owner) {
        super(owner, "Log in");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setModal(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));

        container.add(labelLogin);
        container.add(inputLogin);
        container.add(labelPassword);
        container.add(inputPassword);

        buttonRegistration.addActionListener(new ButtonRegisterEventListener());
        buttonEnter.addActionListener(new ButtonEnterEventListener());
        container.add(buttonRegistration);
        container.add(buttonEnter);
    }

    class ButtonRegisterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            RegistrationWindow registrationWindow = new RegistrationWindow(LoginWindow.this);
            registrationWindow.setVisible(true);
        }
    }

    class ButtonEnterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputLogin.getText().trim().length() > 0 && inputPassword.getText().trim().length() > 0) {
                int userNum = Singleton.SINGLETON.userList.enter(inputLogin.getText(), inputPassword.getText());
                if (userNum != -1) {
                    Singleton.SINGLETON.currentUser = Singleton.SINGLETON.userList.getUser(userNum);
                    LoginWindow.this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Неверный логин или пароль", "Ошибка входа", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }

}
