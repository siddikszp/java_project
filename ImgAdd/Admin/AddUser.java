package Admin;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddUser implements ActionListener {
    private JFrame addUserFrame;
    private JTextField userName, userEmail, userPhone;
    private JPasswordField userPass, userConfirmPass;
    private JComboBox<String> genderBox, locationBox;
    private JButton submitBtn, backBtn;

    public AddUser() {
		
        addUserFrame = new JFrame("Add User");
        addUserFrame.setSize(600, 500);
        addUserFrame.setLocationRelativeTo(null);
        addUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addUserFrame.getContentPane().setBackground(new Color(240, 255, 240));
        addUserFrame.setLayout(null);

        // AddUser Image
        ImageIcon imgIcon = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\AddUsers.png");
        Image scaledImage2 = imgIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel regImg = new JLabel(new ImageIcon(scaledImage2));
        regImg.setBounds(140, 10, 150, 80);
        addUserFrame.add(regImg);

        // Khabar Dibo Logo
        ImageIcon imgIcon1 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\file.png");
        Image scaledImage1 = imgIcon1.getImage().getScaledInstance(230, 130, Image.SCALE_SMOOTH);
        JLabel imgLabel1 = new JLabel(new ImageIcon(scaledImage1));
        imgLabel1.setBounds(5, 0, 150, 100);
        addUserFrame.add(imgLabel1);

        // Labels and Fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        nameLabel.setBounds(40, 90, 100, 30);
        addUserFrame.add(nameLabel);

        userName = new JTextField();
        userName.setBounds(150, 90, 150, 30);
        addUserFrame.add(userName);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        emailLabel.setBounds(40, 130, 100, 30);
        addUserFrame.add(emailLabel);

        userEmail = new JTextField();
        userEmail.setBounds(150, 130, 150, 30);
        addUserFrame.add(userEmail);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        phoneLabel.setBounds(40, 170, 100, 30);
        addUserFrame.add(phoneLabel);

        userPhone = new JTextField();
        userPhone.setBounds(150, 170, 150, 30);
        addUserFrame.add(userPhone);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        passLabel.setBounds(40, 210, 100, 30);
        addUserFrame.add(passLabel);

        userPass = new JPasswordField();
        userPass.setBounds(150, 210, 150, 30);
        addUserFrame.add(userPass);

        JLabel confirmPassLabel = new JLabel("<html>Confirm <br> Password :</html>");
        confirmPassLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        confirmPassLabel.setBounds(40, 250, 150, 30);
        addUserFrame.add(confirmPassLabel);

        userConfirmPass = new JPasswordField();
        userConfirmPass.setBounds(150, 250, 150, 30);
        addUserFrame.add(userConfirmPass);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        genderLabel.setBounds(40, 290, 150, 30);
        addUserFrame.add(genderLabel);

        String[] genders = {"Male", "Female", "Rather not say"};
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(150, 290, 150, 30);
        addUserFrame.add(genderBox);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        locationLabel.setBounds(40, 330, 150, 30);
        addUserFrame.add(locationLabel);

        String[] locations = {"Basundhara", "Baridhara", "Badda", "Banasree", "Khilkhet", "Konapara", "Demra"};
        locationBox = new JComboBox<>(locations);
        locationBox.setBounds(150, 330, 150, 30);
        addUserFrame.add(locationBox);

        // Buttons
        submitBtn = new JButton("Update");
        submitBtn.setBounds(40, 390, 100, 30);
        submitBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        submitBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        submitBtn.addActionListener(this);
        addUserFrame.add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(180, 390, 100, 30);
        backBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        backBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        backBtn.addActionListener(this);
        addUserFrame.add(backBtn);

        addUserFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = userName.getText().trim();
            String email = userEmail.getText().trim();
            String phone = userPhone.getText().trim();
            String password = new String(userPass.getPassword()).trim();
            String confirmPassword = new String(userConfirmPass.getPassword()).trim();
            String gender = (String) genderBox.getSelectedItem();
            String location = (String) locationBox.getSelectedItem();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(addUserFrame, "All fields are required!");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(addUserFrame, "Passwords do not match!");
            } else {
                saveUserData(name, email, phone, password, gender, location);
                JOptionPane.showMessageDialog(addUserFrame, "User Added Successfully!");
                addUserFrame.dispose();
                new ManageUsers();
            }
        } else if (e.getSource() == backBtn) {
            addUserFrame.dispose();
            new ManageUsers();
        }
    }

    private void saveUserData(String name, String email, String phone, String password, String gender, String location) {
        try (FileWriter writer = new FileWriter("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\userdata.txt", true)) {
            writer.write(name + "," + email + "," + phone + "," + password + "," + gender + "," + location + "\n");
        } catch (IOException ie) {
            JOptionPane.showMessageDialog(addUserFrame, "Error saving user data!");
            ie.printStackTrace();
        }
    }
}
