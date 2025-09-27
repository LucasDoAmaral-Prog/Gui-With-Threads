//edição de 2024-06-20
package com.presentation.view;

import javax.swing.*;

/**
 * Factory para criar e configurar os menus e itens de menu da aplicação.
 * Centraliza a lógica de criação dos componentes da barra de menu.
 */
public class MenuItemFactory {

    public static JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("Arquivo");

        // Itens do menu Arquivo
        JMenuItem openItem = new JMenuItem("Abrir Arquivo");
        openItem.setActionCommand("open");

        JMenuItem closeItem = new JMenuItem("Fechar Arquivo");
        closeItem.setActionCommand("close");

        JMenuItem exitItem = new JMenuItem("Sair");
        exitItem.setActionCommand("exit");

    fileMenu.add(openItem);
    fileMenu.add(closeItem);
    fileMenu.addSeparator();
    fileMenu.add(exitItem);

        return fileMenu;
    }

    public static JMenu createConfigMenu() {
        JMenu configMenu = new JMenu("Configuração");

    // Itens do menu Configuração
        JMenuItem patternsItem = new JMenuItem("Padrões");
        patternsItem.setActionCommand("patterns");

        JMenuItem colorsItem = new JMenuItem("Cores");
        colorsItem.setActionCommand("colors");

        JMenuItem speedItem = new JMenuItem("Velocidade");
        speedItem.setActionCommand("speed");

        configMenu.add(patternsItem);
        configMenu.add(colorsItem);
        configMenu.add(speedItem);

        return configMenu;
    }

    public static JMenu createHelpMenu() {
        JMenu helpMenu = new JMenu("Ajuda");

    // Itens do menu Ajuda
        JMenuItem helpItem = new JMenuItem("Ajuda");
        helpItem.setActionCommand("help");

        JMenuItem aboutItem = new JMenuItem("Sobre");
        aboutItem.setActionCommand("about");

        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);

        return helpMenu;
    }
}