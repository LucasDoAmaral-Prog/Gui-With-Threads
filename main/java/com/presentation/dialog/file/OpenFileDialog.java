package com.presentation.dialog.file;

import com.presentation.shared.constants.FileConstants;
import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Diálogo para abrir arquivos
 */
public class OpenFileDialog extends JDialog {

    private File selectedFile = null;
    private boolean fileOpened = false;

    public OpenFileDialog(JFrame parent) {
        super(parent, true); // modal
        openFileChooser();   // abre o seletor assim que o diálogo é criado
    }

    private void openFileChooser() {
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt");
        chooser.setFileFilter(textFilter);
        // simples, sem configuração
        int result = chooser.showOpenDialog(this);      // abre o diálogo

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            fileOpened = true;
        }

        dispose(); // fecha o JDialog depois de escolher ou cancelar
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public boolean isFileOpened() {
        return fileOpened;
    }
}