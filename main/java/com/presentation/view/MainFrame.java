package com.presentation.view;

import com.presentation.domain.service.AnimationService;
import com.presentation.dialog.HelpDialog;
import com.presentation.dialog.AboutDialog;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private AnimatedBackgroundPanel bgPanel;

    public MainFrame() {
        initializeFrame();
        createHelpMenu();
        setupComponents();
        setVisible(true);
    }

    private void initializeFrame() {
        setTitle("Background Animado - Projeto GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void createHelpMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem helpItem = new JMenuItem("Ajuda");
        JMenuItem aboutItem = new JMenuItem("Sobre");

        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        helpItem.addActionListener(e -> HelpDialog.showHelpDialog(this));
        aboutItem.addActionListener(e -> AboutDialog.showAboutDialog(this));
    }

    private void setupComponents() {
        AnimationService animationService = new AnimationService();
        bgPanel = new AnimatedBackgroundPanel();
        add(bgPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
