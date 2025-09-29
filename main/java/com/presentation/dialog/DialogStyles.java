package com.presentation.dialog;

import javax.swing.*;
import java.awt.*;

public final class DialogStyles {

    public static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    public static final Color SECONDARY_COLOR = new Color(52, 73, 94);
    public static final Color ACCENT_COLOR = new Color(46, 204, 113);
    public static final Color WARNING_COLOR = new Color(243, 156, 18);
    public static final Color SUCCESS_COLOR = new Color(39, 174, 96);
    public static final Color INFO_COLOR = new Color(142, 68, 173);
    public static final Color TECH_COLOR = new Color(230, 126, 34);
    public static final Color TEXT_COLOR = new Color(44, 62, 80);
    public static final Color LIGHT_GRAY = new Color(236, 240, 241);

    public static final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    public static final Font SUBTITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 16);
    public static final Font SECTION_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 13);
    public static final Font CONTENT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    public static final Font SMALL_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
    public static final Font TAB_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 11);

    public static final int DIALOG_WIDTH = 700;
    public static final int DIALOG_HEIGHT = 520;
    public static final int CONTENT_PADDING = 25;
    public static final int BUTTON_WIDTH = 90;
    public static final int BUTTON_HEIGHT = 32;

    private DialogStyles() {}

    public static JTabbedPane createStyledTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(TAB_FONT);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        return tabbedPane;
    }

    public static JPanel createTabContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(CONTENT_PADDING, CONTENT_PADDING, CONTENT_PADDING, CONTENT_PADDING));
        return panel;
    }

    public static JScrollPane createScrollablePanel(JPanel content) {
        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return scrollPane;
    }

    public static JLabel createHeaderLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(SUBTITLE_FONT);
        label.setForeground(color);
        return label;
    }

    public static JLabel createSectionLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(SECTION_FONT);
        label.setForeground(color);
        return label;
    }

    public static JLabel createContentLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(CONTENT_FONT);
        label.setForeground(TEXT_COLOR);
        label.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
        return label;
    }

    public static JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setFont(SMALL_FONT);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }

    public static JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, LIGHT_GRAY));
        return panel;
    }
}
