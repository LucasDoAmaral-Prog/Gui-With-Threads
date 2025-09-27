package com.presentation.dialog;

import javax.swing.*;
import java.awt.*;

public class PatternConfigDialog extends JDialog {

    private JComboBox<String> comboPatterns;
    private String selectedPattern;

    private static final Dimension DIALOG_SIZE = new Dimension(300, 150);

    public PatternConfigDialog(JFrame parent, String currentPattern) {
        super(parent, "Selecionar Padrão", true);

        comboPatterns = new JComboBox<>(new String[]{"CIRCLES", "SQUARES", "STARS", "WAVES"});
        comboPatterns.setSelectedItem(currentPattern);
        comboPatterns.setPreferredSize(new Dimension(150, 25));

        JButton okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(100, 25));
        okButton.addActionListener(e -> {
            selectedPattern = (String) comboPatterns.getSelectedItem();
            dispose();
        });

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setPreferredSize(new Dimension(100, 25));
        cancelButton.addActionListener(e -> {
            selectedPattern = null; // não altera
            dispose();
        });

        // Painel central com label e combo lado a lado
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(new JLabel("Escolha o padrão:"), gbc);

        gbc.gridx = 1;
        centerPanel.add(comboPatterns, gbc);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(DIALOG_SIZE);
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getSelectedPattern() {
        return selectedPattern;
    }
}
