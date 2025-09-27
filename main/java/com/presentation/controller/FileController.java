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

    private void showDirectoryNotFoundMessage(DirectoryNotFoundException e) {
        String message = String.format(
                "Test folder not found: %s%n" +
                        "File dialog will open in: %s%n%n" +
                        "To use the test folder, create: %s",
                e.getRequestedDirectory(),
                e.getFallbackDirectory(),
                e.getRequestedDirectory()
        );

        JOptionPane.showMessageDialog(
                null,
                message,
                "Test Directory Not Found",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void setMenuController(com.presentation.controller.MenuController menuController) {
        this.menuController = menuController;
    }

    public String openFile(File selectedFile) throws IOException, FileReadException {
        if (selectedFile == null) throw new IllegalArgumentException("Arquivo não selecionado.");
        fileValidator.validateFile(selectedFile); // supondo que existe
        String content = fileReader.readFile(selectedFile); // supondo que existe

        if (fileDisplayPanel != null) {
            fileDisplayPanel.displayContent(content, selectedFile.getName());
        }

        this.currentFile = selectedFile;

        if (menuController != null) {
            menuController.updateStatusBar("Abrindo arquivo: " + selectedFile.getName());
        }

        // Mostra mensagem de sucesso (pode ser log ou JOptionPane, dependendo do seu contexto)
        showMessage("Arquivo aberto com sucesso: " + selectedFile.getName(),
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        return content; // retorna o conteúdo para uso posterior
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
