package com.presentation.view;

import com.presentation.controller.MenuController;
import com.presentation.shared.constants.UIConstants;
import com.presentation.shared.util.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.util.Objects;

public class MainView extends JFrame {

    private JTextArea mainArea;
    private StatusBar statusBar;
    private AppMenuBar menuBar;

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
            // Se não conseguir carregar, pode usar um ícone padrão
            setIconImage(UIUtils.createDefaultIcon());
        }

        mainArea = new JTextArea();
        mainArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mainArea);

        statusBar = new StatusBar();
        menuBar = new AppMenuBar();

        setJMenuBar(menuBar.getMenuBar());

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(statusBar.getComponent(), BorderLayout.SOUTH);
    }

    public void setStatus(String message) {
        statusBar.setText(message);
    }

    public void setMainAreaText(String text) {
        mainArea.setText(text);
    }

    public void clearMainAreaText() {
        mainArea.setText("");
    }

    public void addMainMenuListener(MenuController listener) {
        menuBar.setMenuListener(listener);
    }

    public void addWindowListener(WindowListener listener) {
        super.addWindowListener(listener);
    }
}
