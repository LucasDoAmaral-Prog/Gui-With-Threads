package com.presentation.controller;

import com.presentation.shared.constants.AnimationConstants;
import com.presentation.view.AnimatedBackgroundPanel;
import java.awt.Color;

public class AnimationController {

    /**
     * Atualiza o painel de animação usando índices em vez de Strings
     */
    public void updatePattern(AnimatedBackgroundPanel panel, int patternIndex, int colorSchemeIndex, int speedIndex) {
        panel.setPatternIndex(patternIndex);
        panel.setColorSchemeIndex(colorSchemeIndex);
        panel.setSpeedIndex(speedIndex);
    }

    /**
     * Converte um array de cores em índice do esquema correspondente
     */
    public int getColorSchemeIndexFromColors(Color[] colors) {
        if (colors.length > 0 && colors[0].getBlue() > 200) {
            return 0; // Tons Pasteis
        } else if (colors.length > 0 && colors[0].getRed() > 200) {
            return 2; // Tons Quentes
        } else {
            return 1; // Natureza
        }
    }

    /**
     * Converte o nome do padrão em índice
     */
    public int getPatternIndexFromName(String patternName) {
        for (int i = 0; i < AnimationConstants.PATTERN_OPTIONS.length; i++) {
            if (AnimationConstants.PATTERN_OPTIONS[i].equals(patternName)) return i;
        }
        return 0; // padrão CIRCLES
    }

    /**
     * Converte a velocidade em índice
     */
    public int getSpeedIndexFromValue(int speedValue) {
        for (int i = 0; i < AnimationConstants.SPEED_OPTIONS.length; i++) {
            if (AnimationConstants.SPEED_VALUES[i] == speedValue) return i;
        }
        return 1; // NORMAL
    }
}
