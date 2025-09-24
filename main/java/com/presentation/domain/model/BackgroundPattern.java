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

    // getters e setters
    public String getType() { return type; }
    public Color[] getColors() { return colors; }
    public int getSpeed() { return speed; }
}
