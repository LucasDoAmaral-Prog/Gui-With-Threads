package com.presentation.dialog;

import com.presentation.shared.constants.AppConstants;
import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AboutDialog extends JDialog {
    private JFrame parent;

    public AboutDialog(JFrame parent) {
        super(parent, AppConstants.ABOUT_TITLE, true);
        this.parent = parent;
        initializeDialog();
        createComponents();
        setupEventListeners();
    }

    private void initializeDialog() {
        setSize(AppConstants.ABOUT_DIALOG_WIDTH, AppConstants.ABOUT_DIALOG_HEIGHT);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(UIConstants.DIALOG_BACKGROUND);
    }

    private void createComponents() {
        setLayout(new BorderLayout());

        JPanel mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);

        JPanel footerPanel = createFooterPanel();
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(UIConstants.PANEL_BACKGROUND);
        panel.setBorder(new EmptyBorder(UIConstants.PADDING_LARGE * 2,
                UIConstants.PADDING_LARGE * 2,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE * 2));

        // App Icon
        JLabel iconLabel = createAppIcon();
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(iconLabel);

        panel.add(Box.createVerticalStrut(UIConstants.PADDING_LARGE));

        JLabel nameLabel = new JLabel(AppConstants.APP_NAME);
        nameLabel.setFont(UIConstants.TITLE_FONT);
        nameLabel.setForeground(UIConstants.TEXT_PRIMARY);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nameLabel);

        panel.add(Box.createVerticalStrut(UIConstants.PADDING_SMALL));

        JLabel versionLabel = new JLabel("Versão " + AppConstants.APP_VERSION);
        versionLabel.setFont(UIConstants.NORMAL_FONT);
        versionLabel.setForeground(UIConstants.TEXT_SECONDARY);
        versionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(versionLabel);

        panel.add(Box.createVerticalStrut(UIConstants.PADDING_MEDIUM));

        JTextArea descArea = new JTextArea(AppConstants.APP_DESCRIPTION);
        descArea.setFont(UIConstants.NORMAL_FONT);
        descArea.setForeground(UIConstants.TEXT_PRIMARY);
        descArea.setBackground(UIConstants.PANEL_BACKGROUND);
        descArea.setEditable(false);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(descArea);

        panel.add(Box.createVerticalStrut(UIConstants.PADDING_MEDIUM));


        JLabel authorsLabel = new JLabel(AppConstants.APP_AUTHORS);
        authorsLabel.setFont(UIConstants.SMALL_FONT);
        authorsLabel.setForeground(UIConstants.TEXT_MUTED);
        authorsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(authorsLabel);

        panel.add(Box.createVerticalStrut(UIConstants.PADDING_SMALL));

        JLabel copyrightLabel = new JLabel(AppConstants.APP_COPYRIGHT);
        copyrightLabel.setFont(UIConstants.SMALL_FONT);
        copyrightLabel.setForeground(UIConstants.TEXT_MUTED);
        copyrightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(copyrightLabel);

        panel.add(Box.createVerticalStrut(UIConstants.PADDING_SMALL));

        JLabel buildLabel = new JLabel("Build: " + LocalDate.now().toString());
        buildLabel.setFont(UIConstants.SMALL_FONT);
        buildLabel.setForeground(UIConstants.TEXT_MUTED);
        buildLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buildLabel);

        return panel;
    }

    private JLabel createAppIcon() {
        int size = 64;
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(size, size, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(UIConstants.PRIMARY_COLOR);
        g2d.fillOval(4, 4, size-8, size-8);

        g2d.setColor(Color.WHITE);
        g2d.fillOval(size/2 - 4, size/4 - 2, 8, 8);
        g2d.fillOval(size/4 - 3, size*3/4 - 3, 6, 6);
        g2d.fillOval(size*3/4 - 3, size*3/4 - 3, 6, 6);

        g2d.setColor(UIConstants.SUCCESS_COLOR);
        g2d.fillOval(size/2 - 3, size/2 - 3, 6, 6);

        g2d.dispose();

        return new JLabel(new ImageIcon(img));
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(UIConstants.DIALOG_BACKGROUND);
        footerPanel.setBorder(new EmptyBorder(UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM));

        JButton okButton = new JButton("OK");
        okButton.setFont(UIConstants.NORMAL_FONT);
        okButton.setBackground(UIConstants.PRIMARY_COLOR);
        okButton.setForeground(Color.WHITE);
        okButton.setFocusPainted(false);
        okButton.setBorderPainted(false);
        okButton.setPreferredSize(new Dimension(UIConstants.BUTTON_WIDTH, UIConstants.BUTTON_HEIGHT));
        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okButton.setBackground(UIConstants.PRIMARY_COLOR.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okButton.setBackground(UIConstants.PRIMARY_COLOR);
            }
        });

        footerPanel.add(okButton);

        return footerPanel;
    }

    private void setupEventListeners() {
        findAndConfigureOKButton(getContentPane());
    }

    private void findAndConfigureOKButton(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals("OK")) {
                    button.addActionListener(e -> dispose());
                    return;
                }
            }
            if (component instanceof Container) {
                findAndConfigureOKButton((Container) component);
            }
        }
    }

    public static void showAboutDialog(JFrame parent) {
        SwingUtilities.invokeLater(() -> {
            AboutDialog dialog = new AboutDialog(parent);
            dialog.setVisible(true);
        });
    }
}
