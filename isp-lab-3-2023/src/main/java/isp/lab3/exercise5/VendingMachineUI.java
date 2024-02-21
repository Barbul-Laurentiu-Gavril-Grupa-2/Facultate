package isp.lab3.exercise5;

import javax.swing.*;
import java.awt.*;

public class VendingMachineUI extends JFrame {
    private VendingMachine vendingMachine;

    private JButton insertCoinsButton;
    private JButton selectProductButton;

    public VendingMachineUI(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;

        setTitle("Vending Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        insertCoinsButton = new JButton("Insert Coins");
        selectProductButton = new JButton("Select Product");

        buttonPanel.add(insertCoinsButton);
        buttonPanel.add(selectProductButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center the window on the screen

        insertCoinsButton.addActionListener(e -> insertCoins());
        selectProductButton.addActionListener(e -> selectProduct());
    }

    private void insertCoins() {
        String coinsInput = JOptionPane.showInputDialog(this, "Enter coins to insert:");
        if (coinsInput != null) {
            try {
                int coins = Integer.parseInt(coinsInput);
                vendingMachine.insertCoins(coins);
                JOptionPane.showMessageDialog(this, "You have inserted: " + coins + " coins.\nTotal: " + vendingMachine.getCoins() + " coins.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void selectProduct() {
        String productsList = vendingMachine.displayProducts();
        String productIdInput = JOptionPane.showInputDialog(this, productsList + "Enter the product ID:");
        if (productIdInput != null) {
            try {
                int productId = Integer.parseInt(productIdInput);
                String result = vendingMachine.selectProduct(productId);
                JOptionPane.showMessageDialog(this, result);
                if (result.equals("Ati ales produsul: " + vendingMachine.getProductName(productId))) {
                    vendingMachine.updateProduct(productId);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineUI ui = new VendingMachineUI(vendingMachine);
        ui.setVisible(true);
    }
}
