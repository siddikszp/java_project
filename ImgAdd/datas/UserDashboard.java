package datas;

import Entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserDashboard {
    private JFrame frame;

    public UserDashboard(User user) {
        frame = new JFrame("User Dashboard");
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(240, 255, 240));

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getName() + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBounds(380, 5, 300, 50);
        frame.add(welcomeLabel);

        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        emailLabel.setBounds(390, 30, 300, 50);
        frame.add(emailLabel);

        JLabel aLabel = new JLabel("Available Restaurants:");
        aLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        aLabel.setBounds(20, 130, 200, 30);
        frame.add(aLabel);

        // Khabar Dibo Logo
        ImageIcon imgIcon1 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\file.png");
        Image scaledImage1 = imgIcon1.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel1 = new JLabel(new ImageIcon(scaledImage1));
        imgLabel1.setBounds(10, 5, 150, 100);
        frame.add(imgLabel1);

        // Res01 - Hot Grill
        ImageIcon imgIcon2 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\Res01.png");
        Image scaledImage2 = imgIcon2.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel2 = new JLabel(new ImageIcon(scaledImage2));
        imgLabel2.setBounds(20, 180, 150, 100);
        frame.add(imgLabel2);

        // Res02 - Takeaway Foods
        ImageIcon imgIcon3 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\Res02.png");
        Image scaledImage3 = imgIcon3.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel3 = new JLabel(new ImageIcon(scaledImage3));
        imgLabel3.setBounds(200, 180, 150, 100);
        frame.add(imgLabel3);

        // Res03 - Chef Master
        ImageIcon imgIcon4 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\Res03.png");
        Image scaledImage4 = imgIcon4.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel4 = new JLabel(new ImageIcon(scaledImage4));
        imgLabel4.setBounds(380, 180, 150, 100);
        frame.add(imgLabel4);

        // Hot Grill Label 
        JLabel hg = new JLabel("HOT GRILL");
        hg.setFont(new Font("Times New Roman", Font.BOLD, 12));
        hg.setBounds(30, 300, 200, 30);
        hg.setForeground(Color.BLUE);
        hg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new HotGrill(user);
            }
        });
        frame.add(hg);

        // Takeaway Foods Label 
        JLabel tf = new JLabel("TAKEAWAY FOODS");
        tf.setFont(new Font("Times New Roman", Font.BOLD, 12));
        tf.setBounds(200, 300, 200, 30);
        tf.setForeground(Color.BLUE);
        tf.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tf.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new TakeAway(user);
            }
        });
        frame.add(tf);

        // Chef Master Label 
        JLabel cm = new JLabel("CHEF MASTER");
        cm.setFont(new Font("Times New Roman", Font.BOLD, 12));
        cm.setBounds(385, 300, 200, 30);
        cm.setForeground(Color.BLUE);
        cm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new ChefMaster(user);
            }
        });
        frame.add(cm);

        frame.setVisible(true);
		
		JButton backButton = new JButton("Back");
        backButton.setBounds(230, 350, 100, 30); 
        backButton.addActionListener(e -> {
            frame.dispose();
            new Login();
        });
        frame.add(backButton);

        frame.setVisible(true);
    }
}
