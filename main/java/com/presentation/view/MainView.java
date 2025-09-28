package com.presentation.view;

import com.presentation.controller.MenuController;
import com.presentation.shared.constants.UIConstants;
import com.presentation.shared.util.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.util.Objects;

public class MainView extends JFrame {

    private JLabel fileTitleLabel;
    private JTextArea mainArea; // Agora é JTextArea para texto simples e quebra automática
    private StatusBar statusBar;
    private AppMenuBar menuBar;
    private String currentFileName; // Para armazenar o nome do arquivo exibido

    public MainView() {
        setTitle(UIConstants.MAIN_WINDOW_TITLE);
        setSize(800, 600);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);

        try {
            ImageIcon logo = new ImageIcon(
                    Objects.requireNonNull(UIConstants.class.getResource(UIConstants.LOGO_PATH))
            );
            setIconImage(logo.getImage());
        } catch (Exception e) {
            setIconImage(UIUtils.createDefaultIcon());
        }

        // Personalizando título do arquivo
        fileTitleLabel = new JLabel("", SwingConstants.CENTER);
        fileTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        fileTitleLabel.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));

        // Área principal para texto simples, com quebra de linha automática e apenas scroll vertical
        mainArea = new JTextArea();
        mainArea.setEditable(false);
        mainArea.setLineWrap(true); // Ativa quebra automática de linha
        mainArea.setWrapStyleWord(true); // Quebra por palavra
        mainArea.setFocusable(false);

        JScrollPane scrollPane = new JScrollPane(mainArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Nunca mostra scroll horizontal
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        statusBar = new StatusBar();
        menuBar = new AppMenuBar();

        setJMenuBar(menuBar.getMenuBar());

        setLayout(new BorderLayout());
        add(fileTitleLabel, BorderLayout.NORTH); // Título do arquivo no topo
        add(scrollPane, BorderLayout.CENTER);
        add(statusBar.getComponent(), BorderLayout.SOUTH);
    }

    public void setStatus(String message) {
        statusBar.setText(message);
    }

    /**
     * Atualiza o conteúdo principal e o título do arquivo.
     * @param fileName nome do arquivo exibido (pode ser estilizado com HTML se desejar)
     * @param textContent conteúdo do arquivo (texto simples)
     */
    public void setMainAreaContent(String fileName, String textContent) {
        this.currentFileName = fileName;
        fileTitleLabel.setText(fileName);
        mainArea.setText(textContent);
    }

    public void clearMainAreaContent() {
        this.currentFileName = null;
        fileTitleLabel.setText("");
        mainArea.setText("");
    }

    /**
     * Retorna o nome do arquivo atualmente exibido na mainArea, ou null se nenhum.
     */
    public String getCurrentFileName() {
        return currentFileName;
    }

    public void addMainMenuListener(MenuController listener) {
        menuBar.setMenuListener(listener);
    }

    public void addWindowListener(WindowListener listener) {
        super.addWindowListener(listener);
    }
}