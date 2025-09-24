package com.presentation.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimatedBackgroundPanel extends JPanel {
    private List<MovingCircle> shapes = new ArrayList<>();
    private Timer timer;
    private Random rand = new Random();
    private Color[] colorScheme = {
            new Color(64, 128, 255, 120),
            new Color(255, 64, 128, 120),
            new Color(128, 255, 64, 120),
            new Color(255, 255, 64, 120),
            new Color(128, 64, 255, 120)
    };

    public AnimatedBackgroundPanel() {
        setOpaque(false);
        initializeShapes();
        startAnimation();
    }

    private void initializeShapes() {
        shapes.clear();
        for (int i = 0; i < 15; i++) {
            shapes.add(new MovingCircle(
                    rand.nextInt(800),
                    rand.nextInt(600),
                    colorScheme[rand.nextInt(colorScheme.length)]
            ));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(20, 20, 40, 50),
                getWidth(), getHeight(), new Color(40, 20, 60, 50)
        );
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for (MovingCircle shape : shapes) {
            shape.draw(g2d);
        }
    }

    private void startAnimation() {
        timer = new Timer(16, e -> {
            for (MovingCircle shape : shapes) {
                shape.update(getWidth(), getHeight());
            }
            repaint();
        });
        timer.start();
    }

    private class MovingCircle {
        private float x, y, dx, dy;
        private Color color;
        private float size;

        public MovingCircle(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.dx = (rand.nextFloat() - 0.5f) * 4;
            this.dy = (rand.nextFloat() - 0.5f) * 4;
            this.size = 20 + rand.nextFloat() * 30;
        }

        public void update(int width, int height) {
            x += dx;
            y += dy;

            if (x <= 0 || x >= width - size) dx = -dx;
            if (y <= 0 || y >= height - size) dy = -dy;
        }

        public void draw(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fillOval((int)x, (int)y, (int)size, (int)size);
        }
    }
}
