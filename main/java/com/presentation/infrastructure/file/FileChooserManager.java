package com.presentation.infrastructure.file;

import com.presentation.shared.constants.FileConstants;
import com.presentation.shared.constants.UIConstants;
import com.presentation.shared.exception.DirectoryNotFoundException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

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
            String userHome = System.getProperty(FileConstants.USER_DIR_PATH);
            File defaultDir = new File(userHome);
            if (defaultDir.exists()) {
                chooser.setCurrentDirectory(defaultDir);
            } else {
                throw new DirectoryNotFoundException(FileConstants.ERROR_NO_DIRS_FOUND);
            }
        }

        chooser.setDialogTitle(FileConstants.DIALOG_TITLE_OPEN_FILE);

        FileNameExtensionFilter textFilter = new FileNameExtensionFilter(FileConstants.TEXT_EXTENSIONS_DESCRIPTION, FileConstants.TEXT_EXTENSIONS);
        chooser.setFileFilter(textFilter);
        chooser.setAcceptAllFileFilterUsed(false);

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }
}