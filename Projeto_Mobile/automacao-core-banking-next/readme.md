#Overview
Documento criado com o objetivo de facilitar as configurações para execução do projeto.

##  Automação Core Banking Next

## Pré-requisitos
### Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- Git ([instale agora](https://git-scm.com/downloads));
- IntelliJ Community ([instale agora](https://www.jetbrains.com/pt-br/idea/download));
- Java 11 ([JDK 11 instale agora](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html));
- Appium ([instale agora](http://appium.io/downloads.html))

## Configurando o Projeto
### Usando o terminal (git bash), faça:
1. Clone este projeto: git clone linkDoRepositorio
   1. *Dica: Não fazer o clone do projeto em pastas que tenham sincronização como o 'OneDrive'*
2. Entre na pasta do projeto: cd **aautomacao-core-banking-next**
3. Acesse ou crie a branch em que vai trabalhar.

### Antes de abrir o projeto no IntelliJ, faça:
1. Realize o download do arquivo nessa página: Clique [aqui](https://confluence.prebanco.com.br/download/attachments/67288467/gradle.properties?version=2&modificationDate=1640088420000&api=v2)
2. Renomeie o arquivo para **gradle.properties**
3. Abra o diretório do projeto **automacao-core-banking-next** e coloque o arquivo renomeado dentro dele
4. Agora abra o projeto no IntelliJ

### Faça os ajustes abaixo no IntelliJ
1. Em **File -> Project Struture -> Project** selecione a opção **11 java version** no campo **Project SDK** e clique em apply e depois ok
2. Em **File -> Settings -> Build, Execution, Deployment -> Gradle**
   - selecione a opção **Gradle (Default)** no campo **Build and run using**
   - selecione a opção **IntelliJ IDEA** no campo **Run tests using**
   - selecione a opção **wrapper task in Gradle build script** no campo **Use Gradle from**
   - selecione a opção **11 java version** no campo **Gradle JVM**
3. Em **File -> Settings -> Editor -> General -> Auto Import**
    - selecione a opção **Optimize imports on the fly**
4. Em **File -> Settings -> Editor -> Code Style -> Java -> Imports**
    - Adicionar na caixa **Class count to use import with** o valor **999999999**
    - Adicionar na caixa **Names count to use static import with** o valor **999999999**
5. Após ajustar essas opções clique em apply e depois ok
>>>>>>> 6a646970d (Aplicando correções para o handover com a squad seguros)
