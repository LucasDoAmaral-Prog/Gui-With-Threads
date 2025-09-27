package com.presentation.infrastructure.file;

import com.presentation.shared.exception.DirectoryNotFoundException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.net.URL;


public class FileChooserManager {

    private final String defaultDirPath;


    public FileChooserManager(String defaultDirPath) {
        this.defaultDirPath = defaultDirPath;
    }

    public File openFileDialog() throws DirectoryNotFoundException {
        JFileChooser chooser = new JFileChooser();

        File initialDir = new File(defaultDirPath);
        if (initialDir.exists() && initialDir.isDirectory()) {
            chooser.setCurrentDirectory(initialDir);
        } else {
            // Se o diretório inicial não existir, tenta o diretório do usuário
            String userHome = System.getProperty("user.home");
            File defaultDir = new File(userHome);
            if (defaultDir.exists()) {
                chooser.setCurrentDirectory(defaultDir);
            } else {
                throw new DirectoryNotFoundException("Initial directory not found: " + defaultDirPath + " nor user home: " + userHome);
            }
        }

        chooser.setDialogTitle("Abrir Arquivo");

        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt");
        chooser.setFileFilter(textFilter);
        chooser.setAcceptAllFileFilterUsed(false);

        // Show the dialog
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }
}