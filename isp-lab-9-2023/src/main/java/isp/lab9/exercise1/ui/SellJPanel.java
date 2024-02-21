package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * todo: implement - it should look similar to the 'Buy' panel
 */
public class SellJPanel extends JPanel {
    private StockMarketJFrame mainFrame;
    public SellJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }
    private void initComponents(){
        setLayout(new GridLayout(2, 2));

        JPanel SellJPanel = new JPanel();
        SellJPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        JTextField availableFundsTextField = new JTextField(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        JComboBox<String> symbolComboBox = new JComboBox<>();
        symbolComboBox.setModel(new DefaultComboBoxModel(mainFrame.getMarketService().getSymbols()));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel costLabel = new JLabel("Total cost:");
        JTextField costTextField = new JTextField();
        costTextField.setEditable(false);

        JButton SellButton = new JButton("Sell");

        JButton costButton = new JButton("Get cost");
        costButton.addActionListener(e ->
    calculateTotalCostActionPerformed(symbolComboBox, quantityTextField, costTextField));

        SellJPanel.add(availableFundsLabel);
        SellJPanel.add(availableFundsTextField);
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(symbolLabel);
        SellJPanel.add(symbolComboBox);
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(quantityLabel);
        SellJPanel.add(quantityTextField);
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(costLabel);
        SellJPanel.add(costTextField);
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(new JPanel()); // empty cell in the grid
        SellJPanel.add(costButton);
        SellJPanel.add(SellButton);
    add(SellJPanel);
    add(new JPanel()); // empty cell in the grid
    add(new JPanel()); // empty cell in the grid
    add(new JPanel()); // empty cell in the grid

}

    /**
     * Calculates the total transaction cost
     */
    private void calculateTotalCostActionPerformed(JComboBox<String> symbolComboBox,
                                                   JTextField quantityTextField,
                                                   JTextField totalCostTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            try {
                int quantity = Integer.parseInt(quantityTextField.getText());
                DecimalFormat formatter = new DecimalFormat("#,##0.##");
                totalCostTextField.setText(
                        formatter.format(stockPrice.multiply(new BigDecimal(quantity))));
            } catch (NumberFormatException e) {
                totalCostTextField.setText("Invalid quantity value!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
