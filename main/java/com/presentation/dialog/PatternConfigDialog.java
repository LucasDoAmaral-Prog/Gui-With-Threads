package com.presentation.dialog;

import com.presentation.shared.constants.AnimationConstants;

import javax.swing.*;
import java.awt.*;

public class PatternConfigDialog extends JDialog {

    private JComboBox<String> comboPatterns;
    private Integer selectedIndex; // Agora usamos índice

    private static final Dimension DIALOG_SIZE = new Dimension(350, 150);

    public PatternConfigDialog(JFrame parent, int currentIndex) {
        super(parent, AnimationConstants.PATTERN_CONFIG_DIALOG_TITLE, true);

        comboPatterns = new JComboBox<>(AnimationConstants.PATTERN_OPTIONS);
        comboPatterns.setSelectedIndex(currentIndex); // seleciona pelo índice
        comboPatterns.setPreferredSize(new Dimension(180, 25));

        JButton okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(100, 25));
        okButton.addActionListener(e -> {
            selectedIndex = comboPatterns.getSelectedIndex(); // pega índice selecionado
            dispose();
        });

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setPreferredSize(new Dimension(100, 25));
        cancelButton.addActionListener(e -> {
            selectedIndex = null; // não altera
            dispose();
        });

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(new JLabel(AnimationConstants.PATTERN_CONFIG_DIALOG_TEXT), gbc);

        gbc.gridx = 1;
        centerPanel.add(comboPatterns, gbc);

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

    // Retorna índice selecionado
    public Integer getSelectedIndex() {
        return selectedIndex;
    }
}
