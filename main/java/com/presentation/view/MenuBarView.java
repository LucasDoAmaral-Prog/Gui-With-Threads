//edição de 2024-06-20
package com.presentation.view;

import javax.swing.*;

/**
 * Representa a barra de menus (JMenuBar) da aplicação.
 * Utiliza a MenuItemFactory para construir seus menus.
 */
public class MenuBarView extends JMenuBar {

    public MenuBarView() {
        // Usa a factory para criar e adicionar os menus
        add(MenuItemFactory.createFileMenu());
        add(MenuItemFactory.createConfigMenu());
        add(MenuItemFactory.createHelpMenu());
    }
}