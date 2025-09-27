package com.presentation.view;

import javax.swing.*;
import java.awt.*;

import com.presentation.shared.constants.StatusBarConstants;

public class StatusBar {

    private JLabel label;

    public StatusBar() {
        label = new JLabel(StatusBarConstants.STATUS_READY);
        label.setBorder(BorderFactory.createLoweredBevelBorder());
        label.setPreferredSize(new Dimension(0, 25));
    }

    public JComponent getComponent() {
        return label;
    }

    public void setText(String text) {
        label.setText(text);
    }

}
