package com.presentation.dialog.about;

import com.presentation.dialog.DialogStyles;
import com.presentation.dialog.help.HelpDialog;
import com.presentation.view.MainView;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {

    private final MainView parentView;
    private JTabbedPane tabbedPane;

    public AboutDialog(MainView parent) {
        super(parent, "Sobre - Basic GUI with Threads", true);
        this.parentView = parent;
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(DialogStyles.DIALOG_WIDTH, DialogStyles.DIALOG_HEIGHT);
        setLocationRelativeTo(parentView);
        setResizable(true);

        createComponents();
        layoutComponents();
    }

    private void createComponents() {
        tabbedPane = DialogStyles.createStyledTabbedPane();

        tabbedPane.addTab("📋 Projeto", AboutSection.createProjectSection());
        tabbedPane.addTab("🎯 Objetivos", AboutSection.createObjectivesSection());
        tabbedPane.addTab("⚙️ Funcionalidades", AboutSection.createFeaturesSection());
        tabbedPane.addTab("🔧 Técnico", AboutSection.createTechnicalSection());
        tabbedPane.addTab("👥 Equipe", AboutSection.createTeamSection());
        tabbedPane.addTab("📊 Avaliação", AboutSection.createEvaluationSection());
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = DialogStyles.createButtonPanel();

        JButton helpButton = DialogStyles.createStyledButton("Ajuda", DialogStyles.ACCENT_COLOR);
        helpButton.addActionListener(e -> {
            dispose();
            HelpDialog.showDialog(parentView);
        });

        JButton closeButton = DialogStyles.createStyledButton("Fechar", DialogStyles.PRIMARY_COLOR);
        closeButton.addActionListener(e -> dispose());

        buttonPanel.add(helpButton);
        buttonPanel.add(closeButton);

        return buttonPanel;
    }

    public static void showDialog(MainView parent) {
        AboutDialog dialog = new AboutDialog(parent);
        dialog.setVisible(true);
    }
}
