package tst;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingInterfaceExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Create and configure the main frame
        JFrame frame = new JFrame("Swing Interface Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a panel for the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Add text field for user input
        JTextField textField = new JTextField(20);
        inputPanel.add(textField);

        // Add button to perform an action
        JButton button = new JButton("Perform Action");
        inputPanel.add(button);

        // Create a label to display the result
        JLabel resultLabel = new JLabel();

        // Create a panel to display the result
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(resultLabel);

        // Add components to the main frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);

        // Register an action listener for the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text entered in the text field
                String inputText = textField.getText();

                // Perform some action based on the input
                String result = performAction(inputText);

                // Update the result label
                resultLabel.setText(result);
            }
        });

        // Set the size and visibility of the frame
        frame.pack();
        frame.setVisible(true);
    }

    private static String performAction(String input) {
        // Perform some action based on the input
        return "Action performed with input: " + input;
    }
}

