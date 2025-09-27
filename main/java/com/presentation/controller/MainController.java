package com.presentation.controller;

import com.presentation.shared.constants.MenuConstants;
import com.presentation.shared.constants.UIConstants;
import com.presentation.view.AnimatedBackgroundPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Controlador principal da aplicação (interface e layout)
 */
public class MainController extends JFrame {

    private MenuController menuController;
    private ConfigController configController;
    private AnimatedBackgroundPanel backgroundPanel;
    private JLabel statusBar;
    private JMenuBar menuBar;

    public MainController() {
        initializeComponents();
        setupWindow();
        createMenus();
        layoutComponents();
    }

    private void initializeComponents() {
        backgroundPanel = new AnimatedBackgroundPanel(); // painel animado
        configController = new ConfigController(this, backgroundPanel); // novo controlador de config
        menuController = new MenuController(this, configController);   // menu delega para config

        // Barra de status
        statusBar = new JLabel(UIConstants.STATUS_READY);
        statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
        statusBar.setPreferredSize(new Dimension(0, 25));
    }

    private void setupWindow() {
        setTitle(UIConstants.MAIN_WINDOW_TITLE);
        setSize(UIConstants.MAIN_WINDOW_WIDTH, UIConstants.MAIN_WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenus() {
        menuBar = new JMenuBar();

        // Menu Configuração
        JMenu menuConfiguracao = new JMenu(MenuConstants.MENU_CONFIGURACAO);
        menuConfiguracao.setMnemonic(MenuConstants.MNEMONIC_CONFIGURACAO);

        menuConfiguracao.add(createMenuItem(
                MenuConstants.MENU_ITEM_PADROES,
                MenuConstants.MNEMONIC_PADROES,
                MenuConstants.ACTION_PADROES));

        menuConfiguracao.add(createMenuItem(
                MenuConstants.MENU_ITEM_CORES,
                MenuConstants.MNEMONIC_CORES,
                MenuConstants.ACTION_CORES));

        menuConfiguracao.add(createMenuItem(
                MenuConstants.MENU_ITEM_VELOCIDADE,
                MenuConstants.MNEMONIC_VELOCIDADE,
                MenuConstants.ACTION_VELOCIDADE));

        menuBar.add(menuConfiguracao);
        setJMenuBar(menuBar);
    }

    private JMenuItem createMenuItem(String text, int mnemonic, String actionCommand) {
        JMenuItem item = new JMenuItem(text);
        item.setMnemonic(mnemonic);
        item.setActionCommand(actionCommand);
        item.addActionListener(menuController); // delegado para MenuController
        return item;
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(backgroundPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    public void updateStatusBar(String message) {
        statusBar.setText(message);
    }
}
