// ...existing code...

public class FileController {
    
    // ...existing fields...
    private MenuController menuController; // Nova referência
    
    // ...existing constructors...
    
    /**
     * Define o controlador de menu para sincronização de estado
     */
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
    
    /**
     * Notifica mudança de estado para atualizar menus
     */
    private void notifyStateChanged() {
        if (menuController != null) {
            menuController.updateMenuState();
        }
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
                
                // ✅ NOTIFICA MUDANÇA DE ESTADO
                notifyStateChanged();
                
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
            
            // ✅ NOTIFICA MUDANÇA DE ESTADO
            notifyStateChanged();
            
            showMessage("Arquivo fechado: " + fileName, 
                       "Arquivo Fechado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            showMessage("Nenhum arquivo está aberto no momento.", 
                       "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // ...rest of existing code...
}