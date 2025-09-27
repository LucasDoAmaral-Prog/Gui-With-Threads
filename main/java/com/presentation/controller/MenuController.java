package com.presentation.controller;

import com.presentation.dialog.config.ColorConfigDialog;
import com.presentation.dialog.config.PatternConfigDialog;
import com.presentation.dialog.config.SpeedConfigDialog;
import com.presentation.dialog.file.CloseFileDialog;
import com.presentation.dialog.file.ExitDialog;
import com.presentation.dialog.file.OpenFileDialog;
import com.presentation.dialog.help.AboutDialog;
import com.presentation.dialog.help.HelpDialog;
import com.presentation.shared.constants.UIConstants;
import com.presentation.shared.constants.MenuConstants;
import com.presentation.shared.exception.DirectoryNotFoundException;
import com.presentation.shared.exception.FileReadException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Controlador responsável por gerenciar as ações dos menus
 */
public class MenuController implements ActionListener {

    private JFrame parentFrame;

    public MenuController(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case MenuConstants.ACTION_ABRIR_ARQUIVO:
                    handleOpenFile();
                    break;

                case MenuConstants.ACTION_FECHAR_ARQUIVO:
                    handleCloseFile();
                    break;

                case MenuConstants.ACTION_SAIR:
                    handleExit();
                    break;

                case MenuConstants.ACTION_PADROES:
                    handlePatternConfig();
                    break;

                case MenuConstants.ACTION_CORES:
                    handleColorConfig();
                    break;

                case MenuConstants.ACTION_VELOCIDADE:
                    handleSpeedConfig();
                    break;

                case MenuConstants.ACTION_AJUDA:
                    handleHelp();
                    break;

                case MenuConstants.ACTION_SOBRE:
                    handleAbout();
                    break;

                default:
                    showNotImplementedMessage();
                    break;
            }
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void handleOpenFile() throws IOException, FileReadException, DirectoryNotFoundException {
        FileController controller = new FileController();
        MainController.displayOnMainArea(controller.openFile());
        updateStatusBar(UIConstants.STATUS_FILE_OPENED);
    }

    private void handleCloseFile() {
        MainController.clearMainArea();
        updateStatusBar(UIConstants.STATUS_FILE_CLOSED);
    }

    private void handleExit() {
        ExitDialog dialog = new ExitDialog(parentFrame);
        dialog.setVisible(true);

        if (dialog.isExitConfirmed()) {
            System.exit(0);
        }
    }

    private void handlePatternConfig() {
        PatternConfigDialog dialog = new PatternConfigDialog(parentFrame);
        dialog.setVisible(true);
    }

    private void handleColorConfig() {
        ColorConfigDialog dialog = new ColorConfigDialog(parentFrame);
        dialog.setVisible(true);
    }

    private void handleSpeedConfig() {
        SpeedConfigDialog dialog = new SpeedConfigDialog(parentFrame);
        dialog.setVisible(true);
    }

    private void handleHelp() {
        HelpDialog dialog = new HelpDialog(parentFrame);
        dialog.setVisible(true);
    }

    private void handleAbout() {
        AboutDialog dialog = new AboutDialog(parentFrame);
        dialog.setVisible(true);
    }

    private void showNotImplementedMessage() {
        JOptionPane.showMessageDialog(parentFrame,
                UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED,
                UIConstants.DIALOG_TITLE_INFO,
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Atualiza a barra de status delegando para a classe principal
    void updateStatusBar(String message) {
        if (parentFrame instanceof MainController) {
            ((MainController) parentFrame).updateStatusBar(message);
        }
    }

    // Limpa a área principal delegando para a classe principal
    private void clearMainArea() {
        if (parentFrame instanceof MainController) {
            ((MainController) parentFrame).clearMainArea();
        }
    }

    // Manipula exceções que possam ocorrer
    private void handleException(Exception ex) {
        String message = "Erro inesperado: " + ex.getMessage();
        JOptionPane.showMessageDialog(parentFrame,
                message,
                UIConstants.DIALOG_TITLE_ERROR,
                JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

}