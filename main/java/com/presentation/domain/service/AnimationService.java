package com.basicgui.domain.service;

import com.basicgui.domain.model.BackgroundPattern;
import java.awt.Color;

public class AnimationService {
    public BackgroundPattern getDefaultPattern() {
        return new BackgroundPattern("circles", new Color[]{Color.BLUE, Color.GREEN, Color.RED}, 16);
    }
    // Métodos para criar outros padrões, mudar cores, etc.
}
