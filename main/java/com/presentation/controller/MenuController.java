//package com.presentation.controller;
//
//import com.presentation.dialog.config.ColorConfigDialog;
//import com.presentation.dialog.config.PatternConfigDialog;
//import com.presentation.dialog.config.SpeedConfigDialog;
//import com.presentation.dialog.file.CloseFileDialog;
//import com.presentation.dialog.file.ExitDialog;
//import com.presentation.dialog.file.OpenFileDialog;
//import com.presentation.dialog.help.AboutDialog;
//import com.presentation.dialog.help.HelpDialog;
//import com.presentation.shared.constants.UIConstants;
//import com.presentation.shared.constants.MenuConstants;
//import com.presentation.shared.exception.DirectoryNotFoundException;
//import com.presentation.shared.exception.FileReadException;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//
///**
// * Controlador responsável por gerenciar as ações dos menus
// */
//public class MenuController implements ActionListener {
//
//    private JFrame parentFrame;
//
//    public MenuController(JFrame parentFrame) {
//        this.parentFrame = parentFrame;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String command = e.getActionCommand();
//
//        try {
//            switch (command) {
//                case MenuConstants.ACTION_ABRIR_ARQUIVO:
//                    handleOpenFile();
//                    break;
//
//                case MenuConstants.ACTION_FECHAR_ARQUIVO:
//                    handleCloseFile();
//                    break;
//
//                case MenuConstants.ACTION_SAIR:
//                    handleExit();
//                    break;
//
//                case MenuConstants.ACTION_PADROES:
//                    handlePatternConfig();
//                    break;
//
//                case MenuConstants.ACTION_CORES:
//                    handleColorConfig();
//                    break;
//
//                case MenuConstants.ACTION_VELOCIDADE:
//                    handleSpeedConfig();
//                    break;
//
//                case MenuConstants.ACTION_AJUDA:
//                    handleHelp();
//                    break;
//
//                case MenuConstants.ACTION_SOBRE:
//                    handleAbout();
//                    break;
//
//                default:
//                    showNotImplementedMessage();
//                    break;
//            }
//        } catch (Exception ex) {
//            handleException(ex);
//        }
//    }
//
//    private void handleOpenFile() throws IOException, FileReadException, DirectoryNotFoundException {
//        FileController controller = new FileController();
//        MainController.displayOnMainArea(controller.openFile());
//        updateStatusBar(UIConstants.STATUS_FILE_OPENED);
//    }
//
//    private void handleCloseFile() {
//        MainController.clearMainArea();
//        updateStatusBar(UIConstants.STATUS_FILE_CLOSED);
//    }
//
//    private void handleExit() {
//        ExitDialog dialog = new ExitDialog(parentFrame);
//        dialog.setVisible(true);
//
//        if (dialog.isExitConfirmed()) {
//            System.exit(0);
//        }
//    }
//
//    private void handlePatternConfig() {
//        PatternConfigDialog dialog = new PatternConfigDialog(parentFrame);
//        dialog.setVisible(true);
//    }
//
//    private void handleColorConfig() {
//        ColorConfigDialog dialog = new ColorConfigDialog(parentFrame);
//        dialog.setVisible(true);
//    }
//
//    private void handleSpeedConfig() {
//        SpeedConfigDialog dialog = new SpeedConfigDialog(parentFrame);
//        dialog.setVisible(true);
//    }
//
//    private void handleHelp() {
//        HelpDialog dialog = new HelpDialog(parentFrame);
//        dialog.setVisible(true);
//    }
//
//    private void handleAbout() {
//        AboutDialog dialog = new AboutDialog(parentFrame);
//        dialog.setVisible(true);
//    }
//
//    private void showNotImplementedMessage() {
//        JOptionPane.showMessageDialog(parentFrame,
//                UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED,
//                UIConstants.DIALOG_TITLE_INFO,
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    // Atualiza a barra de status delegando para a classe principal
//    void updateStatusBar(String message) {
//        if (parentFrame instanceof MainController) {
//            ((MainController) parentFrame).updateStatusBar(message);
//        }
//    }
//
//    // Limpa a área principal delegando para a classe principal
//    private void clearMainArea() {
//        if (parentFrame instanceof MainController) {
//            ((MainController) parentFrame).clearMainArea();
//        }
//    }
//
//    // Manipula exceções que possam ocorrer
//    private void handleException(Exception ex) {
//        String message = "Erro inesperado: " + ex.getMessage();
//        JOptionPane.showMessageDialog(parentFrame,
//                message,
//                UIConstants.DIALOG_TITLE_ERROR,
//                JOptionPane.ERROR_MESSAGE);
//        ex.printStackTrace();
//    }
//
//}


package com.presentation.controller;

import com.presentation.shared.constants.MenuConstants;
import com.presentation.shared.constants.StatusBarConstants;
import com.presentation.shared.listener.MenuListener;
import com.presentation.view.MainView;

import javax.swing.*;

public class MenuController extends MenuListener {

    private MainView mainView;

    public MenuController(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onMenuSelected(String command) {
        switch (command) {
            case MenuConstants.ACTION_ABRIR_ARQUIVO:
                openFile();
                break;
            case MenuConstants.ACTION_FECHAR_ARQUIVO:
                closeFile();
                break;
            case MenuConstants.ACTION_SAIR:
                exit();
                break;
            case MenuConstants.ACTION_PADROES:
                configurePatterns();
                break;
            case MenuConstants.ACTION_CORES:
                configureColors();
                break;
            case MenuConstants.ACTION_VELOCIDADE:
                configureSpeed();
                break;
            case MenuConstants.ACTION_AJUDA:
                showHelp();
                break;
            case MenuConstants.ACTION_SOBRE:
                showAbout();
                break;
            default:
                // default action, if needed
        }
    }

    private void openFile() {
        mainView.setStatus(StatusBarConstants.STATUS_FILE_OPENING);
        FileController fileController = new FileController();
        try {
            String fileContent = fileController.openFile();
            mainView.setMainAreaText(fileContent);
            mainView.setStatus(StatusBarConstants.STATUS_FILE_OPENED);
        } catch (Exception e) {
            mainView.setStatus("Error opening file: " + e.getMessage());
            mainView.setMainAreaText("");
            mainView.setStatus(StatusBarConstants.STATUS_READY);
        }
    }

    private void closeFile() {
        mainView.setStatus(StatusBarConstants.STATUS_FILE_CLOSING);
        mainView.clearMainAreaText();
        mainView.setStatus(StatusBarConstants.STATUS_READY);

    }
    private void exit() {
        // Opcional: exibe mensagem na barra de status
        mainView.setStatus(StatusBarConstants.STATUS_EXITING);

        // Opcional: caixa de confirmação
        int result = JOptionPane.showConfirmDialog(
                mainView,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION
        );
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0); // Encerra a aplicação
        }
        mainView.setStatus(StatusBarConstants.STATUS_READY);
    }
    private void configurePatterns() {
        /* substitua o bloco de código a seguir pela lógica do que deve acontecer quando este botão é clicado */
        String message = "Configuração de padrão selecionado";
        JOptionPane.showMessageDialog(mainView, message, "Menu Action" , JOptionPane.INFORMATION_MESSAGE);
        mainView.setStatus(message);
    }
    private void configureColors() {
        /* substitua o bloco de código a seguir pela lógica do que deve acontecer quando este botão é clicado */
        String message = "Configuração de cor selecionado";
        JOptionPane.showMessageDialog(mainView, message, "Menu Action" , JOptionPane.INFORMATION_MESSAGE);
        mainView.setStatus(message);
    }
    private void configureSpeed() {
        /* substitua o bloco de código a seguir pela lógica do que deve acontecer quando este botão é clicado */
        String message = "Configuração de velocidade selecionado";
        JOptionPane.showMessageDialog(mainView, message, "Menu Action" , JOptionPane.INFORMATION_MESSAGE);
        mainView.setStatus(message);
    }
    private void showHelp() {
        /* substitua o bloco de código a seguir pela lógica do que deve acontecer quando este botão é clicado */
        String message = "Ajuda selecionado";
        JOptionPane.showMessageDialog(mainView, message, "Menu Action" , JOptionPane.INFORMATION_MESSAGE);
        mainView.setStatus(message);
    }
    private void showAbout() {
        /* substitua o bloco de código a seguir pela lógica do que deve acontecer quando este botão é clicado */
        String message = "Sobre selecionado";
        JOptionPane.showMessageDialog(mainView, message, "Menu Action" , JOptionPane.INFORMATION_MESSAGE);
        mainView.setStatus(message);
    }
}