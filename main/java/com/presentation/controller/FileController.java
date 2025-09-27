package com.presentation.controller;

import com.presentation.domain.service.FileService;
import com.presentation.infrastructure.file.FileChooserManager;
import com.presentation.shared.constants.FileConstants;
import com.presentation.shared.exception.DirectoryNotFoundException;
import com.presentation.shared.exception.FileNotSelectedException;
import com.presentation.shared.exception.FileReadException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileController {

    private final FileService fileService;
    private File currentFile;

    public FileController() {
        this.fileService = new FileService();
    }

    public String openFile() throws FileReadException, DirectoryNotFoundException, FileNotSelectedException {
        FileChooserManager fileChooser = new FileChooserManager(FileConstants.class.getResource(FileConstants.DEFAULT_DIR_PATH).getPath());
        File selectedFile;

        try {
            selectedFile = fileChooser.openFileDialog();
        } catch (DirectoryNotFoundException e) {
            showDirectoryNotFoundMessage(e);
            throw e;
        }

        if (selectedFile == null) {
            showMessage("Operação cancelada: nenhum arquivo foi selecionado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            throw new FileNotSelectedException("Nenhum arquivo foi selecionado.");
        }

        try {
            String content = fileService.openFile(selectedFile);
            this.currentFile = selectedFile;
            return content;
        } catch (FileReadException e) {
            showMessage("Error reading file: " + e.getMessage(), "File Read Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    private void showDirectoryNotFoundMessage(DirectoryNotFoundException e) {
        JOptionPane.showMessageDialog(
                null,
                "Error accessing initial directory: " + e.getMessage(),
                "Directory Not Found",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}