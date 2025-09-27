//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.main;

import com.presentation.controller.MainController;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        configureLookAndFeel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main.startApplication();
                } catch (Exception e) {
                    Main.handleStartupError(e);
                }

            }
        });
    }

    private static void configureLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Could not set Look and Feel: " + e.getMessage());
        }

    }

    private static void startApplication() {
        MainController mainWindow = new MainController();
        mainWindow.setVisible(true);
        mainWindow.updateStatusBar("Pronto");
    }

    private static void handleStartupError(Exception e) {
        String errorMessage = "Error starting the application: " + e.getMessage();
        e.printStackTrace();
        JOptionPane.showMessageDialog((Component)null, errorMessage, "Erro", 0);
        System.exit(1);
    }
}
