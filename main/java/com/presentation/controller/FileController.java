package com.presentation.controller;

import com.presentation.domain.service.FileService;
import com.presentation.infrastructure.file.FileChooserManager;
import com.presentation.infrastructure.file.FileReader;
import com.presentation.infrastructure.file.FileValidator;
import com.presentation.shared.exception.DirectoryNotFoundException;
import com.presentation.shared.exception.FileReadException;
import com.presentation.view.FileDisplayPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileController {

    private final FileService fileService;
    private final FileReader fileReader;
    private final FileValidator fileValidator;
    private FileDisplayPanel fileDisplayPanel;
    private File currentFile;
    private com.presentation.controller.MenuController menuController; // Adiciona referência ao MenuController

    public FileController() {
        this.fileService = new FileService();
        this.fileReader = new FileReader();
        this.fileValidator = new FileValidator();

    }


    public String openFile() throws IOException, FileReadException, DirectoryNotFoundException {
        FileChooserManager fileChooser = new FileChooserManager();
        File selectedFile = null;

        try {
            selectedFile = fileChooser.openFileDialog();
        } catch (DirectoryNotFoundException e) {
            showDirectoryNotFoundMessage(e);
        }

        if (selectedFile != null) {
            if (fileValidator.validateFile(selectedFile)) {
                String content = fileReader.readFile(selectedFile);
                this.currentFile = selectedFile;

                return content;
            } else {
                throw new IOException("Invalid file type. Please select a .txt file.");
            }
        } else {
            throw new IOException("No file selected.");
        }
    }

    private void showDirectoryNotFoundMessage(DirectoryNotFoundException e) {
        JOptionPane.showMessageDialog(
                null,
                "Erro ao acessar o diretório inicial: " + e.getMessage(),
                "Diretório Não Encontrado",
                JOptionPane.ERROR_MESSAGE
        );
    }

//    public void closeFile() {
//        if (currentFile != null) {
//            if (fileDisplayPanel != null) {
//                fileDisplayPanel.clearContent();
//            }
//            String fileName = currentFile.getName();
//            this.currentFile = null;
//
//            // Atualiza estado do menu após fechar arquivo
//            if (menuController != null) {
//                menuController.updateMenuState();
//            }
//
//            showMessage("Arquivo fechado: " + fileName,
//                    "Arquivo Fechado", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            showMessage("Nenhum arquivo está aberto no momento.",
//                    "Aviso", JOptionPane.WARNING_MESSAGE);
//        }
//    }

    public boolean hasOpenFile() {
        return currentFile != null;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public String getCurrentFileName() {
        return currentFile != null ? currentFile.getName() : null;
    }

//    public void exitApplication() {
//        int option = JOptionPane.showConfirmDialog(
//                null,
//                "Tem certeza que deseja sair da aplicação?",
//                "Confirmar Saída",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE
//        );
//
//        if (option == JOptionPane.YES_OPTION) {
//            if (hasOpenFile()) {
//                closeFile();
//            }
//            System.exit(0);
//        }
//    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}
