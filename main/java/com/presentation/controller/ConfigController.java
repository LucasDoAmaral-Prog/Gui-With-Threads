package com.presentation.controller;

import com.presentation.dialog.PatternConfigDialog;
import com.presentation.dialog.ColorConfigDialog;
import com.presentation.dialog.SpeedConfigDialog;
import com.presentation.shared.constants.AnimationConstants;
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
        // Passa o índice atual
        int currentIndex = getPatternIndex(backgroundPanel.getCurrentPattern());
        PatternConfigDialog dialog = new PatternConfigDialog(parentFrame, currentIndex);
        dialog.setVisible(true);

        Integer selectedIndex = dialog.getSelectedIndex();
        if (selectedIndex != null) {
            backgroundPanel.setPatternIndex(selectedIndex);
        }
    }

    public void configureColor() {
        int currentIndex = getColorIndex(backgroundPanel.getCurrentColorScheme());
        ColorConfigDialog dialog = new ColorConfigDialog(parentFrame, currentIndex);
        dialog.setVisible(true);

        Integer selectedIndex = dialog.getSelectedIndex();
        if (selectedIndex != null) {
            backgroundPanel.setColorSchemeIndex(selectedIndex);
        }
    }

    public void configureSpeed() {
        int currentIndex = getSpeedIndex(backgroundPanel.getCurrentSpeed());
        SpeedConfigDialog dialog = new SpeedConfigDialog(parentFrame, currentIndex);
        dialog.setVisible(true);

        Integer selectedIndex = dialog.getSelectedIndex();
        if (selectedIndex != null) {
            backgroundPanel.setSpeedIndex(selectedIndex);
        }
    }

    // =================== MÉTODOS AUXILIARES ===================
    private int getPatternIndex(String pattern) {
        for (int i = 0; i < AnimationConstants.PATTERN_OPTIONS.length; i++) {
            if (AnimationConstants.PATTERN_OPTIONS[i].equals(pattern)) return i;
        }
        return 0;
    }

    private int getColorIndex(String color) {
        for (int i = 0; i < AnimationConstants.COLOR_OPTIONS.length; i++) {
            if (AnimationConstants.COLOR_OPTIONS[i].equals(color)) return i;
        }
        return 0;
    }

    private int getSpeedIndex(String speed) {
        for (int i = 0; i < AnimationConstants.SPEED_OPTIONS.length; i++) {
            if (AnimationConstants.SPEED_OPTIONS[i].equals(speed)) return i;
        }
        return 1; // normal
    }
}
