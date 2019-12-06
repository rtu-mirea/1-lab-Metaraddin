package com.company;

import javax.swing.*;
import java.awt.event.*;

public class AddTestWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonAdd;
    private JTextField numberText;
    private JTextField themeText;
    private JTextField questionsCountText;
    private JTextField difficultyText;
    private JTextField maximumScoreText;
    private JButton buttonCancel;

    public AddTestWindow() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonAdd);

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        /*setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);*/
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (themeText.getText().trim().length() > 0) {
                    try {
                        Singleton.SINGLETON.testList.addTest(new Test(Integer.parseInt(numberText.getText()),
                                themeText.getText(),
                                Integer.parseInt(questionsCountText.getText()),
                                Integer.parseInt(difficultyText.getText()),
                                Integer.parseInt(maximumScoreText.getText())));
                        AddTestWindow.this.dispose();
                        return;
                    } catch (NumberFormatException e) { }
                }
                JOptionPane.showMessageDialog(null, "Check the input is correct.", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    private void onOK() {
        dispose();
    }

    public static void main(String[] args) {
        AddTestWindow dialog = new AddTestWindow();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setModal(true);
        System.exit(0);
    }
}
