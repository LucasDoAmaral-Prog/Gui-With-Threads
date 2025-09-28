package com.presentation.dialog;

import com.shared.constants.AppConstants;
import com.shared.constants.UIConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class HelpDialog extends JDialog {
    private JFrame parent;
    private JTextArea helpTextArea;
    private JTabbedPane tabbedPane;

    public HelpDialog(JFrame parent) {
        super(parent, AppConstants.HELP_TITLE, true);
        this.parent = parent;
        initializeDialog();
        createComponents();
        loadHelpContent();
        setupEventListeners();
    }

    private void initializeDialog() {
        setSize(AppConstants.HELP_DIALOG_WIDTH, AppConstants.HELP_DIALOG_HEIGHT);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        getContentPane().setBackground(UIConstants.DIALOG_BACKGROUND);
    }

    private void createComponents() {
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        // Main Content with Tabs
        tabbedPane = createTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        // Footer with Buttons
        JPanel footerPanel = createFooterPanel();
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(UIConstants.HEADER_BACKGROUND);
        headerPanel.setBorder(new EmptyBorder(UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM));

        // Title and Icon
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(false);

        // Help Icon
        JLabel iconLabel = new JLabel();
        try {
            ImageIcon helpIcon = createHelpIcon();
            iconLabel.setIcon(helpIcon);
        } catch (Exception e) {
            iconLabel.setText("?");
            iconLabel.setFont(new Font("Arial", Font.BOLD, 24));
            iconLabel.setForeground(UIConstants.PRIMARY_COLOR);
        }

        JLabel titleLabel = new JLabel("Sistema de Ajuda");
        titleLabel.setFont(UIConstants.TITLE_FONT);
        titleLabel.setForeground(UIConstants.TEXT_PRIMARY);

        titlePanel.add(iconLabel);
        titlePanel.add(Box.createHorizontalStrut(UIConstants.PADDING_MEDIUM));
        titlePanel.add(titleLabel);

        headerPanel.add(titlePanel, BorderLayout.WEST);

        return headerPanel;
    }

    private JTabbedPane createTabbedPane() {
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(UIConstants.NORMAL_FONT);
        tabs.setBackground(UIConstants.PANEL_BACKGROUND);

        // Tab 1: Guia Geral
        JPanel generalTab = createGeneralHelpTab();
        tabs.addTab("Guia Geral", generalTab);

        // Tab 2: Menu Arquivo
        JPanel fileTab = createFileMenuTab();
        tabs.addTab("Menu Arquivo", fileTab);

        // Tab 3: Menu Configuração
        JPanel configTab = createConfigMenuTab();
        tabs.addTab("Configurações", configTab);

        // Tab 4: Background Animado
        JPanel animationTab = createAnimationTab();
        tabs.addTab("Animações", animationTab);

        return tabs;
    }

    private JPanel createGeneralHelpTab() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE));

        // Create scrollable text area
        helpTextArea = new JTextArea();
        helpTextArea.setFont(UIConstants.NORMAL_FONT);
        helpTextArea.setLineWrap(true);
        helpTextArea.setWrapStyleWord(true);
        helpTextArea.setEditable(false);
        helpTextArea.setBackground(Color.WHITE);
        helpTextArea.setBorder(new EmptyBorder(UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM));

        String generalHelp = "BEM-VINDO AO " + AppConstants.APP_NAME + "\n\n" +
                AppConstants.APP_DESCRIPTION + "\n\n" +
                "CARACTERÍSTICAS PRINCIPAIS:\n" +
                "• Interface gráfica moderna e intuitiva\n" +
                "• Background animado com múltiplos padrões\n" +
                "• Sistema completo de arquivos\n" +
                "• Configurações personalizáveis\n" +
                "• Threads otimizadas para performance\n\n" +
                "COMO USAR:\n" +
                "1. Use o Menu Arquivo para abrir e manipular arquivos\n" +
                "2. Configure o background através do Menu Configuração\n" +
                "3. Explore as diferentes abas desta ajuda para detalhes específicos\n\n" +
                "DICAS:\n" +
                "• Clique em qualquer menu para ver as opções disponíveis\n" +
                "• O background animado pode ser personalizado completamente\n" +
                "• Todos os arquivos de texto são suportados";

        helpTextArea.setText(generalHelp);
        helpTextArea.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(helpTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Informações Gerais",
                TitledBorder.LEFT, TitledBorder.TOP, UIConstants.SUBTITLE_FONT));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createFileMenuTab() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE));

        JTextArea fileHelp = new JTextArea();
        fileHelp.setFont(UIConstants.NORMAL_FONT);
        fileHelp.setLineWrap(true);
        fileHelp.setWrapStyleWord(true);
        fileHelp.setEditable(false);
        fileHelp.setBackground(Color.WHITE);

        String fileContent = "MENU ARQUIVO - GERENCIAMENTO DE ARQUIVOS\n\n" +
                "ABRIR ARQUIVO:\n" +
                "• Permite selecionar e abrir arquivos de texto\n" +
                "• Suporta formatos: .txt, .log, .md, .java, .xml\n" +
                "• O conteúdo é exibido na área principal da aplicação\n" +
                "• Codificação UTF-8 é suportada automaticamente\n\n" +
                "FECHAR ARQUIVO:\n" +
                "• Remove o conteúdo da área de visualização\n" +
                "• Libera recursos de memória\n" +
                "• Não afeta o arquivo original no disco\n\n" +
                "SAIR:\n" +
                "• Encerra a aplicação de forma segura\n" +
                "• Para threads de animação automaticamente\n" +
                "• Salva configurações se necessário\n\n" +
                "DICAS DE USO:\n" +
                "• Use Ctrl+O para abrir arquivos rapidamente\n" +
                "• Arquivos grandes podem demorar para carregar\n" +
                "• A área de texto suporta rolagem automática";

        fileHelp.setText(fileContent);
        fileHelp.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(fileHelp);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Gerenciamento de Arquivos",
                TitledBorder.LEFT, TitledBorder.TOP, UIConstants.SUBTITLE_FONT));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createConfigMenuTab() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE));

        JTextArea configHelp = new JTextArea();
        configHelp.setFont(UIConstants.NORMAL_FONT);
        configHelp.setLineWrap(true);
        configHelp.setWrapStyleWord(true);
        configHelp.setEditable(false);
        configHelp.setBackground(Color.WHITE);

        String configContent = "MENU CONFIGURAÇÃO - PERSONALIZAÇÃO\n\n" +
                "PADRÕES DE ANIMAÇÃO:\n" +
                "• CIRCLES: Círculos coloridos em movimento suave\n" +
                "• SQUARES: Quadrados com rotação dinâmica\n" +
                "• STARS: Estrelas com efeito de rotação\n" +
                "• WAVES: Ondas fluidas com movimento senoidal\n\n" +
                "ESQUEMAS DE CORES:\n" +
                "• COOL: Tons frios (azul, ciano, violeta)\n" +
                "• WARM: Tons quentes (vermelho, laranja, amarelo)\n" +
                "• NATURE: Tons naturais (verde, marrom, dourado)\n" +
                "• CUSTOM: Personalize suas próprias cores\n\n" +
                "VELOCIDADE DA ANIMAÇÃO:\n" +
                "• SLOW: Movimento relaxante e suave (50ms delay)\n" +
                "• NORMAL: Velocidade padrão balanceada (16ms delay)\n" +
                "• FAST: Animação rápida e dinâmica (8ms delay)\n\n" +
                "PERFORMANCE:\n" +
                "• Velocidades mais altas consomem mais CPU\n" +
                "• Recomenda-se NORMAL para uso geral\n" +
                "• Use SLOW em computadores mais antigos";

        configHelp.setText(configContent);
        configHelp.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(configHelp);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Opções de Configuração",
                TitledBorder.LEFT, TitledBorder.TOP, UIConstants.SUBTITLE_FONT));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createAnimationTab() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE,
                UIConstants.PADDING_LARGE));

        JTextArea animationHelp = new JTextArea();
        animationHelp.setFont(UIConstants.NORMAL_FONT);
        animationHelp.setLineWrap(true);
        animationHelp.setWrapStyleWord(true);
        animationHelp.setEditable(false);
        animationHelp.setBackground(Color.WHITE);

        String animationContent = "SISTEMA DE ANIMAÇÃO - TECNOLOGIA\n\n" +
                "COMO FUNCIONA:\n" +
                "• Utiliza threads separadas para animação suave\n" +
                "• Renderização otimizada com Graphics2D\n" +
                "• Anti-aliasing para qualidade visual superior\n" +
                "• Timer baseado em Swing para sincronização\n\n" +
                "CONTROLES DISPONÍVEIS:\n" +
                "• Pause/Resume: Clique na área de animação\n" +
                "• Mudança de padrão: Menu Configuração > Padrões\n" +
                "• Ajuste de cores: Menu Configuração > Cores\n" +
                "• Controle de velocidade: Menu Configuração > Velocidade\n\n" +
                "DETALHES TÉCNICOS:\n" +
                "• Clean Architecture com separação de camadas\n" +
                "• Factory Pattern para criação de padrões\n" +
                "• Observer Pattern para atualizações de UI\n" +
                "• Thread-safe com SwingUtilities\n\n" +
                "TROUBLESHOOTING:\n" +
                "• Se a animação travar, reduza a velocidade\n" +
                "• Performance baixa: use menos elementos\n" +
                "• Para resetar: reinicie a aplicação";

        animationHelp.setText(animationContent);
        animationHelp.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(animationHelp);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Sistema de Animação",
                TitledBorder.LEFT, TitledBorder.TOP, UIConstants.SUBTITLE_FONT));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setBackground(UIConstants.DIALOG_BACKGROUND);
        footerPanel.setBorder(new EmptyBorder(UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM,
                UIConstants.PADDING_MEDIUM));

        // Print Button
        JButton printButton = createStyledButton("Imprimir", UIConstants.INFO_COLOR);

        // Close Button
        JButton closeButton = createStyledButton("Fechar", UIConstants.SECONDARY_COLOR);

        footerPanel.add(printButton);
        footerPanel.add(Box.createHorizontalStrut(UIConstants.PADDING_MEDIUM));
        footerPanel.add(closeButton);

        return footerPanel;
    }

    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(UIConstants.NORMAL_FONT);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(UIConstants.BUTTON_WIDTH, UIConstants.BUTTON_HEIGHT));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });

        return button;
    }

    private void setupEventListeners() {
        // Print Button
        Component[] components = ((JPanel) getContentPane().getComponent(2)).getComponents();
        for (Component comp : components) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (button.getText().equals("Imprimir")) {
                    button.addActionListener(e -> printHelp());
                } else if (button.getText().equals("Fechar")) {
                    button.addActionListener(e -> dispose());
                }
            }
        }
    }

    private void printHelp() {
        try {
            // Simple print functionality
            if (helpTextArea.print()) {
                JOptionPane.showMessageDialog(this,
                        "Ajuda enviada para impressão com sucesso!",
                        "Imprimir", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao imprimir: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ImageIcon createHelpIcon() {
        // Create a simple help icon programmatically
        int size = 32;
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(size, size, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw circle
        g2d.setColor(UIConstants.PRIMARY_COLOR);
        g2d.fillOval(2, 2, size-4, size-4);

        // Draw question mark
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g2d.getFontMetrics();
        int x = (size - fm.stringWidth("?")) / 2;
        int y = (size + fm.getAscent()) / 2 - 2;
        g2d.drawString("?", x, y);

        g2d.dispose();
        return new ImageIcon(img);
    }

    private void loadHelpContent() {
        try {
            // Try to load external help content
            InputStream is = getClass().getClassLoader().getResourceAsStream(AppConstants.HELP_TEXT_FILE);
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                if (content.length() > 0) {
                    helpTextArea.setText(content.toString());
                    helpTextArea.setCaretPosition(0);
                }
            }
        } catch (Exception e) {
            // Use default content if file not found
            System.out.println("Help file not found, using default content: " + e.getMessage());
        }
    }

    public static void showHelpDialog(JFrame parent) {
        SwingUtilities.invokeLater(() -> {
            HelpDialog dialog = new HelpDialog(parent);
            dialog.setVisible(true);
        });
    }
}
