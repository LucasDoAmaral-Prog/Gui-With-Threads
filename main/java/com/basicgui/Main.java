package com.basicgui;

import javax.swing.*;
import com.presentation.view.AnimatedBackgroundPanel;

import com.presentation.view.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}

