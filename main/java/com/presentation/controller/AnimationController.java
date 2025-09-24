package com.presentation.controller;

import com.basicgui.presentation.view.AnimatedBackgroundPanel;
import com.basicgui.domain.model.BackgroundPattern;

public class AnimationController {
    private AnimatedBackgroundPanel panel;
    public AnimationController(AnimatedBackgroundPanel panel) {
        this.panel = panel;
    }
    public void changePattern(String type, java.awt.Color[] colors, int speed) {
        panel.setPattern(new BackgroundPattern(type, colors, speed));
    }
}
