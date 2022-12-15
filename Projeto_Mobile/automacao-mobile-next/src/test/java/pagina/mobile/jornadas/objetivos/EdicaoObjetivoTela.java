package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.reformatarValorMonetario;

public class EdicaoObjetivoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_edit")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Editar\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Editar\"])[1]")
    private MobileElement botaoEditar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_remove")
    @iOSXCUITFindBy(accessibility = "Remover")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Remover\"`]")
    private MobileElement botaoExcluir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Buscar\"])[1]")
    private MobileElement nome;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_target_amount")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Buscar\"])[2]")
    private MobileElement metaObjetivo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_month")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'prazo']/../XCUIElementTypePicker[3]/XCUIElementTypePickerWheel")
    private MobileElement prazoMes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_year")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'prazo']/../XCUIElementTypePicker[4]/XCUIElementTypePickerWheel")
    private MobileElement prazoAno;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_goal_suggestion")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PARCELAS MENSAIS\"]/../XCUIElementTypeTextField")
    private MobileElement parcelasMensais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_date_confirm")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Todo dia\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Todo dia\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dia da aplica��o\"]/../XCUIElementTypeButton")
    private MobileElement diaAplicacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/container_date")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_date_confirm")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Todo dia\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Todo dia\")]")
    private MobileElement selecionaDia;

    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement confirmarDiaAplicacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_done")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Concluir\"`]")
    private MobileElement botaoConcluir;

    @AndroidFindBy(xpath = "//*[contains(@text,\"OBJETIVOS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OBJETIVOS\"]")
    private MobileElement textoObjetivo;

    @AndroidFindBy(xpath = "//*[contains(@text,\"EDI��O DO OBJETIVO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"EDI��O DO OBJETIVO\"]")
    private MobileElement textoEdicaoObjetivo;

    @AndroidFindBy(id ="br.com.bradesco.next:id/btn_save")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Salvar\"]")
    private MobileElement botaoSalvar;

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypePicker[1]/XCUIElementTypePickerWheel")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeCell[3]/XCUIElementTypePicker[1]/XCUIElementTypePickerWheel")
    private MobileElement prazoMesTelaPrincipal;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_date_confirm")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Todo dia 5\"`]")
    private MobileElement selecionaDia5;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tudo certo! Suas altera��es foram salvas.\"]")
    @iOSXCUITFindBy(accessibility = "Tudo certo! Suas altera��es foram salvas.")
    private MobileElement mensagemSucesso;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Aporte\"]")
    private MobileElement botaoAporte;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuarIosTeclado;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Parcela mensal e prazo sugeridos\"]")
    private MobileElement labelParcelaMensalEPrazoSugeridos;

    public EdicaoObjetivoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar bot�o editar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Editar\"")
    public EdicaoObjetivoTela tocarEditar() throws Exception {
        aguardarCarregamentoElemento(botaoEditar);
        tocarElemento(botaoEditar, "N�o foi poss�vel tocar bot�o editar");
        salvarEvidencia("Tocar bot�o editar");
        return this;
    }
    /**
     * Validar tela edi��o objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Edi��o objetivo\"")
    public EdicaoObjetivoTela validarTelaEdicaoObjetivo() throws Exception{
        verificarPresencaElemento(textoEdicaoObjetivo);
        salvarEvidencia("Validar texto edi��o do objetivo");
        return this;
    }

    /**
     * Tocar bot�o voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public EdicaoObjetivoTela tocarVoltar() throws Exception {
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar bot�o voltar");
        salvarEvidencia("Tocar bot�o voltar");
        return this;
    }

    /**
     * Tocar bot�o excluir
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Excluir\"")
    public EdicaoObjetivoTela tocarExcluir() throws Exception {
        tocarElemento(botaoExcluir,"N�o foi poss�vel tocar bot�o excluir");
        salvarEvidencia("Tocar bot�o excluir");
        return this;
    }

    /**
     * Apagar nome
     *
     * @return
     * @throws Exception
     */
    @Step("Apagar \"Nome\"")
    public EdicaoObjetivoTela apagarNome() throws Exception {
        apagarCampoTexto(nome,"N�o foi poss�vel apagar nome");
        salvarEvidencia("Apagar nome");
        return this;
    }

    /**
     * Alterar nome
     *
     * @return
     * @throws Exception
     * @param novoNome
     */
    @Step("Altera \"Nome\"")
    public EdicaoObjetivoTela alterarNome(String novoNome) throws Exception {
        OperadorEvidencia.logarPasso("Digitando o Nome: " + novoNome);
        escreverTexto(nome, novoNome + (ios?"\uE007":""),"N�o foi poss�vel alterar nome");
        salvarEvidencia("Digitou o nome: " + nome.getText());
        return this;
    }

    /**
     * Alterar meta
     *
     * @return
     * @throws Exception
     * @param meta
     */
    @Step("Alterar \"Meta\"")
    public EdicaoObjetivoTela alteraMeta(String meta) throws Exception {
        OperadorEvidencia.logarPasso("Digitando a Meta: R$ " + reformatarValorMonetario(meta));
        if (ios){
            apagarCampoTexto(metaObjetivo,60,"N�o foi poss�vel apagar a meta");
            tocarCoordenadaProporcional(metaObjetivo,90,50);
            escreverTexto(metaObjetivo, "9" + "\uE003".repeat(60) + meta + "\uE007", "N�o foi poss�vel alterar a meta");
            salvarEvidencia("Alterou a meta para o Valor: " + metaObjetivo.getText());
        }
        else {
            escreverTexto(metaObjetivo, meta, "N�o foi poss�vel alterar a meta");
            salvarEvidencia("Tocar em meta");
        }
        return this;
    }

    /**
     * Alterar m�s
     *
     * @return
     * @throws Exception
     */
    @Step("Alterar \"Prazo\"")
    public EdicaoObjetivoTela deslizarPrazoMes() throws Exception{
        esconderTeclado();
        tocarBotaoContinuarIosTeclado();
        deslizar(prazoMes, Direcao.DIREITA, 30,80);
        salvarEvidencia("Tocar em prazo m�s");
        return this;
    }

    /**
     * Alterar ano
     *
     * @return
     * @throws Exception
     */
    @Step("Alterar \"Prazo Ano\"")
    public EdicaoObjetivoTela deslizarPrazoAno() throws Exception{
        esconderTeclado();
        tocarBotaoContinuarIosTeclado();
        deslizar(prazoAno, Direcao.DIREITA, 30,80);
        salvarEvidencia("Tocar em prazo ano");
        return this;
    }

    /**
     * Alterar Parcelas Mensais
     *
     * @return
     * @throws Exception
     * @param parcela
     */
    @Step("Alterar \"Parcelas Mensais\"")
    public EdicaoObjetivoTela alterarParcelasMensais(String parcela) throws Exception{
        OperadorEvidencia.logarPasso("Digitando o valor R$ " + reformatarValorMonetario(parcela));
        if(ios){
            esconderTeclado();
            arrastarElementoProporcional(labelParcelaMensalEPrazoSugeridos,50,10);
            apagarCampoTexto(parcelasMensais,60,"N�o foi poss�vel apagar a meta");
            esconderTeclado();
            tocarCoordenadaProporcional(parcelasMensais,90,50);
            parcelasMensais.sendKeys("9" + "\uE003".repeat(60) + parcela);
        }
        else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(parcelasMensais,"Erro ao rolar at� o Parcelas");
            escreverTexto(parcelasMensais, parcela, "N�o foi poss�vel alterar a parcela mensal");
        }
        salvarEvidencia("Valor digitado no campo das Parcelas mensais: " + parcelasMensais.getText());
        return this;
    }
    /**
     * Tocar Dia da Aplica��o
     *
     * @return
     * @throws Exception
      */
    @Step("Tocar \"Dia da aplica��o\"")
    public EdicaoObjetivoTela tocarDiaAplicacao() throws Exception{
        tocarElemento(diaAplicacao, "N�o foi poss�vel tocar no dia da aplica��o");
        salvarEvidencia("Tocar no dia da aplicacao");
        return this;
    }

    /**
     * Alterar Dia da Aplica��o
     *
     * @return
     * @throws Exception
     */
    @Step("Alterar \"Dia da aplica��o\"")
    public EdicaoObjetivoTela alterarDiaAplicacao() throws Exception{
        if (getDriver() instanceof IOSDriver){
            tocarElemento(selecionaDia,"N�o foi poss�vel selecionar o dia");
            tocarElemento(confirmarDiaAplicacao,"N�o foi poss�vel confirmar dia da aplica��o");
            salvarEvidencia("Alterar dia da aplica��o");
        }
        else {
            tocarElemento(selecionaDia, "N�o foi poss�vel selecionar o dia");
            salvarEvidencia("Alterar dia da aplica��o");
        }
        return this;
    }

    /**
     * Tocar no bot�o confirmar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no \"Bot�o Confirmar\"")
    public EdicaoObjetivoTela tocarBotaoConcluir() throws Exception{
        tocarElemento(botaoConcluir, "N�o foi poss�vel tocar no bot�o confirmar");
        salvarEvidencia("Tocar no bot�o confirmar");
        return this;
    }

    /**
     * Validar estar na tela objetivo
     *
     * @throws Exception
     */
    @Step("Validar estar na tela objetivos")
    public EdicaoObjetivoTela validarTextoObjetivo()throws Exception{
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar no bot�o voltar");
        verificarPresencaElemento(textoObjetivo);
        salvarEvidencia("Validar estar na tela objetivos");
        return this;
    }


    /**Tocar bot�o salvar da edi��o
     * @return
     * @throws Exception
     */
    public EdicaoObjetivoTela tocarBotaoSalvar(String texto)throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSalvar, "N�o foi poss�vel encontrar o bot�o \"Salvar\"");
        salvarEvidencia("Tocar botao Salvar");
        tocarElemento(botaoSalvar,"N�o foi poss�vel tocar no bot�o Salvar");
        //Esta valida��o est� neste passo do teste porque � muito r�pido a apresenta��o da mensagem de suceso.
        if (ios){
            Boolean validou = false;
            if(aguardarPaginaConterTodosTextos(texto))
                validou = true;
            if(aguardarCarregamentoElemento(mensagemSucesso))
                validou = true;
            validarCondicaoBooleana(validou, MetodoComparacaoBooleano.VERDADEIRO,"N�o foi possivel verificar a mensagem");
            salvarEvidencia("Validar mensagem sucesso");
        }
        verificarPresencaElemento(textoObjetivo);
        return this;
    }

    /**
     * @return
     * @throws Exception
     */
    public EdicaoObjetivoTela encontrarDetalhesCardObjetivo() throws Exception {
        aguardarCarregamentoElemento(botaoAporte);
        rolaTelaBaixo();
        salvarEvidencia("Rolar tela ate achar o botao editar");
        return this;
    }

    /**
     * Deslizar o M�s para a Direita (Selecionar outro M�s)
     *
     * @return
     * @throws Exception
     */
    @Step("Deslizar o M�s para a Direita (Selecionar outro M�s)")
    public EdicaoObjetivoTela deslizarDireitaMes() throws Exception {
        if(ios)
            arrastarElemento(prazoMesTelaPrincipal,2000, 100, Direcao.DIREITA);
        else
            arrastarElemento(prazoMes,5000, 400, Direcao.DIREITA);
        salvarEvidencia("Alterar M�s objetivo");
        return this;
    }

    /**
     * Deslizar o M�s para a Esquerda (Selecionar outro M�s)
     *
     * @return
     * @throws Exception
     */
    @Step("Deslizar o M�s para a Esquerda (Selecionar outro M�s)")
    public EdicaoObjetivoTela deslizarEsquerdaMes() throws Exception {
        if(ios)
            arrastarElemento(prazoMesTelaPrincipal,2000, 100, Direcao.ESQUERDA);
        else
            arrastarElemento(prazoMes,5000, 400, Direcao.ESQUERDA);
        salvarEvidencia("Alterar M�s objetivo");
        return this;
    }

    /** Tocar bot�o Todo dia dd
     * @return
     * @throws Exception
     */
    public EdicaoObjetivoTela alterarDataDia() throws Exception {
        rolarTelaAteFinal(1);
        tocarElemento(selecionaDia,"Nao foi possivel tocar no botao 'Todo dia [dd]'");
        salvarEvidencia("Tocar em 'Todo dia [dd]'");
        return this;
    }

    private void tocarBotaoContinuarIosTeclado() throws NextException {
        if(verificarPresencaElemento(botaoContinuarIosTeclado)) tocarElemento(botaoContinuarIosTeclado,"Erro ao tentar tocar no 'Continuar' do Teclado iOS");
    }

}
