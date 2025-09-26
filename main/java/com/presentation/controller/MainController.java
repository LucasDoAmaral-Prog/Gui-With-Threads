package com.presentation.controller;

import com.presentation.view.MainFrame;
import javax.swing.SwingUtilities;

/**
 * Controlador principal da aplicação
 * Coordena todos os outros controladores e inicializa a aplicação
 */
public class MainController {
    
    private MainFrame mainFrame;
    private FileController fileController;
    private MenuController menuController;
    
    public MainController() {
        initializeApplication();
    }
    
    /**
     * Inicializa toda a aplicação
     */
    private void initializeApplication() {
        SwingUtilities.invokeLater(() -> {
            // Cria e exibe a janela principal
            mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            
            // Obtém referências dos controladores já criados no MainFrame
            fileController = mainFrame.getFileController();
            menuController = mainFrame.getMenuController();
            
            // Configuração inicial
            updateInitialState();
        });
    }
    
    /**
     * Configura o estado inicial da aplicação
     */
    private void updateInitialState() {
        if (menuController != null) {
            menuController.updateMenuState();
        }
    }
    
    /**
     * Obtém o controlador de arquivos
     */
    public FileController getFileController() {
        return fileController;
    }
    
    /**
     * Obtém o controlador de menu
     */
    public MenuController getMenuController() {
        return menuController;
    }
    
    /**
     * Obtém a janela principal
     */
    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    /**
     * Método principal para inicializar a aplicação
     */
    public static void main(String[] args) {
        // Configura o Look and Feel do sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            // Se falhar, usa o padrão do Java
            System.err.println("Couldn't set system look and feel: " + e.getMessage());
        }
        
        // Inicializa a aplicação
        new MainController();
    }
}