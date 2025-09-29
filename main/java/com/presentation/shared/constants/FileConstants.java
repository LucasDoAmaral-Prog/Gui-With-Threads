package com.presentation.shared.constants;

public final class FileConstants {
    
    // Extensões de arquivo suportadas
    public static final String[] TEXT_EXTENSIONS = {"txt", "text", "json", "md"};
    public static final String TEXT_EXTENSIONS_DESCRIPTION = "Arquivos de Texto (*.txt, *.text, *.json, *.md)";
    // Tamanhos
    public static final long MAX_FILE_SIZE_BYTES = 5 * 1024 * 1024; // 5MB
    public static final String MAX_FILE_SIZE_DISPLAY = "5MB";

    // Diretório padrão
    public static final String DEFAULT_DIR_PATH = "/test-files";
    public static final String USER_DIR_PATH = "user.home";
    
    // Mensagens de erro
    public static final String CANCELED_OPERATION = "Operação cancelada";
    public static final String EXCEPTION_NO_FILE_SELECTED = "Nenhum arquivo foi selecionado";
    public static final String ERROR_NO_DIRS_FOUND = "Não foi posssível abir o diretório padrão nem o diretório do usuário";

    // Dialogos
    public static final String DIALOG_TITLE_OPEN_FILE = "Abrir Arquivo";


}
