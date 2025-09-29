package com.presentation.dialog.about;

import com.presentation.dialog.DialogStyles;

import java.util.Arrays;
import java.util.List;

public final class AboutContent {

    private AboutContent() {}

    public static List<String> getProjectInfo() {
        return Arrays.asList(
                "Aplicação Java completa com interface gráfica avançada",
                "Demonstração de conceitos fundamentais de POO",
                "Integração de threads para animações dinâmicas",
                "Manipulação segura de arquivos de texto",
                "Interface responsiva com componentes personalizados",
                "Projeto acadêmico desenvolvido colaborativamente",
                "Implementação seguindo padrões de Clean Architecture",
                "Foco em usabilidade e experiência do usuário"
        );
    }

    public static List<String> getObjectives() {
        return Arrays.asList(
                "Demonstrar mecânica de ouvintes (ActionListener implementation)",
                "Implementar leitura e apresentação de arquivos de texto",
                "Criar animações dinâmicas usando threads separadas",
                "Desenvolver diálogos personalizados com componentes Swing",
                "Integrar JFileChooser para manipulação de arquivos",
                "Aplicar padrões de arquitetura orientada a objetos",
                "Implementar interface responsiva com múltiplos layouts",
                "Garantir separação adequada entre lógica e apresentação",
                "Criar componentes reutilizáveis e extensíveis",
                "Demonstrar boas práticas de programação Java"
        );
    }

    public static FeatureGroup[] getFeatures() {
        return new FeatureGroup[]{
                new FeatureGroup("📁 Alt+A ARQUIVO:", DialogStyles.PRIMARY_COLOR, Arrays.asList(
                        "A - Abrir arquivo",
                        "F - Fechar arquivo",
                        "S - Sair da aplicação"
                )),
                new FeatureGroup("🎨 Alt+C CONFIGURAÇÃO:", DialogStyles.TECH_COLOR, Arrays.asList(
                        "P - Padrões de animação",
                        "O - Cores personalizadas",
                        "v - Velocidade das animações"
                )),
                new FeatureGroup("❓ Alt+J AJUDA:", DialogStyles.ACCENT_COLOR, Arrays.asList(
                        "A - Ajuda detalhada",
                        "S- Informações do projeto"
                )),
                new FeatureGroup("🖥️ INTERFACE:", DialogStyles.INFO_COLOR, Arrays.asList(
                        "Área de conteúdo com scroll automático",
                        "Fundo animado executado em thread separada",
                        "Barra de status com feedback em tempo real",
                        "Redimensionamento dinâmico de componentes"
                ))
        };
    }

    public static TechnicalGroup[] getTechnicalSpecs() {
        return new TechnicalGroup[]{
                new TechnicalGroup("🖼️ Interface Gráfica:", Arrays.asList(
                        "JFrame principal com layout BorderLayout",
                        "JMenuBar customizada com atalhos Alt+A, Alt+C, Alt+J",
                        "JPanel personalizado para animações",
                        "JDialog modal para ajuda e configurações",
                        "JScrollPane para conteúdo de arquivos",
                        "JTextArea com quebra de linha automática"
                )),
                new TechnicalGroup("🔄 Multithreading:", Arrays.asList(
                        "Thread separada para animação de fundo",
                        "EDT (Event Dispatch Thread) para interface",
                        "Sincronização adequada entre threads",
                        "SwingUtilities.invokeLater() para updates de UI"
                )),
                new TechnicalGroup("📂 Manipulação de Arquivos:", Arrays.asList(
                        "JFileChooser para seleção de arquivos",
                        "Validação de tipos de arquivo suportados",
                        "Leitura segura com tratamento de exceções",
                        "Suporte a arquivos .txt, .md, .log"
                )),
                new TechnicalGroup("⚡ Eventos e Listeners:", Arrays.asList(
                        "ActionListener implementado internamente",
                        "MouseListener para interações customizadas",
                        "WindowListener para encerramento seguro",
                        "Padrão Observer para comunicação entre componentes"
                ))
        };
    }

    public static TeamMember[] getTeamMembers() {
        return new TeamMember[]{
                new TeamMember("🖥️ Interface Menu", "1 Desenvolvedor", DialogStyles.PRIMARY_COLOR, Arrays.asList(
                        "Criação da estrutura de menus (JMenuBar)",
                        "Implementação de ActionListeners",
                        "Definição de atalhos Alt+A, Alt+C, Alt+J",
                        "Integração com MenuController"
                )),
                new TeamMember("🎨 Background & Animação", "2 Desenvolvedores", DialogStyles.ACCENT_COLOR, Arrays.asList(
                        "Desenvolvimento do painel animado personalizado",
                        "Implementação de threads para animações",
                        "Sistema de configuração Alt+P, Alt+O, Ctrl+Shift+S",
                        "Otimização de performance gráfica"
                )),
                new TeamMember("📁 Lógica de Arquivos", "2 Desenvolvedores", DialogStyles.INFO_COLOR, Arrays.asList(
                        "Integração com JFileChooser",
                        "Sistema de leitura Alt+A e fechamento Alt+F",
                        "Tratamento de exceções de I/O",
                        "Interface de exibição de conteúdo"
                )),
                new TeamMember("📖 Ajuda & Documentação", "1 Desenvolvedor", DialogStyles.TECH_COLOR, Arrays.asList(
                        "Criação de diálogos de ajuda Alt+A",
                        "Documentação técnica do projeto",
                        "Sistema de informações sobre a aplicação",
                        "Criação de constantes e textos padronizados"
                ))
        };
    }

    public static List<String> getEvaluationCriteria() {
        return Arrays.asList(
                "Entrega completa - Todos os requisitos funcionais implementados",
                "Metodologia padronizada - Processo de desenvolvimento estruturado",
                "Código em inglês - Nomenclatura internacional seguida",
                "Arquitetura de classes - Design orientado a objetos bem estruturado",
                "Qualidade do código - Boas práticas e padrões aplicados",
                "Execução multithread - Threads implementadas corretamente",
                "Elementos gráficos - Interface rica e componentes dinâmicos",
                "Aspecto geral - Aplicação polida e experiência profissional"
        );
    }

    public static class FeatureGroup {
        public final String title;
        public final java.awt.Color color;
        public final List<String> items;

        public FeatureGroup(String title, java.awt.Color color, List<String> items) {
            this.title = title;
            this.color = color;
            this.items = items;
        }
    }

    public static class TechnicalGroup {
        public final String title;
        public final List<String> items;

        public TechnicalGroup(String title, List<String> items) {
            this.title = title;
            this.items = items;
        }
    }

    public static class TeamMember {
        public final String role;
        public final String count;
        public final java.awt.Color color;
        public final List<String> responsibilities;

        public TeamMember(String role, String count, java.awt.Color color, List<String> responsibilities) {
            this.role = role;
            this.count = count;
            this.color = color;
            this.responsibilities = responsibilities;
        }
    }
}
