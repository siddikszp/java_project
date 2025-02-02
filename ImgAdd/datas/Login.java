package datas;

import Admin.AdminDashboard;
import Entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login implements ActionListener {
    private JFrame frame;
    private JTextField uName;
    private JPasswordField pass;

    public Login() {
        frame = new JFrame("Login");
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(240, 255, 240));

        //Lau Menu,Login Panel
        JPanel pan1 = new JPanel() {
         private Image backgroundImage = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\LẤU _ Menu Shooting.jpeg").getImage();
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
              if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        pan1.setBounds(315, 0, 270, 500);
        pan1.setLayout(null);

        // Welcome Image
        ImageIcon imgIcon3 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\welcome (2).png");
        Image scaledImage3 = imgIcon3.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel3 = new JLabel(new ImageIcon(scaledImage3));
        imgLabel3.setBounds(10, 80, 290, 100);
				
        //Khabar Dibo Logo
        ImageIcon imgIcon1 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\file.png");
        Image scaledImage1 = imgIcon1.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel1 = new JLabel(new ImageIcon(scaledImage1));
        imgLabel1.setBounds(10, 05, 150, 100);
		
		// Bike
        ImageIcon imgIcon2 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\.png");
        Image scaledImage2 = imgIcon2.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        JLabel imgLabel2 = new JLabel(new ImageIcon(scaledImage2));
        imgLabel2.setBounds(110, 20, 300, 100);

        // Components
        JLabel uLabel = new JLabel("Username:");
        uLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        uLabel.setBounds(50, 180, 100, 30);

        uName = new JTextField();
        uName.setBounds(50, 210, 200, 30);

        JLabel pLabel = new JLabel("Password:");
        pLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pLabel.setBounds(50, 250, 100, 30);

        pass = new JPasswordField();
        pass.setBounds(50, 280, 200, 30);

        JButton lgnButton = new JButton("Login");
        lgnButton.setBounds(50, 350, 100, 30);
        lgnButton.addActionListener(this);

        JButton regButton = new JButton("Register");
        regButton.setBounds(170, 350, 100, 30);
        regButton.addActionListener(this);

        JButton extButton = new JButton("Exit");
        extButton.setBounds(50, 400, 100, 30);
        extButton.addActionListener(this);

        // Adding Components to Frame
        frame.add(uLabel);
        frame.add(uName);
        frame.add(pLabel);
        frame.add(pass);
        frame.add(lgnButton);
        frame.add(regButton);
        frame.add(extButton);
        frame.add(imgLabel3);
        frame.add(imgLabel2);
        frame.add(imgLabel1);
        frame.add(pan1);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source.getText().equals("Login")) {
            handleLogin();
        } else if (source.getText().equals("Register")) {
            frame.dispose();
            new Registration();
        } else if (source.getText().equals("Exit")) {
            System.exit(0);
        }
    }

    private void handleLogin() {
        String username = uName.getText().trim();
        String password = new String(pass.getPassword()).trim();

        // Admin Login
        if (username.equals("111") && password.equals("111")) {
            JOptionPane.showMessageDialog(frame, "Successfully logged in!");
            frame.dispose();
            new AdminDashboard();
            return;
        }

        // User Authentication
        User user = authenticateUser(username, password);
        if (user != null) {
            JOptionPane.showMessageDialog(frame, "Successfully logged in!");
            frame.dispose();
            new UserDashboard(user);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
        }
    }

    private User authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\userdata.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6 && parts[0].trim().equals(username) && parts[3].trim().equals(password)) {
                    return new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error reading user data!");
        }
        return null;
    }
}
