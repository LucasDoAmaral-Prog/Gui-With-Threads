package com.presentation.shared.util;

import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import java.awt.*;

public class UIUtils {

    // Cria um ícone padrão para a aplicação que será utilizado se a logo personalizada não for encontrada
    public static Image createDefaultIcon() {
        int size = 32;
        java.awt.image.BufferedImage icon = new java.awt.image.BufferedImage(size, size, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = icon.createGraphics();
        g2d.setColor(Color.magenta);
        g2d.fillOval(4, 4, size-8, size-8);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("?", 12, 22);
        g2d.dispose();
        return icon;
    }

    // Facilitam a exibição de mensagens para o usuário com título padrão ou personalizado
    public static void showMessage(String message, int messageType) {
        showMessage(message, UIConstants.DIALOG_TITLE_DEFAULT, messageType);
    }

    public static void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    public static void configureOptionPaneBntOptions() {
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do tipo");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");
        UIManager.put("FileChooser.openDialogTitleText", "Selecionar arquivo");
    }


}
