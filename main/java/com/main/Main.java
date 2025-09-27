package com.main;

import com.presentation.controller.MainController;
import com.presentation.shared.constants.UIConstants;

import javax.swing.*;

/**
 * Classe principal da aplicação Java GUI
 * Ponto de entrada do programa
 */
public class Main {

    // Main
    public static void main(String[] args) {

        configureLookAndFeel();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    startApplication();
                } catch (Exception e) {
                    handleStartupError(e);
                }
            }
        });
    }

    // Configura o Look and Feel (estilo de parência) da aplicação
    private static void configureLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Could not set Look and Feel: " + e.getMessage());
        }
    }

    // Inicia a aplicação principal
    private static void startApplication() {
        // Cria e exibe a janela principal
        MainController mainWindow = new MainController();
        mainWindow.setVisible(true);

        // Atualiza a barra de status para indicar que a aplicação foi iniciada
        mainWindow.updateStatusBar(UIConstants.STATUS_READY);
    }

    // Manipula erros que possam ocorrer durante a inicialização
    private static void handleStartupError(Exception e) {
        String errorMessage = "Error starting the application: " + e.getMessage();

        e.printStackTrace();

        JOptionPane.showMessageDialog(null,
                errorMessage,
                UIConstants.DIALOG_TITLE_ERROR,
                JOptionPane.ERROR_MESSAGE);

        // Encerra a aplicação com código de erro
        System.exit(1);
    }
}