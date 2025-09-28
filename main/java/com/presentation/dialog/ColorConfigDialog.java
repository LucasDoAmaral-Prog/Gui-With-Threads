package com.presentation.dialog;

import com.presentation.shared.constants.AnimationConstants;
import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import java.awt.*;

public class ColorConfigDialog extends JDialog {

    private JComboBox<String> comboColors;
    private Integer selectedIndex; // agora armazenamos o índice selecionado

    private static final Dimension DIALOG_SIZE = new Dimension(350, 150);

    public ColorConfigDialog(JFrame parent, int currentIndex) {
        super(parent, AnimationConstants.COLOR_CONFIG_DIALOG_TITLE, true);

        // ComboBox com todas as cores disponíveis
        comboColors = new JComboBox<>(AnimationConstants.COLOR_OPTIONS);
        comboColors.setSelectedIndex(currentIndex); // seleciona pelo índice
        comboColors.setPreferredSize(new Dimension(180, 25));

        // Botão OK
        JButton okButton = new JButton(UIConstants.BTN_OK);
        okButton.setPreferredSize(new Dimension(100, 25));
        okButton.addActionListener(e -> {
            selectedIndex = comboColors.getSelectedIndex(); // pega índice selecionado
            dispose();
        });

        // Botão Cancelar
        JButton cancelButton = new JButton(UIConstants.BTN_CANCEL);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        cancelButton.addActionListener(e -> {
            selectedIndex = null; // não altera
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
        centerPanel.add(new JLabel(AnimationConstants.COLOR_CONFIG_DIALOG_TEXT), gbc);

        gbc.gridx = 1;
        centerPanel.add(comboColors, gbc);

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

    // Retorna índice selecionado
    public Integer getSelectedIndex() {
        return selectedIndex;
    }
}
