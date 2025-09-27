//edição de 2024-06-20
package com.presentation.shared.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileMenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "open":
                JOptionPane.showMessageDialog(null, "Ação: Abrir Arquivo");
                break;
            case "close":
                JOptionPane.showMessageDialog(null, "Ação: Fechar Arquivo");
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }
}