# 🎯 Basic GUI with Threads - Java Project

<div align="center">

![Java](https://img.shields.io/badge/Java-8+-orange.svg)
![Swing](https://img.shields.io/badge/GUI-Swing-blue.svg)
![Threads](https://img.shields.io/badge/Concurrency-Threads-green.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)
![Team](https://img.shields.io/badge/Team-6%20Developers-purple.svg)

*Aplicação Java com interface gráfica demonstrando uso de threads, manipulação de arquivos e animações dinâmicas*

[📋 Relatório](docs/report.pdf) • [🎬 Demo](docs/demo.gif) • [🐛 Bugs](https://github.com/LucasDoAmaral-Prog/Gui-With-Threads/issues) • [✨ Features](https://github.com/LucasDoAmaral-Prog/Gui-With-Threads/issues?q=label%3Aenhancement)

</div>

---

## 📖 Sobre o Projeto

Este projeto desenvolve uma aplicação Java completa com interface gráfica que explora conceitos avançados de programação orientada a objetos, incluindo:

- 🖥️ **Interface Gráfica Moderna** com JFrame e componentes Swing
- 🎨 **Animações Dinâmicas** executadas em threads separadas
- 📁 **Sistema de Arquivos** para leitura e exibição de conteúdo
- 🔧 **Menus Configuráveis** para personalização de padrões e velocidades
- 📖 **Sistema de Ajuda** com diálogos personalizados e documentação rica

### 🏗️ Arquitetura Limpa

O projeto segue princípios de **Clean Architecture** com separação clara de responsabilidades:

```
📁 Presentation Layer    → Interface do usuário e controle de fluxo
📁 Domain Layer         → Regras de negócio e lógica central  
📁 Infrastructure Layer → Acesso a recursos externos (arquivos, threads)
📁 Shared Layer         → Utilitários e componentes reutilizáveis
```

---

## 👥 Equipe de Desenvolvimento

<table>
  <tr>
    <td align="center">
      <img src="https://github.com/usuario1.png" width="80px;"/><br/>
      <sub><b>Interface Menu</b></sub><br/>
      <sub>1 Developer</sub>
    </td>
    <td align="center">
      <img src="https://github.com/usuario2.png" width="80px;"/><br/>
      <sub><b>Background & Animação</b></sub><br/>
      <sub>2 Developers</sub>
    </td>
    <td align="center">
      <img src="https://github.com/usuario3.png" width="80px;"/><br/>
      <sub><b>Lógica de Arquivos</b></sub><br/>
      <sub>2 Developers</sub>
    </td>
    <td align="center">
      <img src="https://github.com/usuario4.png" width="80px;"/><br/>
      <sub><b>Ajuda & Documentação</b></sub><br/>
      <sub>1 Developer</sub>
    </td>
  </tr>
</table>

---

## 🚀 Getting Started

### 📋 Pré-requisitos

```
Java 8 ou superior
IDE (IntelliJ IDEA, Eclipse, VSCode)
Git 2.0+
```

### 🔧 Instalação

1. **Clone o repositório**
   ```
   git clone https://github.com/LucasDoAmaral-Prog/Gui-With-Threads.git
   cd Gui-With-Threads
   ```

2. **Configure sua branch de desenvolvimento**
   ```
   # Para Interface Menu
   git checkout -b feature/interface-menu
   
   # Para Background & Animação  
   git checkout -b feature/background-animation
   
   # Para Lógica de Arquivos
   git checkout -b feature/file-logic
   
   # Para Ajuda & Documentação
   git checkout -b feature/help-documentation
   ```

3. **Estrutura de pastas (auto-criação)**
   ```
   mkdir -p src/main/java/com/basicgui/{presentation/{view,controller,dialog},domain/{model,service,entity},infrastructure/{file,thread,config},shared/{util,constants,exception,listener}}
   mkdir -p src/main/resources/{images,icons,config}
   ```

---

## 🏗️ Divisão de Responsabilidades

<details>
<summary><b>🖥️ Interface Menu (1 Developer)</b></summary>

### 📂 Arquivos de Responsabilidade:
```
src/com/basicgui/presentation/view/
├── MainFrame.java           # JFrame principal
├── MenuBarView.java         # Barra de menus
├── StatusBarView.java       # Barra de status
└── MenuItemFactory.java     # Factory para itens de menu

src/com/basicgui/presentation/controller/
├── MainController.java      # Controlador principal
└── MenuController.java      # Controle de menus

src/com/basicgui/shared/listener/
├── FileMenuListener.java    # Listener menu Arquivo
├── ConfigMenuListener.java  # Listener menu Configuração
└── HelpMenuListener.java    # Listener menu Ajuda
```

### ✅ Tasks:
- [ ] Implementar JFrame principal com layout
- [ ] Criar barra de menus (Arquivo, Configuração, Ajuda)
- [ ] Desenvolver barra de status informativa
- [ ] Implementar ActionListeners para eventos de menu
- [ ] Integrar componentes na interface principal

</details>

<details>
<summary><b>🎨 Background & Animação (2 Developers)</b></summary>

### 📂 Arquivos de Responsabilidade:
```
src/com/basicgui/presentation/view/
├── AnimatedBackgroundPanel.java  # Painel com animação
└── ContentPanelView.java        # Área de conteúdo

src/com/basicgui/infrastructure/thread/
├── AnimationThread.java         # Thread de animação
├── ThreadManager.java           # Gerenciador de threads
└── SafeSwingWorker.java         # Worker thread-safe

src/com/basicgui/domain/service/
├── AnimationService.java        # Lógica de animação
└── BackgroundRenderService.java # Renderização gráfica
```

### ✅ Tasks:
- [ ] Desenvolver painel personalizado com paintComponent()
- [ ] Implementar thread dedicada para animações
- [ ] Criar sistema de gerenciamento de threads
- [ ] Desenvolver lógica de renderização gráfica
- [ ] Implementar controles de velocidade e padrões

</details>

<details>
<summary><b>📁 Lógica de Arquivos (2 Developers)</b></summary>

### 📂 Arquivos de Responsabilidade:
```
src/com/basicgui/infrastructure/file/
├── FileReader.java              # Leitura de arquivos
├── FileValidator.java           # Validação de arquivos
├── FileChooserManager.java      # Gerenciamento JFileChooser
└── TextFileProcessor.java       # Processamento de texto

src/com/basicgui/domain/service/
└── FileService.java             # Serviço de arquivos

src/com/basicgui/presentation/view/
└── FileDisplayPanel.java        # Exibição de conteúdo
```

### ✅ Tasks:
- [ ] Implementar JFileChooser para seleção
- [ ] Desenvolver sistema de leitura segura
- [ ] Criar validação de tipos de arquivo
- [ ] Implementar área de exibição com scroll
- [ ] Desenvolver tratamento de exceções

</details>

<details>
<summary><b>📖 Ajuda & Documentação (1 Developer)</b></summary>

### 📂 Arquivos de Responsabilidade:
```
src/com/basicgui/presentation/dialog/
├── HelpDialog.java              # Diálogo de ajuda
└── AboutDialog.java             # Diálogo sobre

src/main/resources/
├── images/                      # Imagens dos diálogos
└── config/                      # Textos de ajuda

src/com/basicgui/shared/constants/
├── AppConstants.java            # Constantes da aplicação
└── UIConstants.java             # Constantes de interface
```

### ✅ Tasks:
- [ ] Criar diálogo de ajuda com imagens e texto rolável
- [ ] Desenvolver diálogo "Sobre" informativo
- [ ] Organizar recursos visuais e textuais
- [ ] Implementar navegação nos diálogos
- [ ] Criar sistema de constantes centralizadas

</details>

---

## 🔄 Fluxo de Trabalho

### 📋 Metodologia Ágil
- **Scrum**: Sprints de 1 semana
- **Daily Stand-up**: 15min diários
- **Sprint Review**: Demonstrações semanais
- **Retrospectiva**: Melhorias contínuas

### 🔀 Git Workflow
```
# 1. Atualizar main
git checkout main
git pull origin main

# 2. Criar feature branch
git checkout -b feature/sua-funcionalidade

# 3. Desenvolver e committar
git add .
git commit -m "feat: implementar funcionalidade X"

# 4. Push e Pull Request
git push origin feature/sua-funcionalidade
# Criar PR no GitHub
```

### 📝 Padrão de Commits
```
feat: nova funcionalidade
fix: correção de bug  
docs: documentação
refactor: refatoração
test: testes
style: formatação
```

---

## 🏛️ Arquitetura do Sistema

### 📊 Diagrama de Componentes

```
graph TB
    subgraph "Presentation Layer"
        A[MainFrame] --> B[MenuBarView]
        A --> C[ContentPanel]
        A --> D[StatusBar]
        E[Controllers] --> A
    end
    
    subgraph "Domain Layer"
        F[FileService] --> G[AnimationService]
        F --> H[ConfigService]
    end
    
    subgraph "Infrastructure Layer"
        I[FileManager] --> J[ThreadManager]
        I --> K[ConfigManager]
    end
    
    E --> F
    F --> I
```

### 🔄 Fluxo de Comunicação

1. **UI Event** → Controller
2. **Controller** → Domain Service  
3. **Domain Service** → Infrastructure
4. **Infrastructure** → External Resources
5. **Result** ← Back through layers

---

## 📦 Estrutura de Arquivos

<details>
<summary>Ver estrutura completa</summary>

```
src/main/java/com/basicgui/
├── Main.java
├── presentation/
│   ├── view/
│   │   ├── MainFrame.java
│   │   ├── MenuBarView.java
│   │   ├── StatusBarView.java
│   │   ├── ContentPanelView.java
│   │   ├── AnimatedBackgroundPanel.java
│   │   ├── FileDisplayPanel.java
│   │   └── MenuItemFactory.java
│   ├── controller/
│   │   ├── MainController.java
│   │   ├── FileController.java
│   │   ├── ConfigController.java
│   │   ├── AnimationController.java
│   │   └── MenuController.java
│   └── dialog/
│       ├── HelpDialog.java
│       ├── AboutDialog.java
│       ├── PatternConfigDialog.java
│       ├── ColorConfigDialog.java
│       └── SpeedConfigDialog.java
├── domain/
│   ├── model/
│   │   ├── FileContent.java
│   │   ├── AnimationConfig.java
│   │   ├── AppSettings.java
│   │   ├── BackgroundPattern.java
│   │   └── ColorScheme.java
│   ├── service/
│   │   ├── FileService.java
│   │   ├── AnimationService.java
│   │   ├── ConfigurationService.java
│   │   └── BackgroundRenderService.java
│   └── entity/
│       ├── Pattern.java
│       ├── ColorSet.java
│       ├── Speed.java
│       └── Position.java
├── infrastructure/
│   ├── file/
│   │   ├── FileReader.java
│   │   ├── FileValidator.java
│   │   ├── FileChooserManager.java
│   │   └── TextFileProcessor.java
│   ├── thread/
│   │   ├── AnimationThread.java
│   │   ├── BackgroundTaskExecutor.java
│   │   ├── ThreadManager.java
│   │   └── SafeSwingWorker.java
│   └── config/
│       ├── PropertiesManager.java
│       ├── ConfigPersistence.java
│       └── DefaultSettings.java
└── shared/
    ├── util/
    │   ├── SwingUtils.java
    │   ├── ColorUtils.java
    │   ├── ValidationUtils.java
    │   ├── GraphicsUtils.java
    │   └── FileUtils.java
    ├── constants/
    │   ├── AppConstants.java
    │   ├── MenuConstants.java
    │   ├── UIConstants.java
    │   ├── FileConstants.java
    │   └── AnimationConstants.java
    ├── exception/
    │   ├── FileReadException.java
    │   ├── InvalidConfigException.java
    │   ├── AnimationException.java
    │   └── ThreadException.java
    └── listener/
        ├── FileMenuListener.java
        ├── ConfigMenuListener.java
        ├── HelpMenuListener.java
        └── WindowCloseListener.java
```

</details>

---

## 🛠️ Tecnologias Utilizadas

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-4285F4?style=for-the-badge&logo=java&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

</div>

- **Java 8+**: Linguagem principal
- **Swing/AWT**: Framework de interface gráfica  
- **Threads**: Concorrência e paralelismo
- **I/O Streams**: Manipulação de arquivos
- **Git**: Controle de versão
- **GitHub**: Colaboração e CI/CD

---

## 📋 Critérios de Avaliação

| Critério | Peso | Status |
|----------|------|--------|
| Entrega completa | ⭐⭐⭐ | ⏳ |
| Metodologia ágil | ⭐⭐ | ✅ |
| Código em inglês | ⭐⭐ | ✅ |
| Arquitetura limpa | ⭐⭐⭐ | ✅ |
| Qualidade do código | ⭐⭐⭐ | ⏳ |
| Multithreading | ⭐⭐⭐ | ⏳ |
| Elementos gráficos | ⭐⭐ | ⏳ |
| Aspecto geral | ⭐⭐ | ⏳ |

---

## 🤝 Como Contribuir

1. **Fork** o projeto
2. **Crie** sua feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** suas mudanças (`git commit -m 'feat: Add some AmazingFeature'`)
4. **Push** para a branch (`git push origin feature/AmazingFeature`)
5. **Abra** um Pull Request

### 📞 Comunicação da Equipe

- 💬 **Discord/Teams**: Comunicação rápida e daily meetings
- 🐛 **GitHub Issues**: Bugs e solicitações de features  
- 📚 **GitHub Wiki**: Documentação técnica detalhada
- 📧 **Email**: Comunicações formais

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 🎓 Sobre o Curso

**SI400 - Programação Orientada a Objetos II**  
*Linguagem Java - Versão 2025.a*

> Este projeto faz parte do curso de Sistemas de Informação, focando em conceitos avançados de POO, interface gráfica e programação concorrente em Java.

---

<div align="center">

### ⭐ Se este projeto foi útil, considere dar uma estrela!

[🔝 Voltar ao topo](#-basic-gui-with-threads---java-project)

</div>
```

