package com.presentation.view;

import javax.swing.*;
import com.presentation.shared.listener.MenuListener;
import com.presentation.shared.constants.MenuConstants;

public class AppMenuBar {
    private JMenuBar menuBar;
    private MenuListener menuListener;

    public AppMenuBar() {
        menuBar = new JMenuBar();

        // Menu Arquivo
        JMenu menuArquivo = new JMenu(MenuConstants.MENU_ARQUIVO);
        menuArquivo.setMnemonic(MenuConstants.MNEMONIC_ARQUIVO);

        JMenuItem abrirArquivo = new JMenuItem(MenuConstants.MENU_ITEM_ABRIR_ARQUIVO);
        abrirArquivo.setMnemonic(MenuConstants.MNEMONIC_ABRIR_ARQUIVO);
        abrirArquivo.setActionCommand(MenuConstants.ACTION_ABRIR_ARQUIVO);
        abrirArquivo.addActionListener(e -> fireEvent(MenuConstants.ACTION_ABRIR_ARQUIVO));

        JMenuItem fecharArquivo = new JMenuItem(MenuConstants.MENU_ITEM_FECHAR_ARQUIVO);
        fecharArquivo.setMnemonic(MenuConstants.MNEMONIC_FECHAR_ARQUIVO);
        fecharArquivo.setActionCommand(MenuConstants.ACTION_FECHAR_ARQUIVO);
        fecharArquivo.addActionListener(e -> fireEvent(MenuConstants.ACTION_FECHAR_ARQUIVO));

        JMenuItem sair = new JMenuItem(MenuConstants.MENU_ITEM_SAIR);
        sair.setMnemonic(MenuConstants.MNEMONIC_SAIR);
        sair.setActionCommand(MenuConstants.ACTION_SAIR);
        sair.addActionListener(e -> fireEvent(MenuConstants.ACTION_SAIR));

        menuArquivo.add(abrirArquivo);
        menuArquivo.add(fecharArquivo);
        menuArquivo.addSeparator();
        menuArquivo.add(sair);

        // Menu Configuração
        JMenu menuConfiguracao = new JMenu(MenuConstants.MENU_CONFIGURACAO);
        menuConfiguracao.setMnemonic(MenuConstants.MNEMONIC_CONFIGURACAO);

        JMenuItem padroes = new JMenuItem(MenuConstants.MENU_ITEM_PADROES);
        padroes.setMnemonic(MenuConstants.MNEMONIC_PADROES);
        padroes.setActionCommand(MenuConstants.ACTION_PADROES);
        padroes.addActionListener(e -> fireEvent(MenuConstants.ACTION_PADROES));

        JMenuItem cores = new JMenuItem(MenuConstants.MENU_ITEM_CORES);
        cores.setMnemonic(MenuConstants.MNEMONIC_CORES);
        cores.setActionCommand(MenuConstants.ACTION_CORES);
        cores.addActionListener(e -> fireEvent(MenuConstants.ACTION_CORES));

        JMenuItem velocidade = new JMenuItem(MenuConstants.MENU_ITEM_VELOCIDADE);
        velocidade.setMnemonic(MenuConstants.MNEMONIC_VELOCIDADE);
        velocidade.setActionCommand(MenuConstants.ACTION_VELOCIDADE);
        velocidade.addActionListener(e -> fireEvent(MenuConstants.ACTION_VELOCIDADE));

        menuConfiguracao.add(padroes);
        menuConfiguracao.add(cores);
        menuConfiguracao.add(velocidade);

        // Menu Ajuda
        JMenu menuAjuda = new JMenu(MenuConstants.MENU_AJUDA);
        menuAjuda.setMnemonic(MenuConstants.MNEMONIC_AJUDA);

        JMenuItem ajuda = new JMenuItem(MenuConstants.MENU_ITEM_AJUDA);
        ajuda.setMnemonic(MenuConstants.MNEMONIC_AJUDA_ITEM);
        ajuda.setActionCommand(MenuConstants.ACTION_AJUDA);
        ajuda.addActionListener(e -> fireEvent(MenuConstants.ACTION_AJUDA));

        JMenuItem sobre = new JMenuItem(MenuConstants.MENU_ITEM_SOBRE);
        sobre.setMnemonic(MenuConstants.MNEMONIC_SOBRE);
        sobre.setActionCommand(MenuConstants.ACTION_SOBRE);
        sobre.addActionListener(e -> fireEvent(MenuConstants.ACTION_SOBRE));

        menuAjuda.add(ajuda);
        menuAjuda.addSeparator();
        menuAjuda.add(sobre);

        // Adicionandos todos os menus à barra principal
        menuBar.add(menuArquivo);
        menuBar.add(menuConfiguracao);
        menuBar.add(menuAjuda);
    }

    private void fireEvent(String command) {
        if (menuListener != null) menuListener.onMenuSelected(command);
    }

    public void setMenuListener(MenuListener listener) {
        this.menuListener = listener;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
