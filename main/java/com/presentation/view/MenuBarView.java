package com.presentation.view;

import com.presentation.controller.MenuController;
import javax.swing.*;

/**
 * Visualização da barra de menu da aplicação
 */
public class MenuBarView {
    
    private final MenuController menuController;
    private JMenuBar menuBar;
    
    public MenuBarView(MenuController menuController) {
        this.menuController = menuController;
        this.menuBar = menuController.getMenuBar();
    }
    
    /**
     * Retorna a barra de menu
     */
    public JMenuBar getMenuBar() {
        return menuBar;
    }
    
    /**
     * Atualiza o estado da barra de menu
     */
    public void updateMenuState() {
        menuController.updateMenuState();
    }
}
