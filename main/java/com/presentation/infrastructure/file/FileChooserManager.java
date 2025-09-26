package com.presentation.infrastructure.file;

import com.presentation.shared.constants.FileConstants;
import com.presentation.shared.exception.DirectoryNotFoundException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooserManager {
    
    private JFileChooser fileChooser;
    
    public FileChooserManager() throws DirectoryNotFoundException {
        initializeFileChooser();
    }
    
    private void initializeFileChooser() throws DirectoryNotFoundException {
        fileChooser = new JFileChooser();
        setupFileFilters();
        setupChooserProperties();
    }
    
    private void setupFileFilters() {
        // filtro para arquivos de texto usando as constantes
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter(
            FileConstants.TEXT_FILES_FILTER, 
            FileConstants.TEXT_EXTENSIONS
        );
        
        // filtro para todos os arquivos
        FileNameExtensionFilter allFilter = new FileNameExtensionFilter(
            FileConstants.ALL_FILES_FILTER, "*"
        );
        
        fileChooser.addChoosableFileFilter(textFilter);
        fileChooser.addChoosableFileFilter(allFilter);
        fileChooser.setFileFilter(textFilter); 
    }
    
    private void setupChooserProperties() throws DirectoryNotFoundException {
        fileChooser.setDialogTitle(FileConstants.CHOOSER_TITLE);
        setInitialDirectory();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
    }
    
    private void setInitialDirectory() throws DirectoryNotFoundException {
        File defaultDir = new File(FileConstants.DEFAULT_DIRECTORY);
        
        if (defaultDir.exists() && defaultDir.isDirectory()) {
            fileChooser.setCurrentDirectory(defaultDir);
        } else {
            // se o diretório não existir, manda o usuário para o diretório padrão do usuario e lança uam exceção
            String fallbackDir = System.getProperty("user.home");
            fileChooser.setCurrentDirectory(new File(fallbackDir));
            
            throw new DirectoryNotFoundException(FileConstants.DEFAULT_DIRECTORY, fallbackDir);
        }
    }
    
    public File chooseFile() {
        int result = fileChooser.showOpenDialog(null);
        // esse "showOpenDialog" é o que abre a caixa de seleção de texto
        
        if (result == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION -> usuário clicou "Abrir/OK"
            return fileChooser.getSelectedFile();
        }
        
        return null;
    }
}
