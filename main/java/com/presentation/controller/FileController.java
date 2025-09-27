package com.presentation.controller;

import com.presentation.domain.service.FileService;
import com.presentation.infrastructure.file.FileChooserManager;
import com.presentation.shared.constants.FileConstants; // Import the constants
import com.presentation.shared.constants.UIConstants;
import com.presentation.shared.exception.DirectoryNotFoundException;
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

    public String openFile() throws IOException, FileReadException, DirectoryNotFoundException {
        // Pass the default directory path to the file chooser
        //System.out.println(FileConstants.class.getResource(FileConstants.DEFAULT_DIR_PATH).getPath());
        //FileChooserManager fileChooser = new FileChooserManager(FileConstants.class.getResource(FileConstants.DEFAULT_DIR_PATH).getPath());
        FileChooserManager fileChooser = new FileChooserManager(FileConstants.TEST_DIR);
        File selectedFile = null;

        try {
            selectedFile = fileChooser.openFileDialog();
        } catch (DirectoryNotFoundException e) {
            showDirectoryNotFoundMessage(e);
        }

        if (selectedFile != null) {
            try {
                String content = fileService.openFile(selectedFile);
                this.currentFile = selectedFile;
                return content;
            } catch (FileReadException e) {
                showMessage("Error reading file: " + e.getMessage(), "File Read Error", JOptionPane.ERROR_MESSAGE);
                throw e;
            }
        } else {
            throw new IOException("No file selected.");
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

    public boolean hasOpenFile() {
        return currentFile != null;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public String getCurrentFileName() {
        return currentFile != null ? currentFile.getName() : null;
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}