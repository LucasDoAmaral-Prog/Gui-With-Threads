package com.presentation.domain.service;

import java.awt.*;
import java.awt.geom.*;

public class BackgroundRenderService {

    public void renderBackground(Graphics2D g2d, int width, int height) {
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(20, 20, 40, 50),
                width, height, new Color(40, 20, 60, 50)
        );
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }

    public void renderCircle(Graphics2D g2d, float x, float y, float size, Color color) {
        g2d.setColor(color);
        g2d.fill(new Ellipse2D.Float(x, y, size, size));
    }

    public void renderSquare(Graphics2D g2d, float x, float y, float size, Color color) {
        g2d.setColor(color);
        g2d.fillRect((int)x, (int)y, (int)size, (int)size);
    }

    public void renderStar(Graphics2D g2d, float centerX, float centerY, float radius, Color color, float rotation) {
        g2d.setColor(color);
        Path2D star = new Path2D.Float();

        for (int i = 0; i < 10; i++) {
            double angle = (i * Math.PI / 5) + rotation;
            float r = (i % 2 == 0) ? radius : radius * 0.5f;
            float px = centerX + (float) (r * Math.cos(angle));
            float py = centerY + (float) (r * Math.sin(angle));

            if (i == 0) star.moveTo(px, py);
            else star.lineTo(px, py);
        }
        star.closePath();
        g2d.fill(star);
    }

    public void renderWave(Graphics2D g2d, float x, float y, float size, Color color, float rotation) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(3));
        for (int i = 0; i < size; i += 5) {
            float waveY = y + (float) (Math.sin((x + i) * 0.05 + rotation) * 10);
            g2d.drawOval((int) x + i, (int) waveY, 8, 8);
        }
    }

    public void applyRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    }
}