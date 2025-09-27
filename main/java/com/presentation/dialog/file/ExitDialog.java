package com.presentation.dialog.file;

import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo para confirmar saída da aplicação
 */
public class ExitDialog extends JDialog {

    private boolean exitConfirmed = false;

    public ExitDialog(JFrame parent) {
        super(parent, "Sair da Aplicação", true);
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(300, 120);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de confirmação
        JLabel confirmLabel = new JLabel(UIConstants.MESSAGE_EXIT_CONFIRM);
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);
        confirmLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(confirmLabel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton simButton = new JButton("Sim");
        simButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitConfirmed = true;
                dispose();
            }
        });

        JButton naoButton = new JButton("Não");
        naoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(simButton);
        buttonPanel.add(naoButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public boolean isExitConfirmed() {
        return exitConfirmed;
    }
}