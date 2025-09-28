package com.basicgui;

import javax.swing.*;
import com.presentation.controller.MainController;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Cria e exibe a janela principal
            MainController mainFrame = new MainController();
            mainFrame.setVisible(true);
        });
    }
}
