package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class SafetyFrame extends JFrame {

    public SafetyFrame() {

        setTitle("BuildSphere - Safety");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("SAFETY VIOLATION");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(270, 25, 300, 35);
        panel.add(title);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(80, 100, 120, 30);
        panel.add(categoryLabel);

        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{"PPE", "Electrical", "Fall Risk", "Other"}
        );
        categoryBox.setBounds(200, 100, 220, 30);
        panel.add(categoryBox);

        JLabel severityLabel = new JLabel("Severity:");
        severityLabel.setBounds(80, 150, 120, 30);
        panel.add(severityLabel);

        JComboBox<String> severityBox = new JComboBox<>(
                new String[]{"Low", "Medium", "High"}
        );
        severityBox.setBounds(200, 150, 220, 30);
        panel.add(severityBox);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(80, 200, 120, 30);
        panel.add(descriptionLabel);

        JTextArea descriptionArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(descriptionArea);
        scroll.setBounds(200, 200, 400, 80);
        panel.add(scroll);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(80, 310, 120, 30);
        panel.add(statusLabel);

        JComboBox<String> statusBox = new JComboBox<>(
                new String[]{"Open", "In Progress", "Closed"}
        );
        statusBox.setBounds(200, 310, 220, 30);
        panel.add(statusBox);

        JButton save = new JButton("SAVE VIOLATION");
        save.setBounds(250, 380, 160, 40);
        panel.add(save);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "Safety Violation Saved!"
                )
        );

        add(panel);
    }
}
