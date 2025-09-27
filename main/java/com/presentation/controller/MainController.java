package com.presentation.controller;

import com.presentation.dialog.file.ExitDialog;
import com.presentation.shared.constants.MenuConstants;
import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Controlador principal da aplicação
 */
public class MainController extends JFrame {

    private MenuController menuController;
    private static JTextArea mainArea;
    private JLabel statusBar;
    private JMenuBar menuBar;

    public MainController() {
        initializeComponents();
        setupWindow();
        createMenus();
        layoutComponents();

    }

    // Inicializa os componentes da interface - Main Area (com scroll), Status Bar e Menu
    private void initializeComponents() {
        menuController = new MenuController(this);

        // Área principal (somente leitura)
        mainArea = new JTextArea();
        mainArea.setFont(new Font(UIConstants.TEXT_AREA_FONT_NAME, Font.PLAIN, UIConstants.TEXT_AREA_FONT_SIZE));
        mainArea.setEditable(false);
        mainArea.setLineWrap(true);
        mainArea.setWrapStyleWord(true);
        mainArea.setBackground(getBackground()); // Mesmo fundo da janela
        mainArea.setFocusable(false); // Remove a capacidade de receber foco

        // Barra de status
        statusBar = new JLabel(UIConstants.STATUS_READY);
        statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
        statusBar.setPreferredSize(new Dimension(0, 25));
    }

    // Configura as propriedades da janela principal - tamanho, título, ícone, comportamento de fechamento
    private void setupWindow() {
        setTitle(UIConstants.MAIN_WINDOW_TITLE);
        setSize(UIConstants.MAIN_WINDOW_WIDTH, UIConstants.MAIN_WINDOW_HEIGHT);
        setMinimumSize(new Dimension(UIConstants.MAIN_WINDOW_MIN_WIDTH, UIConstants.MAIN_WINDOW_MIN_HEIGHT));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configura o ícone da aplicação
        try {
            // Tenta carregar o logo da FT
            ImageIcon logo = new ImageIcon(
                    UIConstants.class.getResource("/FT_logo.jpg")
            );
            if (logo.getIconWidth() > 0) {
                setIconImage(logo.getImage());
            } else {
                // Se não conseguir carregar, usa o ícone padrão
                setIconImage(createDefaultIcon());
            }
        } catch (Exception e) {
            // Se falhar, usa o ícone padrão
            setIconImage(createDefaultIcon());
        }

        // Configura o comportamento de fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });
    }


    // Cria um menu ou item de menu com texto, ação e mnemônico (a ser usado na criação dos menus)
    private JComponent createMenuComponent(String text, int mnemonic, String actionCommand) {
        if (actionCommand == null) {
            // Cria um menu
            JMenu menu = new JMenu(text);
            menu.setMnemonic(mnemonic);
            return menu;
        } else {
            // Cria um item de menu
            JMenuItem menuItem = new JMenuItem(text);
            menuItem.setActionCommand(actionCommand);
            menuItem.setMnemonic(mnemonic);
            menuItem.addActionListener(menuController);
            return menuItem;
        }
    }

    // Cria os menus da aplicação - Arquivo, Configuração e Ajuda
    private void createMenus() {
        menuBar = new JMenuBar();

        // Menu Arquivo
        JMenu menuArquivo = (JMenu) createMenuComponent(MenuConstants.MENU_ARQUIVO, MenuConstants.MNEMONIC_ARQUIVO, null);
        menuArquivo.add(createMenuComponent(MenuConstants.MENU_ITEM_ABRIR_ARQUIVO,
                MenuConstants.MNEMONIC_ABRIR_ARQUIVO,
                MenuConstants.ACTION_ABRIR_ARQUIVO));
        menuArquivo.add(createMenuComponent(MenuConstants.MENU_ITEM_FECHAR_ARQUIVO,
                MenuConstants.MNEMONIC_FECHAR_ARQUIVO,
                MenuConstants.ACTION_FECHAR_ARQUIVO));
        menuArquivo.addSeparator();
        menuArquivo.add(createMenuComponent(MenuConstants.MENU_ITEM_SAIR,
                MenuConstants.MNEMONIC_SAIR,
                MenuConstants.ACTION_SAIR));

        // Menu Configuração
        JMenu menuConfiguracao = (JMenu) createMenuComponent(MenuConstants.MENU_CONFIGURACAO, MenuConstants.MNEMONIC_CONFIGURACAO, null);
        menuConfiguracao.add(createMenuComponent(MenuConstants.MENU_ITEM_PADROES,
                MenuConstants.MNEMONIC_PADROES,
                MenuConstants.ACTION_PADROES));
        menuConfiguracao.add(createMenuComponent(MenuConstants.MENU_ITEM_CORES,
                MenuConstants.MNEMONIC_CORES,
                MenuConstants.ACTION_CORES));
        menuConfiguracao.add(createMenuComponent(MenuConstants.MENU_ITEM_VELOCIDADE,
                MenuConstants.MNEMONIC_VELOCIDADE,
                MenuConstants.ACTION_VELOCIDADE));

        // Menu Ajuda
        JMenu menuAjuda = (JMenu) createMenuComponent(MenuConstants.MENU_AJUDA, MenuConstants.MNEMONIC_AJUDA, null);
        menuAjuda.add(createMenuComponent(MenuConstants.MENU_ITEM_AJUDA,
                MenuConstants.MNEMONIC_AJUDA_ITEM,
                MenuConstants.ACTION_AJUDA));
        menuAjuda.addSeparator();
        menuAjuda.add(createMenuComponent(MenuConstants.MENU_ITEM_SOBRE,
                MenuConstants.MNEMONIC_SOBRE,
                MenuConstants.ACTION_SOBRE));

        menuBar.add(menuArquivo);
        menuBar.add(menuConfiguracao);
        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);
    }

    // Organiza os componentes na janela - Main Area (com scroll), Status Bar e Menu
    private void layoutComponents() {
        setLayout(new BorderLayout());

        // Área principal com scroll
        JScrollPane scrollPane = new JScrollPane(mainArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // Barra de status na parte inferior
        add(statusBar, BorderLayout.SOUTH);
    }

    // Manipula o fechamento da janela
    private void handleWindowClosing() {
        ExitDialog dialog = new ExitDialog(this);
        dialog.setVisible(true);

        if (dialog.isExitConfirmed()) {
            System.exit(0);
        }
    }

    // Cria um ícone padrão para a aplicação que será utilizado se a logo personalizada não for encontrada
    private Image createDefaultIcon() {
        int size = 32;
        java.awt.image.BufferedImage icon = new java.awt.image.BufferedImage(size, size, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = icon.createGraphics();
        g2d.setColor(Color.magenta);
        g2d.fillOval(4, 4, size-8, size-8);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("?", 12, 22);
        g2d.dispose();
        return icon;
    }

    public void updateStatusBar(String message) {
        statusBar.setText(message);
    }

    public static void clearMainArea() {
        mainArea.setText("");
    }

    public void setMainAreaContent(String content) {
        mainArea.setText(content);
    }

    /**
     * Exibe um texto na área principal da aplicação.
     * @param text O texto a ser exibido.
     */
    public static void displayOnMainArea(String text) {
        mainArea.setText(text);
    }

    public String getMainAreaContent() {
        return mainArea.getText();
    }
}