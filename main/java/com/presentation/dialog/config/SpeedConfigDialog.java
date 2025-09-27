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
 * Diálogo para configuração de velocidade das animações
 */
public class SpeedConfigDialog extends JDialog {

    private int selectedSpeed = UIConstants.DEFAULT_ANIMATION_SPEED;

    public SpeedConfigDialog(JFrame parent) {
        super(parent, "Configurar Velocidade", true);
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(400, 200);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de informação
        JLabel titleLabel = new JLabel(UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Painel central com controle de velocidade
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel speedLabel = new JLabel("Velocidade da Animação:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        centerPanel.add(speedLabel, gbc);

        JSlider speedSlider = new JSlider(UIConstants.MIN_ANIMATION_SPEED,
                UIConstants.MAX_ANIMATION_SPEED,
                UIConstants.DEFAULT_ANIMATION_SPEED);
        speedSlider.setMajorTickSpacing(50);
        speedSlider.setMinorTickSpacing(10);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(speedSlider, gbc);

        panel.add(centerPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSpeed = speedSlider.getValue();
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

    public int getSelectedSpeed() {
        return selectedSpeed;
    }
}