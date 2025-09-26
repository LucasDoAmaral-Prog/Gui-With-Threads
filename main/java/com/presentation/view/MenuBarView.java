package com.presentation.view;

import com.presentation.controller.MenuController;
import javax.swing.*;

/**
 * View da barra de menu - wrapper para o MenuController
 */
public class MenuBarView {
    
    private final MenuController menuController;
    
    public MenuBarView(MenuController menuController) {
        this.menuController = menuController;
    }
    
    /**
     * Obtém a barra de menu
     */
    public JMenuBar getMenuBar() {
        return menuController.getMenuBar();
    }
    
    /**
     * Atualiza o estado do menu
     */
    public void updateMenuState() {
        menuController.updateMenuState();
    }
}