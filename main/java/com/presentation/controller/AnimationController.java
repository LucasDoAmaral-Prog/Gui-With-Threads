package com.presentation.controller;

import com.presentation.view.AnimatedBackgroundPanel;
import com.presentation.domain.model.BackgroundPattern;
import java.awt.Color;

public class AnimationController {

    public void updatePattern(AnimatedBackgroundPanel panel, String type, Color[] colors, int speed) {
        // Crie o BackgroundPattern mas use apenas o tipo
        BackgroundPattern pattern = new BackgroundPattern(type, colors, speed);

        // Passe apenas o tipo (String) para setPattern
        panel.setPattern(pattern.getType());

        // Configure cores e velocidade separadamente
        panel.setColorScheme(getSchemeNameFromColors(colors));
        panel.setSpeed(String.valueOf(speed));
    }

    private String getSchemeNameFromColors(Color[] colors) {
        // Lógica simples para determinar esquema baseado nas cores
        if (colors.length > 0 && colors[0].getBlue() > 200) {
            return "COOL";
        } else if (colors.length > 0 && colors[0].getRed() > 200) {
            return "WARM";
        } else {
            return "NATURE";
        }
    }
}
