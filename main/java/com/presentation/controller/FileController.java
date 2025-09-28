// ...existing code...
package com.presentation.controller;

import com.presentation.domain.service.FileService;
import com.presentation.infrastructure.file.FileChooserManager;
import com.presentation.shared.constants.FileConstants;
import com.presentation.shared.exception.DirectoryNotFoundException;
import com.presentation.shared.exception.FileReadException;
import com.presentation.shared.exception.FileNotSelectedException;
import com.presentation.shared.util.UIUtils;
import com.presentation.infrastructure.thread.SafeSwingWorker;

import javax.swing.*;
import java.io.File;

public class FileController {

    private final FileService fileService;
    private File currentFile;

    public FileController() {
        this.fileService = new FileService();
    }

    /**
     * Lê o arquivo selecionado usando uma thread (SwingWorker) e executa o callback ao finalizar.
     * @param selectedFile Arquivo a ser lido
     * @param callback Função que recebe o conteúdo lido ou a exceção
     */
    public void openFileWithThread(File selectedFile, java.util.function.BiConsumer<String, Exception> callback) {
        new javax.swing.SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                return fileService.openFile(selectedFile);
            }
            @Override
            protected void done() {
                try {
                    String conteudo = get();
                    callback.accept(conteudo, null);
                } catch (Exception e) {
                    callback.accept(null, e);
                }
            }
        }.execute();
    }

    public String openFile() throws FileReadException, DirectoryNotFoundException, FileNotSelectedException {
        String initialDir = System.getProperty("user.home");
        FileChooserManager fileChooser = new FileChooserManager(initialDir);
        File selectedFile;

        selectedFile = fileChooser.openFileDialog();

        if (selectedFile == null) {
            throw new FileNotSelectedException(FileConstants.EXCEPTION_NO_FILE_SELECTED);
        }

        String content = fileService.openFile(selectedFile);
        this.currentFile = selectedFile;
        return content;
    }

    public String getCurrentFileName() {
        return currentFile.getName();
    }


}