package datas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;

public class Homepage implements MouseListener {
    private JFrame f;
    private JLabel lgnLabel;

    public Homepage() {
        f = new JFrame("Homepage");
        f.setSize(600, 500);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background Image
        ImageIcon bg = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\Bike.jpeg");
        Image scaledBg = bg.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        JLabel bgk = new JLabel(new ImageIcon(scaledBg));
        bgk.setBounds(0, 0, 600, 500);
        bgk.setLayout(null);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setOpaque(false);
        headerPanel.setBounds(20, 10, 400, 50);

        JLabel titleLabel = new JLabel("<html>Order delivery <br> near you</html>"); 
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        titleLabel.setForeground(new Color(255, 250, 250));
        headerPanel.add(titleLabel); 

        // Login Label
        lgnLabel = new JLabel("Login", SwingConstants.CENTER);
        lgnLabel.setBounds(450, 50, 100, 40);
        lgnLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lgnLabel.setOpaque(true);
        lgnLabel.setBackground(Color.BLACK);
        lgnLabel.setForeground(Color.WHITE);
        lgnLabel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        lgnLabel.addMouseListener(this);

        // Add components:
        bgk.add(headerPanel);
        bgk.add(lgnLabel);
		
        f.add(bgk);
        f.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lgnLabel) {
            f.setVisible(false);
            new Login();
        }
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lgnLabel) {
            lgnLabel.setBackground(Color.LIGHT_GRAY);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lgnLabel) {
            lgnLabel.setBackground(Color.WHITE);
        }
    }

    
}
