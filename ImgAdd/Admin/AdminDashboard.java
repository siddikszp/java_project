package Admin;

import datas.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard implements ActionListener {
	
    private JFrame frame;

    public AdminDashboard() {
        frame = new JFrame("Admin Dashboard");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(240, 255, 240));
        frame.setLayout(null);

        // Khabar Dibo Logo image
        ImageIcon imgIcon1 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\file.png");
        Image scaledImage1 = imgIcon1.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel1 = new JLabel(new ImageIcon(scaledImage1));
        imgLabel1.setBounds(10, 5, 150, 100);

        // Welcome Image
        ImageIcon imgIcon2 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\WelcomeChief.png");
        Image scaledImage2 = imgIcon2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel imgLabel2 = new JLabel(new ImageIcon(scaledImage2));
        imgLabel2.setBounds(110, 30, 400, 150);

        // Admin icon image
        ImageIcon icon = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\AdminIcon.png");
        JLabel iconLabel = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        iconLabel.setBounds(470, 10, 100, 100);
        frame.add(iconLabel);

        //Button 
        JButton btnManageUsers = new JButton("Manage Users");
        btnManageUsers.setBounds(200, 200, 220, 40); 
        btnManageUsers.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnManageUsers.addActionListener(this);
        frame.add(btnManageUsers);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(270, 300, 100, 30);
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        exitButton.addActionListener(e -> System.exit(0));

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(270, 345, 100, 30);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        backButton.addActionListener(e -> {
            frame.dispose();
            new Login();
        });

        // Adding Components to Frame
        frame.add(exitButton);
        frame.add(backButton);
        frame.add(imgLabel1);
        frame.add(imgLabel2);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Manage Users")) {
                frame.dispose();
                new ManageUsers();
            }
        }
    }
}

