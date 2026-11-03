package com.buildsphere.ui;

import javax.swing.*;
import java.awt.*;

public class ReportsFrame extends JFrame {

    public ReportsFrame() {

        setTitle("BuildSphere - Reports");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(
                new GridLayout(6, 1, 10, 10)
        );

        JLabel title = new JLabel(
                "BUILDSHPERE REPORTS",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        String[] reports = {
                "Worker Report",
                "Attendance Report",
                "Material Report",
                "Equipment Report",
                "Safety Report"
        };

        for (String report : reports) {

            JButton button = new JButton(report);

            button.addActionListener(e ->
                    JOptionPane.showMessageDialog(
                            this,
                            report + " Generated!"
                    )
            );

            panel.add(button);
        }

        add(panel);
    }
}