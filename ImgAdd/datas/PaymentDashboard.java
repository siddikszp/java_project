package datas;

import Entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentDashboard extends JFrame {
    private JTextField transactionIdField;
    private JComboBox<String> paymentMethod;
    private JLabel transactionIdLabel, totalAmountLabel;
    private double totalAmount;
    private User user;

    public PaymentDashboard(User user, double totalAmount) {
        this.user = user;
        this.totalAmount = totalAmount;

        setTitle("Payment Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 255, 240));

        JLabel titleLabel = new JLabel("Payment Details");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLabel.setBounds(220, 30, 200, 30);
        add(titleLabel);

        totalAmountLabel = new JLabel("Total Amount: $" + String.format("%.2f", totalAmount));
        totalAmountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalAmountLabel.setBounds(200, 80, 300, 30);
        add(totalAmountLabel);

        JLabel paymentLabel = new JLabel("Payment Method:");
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 14));
        paymentLabel.setBounds(80, 130, 150, 30);
        add(paymentLabel);

        paymentMethod = new JComboBox<>(new String[]{"Bkash", "Cash on Delivery"});
        paymentMethod.setBounds(230, 130, 200, 30);
        paymentMethod.addActionListener(e -> toggleTransactionIdField());
        add(paymentMethod);

        transactionIdLabel = new JLabel("Transaction ID:");
        transactionIdLabel.setFont(new Font("Arial", Font.BOLD, 14));
        transactionIdLabel.setBounds(80, 180, 150, 30);
        transactionIdLabel.setVisible(false);
        add(transactionIdLabel);

        transactionIdField = new JTextField();
        transactionIdField.setBounds(230, 180, 200, 30);
        transactionIdField.setVisible(false);
        add(transactionIdField);

        JButton payButton = new JButton("Pay Now");
        payButton.setBounds(230, 240, 120, 30);
        payButton.setBackground(new Color(0, 128, 0));
        payButton.setForeground(Color.WHITE);
        payButton.setFont(new Font("Arial", Font.BOLD, 14));
        payButton.addActionListener(e -> processPayment());
        add(payButton);

        JButton backButton = new JButton("Cancel");
        backButton.setBounds(230, 280, 120, 30);
        backButton.addActionListener(e -> dispose());
        add(backButton);

        setVisible(true);
    }

    private void toggleTransactionIdField() {
        boolean isBkash = paymentMethod.getSelectedItem().equals("Bkash");
        transactionIdLabel.setVisible(isBkash);
        transactionIdField.setVisible(isBkash);
    }

    private void processPayment() {
        String selectedMethod = (String) paymentMethod.getSelectedItem();

        if (selectedMethod.equals("Bkash")) {
            if (transactionIdField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Transaction ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Payment Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new UserDashboard(user); 
    }
}
