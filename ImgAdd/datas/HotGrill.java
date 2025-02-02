package datas;

import Entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HotGrill {
    private JFrame frame;
    private ArrayList<Double> orderList = new ArrayList<>();
    private User user;

    public HotGrill(User user) {
        this.user = user;
        frame = new JFrame("HOT GRILL");
        frame.setSize(700, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(240, 255, 240));

        JLabel aLabel = new JLabel("Available Food Items:");
        aLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        aLabel.setBounds(200, 30, 250, 30);
        frame.add(aLabel);

        String[] foodNames = {"Sandwich", "Burger", "Hot Wings", "Corn Soup", "Chicken Nuggets", "Rice Bowl"};
        double[] prices = {5.9, 6.7, 5.3, 2.8, 3.1, 8.0};

        int startX = 50, startY = 80;
        for (int i = 0; i < foodNames.length; i++) {
            JLabel foodLabel = new JLabel(foodNames[i] + " - $" + prices[i]);
            foodLabel.setFont(new Font("Arial", Font.BOLD, 14));
            foodLabel.setBounds(startX, startY, 250, 40);
            frame.add(foodLabel);

            JButton orderButton = new JButton("Add to Cart");
            orderButton.setBounds(startX + 260, startY, 120, 30);
            int finalI = i;
            orderButton.addActionListener(e -> {
                orderList.add(prices[finalI]);
                JOptionPane.showMessageDialog(frame, foodNames[finalI] + " added to cart!");
            });
            frame.add(orderButton);

            startY += 50;
        }

        JButton checkoutButton = new JButton("Proceed to Payment");
        checkoutButton.setBounds(220, 400, 180, 30);
        checkoutButton.addActionListener(e -> {
            double total = orderList.stream().mapToDouble(Double::doubleValue).sum();
            frame.dispose();
            new PaymentDashboard(user, total);
        });
        frame.add(checkoutButton);

        JButton backButton = new JButton("Back to Dashboard");
        backButton.setBounds(220, 440, 180, 30);
        backButton.addActionListener(e -> {
            frame.dispose();
            new UserDashboard(user);
        });
        frame.add(backButton);

        frame.setVisible(true);
    }
}
