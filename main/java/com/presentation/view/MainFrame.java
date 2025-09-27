// O package deve ser o seu. Ex: com.basicgui.presentation.view
package com.presentation.view;

// import com.presentation.domain.service.AnimationService; // Mantenha seus imports
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // --- ADICIONADO: Variáveis para os componentes da View ---
    private MenuBarView menuBarView;
    private StatusBarView statusBarView;
    private AnimatedBackgroundPanel bgPanel; // Mantendo seu painel

    public MainFrame() {
        initializeFrame();
        setupComponents();
    }

    private void initializeFrame() {
        setTitle("SI400B - Projeto Gui With Threads");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        // --- ADICIONADO: Layout para organizar os componentes ---
        setLayout(new BorderLayout());
        
        ImageIcon appIcon = new ImageIcon("src/resources/logoft.png"); // ou "src/resources/icon.png"

        // 3. Defina a imagem do ícone para a janela.
        setIconImage(appIcon.getImage());
    }

    private void setupComponents() {
        // 1. Cria e adiciona a barra de menus no topo
        menuBarView = new MenuBarView();
        setJMenuBar(menuBarView);

        // 2. Cria e adiciona a barra de status na base
        statusBarView = new StatusBarView();
        add(statusBarView, BorderLayout.SOUTH);

        // 3. Mantém seu painel de animação no centro
        // AnimationService animationService = new AnimationService(); // A lógica de serviço deve ir para o controller
        bgPanel = new AnimatedBackgroundPanel();
        add(bgPanel, BorderLayout.CENTER);
    }

    // --- ADICIONADO: Getters para que os Controllers possam acessar as Views ---
    public MenuBarView getMenuBarView() {
        return menuBarView;
    }

    public StatusBarView getStatusBarView() {
        return statusBarView;
    }

    /*
     * --- REMOVIDO: O método main() deve sair daqui! ---
     * Na nova estrutura, a responsabilidade de iniciar o programa
     * é do MainController.java. Mova este método para lá.
     */
    // public static void main(String[] args) { ... }
}
