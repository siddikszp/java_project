package datas;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Registration implements ActionListener {
    private JFrame regFrame;
    private JTextField regName, regEmail, phoneNum;
    private JPasswordField regPass, regConfirmPass;
    private JButton submitBtn, backBtn;
    private JComboBox<String> genderBox, locationBox;

    public Registration() {
        regFrame = new JFrame("Register");
        regFrame.setSize(600, 500);
        regFrame.setLocationRelativeTo(null);
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.getContentPane().setBackground(new Color(240, 255, 240));
        regFrame.setLayout(null);

        //Components
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        nameLabel.setBounds(40, 90, 100, 30);
        regFrame.add(nameLabel);

        regName = new JTextField();
        regName.setBounds(150, 90, 150, 30);
        regFrame.add(regName);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        emailLabel.setBounds(40, 130, 100, 30);
        regFrame.add(emailLabel);

        regEmail = new JTextField();
        regEmail.setBounds(150, 130, 150, 30);
        regFrame.add(regEmail);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        phoneLabel.setBounds(40, 170, 100, 30);
        regFrame.add(phoneLabel);

        phoneNum = new JTextField();
        phoneNum.setBounds(150, 170, 150, 30);
        regFrame.add(phoneNum);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        passLabel.setBounds(40, 210, 100, 30);
        regFrame.add(passLabel);

        regPass = new JPasswordField();
        regPass.setBounds(150, 210, 150, 30);
        regFrame.add(regPass);

        JLabel confirmPassLabel = new JLabel("<html>Confirm <br> Password :</html>");
        confirmPassLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        confirmPassLabel.setBounds(40, 250, 150, 30);
        regFrame.add(confirmPassLabel);

        regConfirmPass = new JPasswordField();
        regConfirmPass.setBounds(150, 250, 150, 30);
        regFrame.add(regConfirmPass);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        genderLabel.setBounds(40, 290, 150, 30);
        regFrame.add(genderLabel);

        String[] genders = {"Male", "Female", "Rather not say"};
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(150, 290, 150, 30);
        regFrame.add(genderBox);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        locationLabel.setBounds(40, 330, 150, 30);
        regFrame.add(locationLabel);

        String[] locations = {"Basundhara", "Baridhara", "Badda", "Banasree", "Khilkhet", "Konapara", "Demra"};
        locationBox = new JComboBox<>(locations);
        locationBox.setBounds(150, 330, 150, 30);
        regFrame.add(locationBox);

        // Buttons
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(40, 390, 100, 30);
        submitBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        submitBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        submitBtn.addActionListener(this);
        regFrame.add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(180, 390, 100, 30);
        backBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        backBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        backBtn.addActionListener(this);
        regFrame.add(backBtn);

        //RegisterLogo Image
        ImageIcon imgIcon = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\RegisterLogo.png");
        Image scaledImage2 = imgIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel regImg = new JLabel(new ImageIcon(scaledImage2));
        regImg.setBounds(30, 5, 100, 80);
        regFrame.add(regImg);
        
		//BurgerLogo
        ImageIcon imgIcon1 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\BurgerLogo.png");
        Image scaledImage3 = imgIcon1.getImage().getScaledInstance(270, 270, Image.SCALE_SMOOTH);
        JLabel sideImg = new JLabel(new ImageIcon(scaledImage3));
        sideImg.setBounds(300, 50, 300, 160);
        regFrame.add(sideImg);
        
		//BiriyaniLogo
        ImageIcon imgIcon2 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\BiriyaniImg.png");
        Image scaledImage4 = imgIcon2.getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH);
        JLabel sideAnotherImg = new JLabel(new ImageIcon(scaledImage4));
        sideAnotherImg.setBounds(300, 220, 300, 160);
        regFrame.add(sideAnotherImg);

        regFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = regName.getText().trim();
            String email = regEmail.getText().trim();
            String phone = phoneNum.getText().trim();
            String password = new String(regPass.getPassword()).trim();
            String confirmPassword = new String(regConfirmPass.getPassword()).trim();
            String gender = (String) genderBox.getSelectedItem();
            String location = (String) locationBox.getSelectedItem();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(regFrame, "All fields are required!");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(regFrame, "Oho!Passwords do not match");
            } else {
                saveUserData(name, email, phone, password, gender, location);
                JOptionPane.showMessageDialog(regFrame, "Successfully registered!!");
                regFrame.dispose();
                new Login();
            }
        } else if (e.getSource() == backBtn) {
            regFrame.dispose();
            new Login();
        }
    }

    private void saveUserData(String name, String email, String phone, String password, String gender, String location) {
        try (FileWriter writer = new FileWriter("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\userdata.txt", true)) {
            writer.write(name + "," + email + "," + phone + "," + password + "," + gender + "," + location + "\n");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
