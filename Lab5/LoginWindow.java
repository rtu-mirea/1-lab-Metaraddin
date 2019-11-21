package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JLabel labelLogin = new JLabel("Логин: ");
    private JLabel labelPassword = new JLabel("Пароль: ");
    private JTextField inputLogin = new JTextField("", 5);
    private JTextField inputPassword = new JTextField("", 5);
    private JButton buttonEnter = new JButton("Войти");
    private JButton buttonRegistration = new JButton("Регистрация");

    public LoginWindow() {
        super("Авторизация");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
            RegistrationWindow registrationWindow = new RegistrationWindow();
            registrationWindow.setVisible(true);
        }
    }

    class ButtonEnterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputLogin.getText().trim().length() > 0 && inputPassword.getText().trim().length() > 0) {
                int userNum = Main.userList.enter(inputLogin.getText(), inputPassword.getText());
                if (userNum != -1) {
                    Main.currentUser = Main.userList.getUser(userNum);
                    LoginWindow.this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Неверный логин или пароль", "Ошибка входа", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }

}
