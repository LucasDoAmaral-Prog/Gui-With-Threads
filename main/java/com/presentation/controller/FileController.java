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

/**
 * Controlador responsável pelas operações de arquivo
 * Gerencia abertura, fechamento e exibição de arquivos de texto
 */
public class FileController {

    private final FileService fileService;
    private final FileChooserManager fileChooserManager;
    private final FileReader fileReader;
    private final FileValidator fileValidator;
    private FileDisplayPanel fileDisplayPanel;
    private File currentFile;

    public FileController() {
        this.fileService = new FileService();
        this.fileReader = new FileReader();
        this.fileValidator = new FileValidator();

        // Inicializa FileChooserManager e trata possível exceção de diretório
        try {
            this.fileChooserManager = new FileChooserManager();
        } catch (DirectoryNotFoundException e) {
            this.fileChooserManager = createFallbackFileChooser();
            showDirectoryNotFoundMessage(e);
        }
    }

    /**
     * Cria um FileChooser alternativo em caso de problema com diretório padrão
     */
    private FileChooserManager createFallbackFileChooser() {
        try {
            // Força uso do diretório home
            return new FileChooserManager();
        } catch (DirectoryNotFoundException e) {
            // Se ainda assim falhar, problema mais sério - mas não deveria acontecer
            throw new RuntimeException("Failed to create FileChooserManager even with fallback", e);
        }
    }

    /**
     * Exibe mensagem sobre diretório não encontrado
     */
    private void showDirectoryNotFoundMessage(DirectoryNotFoundException e) {
        String message = String.format(
                "Test folder not found: %s\n" +
                        "File dialog will open in: %s\n\n" +
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

    /**
     * Define o painel de exibição de arquivos
     */
    public void setFileDisplayPanel(FileDisplayPanel fileDisplayPanel) {
        this.fileDisplayPanel = fileDisplayPanel;
    }

    /**
     * Abre um diálogo para selecionar e abrir um arquivo de texto
     */
    public void openFile() {
        try {
            File selectedFile = fileChooserManager.chooseFile();
            if (selectedFile != null) {
                // Valida o arquivo antes de tentar abrir
                fileValidator.validateFile(selectedFile);

                // Lê o conteúdo do arquivo
                String content = fileReader.readFile(selectedFile);

                // Atualiza o painel de exibição
                if (fileDisplayPanel != null) {
                    fileDisplayPanel.displayContent(content, selectedFile.getName());
                }

                // Guarda referência do arquivo atual
                this.currentFile = selectedFile;

                // Notifica sucesso
                showMessage("Arquivo aberto com sucesso: " + selectedFile.getName(),
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (FileReadException e) {
            showMessage("Erro ao abrir arquivo: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            showMessage("Erro inesperado: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Fecha o arquivo atualmente aberto e limpa a área de texto
     */
    public void closeFile() {
        if (currentFile != null) {
            // Limpa o painel de exibição
            if (fileDisplayPanel != null) {
                fileDisplayPanel.clearContent();
            }

            // Remove referência do arquivo atual
            String fileName = currentFile.getName();
            this.currentFile = null;

            showMessage("Arquivo fechado: " + fileName,
                    "Arquivo Fechado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            showMessage("Nenhum arquivo está aberto no momento.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Verifica se há um arquivo aberto atualmente
     */
    public boolean hasOpenFile() {
        return currentFile != null;
    }

    /**
     * Obtém o arquivo atualmente aberto
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * Obtém o nome do arquivo atual
     */
    public String getCurrentFileName() {
        return currentFile != null ? currentFile.getName() : null;
    }

    /**
     * Encerra a aplicação
     */
    public void exitApplication() {
        // Pergunta se deseja realmente sair
        int option = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza que deseja sair da aplicação?",
                "Confirmar Saída",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (option == JOptionPane.YES_OPTION) {
            // Fecha arquivo se houver um aberto
            if (hasOpenFile()) {
                closeFile();
            }

            // Encerra a aplicação
            System.exit(0);
        }
    }

    /**
     * Método auxiliar para exibir mensagens
     */
    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}
