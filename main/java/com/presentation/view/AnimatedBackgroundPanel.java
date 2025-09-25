package com.presentation.view;

import com.presentation.domain.service.AnimationService;
import com.presentation.domain.service.BackgroundRenderService;
import com.presentation.infrastructure.thread.ThreadManager;
import com.presentation.domain.model.BackgroundPattern;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimatedBackgroundPanel extends JPanel {
    private final AnimationService animationService;
    private final BackgroundRenderService renderService;
    private final ThreadManager threadManager;

    private List<AnimatedShape> shapes = new ArrayList<>();
    private Timer timer;
    private Random random = new Random();

    private String currentPattern = "CIRCLES";
    private Color[] currentColors;
    private int animationSpeed = 16;

    public AnimatedBackgroundPanel() {
        this.animationService = new AnimationService();
        this.renderService = new BackgroundRenderService();
        this.threadManager = ThreadManager.getInstance();

        this.currentColors = animationService.getColorScheme("COOL");

        setOpaque(false);
        initializeShapes();
        startAnimation();
    }

    public void setPattern(BackgroundPattern pattern) {
        this.currentPattern = pattern.getType();
        this.currentColors = pattern.getColors();
        this.animationSpeed = pattern.getSpeed();

        if (timer != null) {
            timer.setDelay(animationSpeed);
        }

        initializeShapes();
    }


    private void initializeShapes() {
        shapes.clear();
        for (int i = 0; i < 15; i++) {
            shapes.add(new AnimatedShape(
                    random.nextInt(800),
                    random.nextInt(600),
                    currentColors[random.nextInt(currentColors.length)]
            ));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        renderService.applyRenderingHints(g2d);
        renderService.renderBackground(g2d, getWidth(), getHeight());

        for (AnimatedShape shape : shapes) {
            shape.render(g2d, renderService, currentPattern);
        }
    }

    private void startAnimation() {
        timer = new Timer(animationSpeed, e -> {
            updateAnimation();
            repaint();
        });
        threadManager.setMainAnimationTimer(timer);
        timer.start();
    }

    private void updateAnimation() {
        for (AnimatedShape shape : shapes) {
            shape.update(getWidth(), getHeight());
        }
    }

    // Public methods for external control
    public void setPattern(String pattern) {
        this.currentPattern = pattern;
        initializeShapes();
    }

    public void setColorScheme(String scheme) {
        this.currentColors = animationService.getColorScheme(scheme);
        initializeShapes();
    }

    public void setSpeed(String speed) {
        this.animationSpeed = animationService.getSpeedDelay(speed);
        if (timer != null) {
            timer.setDelay(animationSpeed);
        }
    }

    public void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }

    public void resumeAnimation() {
        if (timer != null && !timer.isRunning()) {
            timer.start();
        }
    }

    // Inner class for animated shapes
    private class AnimatedShape {
        private float x, y, dx, dy;
        private Color color;
        private float size;
        private float rotation = 0;

        public AnimatedShape(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.dx = (random.nextFloat() - 0.5f) * 4;
            this.dy = (random.nextFloat() - 0.5f) * 4;
            this.size = 20 + random.nextFloat() * 30;
        }

        public void update(int width, int height) {
            x += dx;
            y += dy;
            rotation += 0.02f;

            if (x <= 0 || x >= width - size) dx = -dx;
            if (y <= 0 || y >= height - size) dy = -dy;
        }


        public void render(Graphics2D g2d, BackgroundRenderService renderService, String pattern) {
            switch (pattern) {
                case "CIRCLES":
                    renderService.renderCircle(g2d, x, y, size, color);
                    break;
                case "SQUARES":
                    renderService.renderSquare(g2d, x, y, size, color);
                    break;
                case "STARS":
                    renderService.renderStar(g2d, x + size/2, y + size/2, size/2, color, rotation);
                    break;
                case "WAVES":
                    renderService.renderWave(g2d, x, y, size, color, rotation);
                    break;
            }
        }
    }
}
