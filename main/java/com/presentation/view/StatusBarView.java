//edição de 2024-06-20
package com.presentation.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Representa a barra de status na parte inferior da janela principal.
 */
public class StatusBarView extends JPanel {

    private final JLabel statusLabel;

    public StatusBarView() {
        super(new BorderLayout());
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        statusLabel = new JLabel("Pronto");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        add(statusLabel, BorderLayout.CENTER);
    }

    public void setMessage(String message) {
        statusLabel.setText(message);
    }
}