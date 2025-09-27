package com.presentation.infrastructure.file;

import com.presentation.shared.exception.DirectoryNotFoundException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Gerencia a exibição e a lógica do seletor de arquivos (JFileChooser).
 * Encapsula a configuração e a interação com o usuário para selecionar um arquivo.
 */
public class FileChooserManager {

    /**
     * Construtor padrão.
     */
    public FileChooserManager() {
        // Nenhuma inicialização especial é necessária aqui.
    }

    /**
     * Abre um diálogo para o usuário selecionar um arquivo.
     * O diálogo é configurado para aceitar apenas arquivos de texto (.txt).
     *
     * @return O objeto File selecionado pelo usuário, ou null se o usuário cancelar a operação.
     * @throws DirectoryNotFoundException se o diretório inicial padrão (home do usuário) não puder ser encontrado.
     */
    public File openFileDialog() throws DirectoryNotFoundException {
        JFileChooser chooser = new JFileChooser();

        // Tenta definir o diretório inicial como a pasta do usuário
        // Isso melhora a experiência do usuário.
        try {
            String userHome = System.getProperty("user.home");
            File defaultDir = new File(userHome);
            if (defaultDir.exists()) {
                chooser.setCurrentDirectory(defaultDir);
            } else {
                // Se o diretório home não existir (caso raro), lança a exceção
                throw new DirectoryNotFoundException("Diretório inicial do usuário não encontrado: " + userHome);
            }
        } catch (SecurityException e) {
            // Se houver uma restrição de segurança para acessar a propriedade,
            // o JFileChooser usará seu próprio padrão. Não precisamos parar a execução.
            System.err.println("Aviso: Não foi possível acessar o diretório home do usuário devido a restrições de segurança.");
        }

        // Configura o título da janela
        chooser.setDialogTitle("Abrir Arquivo");

        // Cria e aplica um filtro para mostrar apenas arquivos .txt
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt");
        chooser.setFileFilter(textFilter);
        chooser.setAcceptAllFileFilterUsed(false); // Opcional: remove a opção "Todos os Arquivos"

        // Exibe o diálogo para o usuário. O primeiro argumento `null` o centraliza na tela.
        int result = chooser.showOpenDialog(null);

        // Verifica se o usuário clicou no botão "Abrir"
        if (result == JFileChooser.APPROVE_OPTION) {
            // Retorna o arquivo que o usuário selecionou
            return chooser.getSelectedFile();
        } else {
            // Se o usuário cancelou ou fechou a janela, retorna null
            return null;
        }
    }
}