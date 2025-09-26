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
    
    // === REFERÊNCIAS DIRETAS DOS ITENS DE MENU ===
    private JMenuItem openFileItem;
    private JMenuItem closeFileItem;
    private JMenuItem exitItem;
    
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
        
        // Item: Abrir Arquivo - GUARDA REFERÊNCIA
        openFileItem = createMenuItem(
            MenuConstants.MENU_FILE_OPEN, 
            KeyEvent.VK_A, 
            KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK),
            e -> fileController.openFile()
        );
        
        // Item: Fechar Arquivo - GUARDA REFERÊNCIA
        closeFileItem = createMenuItem(
            MenuConstants.MENU_FILE_CLOSE, 
            KeyEvent.VK_F, 
            KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK),
            e -> fileController.closeFile()
        );
        
        // Separador
        JSeparator separator = new JSeparator();
        
        // Item: Sair - GUARDA REFERÊNCIA
        exitItem = createMenuItem(
            MenuConstants.MENU_FILE_EXIT, 
            KeyEvent.VK_S, 
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK),
            e -> fileController.exitApplication()
        );
        
        // Adiciona os itens ao menu
        fileMenu.add(openFileItem);
        fileMenu.add(closeFileItem);
        fileMenu.add(separator);
        fileMenu.add(exitItem);
        
        // Adiciona o menu à barra de menu
        menuBar.add(fileMenu);
    }
    
    /**
     * Cria o menu Configuração (placeholder)
     */
    private void createConfigurationMenu() {
        JMenu configMenu = new JMenu(MenuConstants.MENU_CONFIG_TITLE);
        configMenu.setMnemonic(KeyEvent.VK_C); // Alt + C para abrir o menu
        
        // Item: Padrões
        JMenuItem patternsItem = createMenuItem(
            MenuConstants.MENU_CONFIG_PATTERNS, 
            KeyEvent.VK_P, 
            null,
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
        
        configMenu.add(patternsItem);
        configMenu.add(colorsItem);
        configMenu.add(speedItem);
        
        menuBar.add(configMenu);
    }
    
    /**
     * Cria o menu Ajuda (placeholder)
     */
    private void createHelpMenu() {
        JMenu helpMenu = new JMenu(MenuConstants.MENU_HELP_TITLE);
        helpMenu.setMnemonic(KeyEvent.VK_J); // Alt + J para abrir o menu
        
        // Item: Ajuda
        JMenuItem helpItem = createMenuItem(
            MenuConstants.MENU_HELP_HELP, 
            KeyEvent.VK_A, 
            KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0),
            e -> showNotImplementedDialog("Ajuda")
        );
        
        // Item: Sobre
        JMenuItem aboutItem = createMenuItem(
            MenuConstants.MENU_HELP_ABOUT, 
            KeyEvent.VK_S, 
            null,
            e -> showNotImplementedDialog("Sobre")
        );
        
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        
        menuBar.add(helpMenu);
    }
    
    /**
     * Mostra diálogo para funcionalidades não implementadas
     */
    private void showNotImplementedDialog(String feature) {
        JOptionPane.showMessageDialog(
            null,
            String.format(MenuConstants.MESSAGE_NOT_IMPLEMENTED, feature),
            MenuConstants.TITLE_NOT_IMPLEMENTED,
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
     * Atualiza o estado dos itens de menu - USA REFERÊNCIAS DIRETAS
     */
    public void updateMenuState() {
        SwingUtilities.invokeLater(() -> {
            boolean hasOpenFile = fileController.hasOpenFile();
            
            // ✅ SOLUÇÃO ROBUSTA: Usa referência direta
            if (closeFileItem != null) {
                closeFileItem.setEnabled(hasOpenFile);
            }
        });
    }
}