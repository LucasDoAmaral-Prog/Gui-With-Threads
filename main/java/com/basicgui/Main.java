package com.basicgui;

import javax.swing.*;
import com.presentation.view.AnimatedBackgroundPanel;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Background Animado");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new AnimatedBackgroundPanel());
            frame.setVisible(true);
        });
    }
}
