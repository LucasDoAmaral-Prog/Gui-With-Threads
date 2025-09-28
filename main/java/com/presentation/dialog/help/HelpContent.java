package com.presentation.dialog.help;

import java.util.Arrays;
import java.util.List;

public final class HelpContent {

    private HelpContent() {}

    public static List<ShortcutGroup> getShortcuts() {
        return Arrays.asList(
                new ShortcutGroup("📁 Menu Arquivo (Alt+A)", HelpStyles.PRIMARY_COLOR, Arrays.asList(
                        new Shortcut("A", "Abrir arquivo de texto"),
                        new Shortcut("F", "Fechar arquivo atual")
                )),
                new ShortcutGroup("⚙️ Menu Configuração (Alt+C)", HelpStyles.WARNING_COLOR, Arrays.asList(
                        new Shortcut("P", "Configurar padrões de animação"),
                        new Shortcut("O", "Configurar cores personalizadas"),
                        new Shortcut("V", "Configurar velocidade das animações")
                )),
                new ShortcutGroup("❓ Menu Ajuda (Alt+J)", HelpStyles.SUCCESS_COLOR, Arrays.asList(
                        new Shortcut("A", "Abrir esta janela de ajuda"),
                        new Shortcut("S", "Informações detalhadas do projeto")
                ))
        );
    }

    public static List<String> getGettingStarted() {
        return Arrays.asList(
                "1. Use Alt+A para abrir um arquivo de texto (.txt, .md, .log)",
                "2. O conteúdo será exibido na área central com scroll automático",
                "3. Use F para fechar o arquivo e voltar à animação de fundo",
                "4. Configure a animação usando Alt+C para acessar as opções",
                "5. P permite escolher diferentes padrões de animação",
                "6. O personaliza as cores da animação em tempo real",
                "7. V ajusta a velocidade da animação",
                "8. A barra de status mostra informações sobre as ações realizadas",
                "9. Use Alt+J para acessar esta ajuda a qualquer momento"
        );
    }

    public static List<FeatureHelp> getFeatures() {
        return Arrays.asList(
                new FeatureHelp("📂 Visualização de Arquivos", HelpStyles.PRIMARY_COLOR, Arrays.asList(
                        "Suporte completo a arquivos de texto (.txt, .md, .log)",
                        "Detecção automática de codificação de caracteres",
                        "Scroll suave para arquivos grandes",
                        "Quebra de linha automática para melhor leitura",
                        "Área de título mostra o nome do arquivo aberto",
                        "Validação de tipos de arquivo suportados"
                )),
                new FeatureHelp("🎨 Animação de Fundo", HelpStyles.INFO_COLOR, Arrays.asList(
                        "Execução em thread separada para performance",
                        "Múltiplos padrões de animação disponíveis",
                        "Cores personalizáveis em tempo real",
                        "Controle de velocidade dinâmico",
                        "Não interfere na leitura de arquivos",
                        "Otimizado para diferentes resoluções de tela"
                )),
                new FeatureHelp("🖥️ Interface Responsiva", HelpStyles.SUCCESS_COLOR, Arrays.asList(
                        "Redimensionamento automático de componentes",
                        "Menus com atalhos de teclado intuitivos",
                        "Barra de status informativa",
                        "Navegação por teclado completa",
                        "Feedback visual para todas as ações",
                        "Design moderno e profissional"
                ))
        );
    }

    public static List<String> getTroubleshooting() {
        return Arrays.asList(
                "❓ Arquivo não abre:",
                "  • Verifique se é um arquivo de texto válido (.txt, .md, .log)",
                "  • Confirme se o arquivo não está sendo usado por outro programa",
                "  • Tente um arquivo menor para teste",
                "",
                "❓ Animação está lenta:",
                "  • Use Ctrl+Shift+S para aumentar a velocidade",
                "  • Feche outros programas que consomem muita CPU",
                "  • Reinicie a aplicação se necessário",
                "",
                "❓ Menu não responde:",
                "  • Use os atalhos Alt+A, Alt+C, Alt+J diretamente",
                "  • Clique em uma área vazia da janela e tente novamente",
                "  • Verifique se caps lock não está ativado",
                "",
                "❓ Aplicação trava:",
                "  • Use Alt+S para sair com segurança",
                "  • Force o encerramento se necessário (Ctrl+Alt+T no Linux/Ctrl+Shift+Esc no Windows)",
                "  • Reinicie a aplicação",
                "",
                "❓ Cores estão estranhas:",
                "  • Use Alt+O para resetar as configurações de cor",
                "  • Tente diferentes padrões com Alt+P",
                "  • Reinicie a aplicação para configurações padrão"
        );
    }

    public static List<String> getTips() {
        return Arrays.asList(
                "💡 Use Alt+F para voltar rapidamente à animação após ler um arquivo",
                "💡 Experimente diferentes combinações de padrões e cores para personalizar",
                "💡 A animação continua executando em segundo plano mesmo com arquivo aberto",
                "💡 Arquivos grandes podem demorar alguns segundos para carregar completamente",
                "💡 Use a barra de rolagem ou Page Up/Page Down para navegar em arquivos grandes",
                "💡 A barra de status sempre mostra o que está acontecendo na aplicação",
                "💡 Todos os menus podem ser acessados tanto por mouse quanto por teclado",
                "💡 A aplicação lembra das configurações de cor e velocidade entre sessões",
                "💡 Use Escape para fechar diálogos rapidamente",
                "💡 Mantenha arquivos de texto em formato UTF-8 para melhor compatibilidade"
        );
    }

    public static class ShortcutGroup {
        public final String title;
        public final java.awt.Color color;
        public final List<Shortcut> shortcuts;

        public ShortcutGroup(String title, java.awt.Color color, List<Shortcut> shortcuts) {
            this.title = title;
            this.color = color;
            this.shortcuts = shortcuts;
        }
    }

    public static class Shortcut {
        public final String key;
        public final String description;

        public Shortcut(String key, String description) {
            this.key = key;
            this.description = description;
        }
    }

    public static class FeatureHelp {
        public final String title;
        public final java.awt.Color color;
        public final List<String> items;

        public FeatureHelp(String title, java.awt.Color color, List<String> items) {
            this.title = title;
            this.color = color;
            this.items = items;
        }
    }
}
