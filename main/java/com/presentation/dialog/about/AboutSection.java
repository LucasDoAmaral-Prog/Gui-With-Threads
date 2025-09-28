package com.presentation.dialog.about;

import com.presentation.dialog.DialogStyles;

import javax.swing.*;
import java.awt.*;

public class AboutSection {

    public static JScrollPane createProjectSection() {
        JPanel panel = DialogStyles.createTabContentPanel();

        JLabel titleLabel = new JLabel("🎯 BASIC GUI WITH THREADS");
        titleLabel.setFont(DialogStyles.TITLE_FONT);
        titleLabel.setForeground(DialogStyles.PRIMARY_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10));

        JLabel courseLabel = new JLabel("SI400 - Programação Orientada a Objetos II");
        courseLabel.setFont(DialogStyles.SUBTITLE_FONT);
        courseLabel.setForeground(DialogStyles.SECONDARY_COLOR);
        courseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(courseLabel);
        panel.add(Box.createVerticalStrut(5));

        JLabel versionLabel = new JLabel("Versão 2025.a | Linguagem Java");
        versionLabel.setFont(DialogStyles.SMALL_FONT);
        versionLabel.setForeground(Color.GRAY);
        versionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(versionLabel);
        panel.add(Box.createVerticalStrut(30));

        for (String info : AboutContent.getProjectInfo()) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE);

            JLabel itemLabel = new JLabel("• " + info);
            itemLabel.setFont(DialogStyles.CONTENT_FONT);
            itemLabel.setForeground(DialogStyles.TEXT_COLOR);

            itemPanel.add(itemLabel);
            panel.add(itemPanel);
        }

        return DialogStyles.createScrollablePanel(panel);
    }

    public static JScrollPane createObjectivesSection() {
        JPanel panel = DialogStyles.createTabContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(DialogStyles.createHeaderLabel("🎯 OBJETIVOS PRINCIPAIS", DialogStyles.ACCENT_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (String objective : AboutContent.getObjectives()) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE);

            JLabel checkLabel = new JLabel("✓");
            checkLabel.setFont(DialogStyles.CONTENT_FONT);

            JLabel itemLabel = new JLabel(objective);
            itemLabel.setFont(DialogStyles.CONTENT_FONT);
            itemLabel.setForeground(DialogStyles.TEXT_COLOR);

            itemPanel.add(checkLabel);
            itemPanel.add(itemLabel);
            panel.add(itemPanel);
        }

        return DialogStyles.createScrollablePanel(panel);
    }

    public static JScrollPane createFeaturesSection() {
        JPanel panel = DialogStyles.createTabContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(DialogStyles.createHeaderLabel("⚙️ FUNCIONALIDADES IMPLEMENTADAS", DialogStyles.INFO_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (AboutContent.FeatureGroup group : AboutContent.getFeatures()) {
            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            titlePanel.setBackground(Color.WHITE);

            JLabel titleLabel = new JLabel(group.title);
            titleLabel.setFont(DialogStyles.SECTION_FONT);
            titleLabel.setForeground(group.color);

            titlePanel.add(titleLabel);
            panel.add(titlePanel);
            panel.add(Box.createVerticalStrut(8));

            for (String item : group.items) {
                JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                itemPanel.setBackground(Color.WHITE);

                JLabel itemLabel = new JLabel("  • " + item);
                itemLabel.setFont(DialogStyles.CONTENT_FONT);
                itemLabel.setForeground(DialogStyles.TEXT_COLOR);

                itemPanel.add(itemLabel);
                panel.add(itemPanel);
            }
            panel.add(Box.createVerticalStrut(15));
        }

        return DialogStyles.createScrollablePanel(panel);
    }

    public static JScrollPane createTechnicalSection() {
        JPanel panel = DialogStyles.createTabContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(DialogStyles.createHeaderLabel("🔧 ESPECIFICAÇÕES TÉCNICAS", DialogStyles.TECH_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (AboutContent.TechnicalGroup group : AboutContent.getTechnicalSpecs()) {
            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            titlePanel.setBackground(Color.WHITE);

            JLabel titleLabel = new JLabel(group.title);
            titleLabel.setFont(DialogStyles.SECTION_FONT);
            titleLabel.setForeground(DialogStyles.TECH_COLOR);

            titlePanel.add(titleLabel);
            panel.add(titlePanel);
            panel.add(Box.createVerticalStrut(8));

            for (String item : group.items) {
                JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                itemPanel.setBackground(Color.WHITE);

                JLabel itemLabel = new JLabel("  ▸ " + item);
                itemLabel.setFont(DialogStyles.CONTENT_FONT);
                itemLabel.setForeground(DialogStyles.TEXT_COLOR);

                itemPanel.add(itemLabel);
                panel.add(itemPanel);
            }
            panel.add(Box.createVerticalStrut(15));
        }

        return DialogStyles.createScrollablePanel(panel);
    }

    public static JScrollPane createTeamSection() {
        JPanel panel = DialogStyles.createTabContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(DialogStyles.createHeaderLabel("👥 EQUIPE DE DESENVOLVIMENTO", DialogStyles.PRIMARY_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (AboutContent.TeamMember member : AboutContent.getTeamMembers()) {
            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            titlePanel.setBackground(Color.WHITE);

            JLabel roleLabel = new JLabel(member.role + " (" + member.count + ")");
            roleLabel.setFont(DialogStyles.SECTION_FONT);
            roleLabel.setForeground(member.color);

            titlePanel.add(roleLabel);
            panel.add(titlePanel);
            panel.add(Box.createVerticalStrut(5));

            for (String responsibility : member.responsibilities) {
                JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                itemPanel.setBackground(Color.WHITE);

                JLabel itemLabel = new JLabel("  • " + responsibility);
                itemLabel.setFont(DialogStyles.CONTENT_FONT);
                itemLabel.setForeground(DialogStyles.TEXT_COLOR);

                itemPanel.add(itemLabel);
                panel.add(itemPanel);
            }
            panel.add(Box.createVerticalStrut(15));
        }

        return DialogStyles.createScrollablePanel(panel);
    }

    public static JScrollPane createEvaluationSection() {
        JPanel panel = DialogStyles.createTabContentPanel();

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(DialogStyles.createHeaderLabel("📊 CRITÉRIOS DE AVALIAÇÃO", DialogStyles.SUCCESS_COLOR));
        panel.add(headerPanel);
        panel.add(Box.createVerticalStrut(20));

        for (String criterion : AboutContent.getEvaluationCriteria()) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE);

            JLabel checkLabel = new JLabel("✅");
            checkLabel.setFont(DialogStyles.CONTENT_FONT);

            JLabel itemLabel = new JLabel(criterion);
            itemLabel.setFont(DialogStyles.CONTENT_FONT);
            itemLabel.setForeground(DialogStyles.TEXT_COLOR);

            itemPanel.add(checkLabel);
            itemPanel.add(itemLabel);
            panel.add(itemPanel);
        }

        panel.add(Box.createVerticalStrut(20));

        JLabel footerLabel = new JLabel("🎯 Todos os critérios foram atendidos com sucesso!");
        footerLabel.setFont(DialogStyles.SECTION_FONT);
        footerLabel.setForeground(DialogStyles.SUCCESS_COLOR);
        footerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(footerLabel);

        return DialogStyles.createScrollablePanel(panel);
    }
}
