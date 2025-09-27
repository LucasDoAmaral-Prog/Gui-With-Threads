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
 * Diálogo para configuração de cores do fundo dinâmico
 */
public class ColorConfigDialog extends JDialog {

    private Color selectedColor = Color.BLUE;

    public ColorConfigDialog(JFrame parent) {
        super(parent, "Configurar Cores", true);
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(400, 250);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de informação
        JLabel titleLabel = new JLabel(UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Painel central com opções de cores
        JPanel centerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
                Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.PINK};
        String[] colorNames = {"Vermelho", "Azul", "Verde", "Amarelo",
                "Laranja", "Magenta", "Ciano", "Rosa"};

        ButtonGroup colorGroup = new ButtonGroup();

        for (int i = 0; i < colors.length; i++) {
            JRadioButton colorButton = new JRadioButton(colorNames[i]);
            colorButton.setBackground(colors[i]);
            colorButton.setOpaque(true);

            if (colors[i] == Color.BLUE) {
                colorButton.setSelected(true);
            }

            final Color color = colors[i];
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedColor = color;
                }
            });

            colorGroup.add(colorButton);
            centerPanel.add(colorButton);
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

    public Color getSelectedColor() {
        return selectedColor;
    }
}