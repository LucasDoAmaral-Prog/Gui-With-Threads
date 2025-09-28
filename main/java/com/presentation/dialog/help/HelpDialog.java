package com.presentation.dialog.help;

import com.presentation.dialog.about.AboutDialog;
import com.presentation.view.MainView;

import javax.swing.*;
import java.awt.*;

public class HelpDialog extends JDialog {

    private final MainView parentView;
    private JTabbedPane tabbedPane;

    public HelpDialog(MainView parent) {
        super(parent, "Ajuda - GUI with Threads", true);
        this.parentView = parent;
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(HelpStyles.DIALOG_WIDTH, HelpStyles.DIALOG_HEIGHT);
        setLocationRelativeTo(parentView);
        setResizable(true);

        createComponents();
        layoutComponents();
    }

    private void createComponents() {
        tabbedPane = HelpStyles.createHelpTabbedPane();

        tabbedPane.addTab("⌨️ Atalhos", HelpSection.createShortcutsSection());
        tabbedPane.addTab("🚀 Início", HelpSection.createGettingStartedSection());
        tabbedPane.addTab("⚙️ Funcionalidades", HelpSection.createFeaturesSection());
        tabbedPane.addTab("🔧 Problemas", HelpSection.createTroubleshootingSection());
        tabbedPane.addTab("💡 Dicas", HelpSection.createTipsSection());
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, HelpStyles.LIGHT_GRAY));

        JButton aboutButton = new JButton("Sobre");
        aboutButton.setPreferredSize(new Dimension(90, 32));
        aboutButton.setFont(HelpStyles.CONTENT_FONT);
        aboutButton.setBackground(HelpStyles.INFO_COLOR);
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setFocusPainted(false);
        aboutButton.setBorderPainted(false);
        aboutButton.addActionListener(e -> {
            dispose();
            AboutDialog.showDialog(parentView);
        });

        JButton closeButton = new JButton("Fechar");
        closeButton.setPreferredSize(new Dimension(90, 32));
        closeButton.setFont(HelpStyles.CONTENT_FONT);
        closeButton.setBackground(HelpStyles.PRIMARY_COLOR);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(e -> dispose());

        buttonPanel.add(aboutButton);
        buttonPanel.add(closeButton);

        return buttonPanel;
    }

    public static void showDialog(MainView parent) {
        HelpDialog dialog = new HelpDialog(parent);
        dialog.setVisible(true);
    }
}
