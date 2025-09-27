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
 * Diálogo "Sobre" da aplicação
 */
public class AboutDialog extends JDialog {

    public AboutDialog(JFrame parent) {
        super(parent, "Sobre", true);
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(400, 300);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Painel central com informações
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Título da aplicação
        JLabel titleLabel = new JLabel(UIConstants.MAIN_WINDOW_TITLE);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 10, 20);
        centerPanel.add(titleLabel, gbc);

        // Versão
        JLabel versionLabel = new JLabel("Versão 1.0.0");
        versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 20, 5, 20);
        centerPanel.add(versionLabel, gbc);

        // Separador
        JSeparator separator = new JSeparator();
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 20, 15, 20);
        centerPanel.add(separator, gbc);

        // Informações do desenvolvedor
        JLabel authorLabel = new JLabel("Desenvolvido por: Seu Nome");
        authorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(5, 20, 5, 20);
        centerPanel.add(authorLabel, gbc);

        // Data
        JLabel dateLabel = new JLabel("© 2025 - Todos os direitos reservados");
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 20, 5, 20);
        centerPanel.add(dateLabel, gbc);

        // Descrição
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setText("Interface Java Swing demonstrando o uso de menus,\n" +
                "diálogos e componentes GUI básicos.\n\n" +
                UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED);
        descriptionArea.setEditable(false);
        descriptionArea.setOpaque(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
        gbc.gridy = 5;
        gbc.insets = new Insets(15, 20, 20, 20);
        centerPanel.add(descriptionArea, gbc);

        panel.add(centerPanel, BorderLayout.CENTER);

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