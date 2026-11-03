package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class DPRFrame extends JFrame {

    public DPRFrame() {

        setTitle("BuildSphere - Daily Progress Report");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("DAILY PROGRESS REPORT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(250, 25, 350, 35);
        panel.add(title);

        JLabel dateLabel = new JLabel("Report Date:");
        dateLabel.setBounds(80, 90, 120, 30);
        panel.add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(200, 90, 220, 30);
        panel.add(dateField);

        JLabel workLabel = new JLabel("Work Done:");
        workLabel.setBounds(80, 140, 120, 30);
        panel.add(workLabel);

        JTextArea workArea = new JTextArea();
        workArea.setLineWrap(true);

        JScrollPane workScroll = new JScrollPane(workArea);
        workScroll.setBounds(200, 140, 400, 80);
        panel.add(workScroll);

        JLabel manpowerLabel = new JLabel("Manpower:");
        manpowerLabel.setBounds(80, 250, 120, 30);
        panel.add(manpowerLabel);

        JTextField manpowerField = new JTextField();
        manpowerField.setBounds(200, 250, 220, 30);
        panel.add(manpowerField);

        JLabel issueLabel = new JLabel("Issues:");
        issueLabel.setBounds(80, 300, 120, 30);
        panel.add(issueLabel);

        JTextArea issueArea = new JTextArea();
        JScrollPane issueScroll = new JScrollPane(issueArea);
        issueScroll.setBounds(200, 300, 400, 70);
        panel.add(issueScroll);

        JButton save = new JButton("SAVE DPR");
        save.setBounds(280, 400, 140, 40);
        panel.add(save);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "DPR Saved Successfully!"
                )
        );

        add(panel);
    }
}
