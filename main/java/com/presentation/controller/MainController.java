package com.presentation.controller;

import com.presentation.shared.constants.StatusBarConstants;
import com.presentation.view.MainView;
import com.presentation.shared.util.UIUtils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainController {

    private MainView mainView;
    private MenuController menuController;

    public MainController() {
        mainView = new MainView();
        menuController = new MenuController(mainView);

        mainView.setVisible(true);
        mainView.addMainMenuListener(menuController);
        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onWindowClosing();
            }
        });

        UIUtils.configureOptionPaneBntOptions();
    }

    private void onWindowClosing() {
        mainView.setStatus(StatusBarConstants.STATUS_EXITING);
        System.exit(0);
    }
}