package Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ManageUsers implements ActionListener {
    private JFrame frame;
    private JTable userTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton addUserButton, editUserButton, deleteUserButton, backButton;

    public ManageUsers() {
        frame = new JFrame("Manage Users");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(240, 255, 240));
        frame.setLayout(null);

        // Khabar Dibo Logo
        ImageIcon imgIcon1 = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\file.png");
        Image scaledImage1 = imgIcon1.getImage().getScaledInstance(230, 130, Image.SCALE_SMOOTH);
        JLabel imgLabel1 = new JLabel(new ImageIcon(scaledImage1));
        imgLabel1.setBounds(10, 0, 150, 100);
        frame.add(imgLabel1);

        // Title Label
        JLabel titleLabel = new JLabel("USER DETAILS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(300, 50, 200, 30);
        frame.add(titleLabel);

        // Image icon
        ImageIcon icon = new ImageIcon("C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\Image\\UsersIcon.png");
        JLabel iconLabel = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        iconLabel.setBounds(570, 10, 100, 100);
        frame.add(iconLabel);

        // Table Headers
        String[] columns = {"Name", "Email", "Phone", "Gender", "Location"};
        tableModel = new DefaultTableModel(columns, 0);
        userTable = new JTable(tableModel);
        scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(50, 100, 600, 150);
        frame.add(scrollPane);

        loadUserData();

        // Buttons
        addUserButton = new JButton("Add User");
        addUserButton.setBounds(150, 280, 150, 30);
        addUserButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        addUserButton.addActionListener(this);
        frame.add(addUserButton);

        editUserButton = new JButton("Edit Email");
        editUserButton.setBounds(320, 280, 150, 30);
        editUserButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        editUserButton.addActionListener(this);
        frame.add(editUserButton);

        deleteUserButton = new JButton("Delete User");
        deleteUserButton.setBounds(490, 280, 150, 30);
        deleteUserButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        deleteUserButton.addActionListener(this);
        frame.add(deleteUserButton);

        // Back button
        backButton = new JButton("Back");
        backButton.setBounds(320, 350, 100, 30);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        backButton.addActionListener(e -> {
            frame.dispose();
            new AdminDashboard();
        });
        frame.add(backButton);

        frame.setVisible(true);
    }

    private void loadUserData() {
        String filePath = "C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\userdata.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            tableModel.setRowCount(0); 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) { 
                    tableModel.addRow(new String[]{parts[0], parts[1], parts[2], parts[4], parts[5]});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error loading user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addUserButton) {
            frame.dispose();
            new AddUser();
        } else if (e.getSource() == editUserButton) {
            editSelectedUser();
        } else if (e.getSource() == deleteUserButton) {
            deleteSelectedUser();
        }
    }

    private void editSelectedUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a user to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = (String) tableModel.getValueAt(selectedRow, 0);
        String email = (String) tableModel.getValueAt(selectedRow, 1);
        String phone = (String) tableModel.getValueAt(selectedRow, 2);
        String gender = (String) tableModel.getValueAt(selectedRow, 3);
        String location = (String) tableModel.getValueAt(selectedRow, 4);

        String newEmail = JOptionPane.showInputDialog(frame, "Enter new email:", email);
        if (newEmail != null && !newEmail.trim().isEmpty()) {
            tableModel.setValueAt(newEmail, selectedRow, 1);
            updateUserData(name, email, phone, newEmail, gender, location);
        }
    }

    private void deleteSelectedUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = (String) tableModel.getValueAt(selectedRow, 0);
        String email = (String) tableModel.getValueAt(selectedRow, 1);
        tableModel.removeRow(selectedRow);
        deleteUserFromFile(name, email);
        JOptionPane.showMessageDialog(frame, "User deleted successfully.");
    }

    private void updateUserData(String name, String oldEmail, String phone, String newEmail, String gender, String location) {
        String filePath = "C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\userdata.txt";
        List<String> updatedUsers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6 && parts[0].equals(name) && parts[1].equals(oldEmail)) {
                    parts[1] = newEmail;
                }
                updatedUsers.add(String.join(",", parts));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error updating user data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileWriter writer = new FileWriter(filePath, false)) {
            for (String user : updatedUsers) {
                writer.write(user + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving updated user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUserFromFile(String name, String email) {
        String filePath = "C:\\Users\\AB Siddik\\OneDrive - American International University-Bangladesh\\Desktop\\ImgAdd\\userdata.txt";
        List<String> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!(parts.length >= 6 && parts[0].equals(name) && parts[1].equals(email))) {
                    users.add(line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error deleting user!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileWriter writer = new FileWriter(filePath, false)) {
            for (String user : users) {
                writer.write(user + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving updated user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
