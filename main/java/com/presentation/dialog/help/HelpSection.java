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

        panel.add(HelpStyles.createImageSection(
                "Atalho do Arquivo",
                "/images/help/shortcuts/alt-a-menu.png",
                "Principais atalhos do sistema"
        ));
        panel.add(HelpStyles.createImageSection(
                "Atalho da Configuração",
                "/images/help/shortcuts/alt-c-menu.png",
                "Principais atalhos do sistema"
        ));
        panel.add(HelpStyles.createImageSection(
                "Atalho para Ajuda",
                "/images/help/shortcuts/alt-j-menu.png",
                "Principais atalhos do sistema"
        ));

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
        // Manter como está - sem modificações
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

        // ADICIONAR IMAGEM DAS FEATURES
        panel.add(HelpStyles.createImageSection(
                "Interface Principal.",
                "/images/help/features/animation-running.png",
                "Visão geral das funcionalidades disponíveis"
        ));
        panel.add(HelpStyles.createImageSection(
                "Interface para selicionar Arquivo.",
                "/images/help/features/text-display.png",
                "Visão geral das funcionalidades disponíveis"
        ));
        panel.add(HelpStyles.createImageSection(
                "Interface com arquivo aberto sucedido.",
                "/images/help/features/status-bar.png",
                "Visão geral das funcionalidades disponíveis"
        ));
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

        // ADICIONAR IMAGEM DO ERROR MESSAGE
        panel.add(HelpStyles.createImageSection(
                "Exemplo de Erro Comum",
                "/images/help/troubleshooting/error-message.png",
                "Mensagem de erro: Arquivo vazio ou inválido"
        ));
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
        // Manter como está - sem modificações
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
