package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class MaterialFrame extends JFrame {

    public MaterialFrame() {

        setTitle("BuildSphere - Materials");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("MATERIAL MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(230, 25, 300, 35);
        panel.add(title);

        JLabel nameLabel = new JLabel("Material Name:");
        nameLabel.setBounds(80, 100, 120, 30);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 220, 30);
        panel.add(nameField);

        JLabel unitLabel = new JLabel("Unit:");
        unitLabel.setBounds(80, 150, 120, 30);
        panel.add(unitLabel);

        JComboBox<String> unitBox = new JComboBox<>(
                new String[]{"Bag", "Kg", "Ton", "CFT", "Piece"}
        );
        unitBox.setBounds(200, 150, 220, 30);
        panel.add(unitBox);

        JLabel stockLabel = new JLabel("Minimum Stock:");
        stockLabel.setBounds(80, 200, 120, 30);
        panel.add(stockLabel);

        JTextField stockField = new JTextField();
        stockField.setBounds(200, 200, 220, 30);
        panel.add(stockField);

        JButton save = new JButton("SAVE MATERIAL");
        save.setBounds(200, 280, 150, 40);
        panel.add(save);

        JButton clear = new JButton("CLEAR");
        clear.setBounds(370, 280, 100, 40);
        panel.add(clear);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "Material Saved Successfully!"
                )
        );

        clear.addActionListener(e -> {
            nameField.setText("");
            stockField.setText("");
            unitBox.setSelectedIndex(0);
        });

        add(panel);
    }
}
