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

        // Try to set the initial directory to the one passed in the constructor
        File initialDir = new File(defaultDirPath);
        if (initialDir.exists() && initialDir.isDirectory()) {
            chooser.setCurrentDirectory(initialDir);
        } else {
            // If the provided directory does not exist, fallback to user home or throw the exception
            String userHome = System.getProperty("user.home");
            File defaultDir = new File(userHome);
            if (defaultDir.exists()) {
                chooser.setCurrentDirectory(defaultDir);
            } else {
                throw new DirectoryNotFoundException("Initial directory not found: " + defaultDirPath + " nor user home: " + userHome);
            }
        }

        // Set the dialog title
        chooser.setDialogTitle("Abrir Arquivo");

        // Create and apply a filter to show only .txt files
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