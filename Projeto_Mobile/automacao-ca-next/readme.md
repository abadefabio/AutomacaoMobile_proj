#Overview
Documento criado com o objetivo de facilitar as configurações para execução do projeto.

## Framework Automação Contingência

1. Instalar o Git ([Git](https://git-scm.com/downloads))
2. Instalar o Intellij ([Intellij](https://www.jetbrains.com/pt-br/idea/download))
3. Instalar o Java 8 ([JDK 1.8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html))
4. Clonar o projeto *automacao-contingencia-next*
    - Escolher o diretório para o projeto e executar o seguinte código no terminal:
        - `git clone linkDoRepositório`
5. Ajustar a SDK
    - Selecionar: Project Structure -> Platform Settings -> Project SDK
    - Selecionar a JDK 1.8
6. Ajustar o gradle para utilização do wrapper
    - Selecionar: Preferences -> Build, Execution, Deployment -> Gradle -> Use Gradle from
    - Selecionar "gradle-wrapper.properties" file
    - Selecionar Project SDK 1.8

## Configurações de variáveis de ambiente

### MacOS
1. Editar o arquivo *.profile* referente a pasta home do usuário
   - Adicionar/Ajustar as seguintes linhas, substituindo o * por valores válidos:
       - export NEXUS_URL="http://*/nexus/content/repositories/capco-corenext-build/"
       - export NEXUS_URL_QA="http://*/nexus/content/repositories/nextqa-releases/"
       - export NEXUS_USER="*"
       - export NEXUS_PASSWORD="*"
       - export NEXUS_PUBLISH_SNAPSHOTS_URL="http://*/nexus/content/repositories/snapshots/"
       - export NEXUS_PUBLISH_RELEASES_URL="http://*/nexus/content/repositories/releases/"
2. Executar no terminal o comando source *.profile*

### Linux
1. Editar o arquivo */etc/profile* referente a pasta home do usuário, para a edição do arquivo deve ser utilizado um super usuário (vide sudo)
    - Adicionar/Ajustar as seguintes linhas, substituindo o * por valores válidos:
        - export NEXUS_URL="http://*/nexus/content/repositories/capco-corenext-build/"
        - export NEXUS_URL_QA="http://*/nexus/content/repositories/nextqa-releases/"
        - export NEXUS_USER="*"
        - export NEXUS_PASSWORD="*"
        - export NEXUS_PUBLISH_SNAPSHOTS_URL="http://*/nexus/content/repositories/snapshots/"
        - export NEXUS_PUBLISH_RELEASES_URL="http://*/nexus/content/repositories/releases/"
2. Reinicie a máquina

### Windows
1. No menu do windows, busque por *"variáveis de ambiente"*
    - Nas variáveis de sistema, selecione o botão novo e adicione as variáveis abaixo, substituindo o * por valores válidos:
        - NEXUS_URL="http://*/nexus/content/repositories/capco-corenext-build/"
        - NEXUS_URL_QA="http://*/nexus/content/repositories/nextqa-releases/"
        - NEXUS_USER="*"
        - NEXUS_PASSWORD="*"
        - NEXUS_PUBLISH_SNAPSHOTS_URL="http://*/nexus/content/repositories/snapshots/"
        - NEXUS_PUBLISH_RELEASES_URL="http://*/nexus/content/repositories/releases/"
2. Reinicie a máquina