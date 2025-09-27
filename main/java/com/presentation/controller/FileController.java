//package com.presentation.controller;
//
//import com.presentation.domain.service.FileService;
//import com.presentation.infrastructure.file.FileChooserManager;
//import com.presentation.infrastructure.file.FileReader;
//import com.presentation.infrastructure.file.FileValidator;
//import com.presentation.shared.exception.DirectoryNotFoundException;
//import com.presentation.shared.exception.FileReadException;
//import com.presentation.view.FileDisplayPanel;
//
//import javax.swing.*;
//import java.io.File;
//
//public class FileController {
//
//    private final FileService fileService;
//    private final FileChooserManager fileChooserManager;
//    private final FileReader fileReader;
//    private final FileValidator fileValidator;
//    private FileDisplayPanel fileDisplayPanel;
//    private File currentFile;
//    private com.presentation.controller.MenuController menuController; // Adiciona referência ao MenuController
//
//    public FileController() {
//        this.fileService = new FileService();
//        this.fileReader = new FileReader();
//        this.fileValidator = new FileValidator();
//
//        // Variável local para evitar atribuição dupla ao campo final
//        FileChooserManager tempChooser;
//        try {
//            tempChooser = new FileChooserManager();
//        } catch (DirectoryNotFoundException e) {
//            tempChooser = createFallbackFileChooser();
//            showDirectoryNotFoundMessage(e);
//        }
//        this.fileChooserManager = tempChooser;
//    }
//
//    private void showDirectoryNotFoundMessage(DirectoryNotFoundException e) {
//        String message = String.format(
//                "Test folder not found: %s%n" +
//                        "File dialog will open in: %s%n%n" +
//                        "To use the test folder, create: %s",
//                e.getRequestedDirectory(),
//                e.getFallbackDirectory(),
//                e.getRequestedDirectory()
//        );
//
//        JOptionPane.showMessageDialog(
//                null,
//                message,
//                "Test Directory Not Found",
//                JOptionPane.INFORMATION_MESSAGE
//        );
//    }
//
//    public void setMenuController(com.presentation.controller.MenuController menuController) {
//        this.menuController = menuController;
//    }
//
//    public void openFile() {
//        try {
//            File selectedFile = fileChooserManager.chooseFile();
//            if (selectedFile != null) {
//                fileValidator.validateFile(selectedFile);
//                String content = fileReader.readFile(selectedFile);
//
//                if (fileDisplayPanel != null) {
//                    fileDisplayPanel.displayContent(content, selectedFile.getName());
//                }
//
//                this.currentFile = selectedFile;
//
//                // Atualiza estado do menu após abrir arquivo
//                if (menuController != null) {
//                    menuController.updateMenuState();
//                }
//
//                showMessage("Arquivo aberto com sucesso: " + selectedFile.getName(),
//                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (FileReadException e) {
//            showMessage("Erro ao abrir arquivo: " + e.getMessage(),
//                    "Erro", JOptionPane.ERROR_MESSAGE);
//        } catch (Exception e) {
//            showMessage("Erro inesperado: " + e.getMessage(),
//                    "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
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
//
//    public boolean hasOpenFile() {
//        return currentFile != null;
//    }
//
//    public File getCurrentFile() {
//        return currentFile;
//    }
//
//    public String getCurrentFileName() {
//        return currentFile != null ? currentFile.getName() : null;
//    }
//
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
//
//    private void showMessage(String message, String title, int messageType) {
//        JOptionPane.showMessageDialog(null, message, title, messageType);
//    }
//}
