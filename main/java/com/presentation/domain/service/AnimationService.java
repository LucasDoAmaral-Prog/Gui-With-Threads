package com.presentation.domain.service;

import com.presentation.shared.constants.AnimationConstants;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class AnimationService {
    private Map<String, Color[]> colorSchemes;
    private Map<String, Integer> speedSettings;
    private Map<String, String[]> patternTypes;

    public AnimationService() {
        initializeColorSchemes();
        initializeSpeedSettings();
        initializePatternTypes();
    }

    private void initializeColorSchemes() {
        colorSchemes = new HashMap<>();
        colorSchemes.put(AnimationConstants.COLOR_OPTIONS[0], new Color[]{
                new Color(64, 128, 255, 120), new Color(64, 255, 255, 120),
                new Color(128, 64, 255, 120), new Color(255, 255, 255, 120)
        });
        colorSchemes.put(AnimationConstants.COLOR_OPTIONS[1], new Color[]{
                new Color(64, 255, 64, 120), new Color(128, 255, 64, 120),
                new Color(64, 128, 64, 120), new Color(255, 255, 128, 120)
        });
        colorSchemes.put(AnimationConstants.COLOR_OPTIONS[2], new Color[]{
                new Color(255, 128, 64, 120), new Color(255, 64, 64, 120),
                new Color(255, 255, 64, 120), new Color(255, 128, 128, 120)
        });
    }

    private void initializeSpeedSettings() {
        speedSettings = new HashMap<>();
        speedSettings.put(AnimationConstants.SPEED_OPTIONS[0], 50);  // Lento
        speedSettings.put(AnimationConstants.SPEED_OPTIONS[1], 16);  // Normal
        speedSettings.put(AnimationConstants.SPEED_OPTIONS[2], 8);   // Rápido
    }

    private void initializePatternTypes() {
        patternTypes = new HashMap<>();
        patternTypes.put("BÁSICO", new String[]{
                AnimationConstants.PATTERN_OPTIONS[0], // Círculos
                AnimationConstants.PATTERN_OPTIONS[1]  // Quadrados
        });
        patternTypes.put("AVANÇADO", new String[]{
                AnimationConstants.PATTERN_OPTIONS[2], // Estrelas
                AnimationConstants.PATTERN_OPTIONS[3]  // Ondas
                // Espiral removido
        });
    }

    public Color[] getColorScheme(String schemeName) {
        return colorSchemes.getOrDefault(schemeName, colorSchemes.get(AnimationConstants.COLOR_OPTIONS[0]));
    }

    public int getSpeedDelay(String speedName) {
        return speedSettings.getOrDefault(speedName, 16);
    }

    public String[] getAvailablePatterns(String category) {
        return patternTypes.getOrDefault(category.toUpperCase(), patternTypes.get("BÁSICO"));
    }

    public String[] getAllColorSchemes() {
        return colorSchemes.keySet().toArray(new String[0]);
    }

    public String[] getAllSpeedSettings() {
        return speedSettings.keySet().toArray(new String[0]);
    }

    public String[] getAllPatternCategories() {
        return patternTypes.keySet().toArray(new String[0]);
    }
}
