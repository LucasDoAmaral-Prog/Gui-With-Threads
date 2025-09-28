package com.presentation.shared.constants;

/**
 * Constantes relacionadas a operações de arquivo
 */
public final class FileConstants {
    
    // Extensões de arquivo suportadas
    public static final String[] TEXT_EXTENSIONS = {"txt", "text", "log", "json", "yml", "yaml" };
    
    // Tamanhos
    public static final long MAX_FILE_SIZE_BYTES = 5 * 1024 * 1024; // 5MB
    public static final String MAX_FILE_SIZE_DISPLAY = "5MB";

    // Diretório padrão
    public static final String DEFAULT_DIR_PATH = "/test-files";
    
    // Mensagens de erro
    public static final String CANCELED_OPERATION = "Operação cancelada";
    public static final String EXCEPTION_NO_FILE_SELECTED = "Nenhum arquivo foi selecionado";
    public static final String EXCEPTION_NO_FILE_OPENED = "Nenhum arquivo está aberto";

    
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

}
