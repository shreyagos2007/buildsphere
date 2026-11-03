package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class EquipmentFrame extends JFrame {

    public EquipmentFrame() {

        setTitle("BuildSphere - Equipment");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("EQUIPMENT MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(240, 25, 300, 35);
        panel.add(title);

        JLabel nameLabel = new JLabel("Equipment Name:");
        nameLabel.setBounds(80, 100, 120, 30);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(210, 100, 220, 30);
        panel.add(nameField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(80, 150, 120, 30);
        panel.add(typeLabel);

        JTextField typeField = new JTextField();
        typeField.setBounds(210, 150, 220, 30);
        panel.add(typeField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(80, 200, 120, 30);
        panel.add(statusLabel);

        JComboBox<String> statusBox = new JComboBox<>(
                new String[]{"Available", "In Use", "Maintenance"}
        );
        statusBox.setBounds(210, 200, 220, 30);
        panel.add(statusBox);

        JButton save = new JButton("SAVE EQUIPMENT");
        save.setBounds(210, 280, 160, 40);
        panel.add(save);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "Equipment Saved Successfully!"
                )
        );

        add(panel);
    }
}
