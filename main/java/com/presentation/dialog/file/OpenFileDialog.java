package com.presentation.dialog.file;

import com.presentation.shared.constants.UIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Diálogo para abrir arquivos
 */
public class OpenFileDialog extends JDialog {

    private boolean fileOpened = false;
    private File selectedFile = null;

    public OpenFileDialog(JFrame parent) {
        super(parent, "Abrir Arquivo", true);
        initializeDialog();
    }

    private void initializeDialog() {
        setSize(400, 200);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Área de informação
        JLabel infoLabel = new JLabel("<html><center>" + UIConstants.MESSAGE_FEATURE_NOT_IMPLEMENTED +
                "<br><br>Esta funcionalidade permitirá abrir arquivos de texto.</center></html>");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(infoLabel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simula abertura de arquivo
                fileOpened = true;
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

    public boolean isFileOpened() {
        return fileOpened;
    }

    public File getSelectedFile() {
        return selectedFile;
    }
}