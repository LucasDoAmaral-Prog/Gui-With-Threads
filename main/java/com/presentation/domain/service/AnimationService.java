package com.presentation.domain.service;

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
        colorSchemes.put("COOL", new Color[]{
                new Color(64, 128, 255, 120), new Color(64, 255, 255, 120),
                new Color(128, 64, 255, 120), new Color(255, 255, 255, 120)
        });
        colorSchemes.put("WARM", new Color[]{
                new Color(255, 128, 64, 120), new Color(255, 64, 64, 120),
                new Color(255, 255, 64, 120), new Color(255, 128, 128, 120)
        });
        colorSchemes.put("NATURE", new Color[]{
                new Color(64, 255, 64, 120), new Color(128, 255, 64, 120),
                new Color(64, 128, 64, 120), new Color(255, 255, 128, 120)
        });
    }

    private void initializeSpeedSettings() {
        speedSettings = new HashMap<>();
        speedSettings.put("SLOW", 50);
        speedSettings.put("NORMAL", 16);
        speedSettings.put("FAST", 8);
    }

    private void initializePatternTypes() {
        patternTypes = new HashMap<>();
        patternTypes.put("BASIC", new String[]{"CIRCLES", "SQUARES"});
        patternTypes.put("ADVANCED", new String[]{"STARS", "WAVES", "SPIRAL"});
    }

    public Color[] getColorScheme(String schemeName) {
        return colorSchemes.getOrDefault(schemeName.toUpperCase(), colorSchemes.get("COOL"));
    }

    public int getSpeedDelay(String speedName) {
        return speedSettings.getOrDefault(speedName.toUpperCase(), 16);
    }

    public String[] getAvailablePatterns(String category) {
        return patternTypes.getOrDefault(category.toUpperCase(), patternTypes.get("BASIC"));
    }

    public String[] getAllColorSchemes() {
        return colorSchemes.keySet().toArray(new String[0]);
    }

    public String[] getAllSpeedSettings() {
        return speedSettings.keySet().toArray(new String[0]);
    }
}
