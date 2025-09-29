package com.presentation.dialog.help;

import javax.swing.*;
import java.awt.*;

public final class HelpStyles {

    public static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    public static final Color SUCCESS_COLOR = new Color(39, 174, 96);
    public static final Color WARNING_COLOR = new Color(243, 156, 18);
    public static final Color DANGER_COLOR = new Color(231, 76, 60);
    public static final Color INFO_COLOR = new Color(142, 68, 173);
    public static final Color SHORTCUT_COLOR = new Color(52, 73, 94);
    public static final Color TEXT_COLOR = new Color(44, 62, 80);
    public static final Color LIGHT_GRAY = new Color(236, 240, 241);

    public static final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    public static final Font SUBTITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 14);
    public static final Font SECTION_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 12);
    public static final Font CONTENT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
    public static final Font SHORTCUT_FONT = new Font(Font.MONOSPACED, Font.BOLD, 11);
    public static final Font TAB_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 11);

    public static final int DIALOG_WIDTH = 650;
    public static final int DIALOG_HEIGHT = 480;
    public static final int CONTENT_PADDING = 20;

    private HelpStyles() {}

    public static JTabbedPane createHelpTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(TAB_FONT);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        return tabbedPane;
    }

    public static JPanel createHelpContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(CONTENT_PADDING, CONTENT_PADDING, CONTENT_PADDING, CONTENT_PADDING));
        return panel;
    }

    public static JScrollPane createHelpScrollPane(JPanel content) {
        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return scrollPane;
    }

    public static JLabel createHelpHeader(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(SUBTITLE_FONT);
        label.setForeground(color);
        return label;
    }

    public static JLabel createShortcutLabel(String shortcut) {
        JLabel label = new JLabel(shortcut);
        label.setFont(SHORTCUT_FONT);
        label.setForeground(SHORTCUT_COLOR);
        label.setOpaque(true);
        label.setBackground(LIGHT_GRAY);
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(2, 4, 2, 4)
        ));
        return label;
    }

    public static JPanel createShortcutPanel(String shortcut, String description) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.WHITE);

        panel.add(createShortcutLabel(shortcut));
        panel.add(Box.createHorizontalStrut(10));

        JLabel descLabel = new JLabel(description);
        descLabel.setFont(CONTENT_FONT);
        descLabel.setForeground(TEXT_COLOR);
        panel.add(descLabel);

        return panel;
    }

    public static JLabel createContentItem(String text) {
        JLabel label = new JLabel(text);
        label.setFont(CONTENT_FONT);
        label.setForeground(TEXT_COLOR);
        return label;
    }
    public static JLabel createImageLabel(String imagePath, String caption, int maxWidth) {
        try {
            // AJUSTAR O CAMINHO PARA COM/MAIN
            java.net.URL imageURL = HelpStyles.class.getResource(imagePath);
            if (imageURL != null) {
                ImageIcon originalIcon = new ImageIcon(imageURL);
                Image img = originalIcon.getImage();

                // Redimensionar mantendo proporção
                int originalWidth = originalIcon.getIconWidth();
                int originalHeight = originalIcon.getIconHeight();
                int newWidth = Math.min(originalWidth, maxWidth);
                int newHeight = (originalHeight * newWidth) / originalWidth;

                Image scaledImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
                imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                // Adicionar caption se fornecido
                if (caption != null && !caption.isEmpty()) {
                    imageLabel.setBorder(BorderFactory.createTitledBorder(
                            BorderFactory.createLineBorder(LIGHT_GRAY, 1),
                            caption,
                            0, 0,
                            CONTENT_FONT,
                            TEXT_COLOR
                    ));
                }

                return imageLabel;
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem: " + imagePath);
        }

        // Retorna label placeholder se imagem não carregou
        JLabel placeholder = new JLabel("📷 " + (caption != null ? caption : "Imagem"));
        placeholder.setFont(CONTENT_FONT);
        placeholder.setForeground(Color.GRAY);
        placeholder.setAlignmentX(Component.CENTER_ALIGNMENT);
        placeholder.setBorder(BorderFactory.createDashedBorder(Color.LIGHT_GRAY, 2, 5, 5, true));
        return placeholder;
    }
    public static JPanel createImageSection(String title, String imagePath, String caption) {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBackground(Color.WHITE);

        // Título da seção
        if (title != null && !title.isEmpty()) {
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(SECTION_FONT);
            titleLabel.setForeground(PRIMARY_COLOR);
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            section.add(titleLabel);
            section.add(Box.createVerticalStrut(10));
        }

        // Imagem
        JLabel imageLabel = createImageLabel(imagePath, caption, 400);
        section.add(imageLabel);

        return section;
    }

}
