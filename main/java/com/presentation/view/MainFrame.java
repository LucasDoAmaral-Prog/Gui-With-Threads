package com.presentation.view;

import com.presentation.controller.FileController;
import com.presentation.controller.MenuController;
import com.presentation.domain.service.AnimationService;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    
    private FileController fileController;
    private MenuController menuController;
    private MenuBarView menuBarView;
    private FileDisplayPanel fileDisplayPanel;
    private AnimatedBackgroundPanel backgroundPanel;

    public MainFrame() {
        initializeControllers();
        initializeFrame();
        setupComponents();
    }
    
    private void initializeControllers() {
        // Inicializa os controladores
        fileController = new FileController();
        menuController = new MenuController(fileController);
        menuBarView = new MenuBarView(menuController);
    }

    private void initializeFrame() {
        setTitle("Background Animado - Projeto GUI");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Mudamos para controlar a saída pelo menu
        setSize(800, 600);
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
        setJMenuBar(menuBarView.getMenuBar());
        
        // Cria o painel de exibição de arquivos
        fileDisplayPanel = new FileDisplayPanel();
        fileController.setFileDisplayPanel(fileDisplayPanel);
        
        // Cria o painel de background animado
        AnimationService animationService = new AnimationService();
        backgroundPanel = new AnimatedBackgroundPanel();
        
        // Layout principal
        setLayout(new BorderLayout());
        
        // Adiciona o painel de background como fundo
        add(backgroundPanel, BorderLayout.CENTER);
        
        // Adiciona o painel de arquivo sobreposto (pode ser transparente)
        add(fileDisplayPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
