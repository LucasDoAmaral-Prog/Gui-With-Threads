package com.basicgui;

import javax.swing.*;
import com.presentation.controller.MainController;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainController mainFrame = new MainController();
            mainFrame.setVisible(true);
        });
    }
}
