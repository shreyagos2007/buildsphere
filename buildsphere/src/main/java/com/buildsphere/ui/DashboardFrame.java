package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("BuildSphere - Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Title
        JLabel title = new JLabel("BUILDSHPERE");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(330, 30, 300, 40);
        panel.add(title);

        // Subtitle
        JLabel subtitle = new JLabel("Construction Project Management System");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setBounds(275, 75, 400, 30);
        panel.add(subtitle);

        // Buttons
        JButton projectButton = new JButton("Projects");
        projectButton.setBounds(100, 150, 180, 60);
        panel.add(projectButton);
        projectButton.addActionListener(e -> {
            ProjectFrame projectFrame = new ProjectFrame();
            projectFrame.setVisible(true);
        });

        JButton workerButton = new JButton("Workers");
        workerButton.setBounds(350, 150, 180, 60);
        panel.add(workerButton);
        workerButton.addActionListener(e ->
                new WorkerFrame().setVisible(true)
        );

        JButton materialButton = new JButton("Materials");
        materialButton.setBounds(600, 150, 180, 60);
        panel.add(materialButton);
        materialButton.addActionListener(e ->
                new MaterialFrame().setVisible(true)
        );

        JButton equipmentButton = new JButton("Equipment");
        equipmentButton.setBounds(100, 250, 180, 60);
        panel.add(equipmentButton);
        equipmentButton.addActionListener(e ->
                new EquipmentFrame().setVisible(true)
        );

        JButton attendanceButton = new JButton("Attendance");
        attendanceButton.setBounds(350, 250, 180, 60);
        panel.add(attendanceButton);
        attendanceButton.addActionListener(e ->
                new AttendanceFrame().setVisible(true)
        );

        JButton dprButton = new JButton("DPR");
        dprButton.setBounds(600, 250, 180, 60);
        panel.add(dprButton);
        dprButton.addActionListener(e ->
                new DPRFrame().setVisible(true)
        );

        JButton safetyButton = new JButton("Safety Violation");
        safetyButton.setBounds(225, 350, 180, 60);
        panel.add(safetyButton);
        safetyButton.addActionListener(e ->
                new SafetyFrame().setVisible(true)
        );

        JButton reportsButton = new JButton("Reports");
        reportsButton.setBounds(475, 350, 180, 60);
        panel.add(reportsButton);
        reportsButton.addActionListener(e ->
                new ReportsFrame().setVisible(true)
        );

        add(panel);
    }
}
