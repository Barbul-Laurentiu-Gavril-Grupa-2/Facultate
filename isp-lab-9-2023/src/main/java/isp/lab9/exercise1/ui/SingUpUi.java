package isp.lab9.exercise1.ui;

import javax.swing.*;

public class SingUpJFrame extends JFrame {
    public SingUpJFrame() {
        //setup the window
        this.setTitle("Singup");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 200, 300, 200);

    //create and add components
    JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 100, 20);
        this.add(userLabel);

    JTextField userInputField = new JTextField();
        userInputField.setBounds(160, 20, 100, 20);
        this.add(userInputField);

    JLabel pwdLabel = new JLabel("Password:");
        pwdLabel.setBounds(20, 60, 100, 20);
        this.add(pwdLabel);

    JPasswordField pwdInputField = new JPasswordField();
        pwdInputField.setBounds(160, 60, 100, 20);
        this.add(pwdInputField);

        JButton button = new JButton("SingUP");
        button.setBounds(20, 100, 240, 20);
        this.add(button);
        button.addActionListener(e -> verifyCredentials());
        }
        private void verifyCredentials()
        {
            initAccounts2(JTextField userInputField, JPasswordField pwdInputField)
            SingUpJFrame.this.setVisible(false);

        }

    }
