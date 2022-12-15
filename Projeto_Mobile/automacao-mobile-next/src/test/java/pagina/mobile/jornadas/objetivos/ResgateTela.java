package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.investimentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class ResgateTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/edit_text_value")
    @AndroidFindBy(id = "br.com.bradesco.next:id/value_withdraw_edit_text")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_qnt")
    @iOSXCUITFindBy(accessibility = "Buscar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Buscar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"R$ 0.00\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    private MobileElement valorResgate;

    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_with_draw")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Resgatar tudo\"`]")
    private MobileElement resgatarTudo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextViewMinimumWithdrawalAmount")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Continuar\"]/preceding-sibling::XCUIElementTypeStaticText)[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"? O resgate m�nimo � de R$ 10,00\"`]")
    private MobileElement resgateMinimo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_value")
    @iOSXCUITFindBy(accessibility = "Continuar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_confirmation_withdraw")
    @iOSXCUITFindBy(accessibility = "Confirmar resgate")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar resgate\"`]")
    private MobileElement botaoConfirmarResgate;

    @AndroidFindBy(id = "br.com.bradesco.next:id/view_goals")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver meus objetivos\"`][2]")
    private MobileElement botaoVerMeusObjetivos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_view_withdraw_goal")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeButton/../XCUIElementTypeButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \" Ver comprovante\"`][2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"Ver comprovante\")]")
    private MobileElement verComprovante;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/view_checked")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[3]/XCUIElementTypeButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private MobileElement checkUsarResgate;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Resgatar\"`]")
    private MobileElement botaoResgatar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_goal_name_value")
    @iOSXCUITFindBy(accessibility = "Confere se t� tudo certo com a aplica��o.")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Confere se t� tudo certo com a aplica��o.\"")
    private MobileElement msgConfereSeTaTudoCertoAplicacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/withdraw_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"R$\")]")
    private MobileElement valorParcialResgate;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Enviar por e-mail\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Compartilhar\"`]")
    @iOSXCUITFindBy(accessibility = "Compartilhar")
    private MobileElement botaoCompartilhar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fechar, Bot�o\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    public ResgateTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar bot�o Fechar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\"")
    public ResgateTela tocarBotaoFechar() throws Exception{
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar bot�o Fechar");
        salvarEvidencia("Tocar bot�o Fechar");
        return this;
    }

    /**
     * Tocar bot�o compartilha
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"compartilhar\"")
    public ResgateTela tocarBotaoCompartilhar() throws Exception{
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel tocar bot�o compartilhar");
        salvarEvidencia("Tocar bot�o compartilhar");
        if (ios) {
            tocarCoordenadaProporcional(25,30);
        }else {
            voltarTelaAnterior();
        }
        return this;
    }
    /**
     * Tocar bot�o Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public ResgateTela tocarVoltar() throws Exception{
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar bot�o voltar");
        salvarEvidencia("Tocar bot�o voltar");
        return this;
    }

    /**
     * Escrever Valor resgate
     *
     * @return
     * @throws Exception
     * @param valor
     */
    @Step("Escrever \"Valor do resgate\"")
    public ResgateTela escrevreValorResgate(String valor) throws Exception{
        
        OperadorEvidencia.logarPasso("Escrever valor do resgate: " + valor);
        if(ios) {
            tocarCoordenadaProporcional(valorResgate, 90, 50);
            apagarCampoTexto(valorResgate, 60, "Erro ao apagar texto do campo 'resgate'");
        }
        escreverTexto(valorResgate, valor, "N�o foi poss�vel escrever valor do resgate");
        salvarEvidencia("Digitou o valor do resgate: " + valor);

        return this;
    }

    /**
     * Tocar em Resgatar tudo
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em \"Resgatar tudo\"")
    public ResgateTela tocarResgatarTudo() throws Exception{
        salvarEvidencia("Tocar em resgatar tudo");
        aguardarCarregamentoElemento(resgatarTudo);
        tocarElemento(resgatarTudo,"N�o foi poss�vel tocar em resgatar tudo");
        return this;
    }

    /**
     * Tocar em Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em \"Continuar\"")
    public ResgateTela tocarContinuar() throws Exception{
        if (ios) esconderTeclado();
        salvarEvidencia("Tocar em continuar");
        tocarElemento(botaoContinuar,"N�o foi poss�vel tocar em continuar");
        return this;
    }

    /**
     * Tocar em Resgatar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em \"Resgatar\"")
    public ResgateTela tocarBotaoResgatar() throws Exception{
        salvarEvidencia("Tocar em Resgatar");
        tocarElemento(botaoResgatar,"N�o foi poss�vel tocar em Resgatar");
        return this;
    }

    /**
     * Tocar em Confirmar resgate
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em \"Confirmar resgate\"")
    public ResgateTela tocarConfirmarResgate() throws Exception{
        aguardarCarregamentoElemento(botaoConfirmarResgate);
        salvarEvidencia("Tocar em confirmar resgate");
        tocarElemento(botaoConfirmarResgate,"N�o foi poss�vel tocar em confirmar resgate");
        return this;
    }

    /**
     * Tocar no bot�o Ver Meus Objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Ver Meus Objetivos\"")
    public ResgateTela tocarBotaoVerMeusObjetivos() throws Exception {
        tocarElemento(botaoVerMeusObjetivos, "N�o foi poss�vel tocar no bot�o Ver Meus Objetivos");
        salvarEvidencia("Tocar no bot�o 'bot�o Ver Meus Objetivos'");
        return this;
    }

    /**
     * Tocar em Ver comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em \"Ver comprovante\"")
    public ResgateTela tocarVerComprovante() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(verComprovante,"N�o foi encontrato o bot�o ver comprovante");
        salvarEvidencia("Tocar em ver comprovante");
        tocarElemento(verComprovante,"N�o foi poss�vel tocar em ver comprovante");
        return this;
    }

    /**
     * Validar presen�a da tela 'Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Comprovante'")
    public ResgateTela validarPresencaTelaComprovante() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.COMPROVANTE.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Comprovante' n�o est� presente na tela!");
        salvarEvidencia("Validadar presen�a da tela comprovante");
        return this;
    }

    /**
     * Tocar checkBox Usar resgate
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar check \"Usar Resgate\"")
    public ResgateTela tocarCheckUsarResgate() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkUsarResgate,"N�o foi possivel tocar check usar resgate.");
        tocarElemento(checkUsarResgate,"N�o foi possivel tocar check usar resgate.");
        salvarEvidencia("Tocar check usar resgate.");
        return this;
    }

    /**
     * validar texto resgate minimo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto \"Resgate Minimo\"")
    public ResgateTela validarResgateMinimo() throws Exception{
        validarCondicaoBooleana(aguardarCarregamentoElemento(resgateMinimo), MetodoComparacaoBooleano.VERDADEIRO, "erro ao validar texto resgate minimo");
        salvarEvidencia("validar texto resgate minimo");
        return this;
    }

    /**
     * validar texto Confere se ta tudo certo com a apliccao
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto \"Confere Se Ta Tudo Certo\"")
    public ResgateTela validarConfereSeTaTudoCerto() throws Exception{
        validarCondicaoBooleana( verificarPresencaElemento(msgConfereSeTaTudoCertoAplicacao), MetodoComparacaoBooleano.VERDADEIRO, "erro ao validar texto Confere Se Ta Tudo Certo");
        salvarEvidencia("validar texto Confere Se Ta Tudo Certo");
        return this;
    }

    /**
     * validar valor parcial do resgate em tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar valor \"Resgate\"")
    public ResgateTela validarValorResgateParcial(String valor) throws Exception{
        compararElementoTexto(valorParcialResgate, valor, MetodoComparacao.CONTEM);
        salvarEvidencia("validar valor resgate.");
        return this;
    }
}
