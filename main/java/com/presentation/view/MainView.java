package com.presentation.view;

import com.presentation.controller.MenuController;
import com.presentation.shared.constants.UIConstants;
import com.presentation.shared.util.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.util.Objects;

public class MainView extends JFrame {

    private JLabel fileTitleLabel;
    private JEditorPane mainArea;
    private StatusBar statusBar;
    private AppMenuBar menuBar;
    private String currentFileName; // mantém referência ao nome do arquivo exibido

    public MainView() {
        setTitle(UIConstants.MAIN_WINDOW_TITLE);
        setSize(800, 600);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);

        try {
            ImageIcon logo = new ImageIcon(
                    Objects.requireNonNull(UIConstants.class.getResource(UIConstants.LOGO_PATH))
            );
            setIconImage(logo.getImage());
        } catch (Exception e) {
            setIconImage(UIUtils.createDefaultIcon());
        }

        // Título do arquivo no topo
        fileTitleLabel = new JLabel("", SwingConstants.CENTER);
        fileTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        fileTitleLabel.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));

        // Área principal usando HTML
        mainArea = new JEditorPane();
        mainArea.setContentType("text/html");
        mainArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mainArea);

        statusBar = new StatusBar();
        menuBar = new AppMenuBar();

        setJMenuBar(menuBar.getMenuBar());

        setLayout(new BorderLayout());
        add(fileTitleLabel, BorderLayout.NORTH); // título do arquivo no topo
        add(scrollPane, BorderLayout.CENTER);
        add(statusBar.getComponent(), BorderLayout.SOUTH);
    }

    public void setStatus(String message) {
        statusBar.setText(message);
    }

    public void setMainAreaContent(String fileName, String htmlContent) {
        this.currentFileName = fileName;
        fileTitleLabel.setText(fileName);
        mainArea.setText(htmlContent);
    }

    public void clearMainAreaContent() {
        this.currentFileName = null;
        fileTitleLabel.setText("");
        mainArea.setText("");
    }

    public void addMainMenuListener(MenuController listener) {
        menuBar.setMenuListener(listener);
    }

    public void addWindowListener(WindowListener listener) {
        super.addWindowListener(listener);
    }
}