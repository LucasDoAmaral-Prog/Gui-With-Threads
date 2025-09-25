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

    public Color[] getColors() {
        return colors;
    }

    public int getSpeed() {
        return speed;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Método de conveniência para criar padrões predefinidos
    public static BackgroundPattern createDefaultPattern() {
        Color[] defaultColors = {
                new Color(64, 128, 255, 120),
                new Color(255, 64, 128, 120),
                new Color(128, 255, 64, 120)
        };
        return new BackgroundPattern("CIRCLES", defaultColors, 16);
    }

    public static BackgroundPattern createCoolPattern() {
        Color[] coolColors = {
                new Color(64, 128, 255, 120),
                new Color(64, 255, 255, 120),
                new Color(128, 64, 255, 120)
        };
        return new BackgroundPattern("CIRCLES", coolColors, 16);
    }

    public static BackgroundPattern createWarmPattern() {
        Color[] warmColors = {
                new Color(255, 128, 64, 120),
                new Color(255, 64, 64, 120),
                new Color(255, 255, 64, 120)
        };
        return new BackgroundPattern("STARS", warmColors, 20);
    }

    @Override
    public String toString() {
        return String.format("BackgroundPattern{type='%s', colors=%d, speed=%d}",
                type, colors.length, speed);
    }
}
