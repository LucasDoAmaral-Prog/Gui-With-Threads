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
    private JTextArea mainArea; // Agora é JTextArea para texto simples e quebra automática
    private StatusBar statusBar;
    private AppMenuBar menuBar;

    public MainView() {
        setTitle(UIConstants.MAIN_WINDOW_TITLE);
        setSize(UIConstants.MAIN_WINDOW_WIDTH, UIConstants.MAIN_WINDOW_HEIGHT);
        setMinimumSize(new Dimension(UIConstants.MAIN_WINDOW_MIN_WIDTH, UIConstants.MAIN_WINDOW_MIN_HEIGHT));
        setLocationRelativeTo(null);

        try {
            ImageIcon logo = new ImageIcon(
                    Objects.requireNonNull(UIConstants.class.getResource(UIConstants.LOGO_PATH))
            );
            setIconImage(logo.getImage());
        } catch (Exception e) {
            setIconImage(UIUtils.createDefaultIcon());
        }

        // Personalizando título do arquivo
        fileTitleLabel = new JLabel("", SwingConstants.CENTER);
        fileTitleLabel.setFont(new Font(UIConstants.TEXT_AREA_TITLE_NAME, Font.BOLD, UIConstants.TEXT_AREA_TITLE_SIZE));
        fileTitleLabel.setBorder(BorderFactory.createEmptyBorder(
                UIConstants.TEXT_AREA_TITLE_HORIZONTAL_BORDER,
                UIConstants.TEXT_AREA_TITLE_VERTICAL_BORDER,
                UIConstants.TEXT_AREA_TITLE_HORIZONTAL_BORDER,
                UIConstants.TEXT_AREA_TITLE_VERTICAL_BORDER));

        // Área principal para texto simples, com quebra de linha automática e scroll vertical
        mainArea = new JTextArea();
        mainArea.setEditable(false);
        mainArea.setLineWrap(true);
        mainArea.setWrapStyleWord(true);
        mainArea.setFocusable(false);

        JScrollPane scrollPane = new JScrollPane(mainArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        statusBar = new StatusBar();
        menuBar = new AppMenuBar();

        setJMenuBar(menuBar.getMenuBar());

        setLayout(new BorderLayout());
        add(fileTitleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statusBar.getComponent(), BorderLayout.SOUTH);
    }

    public void setStatus(String message) {
        statusBar.setText(message);
    }

    public void setMainAreaContent(String fileName, String textContent) {
        fileTitleLabel.setText(fileName);
        mainArea.setText(textContent);
    }

    public void clearMainAreaContent() {
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