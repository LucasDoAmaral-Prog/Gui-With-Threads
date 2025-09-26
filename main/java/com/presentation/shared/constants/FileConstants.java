package com.presentation.shared.constants;

/**
 * Constantes relacionadas a operações de arquivo
 */
public final class FileConstants {
    
    // Extensões de arquivo suportadas
    public static final String[] TEXT_EXTENSIONS = {"txt", "text", "log", "json", "yml", "yaml" };
    
    // Filtros de arquivo
    public static final String TEXT_FILES_FILTER = "Arquivos de Texto";
    public static final String ALL_FILES_FILTER = "Todos os Arquivos";
    
    // Tamanhos
    public static final long MAX_FILE_SIZE_BYTES = 5 * 1024 * 1024; // 5MB
    public static final String MAX_FILE_SIZE_DISPLAY = "5MB";
    
    // Mensagens de erro
    public static final String ERROR_NULL_FILE = "Nenhum arquivo foi selecionado";
    public static final String ERROR_FILE_NOT_EXISTS = "O arquivo não existe: ";
    public static final String ERROR_NOT_A_FILE = "O item selecionado não é um arquivo: ";
    public static final String ERROR_CANNOT_READ = "Não foi possível ler o arquivo. Verifique as permissões: ";
    public static final String ERROR_EMPTY_FILE = "O arquivo está vazio: ";
    public static final String ERROR_FILE_TOO_LARGE = "O arquivo é muito grande (%.2f MB). Tamanho máximo permitido: " + MAX_FILE_SIZE_DISPLAY;
    public static final String ERROR_READ_FILE = "Erro ao ler o arquivo: ";
    public static final String ERROR_OUT_OF_MEMORY = "Arquivo muito grande para ser carregado na memória";
    
    // Configurações do FileChooser
    public static final String CHOOSER_TITLE = "Selecionar Arquivo";
    public static final String DEFAULT_DIRECTORY = System.getProperty("user.dir") + "/test-files"; // talvez esse user.dir dê problema
    
    // Codificação
    public static final String DEFAULT_ENCODING = "UTF-8";
    
    // Labels e textos da UI
    public static final String UI_NO_FILE_OPEN = "Nenhum arquivo aberto";
    public static final String UI_FILE_LABEL_PREFIX = "Arquivo: ";
    public static final String UI_FILE_VIEWER_TITLE = "Visualizador de Arquivos";
    
    // Cores da UI
    public static final int UI_FILE_OPEN_COLOR_R = 0;
    public static final int UI_FILE_OPEN_COLOR_G = 100;
    public static final int UI_FILE_OPEN_COLOR_B = 0;
    public static final int UI_BACKGROUND_COLOR_R = 240;
    public static final int UI_BACKGROUND_COLOR_G = 240;
    public static final int UI_BACKGROUND_COLOR_B = 240;
    public static final int UI_HEADER_COLOR_R = 220;
    public static final int UI_HEADER_COLOR_G = 220;
    public static final int UI_HEADER_COLOR_B = 220;
    
    // Dimensões da UI
    public static final int UI_PANEL_WIDTH = 400;
    public static final int UI_PANEL_HEIGHT = 500;
    public static final int UI_FONT_SIZE_TITLE = 14;
    public static final int UI_FONT_SIZE_TEXT = 12;
    public static final int UI_MARGIN_SIZE = 10;
    public static final int UI_BORDER_PADDING = 5;
    
    // Construtor privado para evitar instanciação
    private FileConstants() {
        throw new AssertionError("Esta classe não deve ser instanciada");
    }
}
