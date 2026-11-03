package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class ProjectFrame extends JFrame {

    public ProjectFrame() {

        setTitle("BuildSphere - Projects");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("PROJECT MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(270, 25, 300, 35);
        panel.add(title);

        JLabel nameLabel = new JLabel("Project Name:");
        nameLabel.setBounds(80, 100, 120, 30);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 220, 30);
        panel.add(nameField);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(80, 150, 120, 30);
        panel.add(locationLabel);

        JTextField locationField = new JTextField();
        locationField.setBounds(200, 150, 220, 30);
        panel.add(locationField);

        JLabel startLabel = new JLabel("Start Date:");
        startLabel.setBounds(80, 200, 120, 30);
        panel.add(startLabel);

        JTextField startField = new JTextField();
        startField.setBounds(200, 200, 220, 30);
        panel.add(startField);

        JLabel endLabel = new JLabel("End Date:");
        endLabel.setBounds(80, 250, 120, 30);
        panel.add(endLabel);

        JTextField endField = new JTextField();
        endField.setBounds(200, 250, 220, 30);
        panel.add(endField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(80, 300, 120, 30);
        panel.add(statusLabel);

        JComboBox<String> statusBox = new JComboBox<>(
                new String[]{"Planned", "Ongoing", "Completed", "Cancelled"}
        );
        statusBox.setBounds(200, 300, 220, 30);
        panel.add(statusBox);

        JButton saveButton = new JButton("SAVE PROJECT");
        saveButton.setBounds(200, 360, 150, 40);
        panel.add(saveButton);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setBounds(370, 360, 100, 40);
        panel.add(clearButton);

        saveButton.addActionListener(e -> {

            String name = nameField.getText();
            String location = locationField.getText();

            if (name.isEmpty() || location.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Project Name and Location."
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Project Saved Successfully!"
                );
            }
        });

        clearButton.addActionListener(e -> {
            nameField.setText("");
            locationField.setText("");
            startField.setText("");
            endField.setText("");
            statusBox.setSelectedIndex(0);
        });

        add(panel);
    }
}
