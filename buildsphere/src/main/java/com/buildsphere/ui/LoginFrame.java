package com.buildsphere.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    // BuildSphere theme
    private final Color NAVY = new Color(10, 45, 85);
    private final Color BLUE = new Color(25, 105, 220);
    private final Color GOLD = new Color(245, 170, 25);
    private final Color LIGHT = new Color(245, 248, 252);

    public LoginFrame() {

        setTitle("BuildSphere - Login");
        setSize(900, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT);

        // ================= LEFT SIDE =================
        JPanel leftPanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                // Gradient background
                GradientPaint gradient = new GradientPaint(
                        0, 0, NAVY,
                        getWidth(), getHeight(), BLUE
                );

                g2.setPaint(gradient);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Simple construction logo
                g2.setColor(GOLD);
                g2.fillOval(70, 75, 120, 120);

                g2.setColor(Color.WHITE);
                g2.fillRect(92, 125, 75, 55);

                g2.setColor(NAVY);
                g2.fillRect(103, 140, 12, 40);
                g2.fillRect(126, 135, 12, 45);
                g2.fillRect(149, 145, 12, 35);

                // Crane
                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(4));
                g2.drawLine(130, 125, 130, 70);
                g2.drawLine(130, 70, 210, 70);
                g2.drawLine(180, 70, 180, 110);

                // Brand
                g2.setFont(new Font("SansSerif", Font.BOLD, 38));
                g2.setColor(Color.WHITE);
                g2.drawString("Build", 55, 255);

                g2.setColor(GOLD);
                g2.drawString("Sphere", 160, 255);

                g2.setFont(new Font("SansSerif", Font.PLAIN, 16));
                g2.setColor(Color.WHITE);
                g2.drawString(
                        "Construction Project Management",
                        55, 290
                );

                g2.setFont(new Font("SansSerif", Font.ITALIC, 15));
                g2.drawString(
                        "\"Build Smart. Manage Better.\"",
                        75, 340
                );
            }
        };

        leftPanel.setPreferredSize(new Dimension(430, 560));

        // ================= RIGHT SIDE =================
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new GridBagLayout());

        JPanel loginCard = new JPanel();
        loginCard.setBackground(Color.WHITE);
        loginCard.setLayout(new BoxLayout(loginCard, BoxLayout.Y_AXIS));
        loginCard.setBorder(new EmptyBorder(35, 45, 35, 45));

        JLabel title = new JLabel("Welcome Back!");
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        title.setForeground(NAVY);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Login to your BuildSphere account");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitle.setForeground(Color.GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginCard.add(title);
        loginCard.add(Box.createVerticalStrut(8));
        loginCard.add(subtitle);
        loginCard.add(Box.createVerticalStrut(35));

        // Username
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        usernameField = new JTextField();
        styleField(usernameField);
        usernameField.setToolTipText("Enter username");

        loginCard.add(userLabel);
        loginCard.add(Box.createVerticalStrut(7));
        loginCard.add(usernameField);
        loginCard.add(Box.createVerticalStrut(20));

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        passLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordField = new JPasswordField();
        styleField(passwordField);
        passwordField.setToolTipText("Enter password");

        loginCard.add(passLabel);
        loginCard.add(Box.createVerticalStrut(7));
        loginCard.add(passwordField);
        loginCard.add(Box.createVerticalStrut(25));

        // Login button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(BLUE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(300, 45));
        loginButton.setMaximumSize(new Dimension(300, 45));

        loginButton.addActionListener(this::login);

        loginCard.add(loginButton);
        loginCard.add(Box.createVerticalStrut(20));

        JLabel demo = new JLabel("Demo: admin / 1234");
        demo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        demo.setForeground(Color.GRAY);
        demo.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginCard.add(demo);

        rightPanel.add(loginCard);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void styleField(JTextField field) {

        field.setFont(new Font("SansSerif", Font.PLAIN, 15));
        field.setPreferredSize(new Dimension(300, 42));
        field.setMaximumSize(new Dimension(300, 42));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(210, 218, 230), 1
                ),
                new EmptyBorder(8, 12, 8, 12)
        ));

        field.setBackground(new Color(248, 250, 253));
    }

    private void login(ActionEvent e) {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Demo login
        if (username.equals("rohit") && password.equals("Ranu@6378")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!",
                    "BuildSphere",
                    JOptionPane.INFORMATION_MESSAGE
            );

            DashboardFrame dashboard = new DashboardFrame();
            dashboard.setVisible(true);

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password!",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception ignored) {
            }

            new LoginFrame().setVisible(true);
        });
    }
}