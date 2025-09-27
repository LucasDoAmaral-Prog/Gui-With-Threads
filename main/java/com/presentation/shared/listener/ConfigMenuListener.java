package com.presentation.shared.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigMenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementação básica: apenas imprime o comando
        System.out.println("ConfigMenuListener acionado: " + e.getActionCommand());
    }
}
