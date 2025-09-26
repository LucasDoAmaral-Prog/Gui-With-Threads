package com.presentation.view;

import com.presentation.controller.FileController;
import com.presentation.controller.MenuController;
import com.presentation.domain.service.AnimationService;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    
    private FileController fileController;
    private MenuController menuController;
    private FileDisplayPanel fileDisplayPanel;
    private AnimatedBackgroundPanel backgroundPanel;

    public MainFrame() {
        initializeControllers();
        initializeFrame();
        setupComponents();
        setupLayout();
        finalizeSetup();
    }
    
    private void initializeControllers() {
        // Inicializa os controladores
        fileController = new FileController();
        menuController = new MenuController(fileController);
    }

    private void initializeFrame() {
        setTitle("Background Animado - Projeto GUI com Menu Arquivo");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000, 700); // Aumentei para acomodar melhor os componentes
        setLocationRelativeTo(null);
        
        // Adiciona listener para o botão X da janela
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                fileController.exitApplication();
            }
        });
    }

    private void setupComponents() {
        // Configura a barra de menu
        setJMenuBar(menuController.getMenuBar());
        
        // Cria o painel de exibição de arquivos
        fileDisplayPanel = new FileDisplayPanel();
        fileController.setFileDisplayPanel(fileDisplayPanel);
        
        // Cria o painel de background animado
        backgroundPanel = new AnimatedBackgroundPanel();
    }
    
    private void setupLayout() {
        // Layout principal usando BorderLayout
        setLayout(new BorderLayout());
        
        // Painel principal que combina fundo animado e área de arquivo
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Adiciona o background animado
        mainPanel.add(backgroundPanel, BorderLayout.CENTER);
        
        // Adiciona o painel de arquivo à direita
        mainPanel.add(fileDisplayPanel, BorderLayout.EAST);
        
        // Adiciona o painel principal ao frame
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private void finalizeSetup() {
        // ✅ CONECTA OS CONTROLADORES
        fileController.setMenuController(menuController);
        
        // Configuração final
        pack();
        setSize(1000, 700);
        
        // Atualiza estado inicial dos menus
        if (menuController != null) {
            menuController.updateMenuState();
        }
    }
    
    // === GETTERS PARA OS CONTROLADORES ===
    
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
     * Obtém o painel de exibição de arquivos
     */
    public FileDisplayPanel getFileDisplayPanel() {
        return fileDisplayPanel;
    }
    
    /**
     * Obtém o painel de background animado
     */
    public AnimatedBackgroundPanel getBackgroundPanel() {
        return backgroundPanel;
    }

    /**
     * Método main alternativo (pode usar o MainController.main também)
     */
    public static void main(String[] args) {
        // Configura o Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            System.err.println("Couldn't set system look and feel: " + e.getMessage());
        }
        
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}