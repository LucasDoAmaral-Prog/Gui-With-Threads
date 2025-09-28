package com.presentation.dialog.help;

import javax.swing.*;
import java.awt.*;

public class HelpSection {

    public static JScrollPane createShortcutsSection() {
        JPanel panel = HelpStyles.createHelpContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(HelpStyles.createHelpHeader("⌨️ ATALHOS DE TECLADO", HelpStyles.PRIMARY_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (HelpContent.ShortcutGroup group : HelpContent.getShortcuts()) {
            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            titlePanel.setBackground(Color.WHITE);

            JLabel titleLabel = new JLabel(group.title);
            titleLabel.setFont(HelpStyles.SECTION_FONT);
            titleLabel.setForeground(group.color);

            titlePanel.add(titleLabel);
            panel.add(titlePanel);
            panel.add(Box.createVerticalStrut(8));

            for (HelpContent.Shortcut shortcut : group.shortcuts) {
                panel.add(HelpStyles.createShortcutPanel(shortcut.key, shortcut.description));
            }
            panel.add(Box.createVerticalStrut(15));
        }

        return HelpStyles.createHelpScrollPane(panel);
    }

    public static JScrollPane createGettingStartedSection() {
        JPanel panel = HelpStyles.createHelpContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(HelpStyles.createHelpHeader("🚀 PRIMEIROS PASSOS", HelpStyles.SUCCESS_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (String step : HelpContent.getGettingStarted()) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE);

            JLabel itemLabel = new JLabel(step);
            itemLabel.setFont(HelpStyles.CONTENT_FONT);
            itemLabel.setForeground(HelpStyles.TEXT_COLOR);

            itemPanel.add(itemLabel);
            panel.add(itemPanel);
        }

        return HelpStyles.createHelpScrollPane(panel);
    }

    public static JScrollPane createFeaturesSection() {
        JPanel panel = HelpStyles.createHelpContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(HelpStyles.createHelpHeader("⚙️ FUNCIONALIDADES DETALHADAS", HelpStyles.INFO_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (HelpContent.FeatureHelp feature : HelpContent.getFeatures()) {
            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            titlePanel.setBackground(Color.WHITE);

            JLabel titleLabel = new JLabel(feature.title);
            titleLabel.setFont(HelpStyles.SECTION_FONT);
            titleLabel.setForeground(feature.color);

            titlePanel.add(titleLabel);
            panel.add(titlePanel);
            panel.add(Box.createVerticalStrut(8));

            for (String item : feature.items) {
                JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                itemPanel.setBackground(Color.WHITE);

                JLabel itemLabel = new JLabel("  • " + item);
                itemLabel.setFont(HelpStyles.CONTENT_FONT);
                itemLabel.setForeground(HelpStyles.TEXT_COLOR);

                itemPanel.add(itemLabel);
                panel.add(itemPanel);
            }
            panel.add(Box.createVerticalStrut(15));
        }

        return HelpStyles.createHelpScrollPane(panel);
    }

    public static JScrollPane createTroubleshootingSection() {
        JPanel panel = HelpStyles.createHelpContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(HelpStyles.createHelpHeader("🔧 SOLUÇÃO DE PROBLEMAS", HelpStyles.DANGER_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (String troubleItem : HelpContent.getTroubleshooting()) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE);

            JLabel itemLabel = new JLabel(troubleItem);
            itemLabel.setFont(HelpStyles.CONTENT_FONT);
            itemLabel.setForeground(HelpStyles.TEXT_COLOR);

            if (troubleItem.startsWith("❓")) {
                itemLabel.setFont(HelpStyles.SECTION_FONT);
                itemLabel.setForeground(HelpStyles.DANGER_COLOR);
            }

            itemPanel.add(itemLabel);
            panel.add(itemPanel);
        }

        return HelpStyles.createHelpScrollPane(panel);
    }

    public static JScrollPane createTipsSection() {
        JPanel panel = HelpStyles.createHelpContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(HelpStyles.createHelpHeader("💡 DICAS E TRUQUES", HelpStyles.WARNING_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (String tip : HelpContent.getTips()) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE);

            JLabel itemLabel = new JLabel(tip);
            itemLabel.setFont(HelpStyles.CONTENT_FONT);
            itemLabel.setForeground(HelpStyles.TEXT_COLOR);

            itemPanel.add(itemLabel);
            panel.add(itemPanel);
        }

        return HelpStyles.createHelpScrollPane(panel);
    }
}
