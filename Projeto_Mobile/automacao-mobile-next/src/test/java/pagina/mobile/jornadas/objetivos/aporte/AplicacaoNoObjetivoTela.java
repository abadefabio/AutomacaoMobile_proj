package pagina.mobile.jornadas.objetivos.aporte;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AplicacaoNoObjetivoTela extends PaginaBase {

    //titulo da tela
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"APLICAÇÃO NO OBJETIVO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"APLICAÇÃO NO OBJETIVO\"]")
    @AndroidFindBy(accessibility = "APLICAÇÃO NO OBJETIVO")
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"APLICAÇÃO NO OBJETIVO\"]")
    private MobileElement textoTituloTela;

    //texto Confere se ta tudo certo com a aplicacao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Confere se tá tudo certo com a aplicação.")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Confere se tá tudo certo com a aplicação.\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confere se tá tudo certo com a aplicação.\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_sub_title")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Confere se tá tudo certo com a aplicação\")]")
    private MobileElement textoConfereTudo;

    //combo valor aplicado
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@type=\"XCUIElementTypeTextField\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Valor da aplicação\"]/following::XCUIElementTypeTextField")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_amount")
    @AndroidFindBy(xpath = "//*[@class=\"android.widget.EditText\" and @resource-id=\"br.com.bradesco.next:id/et_amount\"]")
    private MobileElement comboValorAplicado;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_terms")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_term_conditions")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"GoalTermsContinueFooterDelegate\"]/XCUIElementTypeButton[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Li e aceito os termos & condiç?es.\"]")
    private MobileElement botaoLerTermosECondicoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_check")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Aceite de Termos')]")
    @iOSXCUITFindBy(accessibility = "Aceite de Termos e Condições, desmarcado")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Aceite de Termos e Condições')]")
    private MobileElement checkBoxLiTermosECondicoes;

    //botao confirmar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_confirm_contribution")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Confirmar\"]")
    private MobileElement botaoConfirmar;

    //botao ver comprovante
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,\" Ver comprovante\")])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@label,\" Ver comprovante\")])[1]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_receipt")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"br.com.bradesco.next:id/bt_receipt\"]")
    private MobileElement botaoVerComprovante;

    //botao fechar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    @AndroidFindBy(accessibility = "Fechar, Botão")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fechar, Botão\"]")
    private MobileElement botaoFechar;

    //texto Valor da aplicacao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_value")
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/ntv_value_title\"]/following::android.widget.TextView)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Valor da aplicação\"]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Data da aplicação\"]/preceding::XCUIElementTypeStaticText)[6]")
    private MobileElement textoValorAplicacao;

    //botao continuar apos preencher o valor da aplicacao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy (id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//*[@class=\"android.widget.Button\" and contains(@text,\"Continuar\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    //texto do valor aplicado apos visualizacao do comprovante e clique no botao voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_contribution_value")
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/ntv_value_title\"]/following::android.widget.TextView)[1]")
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[@name=\"Valor da aplicação\"])[2]/following::XCUIElementTypeStaticText)[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"goal_type_2\"]/following::XCUIElementTypeStaticText)[3]")
    private MobileElement textoValorAplicado;

    public AplicacaoNoObjetivoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Preencer o campo valor da aplicacao no objetivo
     * @param valor
     * @return AplicacaoNoObjetivoTela
     * @throws Exception
     */
    @Step("Preencher o campo \"valor do objetivo\"")
    public AplicacaoNoObjetivoTela preencherValorDoObjetivo(String valor)throws Exception{
        aguardarCarregamentoElemento(comboValorAplicado);
        escreverTexto(comboValorAplicado,valor,"Erro ao preencher o valor do objetivo");
        salvarEvidencia("'Preencher valor do objetivo': "+valor);
        return this;
    }

    /**
     * Validar presença do título 'APLICAÇÃO NO OBJETIVO'
     * @return
     * @throws NextException
     */
    @Step("Validar presença do título 'APLICAÇÃO NO OBJETIVO'")
    public AplicacaoNoObjetivoTela validarPresencaTituloAplicacaoNoObjetivo() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoTituloTela), MetodoComparacaoBooleano.VERDADEIRO, "O título 'APLICAÇÃO NO OBJETIVO', não está na tela");
        salvarEvidencia("Validado título 'APLICAÇÃO NO OBJETIVO' está presente na tela");
        return this;
    }

    /**
     * Tocar no botão 'LER TERMOS E CONDIÇÕES'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'LER TERMOS E CONDIÇÕES'")
    public AplicacaoNoObjetivoTela tocarBotaoLerTermosECondicoes() throws NextException {
        salvarEvidencia("Tocar no botão 'LER TERMOS E CONDIÇÕES'");
        tocarElemento(botaoLerTermosECondicoes, "Não foi possível tocar no botão 'LER TERMOS E CONDIÇÕES'");
        return this;
    }

    /**
     * Tocar no checkbox 'LI TERMOS E CONDIÇÕES'
     * @return
     * @throws NextException
     */
    @Step("Tocar no checkbox 'LI TERMOS E CONDIÇÕES'")
    public AplicacaoNoObjetivoTela tocarCheckBoxLiTermosECondicoes() throws NextException {
        tocarElemento(checkBoxLiTermosECondicoes, "Não foi possível tocar no checkbox 'LI TERMOS E CONDIÇÕES'");
        salvarEvidencia("Tocado no checkbox 'LI TERMOS E CONDIÇÕES'");
        return this;
    }

    /**
     * Tocar no botão 'Confirmar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Confirmar'")
    public AplicacaoNoObjetivoTela tocarBotaoConfirmar() throws NextException {
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        salvarEvidencia("Tocado no botão 'Confirmar'");
        return this;
    }
    /**
     * Tocar no botao continuar apos preencher o valor da aplicacao
     * @return AplicacaoNoObjetivoTela
     * @throws Exception
     */
    @Step("Tocar no botao \"Continuar\"")
    public AplicacaoNoObjetivoTela tocarNoBotaoContinuarAposPreencherValorDaAplicacao()throws Exception{
        validarCondicaoBooleana(verificarPresencaElemento(botaoContinuar), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao tocar no botao continuar");
        tocarElemento(botaoContinuar,"Nao foi possível tocar no botao continuar");
        salvarEvidencia("Tocar no botao continuar");
        return this;
    }

    /**
     * Validar o valor aplicado antes de tocar o botao confirmar
     * @param valor
     * @return AplicacaoNoObjetivoTela
     * @throws Exception
     */
    @Step("Validar \"valor aplicado no objetivo\"")
     public AplicacaoNoObjetivoTela validarValorAplicadoNoObjetivo(String valor)throws Exception{
        aguardarCarregamentoElemento(textoValorAplicacao);
        String formataValor="R$ "+valor;
        validarAtributoTexto(textoValorAplicacao,formataValor,"Atributo texto difere do texto presente no elemento");
        salvarEvidencia("Valor aplicado no objetivo");
        return this;

    }

    /**
     * Tocar no botao confirmar apos validar o valor aplicado no objetivo
     * @return AplicacaoNoObjetivoTela
     * @throws Exception
     */
    @Step("Tocar no botao \"confirmar\"")
    public AplicacaoNoObjetivoTela tocarBotaoConfimarValorAplicadoNoObjetivo()throws Exception{
        tocarElemento(botaoConfirmar,"Erro ao tocar no botao confirmar");
        salvarEvidencia("Tocar no botao confirmar");
        return this;
    }

    /**
     * Tocar no botao ver comprovante
     * @return AplicacaoNoObjetivoTela
     * @throws Exception
     */
    @Step ("Tocar no botao \"ver comprovante\"")
    public AplicacaoNoObjetivoTela tocarBotaoVerComprovanteDaAplicacaoNoObjetivo()throws Exception{
        if(!verificarPresencaElemento(botaoVerComprovante)){
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerComprovante,"Erro ao tocar no botao ver comprovante");
        }
        tocarElemento(botaoVerComprovante,"Erro ao tocar no botao ver comprovante");
        salvarEvidencia("Tocar no botao ver comprovante");
        return this;
    }

    /**
     *Validar titula da tela aplicacao no objetivo ao retornar da tela de comprovante
     * da aplicacao
     * @return AplicacaoNoObjetivoTela
     * @throws Exception
     */
    @Step ("Validar titulo da tela \"aplicacao no objetivo\"")
    public AplicacaoNoObjetivoTela validarTituloDaTelaAplicacaoNoObjetivo() throws Exception{
        validarCondicaoBooleana(verificarPresencaElemento(textoTituloTela),MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar titulo da tela");
        salvarEvidencia("Validar titulo da tela");
        return this;
    }

    /**
     * Validar o valor aplicado no objetivo apos
     * clique no botao ver comprovante
     * clique no botao voltar na tela comprovante
     * @return AplicacaoNoObjetivoTela
     * @throws Exception
     */
    @Step ("Validar valor aplicado no objetivo apos \"clique botao voltar\"")
    public AplicacaoNoObjetivoTela validarValorAplicadoAposCliqueBotaoVoltarTelaComprovante(String valor)throws Exception{

        if(android) rolarTelaParaCimaAosPoucosAteEncontrarElemento(textoValorAplicado, "Valor aplicado não encontrado!");
        if(ios) rolaTelaBaixo();
        validarAtributoTexto(textoValorAplicado, "R$  " + valor,"Valor Aplicado difere do texto presente no elemento");
        salvarEvidencia("Validado a presença do valor aplicado!");
        return this;

    }

    /**
     * Tocar no botão 'Ver comprovante'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Ver comprovante'")
    public AplicacaoNoObjetivoTela tocarBotaoVerComprovante() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerComprovante, "Não foi possível encontrar botão \"Ver Comprovante\"");
        tocarElemento(botaoVerComprovante, "Não foi possível tocar no botão 'Ver comprovante'");
        salvarEvidencia("Tocado no botão 'Ver comprovante'");
        return this;
    }

    /**
     * Tocar no botão 'Fechar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Fechar'")
    public AplicacaoNoObjetivoTela tocarBotaoFechar() throws NextException {
        salvarEvidencia("Tocar no botão 'Fechar'");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar'");
        return this;
    }

    /**
     * Verificar presença e Tocar no botão 'Fechar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Fechar'")
    public AplicacaoNoObjetivoTela verificarEtocarBotaoFechar() throws NextException {
       if (verificarPresencaElemento(botaoFechar)) {
           salvarEvidencia("Tocar no botão 'Fechar'");
           tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar'");
        }
        return this;
    }
}
