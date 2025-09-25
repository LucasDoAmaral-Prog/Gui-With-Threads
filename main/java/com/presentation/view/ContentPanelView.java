package com.presentation.view;

import javax.swing.*;
import java.awt.*;

public class ContentPanelView extends JPanel {
    private AnimatedBackgroundPanel backgroundPanel;
    private JPanel contentOverlay;

    public ContentPanelView(AnimatedBackgroundPanel backgroundPanel) {
        this.backgroundPanel = backgroundPanel;
        setLayout(new OverlayLayout(this));
        initializeComponents();
    }

    private void initializeComponents() {
        // Background layer (bottom)
        add(backgroundPanel);
        backgroundPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Content overlay (top)
        contentOverlay = new JPanel();
        contentOverlay.setOpaque(false);
        contentOverlay.setLayout(new BorderLayout());
        add(contentOverlay);
        contentOverlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentOverlay.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    public void addContentComponent(Component component, Object constraints) {
        contentOverlay.add(component, constraints);
    }

    public void removeContentComponent(Component component) {
        contentOverlay.remove(component);
    }

    public AnimatedBackgroundPanel getBackgroundPanel() {
        return backgroundPanel;
    }

    public void setBackgroundVisible(boolean visible) {
        backgroundPanel.setVisible(visible);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        backgroundPanel.setEnabled(enabled);
        contentOverlay.setEnabled(enabled);
    }
}
