package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class WorkerFrame extends JFrame {

    public WorkerFrame() {

        setTitle("BuildSphere - Workers");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("WORKER MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(240, 25, 300, 35);
        panel.add(title);

        JLabel nameLabel = new JLabel("Worker Name:");
        nameLabel.setBounds(80, 100, 120, 30);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 220, 30);
        panel.add(nameField);

        JLabel tradeLabel = new JLabel("Trade:");
        tradeLabel.setBounds(80, 150, 120, 30);
        panel.add(tradeLabel);

        JTextField tradeField = new JTextField();
        tradeField.setBounds(200, 150, 220, 30);
        panel.add(tradeField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(80, 200, 120, 30);
        panel.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(200, 200, 220, 30);
        panel.add(phoneField);

        JLabel wageLabel = new JLabel("Daily Wage:");
        wageLabel.setBounds(80, 250, 120, 30);
        panel.add(wageLabel);

        JTextField wageField = new JTextField();
        wageField.setBounds(200, 250, 220, 30);
        panel.add(wageField);

        JButton save = new JButton("SAVE WORKER");
        save.setBounds(200, 320, 150, 40);
        panel.add(save);

        JButton clear = new JButton("CLEAR");
        clear.setBounds(370, 320, 100, 40);
        panel.add(clear);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "Worker Saved Successfully!"
                )
        );

        clear.addActionListener(e -> {
            nameField.setText("");
            tradeField.setText("");
            phoneField.setText("");
            wageField.setText("");
        });

        add(panel);
    }
}