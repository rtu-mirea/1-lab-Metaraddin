package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*public class MainWindow extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input");
    private JRadioButton radioButton1 = new JRadioButton("Test1");
    private JRadioButton radioButton2 = new JRadioButton("Test2");
    private JCheckBox check = new JCheckBox("Check", false);

    public MainWindow() {
        super("Main Window");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        container.add(radioButton1);
        radioButton1.setSelected(true);
        container.add(radioButton2);
        container.add(check);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String message = "";
            message += "Buttow was pressed\nText is " + input.getText() + "\n";
            message += (radioButton1.isSelected() ? "Radio #1" : "Radio #2") + " is selected!\n";
            message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}*/

public class MainWindow extends JFrame {

}
