package com.presentation.domain.model;

import java.awt.Color;

public class BackgroundPattern {
    private String type;
    private Color[] colors;
    private int speed;

    public BackgroundPattern(String type, Color[] colors, int speed) {
        this.type = type;
        this.colors = colors;
        this.speed = speed;
    }

    // Getters
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("BackgroundPattern{type='%s', colors=%d, speed=%d}",
                type, colors.length, speed);
    }
}
