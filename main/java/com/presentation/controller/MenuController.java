package com.presentation.controller;

import com.presentation.shared.constants.MenuConstants;
import com.presentation.shared.constants.UIConstants;

import javax.swing.*;

public class MenuController implements java.awt.event.ActionListener {

    private ConfigController configController;
    private JFrame parentFrame;

    public MenuController(JFrame parentFrame, ConfigController configController) {
        this.parentFrame = parentFrame;
        this.configController = configController;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case MenuConstants.ACTION_PADROES:
                    configController.configurePattern();
                    break;

                case MenuConstants.ACTION_CORES:
                    configController.configureColor();
                    break;

                case MenuConstants.ACTION_VELOCIDADE:
                    configController.configureSpeed();
                    break;

                default:
                    showNotImplementedMessage();
                    break;
            }
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void showNotImplementedMessage() {
        JOptionPane.showMessageDialog(parentFrame,
                UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED,
                UIConstants.DIALOG_TITLE_INFO,
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleException(Exception ex) {
        String message = "Erro inesperado: " + ex.getMessage();
        JOptionPane.showMessageDialog(parentFrame,
                message,
                UIConstants.DIALOG_TITLE_ERROR,
                JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
