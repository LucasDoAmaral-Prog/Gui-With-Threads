package com.presentation.dialog.config;

/**
 * GERADO AUTOMATICAMENTE - A SER EDITADO
 */

import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo para configuração de padrões do fundo dinâmico
 */
public class PatternConfigDialog extends JDialog {

    private String selectedPattern = "Padrão 1";

    public PatternConfigDialog(JFrame parent) {
        super(parent, "Configurar Padrões", true);
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(400, 300);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de informação
        JLabel titleLabel = new JLabel(UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Painel central com opções de padrões
        JPanel centerPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        ButtonGroup patternGroup = new ButtonGroup();
        String[] patterns = {"Padrão 1 - Círculos", "Padrão 2 - Linhas", "Padrão 3 - Partículas", "Padrão 4 - Ondas"};

        for (String pattern : patterns) {
            JRadioButton radioButton = new JRadioButton(pattern);
            if (pattern.equals("Padrão 1 - Círculos")) {
                radioButton.setSelected(true);
            }
            patternGroup.add(radioButton);
            centerPanel.add(radioButton);
        }

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

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public String getSelectedPattern() {
        return selectedPattern;
    }
}