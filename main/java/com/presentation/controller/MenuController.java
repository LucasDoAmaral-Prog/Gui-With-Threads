package com.presentation.controller;

import com.presentation.shared.constants.MenuConstants;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Controlador responsável pela lógica do menu da aplicação
 */
public class MenuController {
    
    private final FileController fileController;
    private JMenuBar menuBar;
    
    public MenuController(FileController fileController) {
        this.fileController = fileController;
        initializeMenu();
    }
    
    /**
     * Inicializa a barra de menu completa
     */
    private void initializeMenu() {
        menuBar = new JMenuBar();
        createFileMenu();
        createConfigurationMenu();
        createHelpMenu();
    }
    
    /**
     * Cria o menu Arquivo com todas as suas opções
     */
    private void createFileMenu() {
        JMenu fileMenu = new JMenu(MenuConstants.MENU_FILE_TITLE);
        fileMenu.setMnemonic(KeyEvent.VK_A); // Alt + A para abrir o menu
        
        // Item: Abrir Arquivo
        JMenuItem openItem = createMenuItem(
            MenuConstants.MENU_FILE_OPEN, 
            KeyEvent.VK_A, 
            KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK),
            e -> fileController.openFile()
        );
        
        // Item: Fechar Arquivo
        JMenuItem closeItem = createMenuItem(
            MenuConstants.MENU_FILE_CLOSE, 
            KeyEvent.VK_F, 
            KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK),
            e -> fileController.closeFile()
        );
        
        // Separador
        JSeparator separator = new JSeparator();
        
        // Item: Sair
        JMenuItem exitItem = createMenuItem(
            MenuConstants.MENU_FILE_EXIT, 
            KeyEvent.VK_S, 
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK),
            e -> fileController.exitApplication()
        );
        
        // Adiciona os itens ao menu
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.add(separator);
        fileMenu.add(exitItem);
        
        // Adiciona o menu à barra de menu
        menuBar.add(fileMenu);
    }
    
    /**
     * Cria o menu Configuração (tá com outras opções só para simular)
     */
    private void createConfigurationMenu() {
        JMenu configMenu = new JMenu(MenuConstants.MENU_CONFIG_TITLE);
        configMenu.setMnemonic(KeyEvent.VK_C); // Alt + C para abrir o menu
        
        // Item: Padrões
        JMenuItem patternsItem = createMenuItem(
            MenuConstants.MENU_CONFIG_PATTERNS, 
            KeyEvent.VK_P, 
            null, // Sem atalho por enquanto
            e -> showNotImplementedDialog("Configuração de Padrões")
        );
        
        // Item: Cores
        JMenuItem colorsItem = createMenuItem(
            MenuConstants.MENU_CONFIG_COLORS, 
            KeyEvent.VK_O, 
            null,
            e -> showNotImplementedDialog("Configuração de Cores")
        );
        
        // Item: Velocidade
        JMenuItem speedItem = createMenuItem(
            MenuConstants.MENU_CONFIG_SPEED, 
            KeyEvent.VK_V, 
            null,
            e -> showNotImplementedDialog("Configuração de Velocidade")
        );
        
        // Adiciona os itens ao menu
        configMenu.add(patternsItem);
        configMenu.add(colorsItem);
        configMenu.add(speedItem);
        
        // Adiciona o menu à barra de menu
        menuBar.add(configMenu);
    }
    
    /**
     * Cria o menu Ajuda (só para simular)
     */
    private void createHelpMenu() {
        JMenu helpMenu = new JMenu(MenuConstants.MENU_HELP_TITLE);
        helpMenu.setMnemonic(KeyEvent.VK_J); // Alt + J para abrir o menu
        
        // Item: Ajuda
        JMenuItem helpItem = createMenuItem(
            MenuConstants.MENU_HELP_HELP, 
            KeyEvent.VK_A, 
            KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), // F1 para ajuda
            e -> showNotImplementedDialog("Ajuda")
        );
        
        // Item: Sobre
        JMenuItem aboutItem = createMenuItem(
            MenuConstants.MENU_HELP_ABOUT, 
            KeyEvent.VK_S, 
            null,
            e -> showNotImplementedDialog("Sobre")
        );
        
        // Adiciona os itens ao menu
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        
        // Adiciona o menu à barra de menu
        menuBar.add(helpMenu);
    }
    
    private void showNotImplementedDialog(String feature) {
        JOptionPane.showMessageDialog(
            null,
            "A parte de '" + feature + "' ainda não foi implementada :(.",
            "Funcionalidade não implementada",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * Método auxiliar para criar itens de menu
     */
    private JMenuItem createMenuItem(String text, int mnemonic, KeyStroke accelerator, ActionListener action) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setMnemonic(mnemonic);
        if (accelerator != null) {
            menuItem.setAccelerator(accelerator);
        }
        menuItem.addActionListener(action);
        return menuItem;
    }
    
    /**
     * Retorna a barra de menu criada
     */
    public JMenuBar getMenuBar() {
        return menuBar;
    }
    
    /**
     * Atualiza o estado dos itens de menu baseado no estado da aplicação
     */
    public void updateMenuState() {
        SwingUtilities.invokeLater(() -> {
            boolean hasOpenFile = fileController.hasOpenFile();
            
            // Encontra o item "Fechar Arquivo" e atualiza seu estado
            JMenu fileMenu = menuBar.getMenu(0); // Menu Arquivo é o primeiro 
            if (fileMenu != null && fileMenu.getItemCount() > 1) {
                JMenuItem closeItem = fileMenu.getItem(1); // "Fechar Arquivo" é o segundo item
                if (closeItem != null) {
                    closeItem.setEnabled(hasOpenFile);
                }
            }
        });
    }
}