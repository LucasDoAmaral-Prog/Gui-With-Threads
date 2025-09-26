package com.presentation.shared.constants;

/**
 * Constantes relacionadas aos menus da aplicação
 */
public final class MenuConstants {
    
    // === MENU ARQUIVO ===
    public static final String MENU_FILE_TITLE = "Arquivo";
    public static final String MENU_FILE_OPEN = "Abrir Arquivo";
    public static final String MENU_FILE_CLOSE = "Fechar Arquivo";
    public static final String MENU_FILE_EXIT = "Sair";
    
    // === MENU CONFIGURAÇÃO ===
    public static final String MENU_CONFIG_TITLE = "Configuração";
    public static final String MENU_CONFIG_PATTERNS = "Padrões";
    public static final String MENU_CONFIG_COLORS = "Cores";
    public static final String MENU_CONFIG_SPEED = "Velocidade";
    
    // === MENU AJUDA ===
    public static final String MENU_HELP_TITLE = "Ajuda";
    public static final String MENU_HELP_HELP = "Ajuda";
    public static final String MENU_HELP_ABOUT = "Sobre";
    
    // === MENSAGENS ===
    public static final String MESSAGE_NOT_IMPLEMENTED = "A funcionalidade '%s' será implementada em breve.";
    public static final String TITLE_NOT_IMPLEMENTED = "Funcionalidade não implementada";
    public static final String MESSAGE_EXIT_CONFIRM = "Deseja realmente sair da aplicação?";
    public static final String TITLE_EXIT_CONFIRM = "Confirmar Saída";
    
    // Construtor privado para evitar instanciação
    private MenuConstants() {
        throw new UnsupportedOperationException("Esta é uma classe de constantes");
    }
}