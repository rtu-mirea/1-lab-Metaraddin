package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow extends JDialog {

    private JLabel labelName = new JLabel("Name: ");
    private JLabel labelLogin = new JLabel("Login: ");
    private JLabel labelPassword = new JLabel("Password: ");
    private JTextField inputName = new JTextField("", 5);
    private JTextField inputLogin = new JTextField("", 5);
    private JTextField inputPassword = new JTextField("", 5);
    private JButton buttonRegistration = new JButton("Registration");

    public RegistrationWindow(JDialog owner) {
        super(owner, "Registration");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setModal(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2, 2, 2));

        container.add(labelName);
        container.add(inputName);
        container.add(labelLogin);
        container.add(inputLogin);
        container.add(labelPassword);
        container.add(inputPassword);

        buttonRegistration.addActionListener(new ButtonRegisterEventListener());
        container.add(buttonRegistration);
    }

    class ButtonRegisterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputName.getText().trim().length() > 0
                    && inputLogin.getText().trim().length() > 0
                    && inputPassword.getText().trim().length() > 0) {
                if (Singleton.SINGLETON.userList.registration(inputName.getText(), inputLogin.getText(), inputPassword.getText(), false)) {
                    JOptionPane.showMessageDialog(null, "Спасибо за регистрацию, " + inputName.getText() + "!", "Успешная регистрация", JOptionPane.PLAIN_MESSAGE);
                    RegistrationWindow.this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Регистрация не удалась.\nПроверьте введённые данные.", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }
}
