package com.presentation.view;

import com.presentation.controller.ConfigController;
import com.presentation.controller.MenuController;
import com.presentation.shared.constants.UIConstants;
import com.presentation.shared.util.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.util.Objects;

public class MainView extends JFrame {

    private JLabel fileTitleLabel;
    private JTextArea mainArea;
    private StatusBar statusBar;
    private AppMenuBar menuBar;
    private ConfigController configController;
    private AnimatedBackgroundPanel backgroundPanel;

    private JPanel centralPanel;
    private static final String CARD_BACKGROUND = "background";
    private static final String CARD_TEXT = "text";

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

        fileTitleLabel = new JLabel("", SwingConstants.CENTER);
        fileTitleLabel.setFont(new Font(UIConstants.TEXT_AREA_TITLE_NAME, Font.BOLD, UIConstants.TEXT_AREA_TITLE_SIZE));
        fileTitleLabel.setBorder(BorderFactory.createEmptyBorder(
                UIConstants.TEXT_AREA_TITLE_HORIZONTAL_BORDER,
                UIConstants.TEXT_AREA_TITLE_VERTICAL_BORDER,
                UIConstants.TEXT_AREA_TITLE_HORIZONTAL_BORDER,
                UIConstants.TEXT_AREA_TITLE_VERTICAL_BORDER));

        // Painel animado e controlador de configuração
        backgroundPanel = new AnimatedBackgroundPanel();
        configController = new ConfigController(this, backgroundPanel);

        // Painel de texto
        mainArea = new JTextArea();
        mainArea.setEditable(false);
        mainArea.setLineWrap(true);
        mainArea.setWrapStyleWord(true);
        mainArea.setFocusable(false);

        JScrollPane scrollPane = new JScrollPane(mainArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // CardLayout central
        centralPanel = new JPanel(new CardLayout());
        centralPanel.add(backgroundPanel, CARD_BACKGROUND);
        centralPanel.add(scrollPane, CARD_TEXT);

        statusBar = new StatusBar();
        menuBar = new AppMenuBar();

        setJMenuBar(menuBar.getMenuBar());

        setLayout(new BorderLayout());
        add(fileTitleLabel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        add(statusBar.getComponent(), BorderLayout.SOUTH);

        // Inicial: mostra o background animado
        showBackgroundMode();
    }

    // Alterna para modo de fundo animado
    public void showBackgroundMode() {
        CardLayout cl = (CardLayout) centralPanel.getLayout();
        cl.show(centralPanel, CARD_BACKGROUND);
    }

    // Alterna para modo texto
    public void showTextMode() {
        CardLayout cl = (CardLayout) centralPanel.getLayout();
        cl.show(centralPanel, CARD_TEXT);
    }

    public void setStatus(String message) {
        statusBar.setText(message);
    }

    public void setMainAreaContent(String fileName, String textContent) {
        fileTitleLabel.setText(fileName);
        mainArea.setText(textContent);
        showTextMode(); // Ao atualizar conteúdo, mostra modo texto
    }

    public void clearMainAreaContent() {
        fileTitleLabel.setText("");
        mainArea.setText("");
        showBackgroundMode(); // Ao limpar, volta para animado
    }

    public void addMainMenuListener(MenuController listener) {
        menuBar.setMenuListener(listener);
    }

    public void addWindowListener(WindowListener listener) {
        super.addWindowListener(listener);
    }
}