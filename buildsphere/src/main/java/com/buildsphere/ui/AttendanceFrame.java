package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class AttendanceFrame extends JFrame {

    public AttendanceFrame() {

        setTitle("BuildSphere - Attendance");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("WORKER ATTENDANCE");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(250, 25, 300, 35);
        panel.add(title);

        JLabel workerLabel = new JLabel("Worker ID:");
        workerLabel.setBounds(100, 100, 120, 30);
        panel.add(workerLabel);

        JTextField workerField = new JTextField();
        workerField.setBounds(220, 100, 220, 30);
        panel.add(workerField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(100, 150, 120, 30);
        panel.add(dateLabel);

        JTextField dateField = new JTextField("DD-MM-YYYY");
        dateField.setBounds(220, 150, 220, 30);
        panel.add(dateField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(100, 200, 120, 30);
        panel.add(statusLabel);

        JComboBox<String> statusBox = new JComboBox<>(
                new String[]{"Present", "Absent", "Leave"}
        );
        statusBox.setBounds(220, 200, 220, 30);
        panel.add(statusBox);

        JButton save = new JButton("SAVE ATTENDANCE");
        save.setBounds(220, 270, 170, 40);
        panel.add(save);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "Attendance Saved Successfully!"
                )
        );

        add(panel);
    }
}
