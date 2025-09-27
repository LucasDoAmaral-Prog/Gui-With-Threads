//edição de 2024-06-20
package com.presentation.controller;

import com.presentation.view.MenuBarView;
import com.presentation.shared.listener.ConfigMenuListener;
import com.presentation.shared.listener.FileMenuListener;
import com.presentation.shared.listener.HelpMenuListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuController {

    public MenuController(MenuBarView menuBar) {
        // Anexa os listeners aos itens de menu correspondentes
        attachListeners(menuBar);
    }

    private void attachListeners(MenuBarView menuBar) {
        // Instancia os listeners
        ActionListener fileListener = new FileMenuListener();
        ActionListener configListener = new ConfigMenuListener(); // Você precisará criar esta classe
        ActionListener helpListener = new HelpMenuListener();     // Você precisará criar esta classe

        // Anexa listener ao Menu 'Arquivo' (índice 0)
        JMenu fileMenu = menuBar.getMenu(0);
        for (int i = 0; i < fileMenu.getItemCount(); i++) {
            JMenuItem item = fileMenu.getItem(i);
            if (item != null) { // Ignora separadores
                item.addActionListener(fileListener);
            }
        }

        // Anexa listener ao Menu 'Configuração' (índice 1)
        JMenu configMenu = menuBar.getMenu(1);
        for (int i = 0; i < configMenu.getItemCount(); i++) {
            configMenu.getItem(i).addActionListener(configListener);
        }

        // Anexa listener ao Menu 'Ajuda' (índice 2)
        JMenu helpMenu = menuBar.getMenu(2);
        for (int i = 0; i < helpMenu.getItemCount(); i++) {
            helpMenu.getItem(i).addActionListener(helpListener);
        }
    }
}