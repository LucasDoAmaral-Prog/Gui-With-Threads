package com.presentation.dialog.help;

/**
 * GERADO AUTOMATICAMENTE - A SER EDITADO
 */

import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo de ajuda da aplicação
 */
public class HelpDialog extends JDialog {

    public HelpDialog(JFrame parent) {
        super(parent, "Ajuda", true);
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(500, 400);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de conteúdo da ajuda
        JTextArea helpText = new JTextArea();
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        String helpContent = UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED + "\n\n" +
                "GUIA DE USO DA APLICAÇÃO\n\n" +
                "MENU ARQUIVO:\n" +
                "• Abrir Arquivo: Permite abrir arquivos de texto para visualização\n" +
                "• Fechar Arquivo: Fecha o arquivo atualmente aberto\n" +
                "• Sair: Encerra a aplicação\n\n" +
                "MENU CONFIGURAÇÃO:\n" +
                "• Padrões: Escolha diferentes padrões para o fundo dinâmico\n" +
                "• Cores: Altere as cores das animações de fundo\n" +
                "• Velocidade: Ajuste a velocidade das animações\n\n" +
                "MENU AJUDA:\n" +
                "• Ajuda: Exibe este diálogo com informações de uso\n" +
                "• Sobre: Mostra informações sobre a aplicação\n\n" +
                "Esta aplicação foi desenvolvida como exemplo de interface Java Swing.";

        helpText.setText(helpContent);
        helpText.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(helpText);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(okButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }
}