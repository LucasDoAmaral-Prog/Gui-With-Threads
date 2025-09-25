package com.presentation.view;

import com.presentation.domain.service.AnimationService;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        initializeFrame();
        setupComponents();
    }

    private void initializeFrame() {
        setTitle("Background Animado - Projeto GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void setupComponents() {
        // Aqui você coloca o código que estava fora da classe
        AnimationService animationService = new AnimationService();
        AnimatedBackgroundPanel bgPanel = new AnimatedBackgroundPanel();
        add(bgPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
