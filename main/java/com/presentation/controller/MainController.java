//edição de 2024-06-20
package com.presentation.controller;

import com.presentation.view.MainFrame;

import javax.swing.*;

/**
 * Controlador principal e ponto de entrada da aplicação.
 * Responsável por inicializar a View principal e os outros controladores.
 */
public class MainController {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Cria a View principal
            MainFrame mainFrame = new MainFrame();

            // 2. Cria os controladores, passando as Views que eles precisam gerenciar
            new MenuController(mainFrame.getMenuBarView());

            // 3. Torna a aplicação visível
            mainFrame.setVisible(true);
        });
    }
}