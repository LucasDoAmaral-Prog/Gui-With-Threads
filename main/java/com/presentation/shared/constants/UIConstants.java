package com.presentation.shared.constants;

import java.awt.*;

public class UIConstants {

    // Constantes da Janela Principal
    public static final String MAIN_WINDOW_TITLE = "Aplicação Java GUI - Unicamp FT";
    public static final int MAIN_WINDOW_WIDTH = 800;
    public static final int MAIN_WINDOW_HEIGHT = 600;
    public static final int MAIN_WINDOW_MIN_WIDTH = 600;
    public static final int MAIN_WINDOW_MIN_HEIGHT = 400;

    // Constantes da Barra de Status
    public static final String STATUS_READY = "Pronto";
    public static final String STATUS_FILE_OPENED = "Arquivo aberto";
    public static final String STATUS_FILE_CLOSED = "Arquivo fechado";

    // Constantes de Diálogos
    public static final String DIALOG_TITLE_ERROR = "Erro";
    public static final String DIALOG_TITLE_INFO = "Informação";
    public static final String DIALOG_TITLE_WARNING = "Aviso";
    public static final String DIALOG_TITLE_CONFIRM = "Confirmação";

    // Mensagens padrão
    public static final String MESSAGE_FEATURE_NOT_IMPLEMENTED = "Feature a ser implementada";
    public static final String MESSAGE_FILE_OPENED_SUCCESS = "Arquivo aberto com sucesso";
    public static final String MESSAGE_FILE_CLOSED_SUCCESS = "Arquivo fechado com sucesso";
    public static final String MESSAGE_EXIT_CONFIRM = "Deseja realmente sair da aplicação?";

    // Ícones e recursos
    public static final String ICON_PATH = "/resources/app-icon.png";
    public static final String LOGO_PATH = "/FT_logo.jpg";

    // Configurações de texto
    public static final int TEXT_AREA_FONT_SIZE = 12;
    public static final String TEXT_AREA_FONT_NAME = "Monospaced";

    // Configurações de animação
    public static final int DEFAULT_ANIMATION_SPEED = 50;
    public static final int MIN_ANIMATION_SPEED = 10;
    public static final int MAX_ANIMATION_SPEED = 200;

    // CORES PRINCIPAIS
    public static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    public static final Color SECONDARY_COLOR = new Color(149, 165, 166);
    public static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    public static final Color WARNING_COLOR = new Color(241, 196, 15);
    public static final Color ERROR_COLOR = new Color(231, 76, 60);
    public static final Color INFO_COLOR = new Color(52, 152, 219);

    // CORES DE FUNDO
    public static final Color DIALOG_BACKGROUND = new Color(248, 249, 250);
    public static final Color PANEL_BACKGROUND = new Color(255, 255, 255);
    public static final Color HEADER_BACKGROUND = new Color(236, 240, 241);

    // CORES DE TEXTO
    public static final Color TEXT_PRIMARY = new Color(44, 62, 80);
    public static final Color TEXT_SECONDARY = new Color(127, 140, 141);
    public static final Color TEXT_MUTED = new Color(149, 165, 166);

    // FONTES
    public static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 18);
    public static final Font SUBTITLE_FONT = new Font("Arial", Font.BOLD, 14);
    public static final Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 12);
    public static final Font SMALL_FONT = new Font("Arial", Font.PLAIN, 10);

    // DIMENSÕES
    public static final int BUTTON_WIDTH = 100;
    public static final int BUTTON_HEIGHT = 35;

    // ESPAÇAMENTOS
    public static final int PADDING_SMALL = 5;
    public static final int PADDING_MEDIUM = 10;
    public static final int PADDING_LARGE = 20;

    // BORDAS
    public static final int BORDER_RADIUS = 5;
}