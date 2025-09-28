package com.presentation.controller;

import com.presentation.dialog.about.AboutDialog;
import com.presentation.dialog.help.HelpDialog;
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
        }
    }

    private void openFile() {
        mainView.setStatus(StatusBarConstants.STATUS_FILE_OPENING);
        FileController fileController = new FileController();
        try {
            String fileContent = fileController.openFile();
            String fileName = fileController.getCurrentFileName();
            mainView.setMainAreaContent(fileName, fileContent);
            mainView.setStatus(StatusBarConstants.STATUS_FILE_OPENED + ": " + fileName);
        } catch (Exception e) {
            mainView.setStatus(StatusBarConstants.STATUS_ERROR_OPENING_FILE + ": " + e.getMessage());
            mainView.clearMainAreaContent();
            // Adicionando delay entre o status de erro e o status pronto para que o usuário possa ler a mensagem de erro
            new javax.swing.Timer(StatusBarConstants.DELAY_AFTER_ERROR, evt -> {
                mainView.setStatus(StatusBarConstants.STATUS_READY);
            }).start();
        }
    }

    private void closeFile() {
        mainView.setStatus(StatusBarConstants.STATUS_FILE_CLOSING);
        mainView.clearMainAreaContent();
        mainView.setStatus(StatusBarConstants.STATUS_READY);
    }
    private void exit() {
        mainView.setStatus(StatusBarConstants.STATUS_EXITING);

        int result = JOptionPane.showConfirmDialog(
                mainView,
                MenuConstants.DIALOG_MESSAGE_EXITING,
                MenuConstants.DIALOG_TITLE_EXITING,
                JOptionPane.YES_NO_OPTION
        );
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0); // Encerra a aplicação
        }
        mainView.setStatus(StatusBarConstants.STATUS_READY);
    }

    private void configurePatterns() {
        mainView.getConfigController().configurePattern();
        mainView.setStatus("Padrão atualizado");
    }

    private void configureColors() {
        mainView.getConfigController().configureColor();
        mainView.setStatus("Esquema de cores atualizado");
    }

    private void configureSpeed() {
        mainView.getConfigController().configureSpeed();
        mainView.setStatus("Velocidade atualizada");
    }

    private void showHelp() {
        HelpDialog.showDialog(mainView);
        mainView.setStatus("Sistema de ajuda detalhado exibido com atalhos atualizados");
    }


    private void showAbout() {
        AboutDialog.showDialog(mainView);
        mainView.setStatus("Informações detalhadas sobre o projeto exibidas");
    }



}