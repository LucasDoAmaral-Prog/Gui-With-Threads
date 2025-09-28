package com.presentation.controller;

import com.presentation.dialog.PatternConfigDialog;
import com.presentation.dialog.ColorConfigDialog;
import com.presentation.dialog.SpeedConfigDialog;
import com.presentation.view.AnimatedBackgroundPanel;

import javax.swing.*;

public class ConfigController {

    private JFrame parentFrame;
    private AnimatedBackgroundPanel backgroundPanel;

    public ConfigController(JFrame parentFrame, AnimatedBackgroundPanel backgroundPanel) {
        this.parentFrame = parentFrame;
        this.backgroundPanel = backgroundPanel;
    }

    public void configurePattern() {
        // Passa o pattern atual
        PatternConfigDialog dialog = new PatternConfigDialog(parentFrame, backgroundPanel.getCurrentPattern());
        dialog.setVisible(true);

        String pattern = dialog.getSelectedPattern();
        if (pattern != null) {
            backgroundPanel.setPattern(pattern);
        }
    }

    public void configureColor() {
        ColorConfigDialog dialog = new ColorConfigDialog(parentFrame, backgroundPanel.getCurrentColorScheme());
        dialog.setVisible(true);

        String scheme = dialog.getSelectedScheme();
        if (scheme != null) {
            backgroundPanel.setColorScheme(scheme);
        }
    }

    public void configureSpeed() {
        SpeedConfigDialog dialog = new SpeedConfigDialog(parentFrame, backgroundPanel.getCurrentSpeed());
        dialog.setVisible(true);

        String speed = dialog.getSelectedSpeed();
        if (speed != null) {
            backgroundPanel.setSpeed(speed);
        }
    }
}