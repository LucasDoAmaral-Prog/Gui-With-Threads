package com.presentation.view;

import com.presentation.shared.constants.FileConstants;
import javax.swing.*;
import java.awt.*;


public class FileDisplayPanel extends JPanel {
    
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JLabel titleLabel;
    private JPanel headerPanel;
    
    public FileDisplayPanel() {
        initializeComponents();
        setupLayout();
        setupStyle();
    }
    
    private void initializeComponents() {
        // Label para mostrar o nome do arquivo
        titleLabel = new JLabel(FileConstants.UI_NO_FILE_OPEN);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FileConstants.UI_FONT_SIZE_TITLE));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Área de texto para exibir o conteúdo
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, FileConstants.UI_FONT_SIZE_TEXT));
        textArea.setBackground(Color.WHITE);
        textArea.setMargin(new Insets(FileConstants.UI_MARGIN_SIZE, FileConstants.UI_MARGIN_SIZE, 
                                     FileConstants.UI_MARGIN_SIZE, FileConstants.UI_MARGIN_SIZE));
        
        // Scroll pane para a área de texto
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        // Painel do cabeçalho
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createEmptyBorder(FileConstants.UI_BORDER_PADDING, FileConstants.UI_MARGIN_SIZE, 
                                           FileConstants.UI_BORDER_PADDING, FileConstants.UI_MARGIN_SIZE)
        ));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void setupStyle() {
        // Define o tamanho preferido
        setPreferredSize(new Dimension(FileConstants.UI_PANEL_WIDTH, FileConstants.UI_PANEL_HEIGHT));
        
        // Borda para o painel principal
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(FileConstants.UI_FILE_VIEWER_TITLE),
            BorderFactory.createEmptyBorder(FileConstants.UI_BORDER_PADDING, FileConstants.UI_BORDER_PADDING, 
                                           FileConstants.UI_BORDER_PADDING, FileConstants.UI_BORDER_PADDING)
        ));
        
        // Cor de fundo
        setBackground(new Color(FileConstants.UI_BACKGROUND_COLOR_R, FileConstants.UI_BACKGROUND_COLOR_G, FileConstants.UI_BACKGROUND_COLOR_B));
        headerPanel.setBackground(new Color(FileConstants.UI_HEADER_COLOR_R, FileConstants.UI_HEADER_COLOR_G, FileConstants.UI_HEADER_COLOR_B));
    }
    
    public void displayContent(String content, String fileName) {
        SwingUtilities.invokeLater(() -> {
            titleLabel.setText(FileConstants.UI_FILE_LABEL_PREFIX + fileName);
            textArea.setText(content);
            textArea.setCaretPosition(0); // Move para o início do texto
            
            // Atualiza a cor do título para indicar arquivo aberto
            titleLabel.setForeground(new Color(FileConstants.UI_FILE_OPEN_COLOR_R, 
                                             FileConstants.UI_FILE_OPEN_COLOR_G, 
                                             FileConstants.UI_FILE_OPEN_COLOR_B));
        });
    }
    
    public void clearContent() {
        SwingUtilities.invokeLater(() -> {
            titleLabel.setText(FileConstants.UI_NO_FILE_OPEN);
            titleLabel.setForeground(Color.BLACK);
            textArea.setText("");
        });
    }

}
