package pagina.mobile.jornadas.pix.mais.opcoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AjudaPixTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='AJUDA PIX']")
    private Object textoAjudaPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que � Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que � Pix?')]")
    private MobileElement botaoOQueEPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que � uma chave Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que � uma chave Pix?')]")
    private MobileElement botaoOQueEChavePix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Como funciona o Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como funciona o Pix?')]")
    private MobileElement botaoComoFuncionaPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Quais os Benef�cios do Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Quais os Benef�cios do Pix?')]")
    private MobileElement botaoQuaisBeneficiosDoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Sou obrigado a aderir ao Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sou obrigado a aderir ao Pix?')]")
    private MobileElement botaoSouObrigadoAderirAoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Preciso da chave para usar o Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Preciso da chave para usar o Pix?')]")
    private MobileElement botaoPrecisoDaChaveParaUsarPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que s�o transa��es Pix via QR Code?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que s�o transa��es Pix via QR Code?')]")
    private MobileElement botaoOQueSaoTransacoesPixViaQrCode;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Posso agendar um Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Posso agendar um Pix?')]")
    private MobileElement botaoPossoAgendarUmPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Terei um limite di�rio de valor no Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terei um limite di�rio de valor no Pix?')]")
    private MobileElement botaoTereiUmLimiteDiarioDeValorNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Terei um limite m�ximo para transa��es por dia?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terei um limite m�ximo para transa��es por dia?')]")
    private MobileElement botaoTereiUmLimiteMaximoParaTransacoesPorDia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Posso usar minha grana de emerg�ncia?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Posso usar minha grana de emerg�ncia?')]")
    private MobileElement botaoPossoUsarMinhaGranaDeEmergencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Posso enviar o Pix para qualquer Banco?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Posso enviar o Pix para qualquer Banco?')]")
    private MobileElement botaoPossoEnviarPixParaQualquerBanco;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Como gerar a \"chave aleat�ria\" ?')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como gerar a \"chave aleat�ria\"?')]")
    private MobileElement botaoComoGerarChaveAleatoria;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que � Portabilidade no Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que � Portabilidade no Pix?')]")
    private MobileElement botaoOQueEPortabilidadeNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que � Reivindica��o no Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que � Reivindica��o no Pix?')]")
    private MobileElement botaoOQueEReivindicacaoNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Como contestar um Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como contestar um Pix?')]")
    private MobileElement botaoComoContestarUmPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Como funciona a contesta��o de um Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como funciona a contesta��o de um Pix?')]")
    private MobileElement botaoComoFuncionaContestarUmPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que � Pix Saque e Pix Troco?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que � Pix Saque e Pix Troco?')]")
    private MobileElement botaoOQueEPixSaqueEPixTroco;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Como funciona o Pix Saque?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como funciona o Pix Saque?')]")
    private MobileElement botaoComoFuncionaPixSaque;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Como funciona o Pix Troco?\"]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como funciona o Pix Troco?')]")
    private MobileElement botaoComoFuncionaPixTroco;

    public AjudaPixTela(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public AjudaPixTela metodoValidacaoDePerguntas() throws Exception {
        if (ios) {
                     tocarOQueSaoTransacoesPixViaQrCode()
                    .validarPerguntaOQueSaoTransacoesPixViaQrCode()
                    .tocarOQueSaoTransacoesPixViaQrCode()

                    .tocarPossoAgendarUmPix()
                    .validarPerguntaPossoAgendarUmPix()
                    .tocarPossoAgendarUmPix()

                    .tocarTereiUmLimiteDiarioDeValorNoPix()
                    .validarPerguntaTereiUmLimiteDiarioDeValorNoPix()
                    .tocarTereiUmLimiteDiarioDeValorNoPix()

                    .tocarTereiUmLimiteMaximoParaTransacoesPorDia()
                    .validarPerguntaTereiUmLimiteMaximoParaTransacoesPorDia()
                    .tocarTereiUmLimiteMaximoParaTransacoesPorDia()

                    .tocarPossoUsarMinhaGranaDeEmergencia()
                    .validarPerguntaPossoUsarMinhaGranaDeEmergencia()
                    .tocarPossoUsarMinhaGranaDeEmergencia()

                    .tocarPossoEnviarPixParaQualquerBanco()
                    .validarPerguntaPossoEnviarPixParaQualquerBanco()
                    .tocarPossoEnviarPixParaQualquerBanco()

                    .tocarComoGerarChaveAleatoria()
                    .validarPerguntaComoGerarChaveAleatoria()
                    .tocarComoGerarChaveAleatoria()

                    .tocarOQueEPortabilidadeNoPix()
                    .validarPerguntaOQueEPortabilidadeNoPix()
                    .tocarOQueEPortabilidadeNoPix()

                    .tocarOQueEReivindicacaoNoPix()
                    .validarPerguntaOQueEReivindicacaoNoPix()
                    .tocarOQueEReivindicacaoNoPix()

                    .tocarComoContestarUmPix()
                    .validarPerguntaComoContestarUmPix()
                    .tocarComoContestarUmPix()

                    .tocarComoFuncionaContestacaoDeUmPix()
                    .validarPerguntaComoFuncionaContestacaoDeUmPix()
                    .tocarComoFuncionaContestacaoDeUmPix()

                    .tocarOQueEPixSaqueEPixTroco()
                    .validarPerguntaOQueEPixSaqueEPixTroco()
                    .tocarOQueEPixSaqueEPixTroco()

                    .tocarComoFuncionaPixSaque()
                    .validarPerguntaComoFuncionaPixSaque()
                    .tocarComoFuncionaPixSaque()

                    .tocarComoFuncionaPixTroco()
                    .validarPerguntaComoFuncionaPixTroco()
                    .tocarComoFuncionaPixTroco();

        } else {
                    tocarTereiUmLimiteDiarioDeValorNoPix()
                    .validarPerguntaTereiUmLimiteDiarioDeValorNoPix()
                    .tocarTereiUmLimiteDiarioDeValorNoPix()

                    .tocarOQueSaoTransacoesPixViaQrCode()
                    .validarPerguntaOQueSaoTransacoesPixViaQrCode()
                    .tocarOQueSaoTransacoesPixViaQrCode()

                    .tocarPossoAgendarUmPix()
                    .validarPerguntaPossoAgendarUmPix()
                    .tocarPossoAgendarUmPix()

                    .tocarTereiUmLimiteMaximoParaTransacoesPorDia()
                    .validarPerguntaTereiUmLimiteMaximoParaTransacoesPorDia()
                    .tocarTereiUmLimiteMaximoParaTransacoesPorDia()

                    .tocarPossoUsarMinhaGranaDeEmergencia()
                    .validarPerguntaPossoUsarMinhaGranaDeEmergencia()
                    .tocarPossoUsarMinhaGranaDeEmergencia()

                    .tocarPossoEnviarPixParaQualquerBanco()
                    .validarPerguntaPossoEnviarPixParaQualquerBanco()
                    .tocarPossoEnviarPixParaQualquerBanco()

                    .tocarComoGerarChaveAleatoria()
                    .validarPerguntaComoGerarChaveAleatoria()
                    .tocarComoGerarChaveAleatoria()

                    .tocarOQueEPortabilidadeNoPix()
                    .validarPerguntaOQueEPortabilidadeNoPix()
                    .tocarOQueEPortabilidadeNoPix()

                    .tocarOQueEReivindicacaoNoPix()
                    .validarPerguntaOQueEReivindicacaoNoPix()
                    .tocarOQueEReivindicacaoNoPix()

                    .tocarComoContestarUmPix()
                    .validarPerguntaComoContestarUmPix()
                    .tocarComoContestarUmPix()

                    .tocarComoFuncionaContestacaoDeUmPix()
                    .validarPerguntaComoFuncionaContestacaoDeUmPix()
                    .tocarComoFuncionaContestacaoDeUmPix()

                    .tocarOQueEPixSaqueEPixTroco()
                    .validarPerguntaOQueEPixSaqueEPixTroco()
                    .tocarOQueEPixSaqueEPixTroco()

                    .tocarComoFuncionaPixSaque()
                    .validarPerguntaComoFuncionaPixSaque()
                    .tocarComoFuncionaPixSaque()

                    .tocarComoFuncionaPixTroco()
                    .validarPerguntaComoFuncionaPixTroco()
                    .tocarComoFuncionaPixTroco();
        }
        return this;
    }

    /**
     * Tocar bot�o 'o que � Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'O que � Pix?'")
    public AjudaPixTela tocarBotaoOQueEPix() throws Exception {
        aguardarCarregamentoElemento(botaoOQueEPix);
        salvarEvidencia("Tocar no bot�o 'O que � Pix?'");
        tocarElemento(botaoOQueEPix, "N�o foi poss�vel Tocar no bot�o 'O que � Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'o que � Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'o que � Pix?'")
    public AjudaPixTela validarPerguntaOQueEPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'O que � Pix?'");
        salvarEvidencia("validar pergunta 'O que � Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'o que � uma chave Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'O que � uma chave Pix?'")
    public AjudaPixTela tocarBotaoOQueEChavePix() throws Exception {
        aguardarCarregamentoElemento(botaoOQueEChavePix);
        salvarEvidencia("Tocar no bot�o 'O que � uma chave Pix?'");
        tocarElemento(botaoOQueEChavePix, "N�o foi poss�vel Tocar no bot�o 'O que � uma chave Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'O que � uma chave Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que � uma chave Pix?'")
    public AjudaPixTela validarPerguntaOQueEChavePix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEChavePix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'O que � uma chave Pix?'");
        salvarEvidencia("validar pergunta 'O que � uma chave Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'Como funciona o Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Tocar bot�o 'Como funciona o Pix?'")
    public AjudaPixTela tocarBotaoComoFuncionaPix() throws Exception {
        aguardarCarregamentoElemento(botaoComoFuncionaPix);
        salvarEvidencia("Tocar no bot�o 'Como funciona o Pix?'");
        tocarElemento(botaoComoFuncionaPix, "N�o foi poss�vel Tocar no bot�o 'Como funciona o Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Como funciona o Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona o Pix?'")
    public AjudaPixTela validarPerguntaComoFuncionaPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Como funciona o Pix?'");
        salvarEvidencia("validar pergunta 'Como funciona o Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'Quais os benef�cios do Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Quais os benef�cios do Pix?'")
    public AjudaPixTela tocarQuaisBeneficiosDoPix() throws Exception {
        aguardarCarregamentoElemento(botaoQuaisBeneficiosDoPix);
        salvarEvidencia("Tocar no bot�o 'Quais os benef�cios do Pix?'");
        tocarElemento(botaoQuaisBeneficiosDoPix, "N�o foi poss�vel Tocar no bot�o 'Quais os benef�cios do Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Quais os benef�cios do Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Quais os benef�cios do Pix?'")
    public AjudaPixTela validarPerguntaQuaisBeneficiosDoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoQuaisBeneficiosDoPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Quais os benef�cios do Pix?'");
        salvarEvidencia("validar pergunta 'Quais os benef�cios do Pix?'");
        return this;
    }


    /**
     * Tocar bot�o 'Sou obrigado a aderir ao Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Sou obrigado a aderir ao Pix?'")
    public AjudaPixTela tocarSouObrigadoAderirAoPix() throws Exception {
        aguardarCarregamentoElemento(botaoSouObrigadoAderirAoPix);
        salvarEvidencia("Tocar no bot�o 'Sou obrigado a aderir ao Pix?'");
        tocarElemento(botaoSouObrigadoAderirAoPix, "N�o foi poss�vel Tocar no bot�o 'Sou obrigado a aderir ao Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Sou obrigado a aderir ao Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Sou obrigado a aderir ao Pix?'")
    public AjudaPixTela validarPerguntaSouObrigadoAderirAoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoSouObrigadoAderirAoPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Sou obrigado a aderir ao Pix?'");
        salvarEvidencia("validar pergunta 'Sou obrigado a aderir ao Pix?'");
        return this;
    }


    /**
     * Tocar bot�o 'Preciso da chave para usar o Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Preciso da chave para usar o Pix?'")
    public AjudaPixTela tocarPrecisoDaChaveParaUsarPix() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDaChaveParaUsarPix);
        salvarEvidencia("Tocar no bot�o 'Preciso da chave para usar o Pix?'");
        tocarElemento(botaoPrecisoDaChaveParaUsarPix, "N�o foi poss�vel Tocar no bot�o 'Preciso da chave para usar o Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Preciso da chave para usar o Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Preciso da chave para usar o Pix?'")
    public AjudaPixTela validarPerguntaPrecisoDaChaveParaUsarPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoPrecisoDaChaveParaUsarPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Preciso da chave para usar o Pix?'");
        salvarEvidencia("validar pergunta 'Preciso da chave para usar o Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'O que s�o transa��es Pix via QR code?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'O que s�o transa��es Pix via QR code?'")
    public AjudaPixTela tocarOQueSaoTransacoesPixViaQrCode() throws Exception {
        if (ios) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueSaoTransacoesPixViaQrCode, "N�o foi poss�vel Tocar no bot�o 'O que s�o transa��es Pix via QR code?'");
            aguardarCarregamentoElemento(botaoOQueSaoTransacoesPixViaQrCode);
            salvarEvidencia("Tocar no bot�o 'O que s�o transa��es Pix via QR code?'");
            tocarElemento(botaoOQueSaoTransacoesPixViaQrCode, "N�o foi poss�vel Tocar no bot�o 'O que s�o transa��es Pix via QR code?'");
        } else {
            aguardarCarregamentoElemento(botaoOQueSaoTransacoesPixViaQrCode);
            salvarEvidencia("Tocar no bot�o 'O que s�o transa��es Pix via QR code?'");
            tocarElemento(botaoOQueSaoTransacoesPixViaQrCode, "N�o foi poss�vel Tocar no bot�o 'O que s�o transa��es Pix via QR code?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'O que s�o transa��es Pix via QR code?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que s�o transa��es Pix via QR code?'")
    public AjudaPixTela validarPerguntaOQueSaoTransacoesPixViaQrCode() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueSaoTransacoesPixViaQrCode), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'O que s�o transa��es Pix via QR code?'");
        salvarEvidencia("validar pergunta 'O que s�o transa��es Pix via QR code?'");
        return this;
    }

    /**
     * Tocar bot�o 'Posso agendar um Pix?'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Posso agendar um Pix?'")
    public AjudaPixTela tocarPossoAgendarUmPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPossoAgendarUmPix, "N�o foi poss�vel Tocar no bot�o 'Posso agendar um Pix?'");
        salvarEvidencia("Tocar no bot�o 'Posso agendar um Pix?'");
        tocarElemento(botaoPossoAgendarUmPix, "N�o foi poss�vel Tocar no bot�o 'Posso agendar um Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Posso agendar um Pix?'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar pergunta 'Posso agendar um Pix?'")
    public AjudaPixTela validarPerguntaPossoAgendarUmPix() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(botaoPossoAgendarUmPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Posso agendar um Pix?'");
        salvarEvidencia("validar pergunta 'Posso agendar um Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'Terei um limite di�rio de valor no Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Terei um limite di�rio de valor no Pix?'")
    public AjudaPixTela tocarTereiUmLimiteDiarioDeValorNoPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTereiUmLimiteDiarioDeValorNoPix, "N�o foi poss�vel Tocar no bot�o 'Terei um limite di�rio de valor no Pix?'");
        salvarEvidencia("Tocar no bot�o 'Terei um limite di�rio de valor no Pix?'");
        tocarElemento(botaoTereiUmLimiteDiarioDeValorNoPix, "N�o foi poss�vel Tocar no bot�o 'Terei um limite di�rio de valor no Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Terei um limite di�rio de valor no Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Terei um limite di�rio de valor no Pix?'")
    public AjudaPixTela validarPerguntaTereiUmLimiteDiarioDeValorNoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoTereiUmLimiteDiarioDeValorNoPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Terei um limite di�rio de valor no Pix?'");
        salvarEvidencia("validar pergunta 'Terei um limite di�rio de valor no Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'Terei um limite m�ximo para transa��es por dia?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Terei um limite m�ximo para transa��es por dia?'")
    public AjudaPixTela tocarTereiUmLimiteMaximoParaTransacoesPorDia() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTereiUmLimiteMaximoParaTransacoesPorDia, "N�o foi poss�vel encontrar o bot�o 'Terei um limite m�ximo para transa��es por dia?'");
        salvarEvidencia("Tocar no bot�o 'Terei um limite m�ximo para transa��es por dia?'");
        tocarElemento(botaoTereiUmLimiteMaximoParaTransacoesPorDia, "N�o foi poss�vel Tocar no bot�o 'Terei um limite m�ximo para transa��es por dia?'");
        return this;
    }

    /**
     * Validar pergunta 'Terei um limite m�ximo para transa��es por dia?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Terei um limite m�ximo para transa��es por dia?'")
    public AjudaPixTela validarPerguntaTereiUmLimiteMaximoParaTransacoesPorDia() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoTereiUmLimiteMaximoParaTransacoesPorDia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Terei um limite m�ximo para transa��es por dia?'");
        salvarEvidencia("validar pergunta 'Terei um limite m�ximo para transa��es por dia?'");
        return this;
    }

    /**
     * Tocar bot�o 'Posso usar minha grana de emerg�ncia?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Posso usar minha grana de emerg�ncia?'")
    public AjudaPixTela tocarPossoUsarMinhaGranaDeEmergencia() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoPossoUsarMinhaGranaDeEmergencia);
            salvarEvidencia("Tocar no bot�o 'Posso usar minha grana de emerg�ncia?'");
            tocarElemento(botaoPossoUsarMinhaGranaDeEmergencia, "N�o foi poss�vel Tocar no bot�o 'Posso usar minha grana de emerg�ncia?'");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPossoUsarMinhaGranaDeEmergencia, "N�o foi poss�vel Tocar no bot�o 'Posso usar minha grana de emerg�ncia?'");
            salvarEvidencia("Tocar no bot�o 'Posso usar minha grana de emerg�ncia?'");
            tocarElemento(botaoPossoUsarMinhaGranaDeEmergencia, "N�o foi poss�vel Tocar no bot�o 'Posso usar minha grana de emerg�ncia?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'Posso usar minha grana de emerg�ncia?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Posso usar minha grana de emerg�ncia?'")
    public AjudaPixTela validarPerguntaPossoUsarMinhaGranaDeEmergencia() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoPossoUsarMinhaGranaDeEmergencia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Posso usar minha grana de emerg�ncia?'");
        salvarEvidencia("validar pergunta 'Posso usar minha grana de emerg�ncia?'");
        return this;
    }

    /**
     * Tocar bot�o 'Posso enviar o Pix para qualquer banco?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Posso enviar o Pix para qualquer banco?'")
    public AjudaPixTela tocarPossoEnviarPixParaQualquerBanco() throws Exception {
        aguardarCarregamentoElemento(botaoPossoEnviarPixParaQualquerBanco);
        salvarEvidencia("Tocar no bot�o 'Posso enviar o Pix para qualquer banco?'");
        tocarElemento(botaoPossoEnviarPixParaQualquerBanco, "N�o foi poss�vel Tocar no bot�o 'Posso enviar o Pix para qualquer banco?'");
        return this;
    }

    /**
     * Validar pergunta 'Posso enviar o Pix para qualquer banco?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Posso enviar o Pix para qualquer banco?'")
    public AjudaPixTela validarPerguntaPossoEnviarPixParaQualquerBanco() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoPossoEnviarPixParaQualquerBanco), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Posso enviar o Pix para qualquer banco?'");
        salvarEvidencia("validar pergunta 'Posso enviar o Pix para qualquer banco?'");
        return this;
    }

    /**
     * Tocar bot�o 'Como gerar a chave aleat�ria?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Como gerar a chave aleat�ria?'")
    public AjudaPixTela tocarComoGerarChaveAleatoria() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoGerarChaveAleatoria, "N�o foi poss�vel encontrar o bot�o 'Como gerar a chave aleat�ria?'");
        salvarEvidencia("Tocar no bot�o 'Como gerar a chave aleat�ria?'");
        tocarElemento(botaoComoGerarChaveAleatoria, "N�o foi poss�vel Tocar no bot�o 'Como gerar a chave aleat�ria?'");
        return this;
    }

    /**
     * Validar pergunta 'Como gerar a chave aleat�ria?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como gerar a chave aleat�ria?'")
    public AjudaPixTela validarPerguntaComoGerarChaveAleatoria() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoGerarChaveAleatoria), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Como gerar a chave aleat�ria?'");
        salvarEvidencia("validar pergunta 'Como gerar a chave aleat�ria?'");
        return this;
    }

    /**
     * Tocar bot�o 'O que � Portabilidade no Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'O que � Portabilidade no Pix?'")
    public AjudaPixTela tocarOQueEPortabilidadeNoPix() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoOQueEPortabilidadeNoPix);
            salvarEvidencia("Tocar no bot�o 'O que � Portabilidade no Pix?'");
            tocarElemento(botaoOQueEPortabilidadeNoPix, "N�o foi poss�vel Tocar no bot�o 'O que � Portabilidade no Pix?'");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueEPortabilidadeNoPix, "N�o foi poss�vel Tocar no bot�o 'O que � Portabilidade no Pix?'");
            salvarEvidencia("Tocar no bot�o 'O que � Portabilidade no Pix?'");
            tocarElemento(botaoOQueEPortabilidadeNoPix, "N�o foi poss�vel Tocar no bot�o 'O que � Portabilidade no Pix?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'O que � Portabilidade no Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que � Portabilidade no Pix?'")
    public AjudaPixTela validarPerguntaOQueEPortabilidadeNoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEPortabilidadeNoPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'O que � Portabilidade no Pix?'");
        salvarEvidencia("validar pergunta 'O que � Portabilidade no Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'O que � Reivindica��o no Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'O que � Reivindica��o no Pix?'")
    public AjudaPixTela tocarOQueEReivindicacaoNoPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueEReivindicacaoNoPix, "N�o foi poss�vel Tocar no bot�o 'O que � Reivindica��o no Pix?'");
        salvarEvidencia("Tocar no bot�o 'O que � Reivindica��o no Pix?'");
        tocarElemento(botaoOQueEReivindicacaoNoPix, "N�o foi poss�vel Tocar no bot�o 'O que � Reivindica��o no Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'O que � Reivindica��o no Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que � Reivindica��o no Pix?'")
    public AjudaPixTela validarPerguntaOQueEReivindicacaoNoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEReivindicacaoNoPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'O que � Reivindica��o no Pix?'");
        salvarEvidencia("validar pergunta 'O que � Reivindica��o no Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'Como contestar um Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Como contestar um Pix?'")
    public AjudaPixTela tocarComoContestarUmPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoContestarUmPix, "N�o foi poss�vel tocar no bot�o 'Como contestar um Pix?'");
        salvarEvidencia("Tocar no bot�o 'Como contestar um Pix?'");
        tocarElemento(botaoComoContestarUmPix, "N�o foi poss�vel Tocar no bot�o 'Como contestar um Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Como contestar um Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como contestar um Pix?'")
    public AjudaPixTela validarPerguntaComoContestarUmPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoContestarUmPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Como contestar um Pix?'");
        salvarEvidencia("validar pergunta 'Como contestar um Pix?'");
        return this;
    }

    /**
     * Tocar bot�o 'Como funciona a contesta��o de um Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Como funciona a contesta��o de um Pix?'")
    public AjudaPixTela tocarComoFuncionaContestacaoDeUmPix() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoComoFuncionaContestarUmPix);
            salvarEvidencia("Tocar no bot�o 'Como funciona a contesta��o de um Pix?'");
            tocarElemento(botaoComoFuncionaContestarUmPix, "N�o foi poss�vel Tocar no bot�o 'Como funciona a contesta��o de um Pix?'");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoFuncionaContestarUmPix, "N�o foi poss�vel Tocar no bot�o 'Como funciona a contesta��o de um Pix?'");
            salvarEvidencia("Tocar no bot�o 'Como funciona a contesta��o de um Pix?'");
            tocarElemento(botaoComoFuncionaContestarUmPix, "N�o foi poss�vel Tocar no bot�o 'Como funciona a contesta��o de um Pix?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'Como funciona a contesta��o de um Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona a contesta��o de um Pix?'")
    public AjudaPixTela validarPerguntaComoFuncionaContestacaoDeUmPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaContestarUmPix), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Como funciona a contesta��o de um Pix?'");
        salvarEvidencia("validar pergunta 'Como funciona a contesta��o de um Pix?'");
        return this;
    }


    /**
     * Tocar bot�o 'O que � Pix Saque e Pix Troco?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'O que � Pix Saque e Pix Troco?'")
    public AjudaPixTela tocarOQueEPixSaqueEPixTroco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueEPixSaqueEPixTroco, "N�o foi poss�vel encontrar o bot�o 'O que � Pix Saque e Pix Troco?'");
        salvarEvidencia("Tocar no bot�o 'O que � Pix Saque e Pix Troco?'");
        tocarElemento(botaoOQueEPixSaqueEPixTroco, "N�o foi poss�vel Tocar no bot�o 'O que � Pix Saque e Pix Troco?'");
        return this;
    }

    /**
     * Validar pergunta 'O que � Pix Saque e Pix Troco?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que � Pix Saque e Pix Troco?'")
    public AjudaPixTela validarPerguntaOQueEPixSaqueEPixTroco() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEPixSaqueEPixTroco), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'O que � Pix Saque e Pix Troco?'");
        salvarEvidencia("validar pergunta 'O que � Pix Saque e Pix Troco?'");
        return this;
    }

    /**
     * Tocar bot�o 'Como funciona o Pix Saque?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Como funciona o Pix Saque?'")
    public AjudaPixTela tocarComoFuncionaPixSaque() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoFuncionaPixSaque, "N�o foi poss�vel encontrar o bot�o 'Como funciona o Pix Saque?'");
        salvarEvidencia("Tocar no bot�o 'Como funciona o Pix Saque?'");
        tocarElemento(botaoComoFuncionaPixSaque, "N�o foi poss�vel Tocar no bot�o 'Como funciona o Pix Saque?'");
        return this;
    }

    /**
     * Validar pergunta 'Como funciona o Pix Saque?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona o Pix Saque?'")
    public AjudaPixTela validarPerguntaComoFuncionaPixSaque() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaPixSaque), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Como funciona o Pix Saque?'");
        salvarEvidencia("validar pergunta 'Como funciona o Pix Saque?'");
        return this;
    }

    /**
     * Tocar bot�o 'Como funciona o Pix Troco?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Como funciona o Pix Troco?'")
    public AjudaPixTela tocarComoFuncionaPixTroco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoFuncionaPixTroco, "N�o foi poss�vel encontrar o bot�o 'Como funciona o Pix Troco?");
        salvarEvidencia("Tocar no bot�o 'Como funciona o Pix Troco?'");
        tocarElemento(botaoComoFuncionaPixTroco, "N�o foi poss�vel Tocar no bot�o 'Como funciona o Pix Troco?'");
        return this;
    }

    /**
     * Validar pergunta 'Como funciona o Pix Troco?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona o Pix Troco?'")
    public AjudaPixTela validarPerguntaComoFuncionaPixTroco() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaPixSaque), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar pergunta 'Como funciona o Pix Troco?'");
        salvarEvidencia("validar pergunta 'Como funciona o Pix Troco?'");
        return this;
    }
}
