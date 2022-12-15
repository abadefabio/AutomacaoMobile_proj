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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que é Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que é Pix?')]")
    private MobileElement botaoOQueEPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que é uma chave Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que é uma chave Pix?')]")
    private MobileElement botaoOQueEChavePix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Como funciona o Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como funciona o Pix?')]")
    private MobileElement botaoComoFuncionaPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Quais os Benefícios do Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Quais os Benefícios do Pix?')]")
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que são transações Pix via QR Code?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que são transações Pix via QR Code?')]")
    private MobileElement botaoOQueSaoTransacoesPixViaQrCode;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Posso agendar um Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Posso agendar um Pix?')]")
    private MobileElement botaoPossoAgendarUmPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Terei um limite diário de valor no Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terei um limite diário de valor no Pix?')]")
    private MobileElement botaoTereiUmLimiteDiarioDeValorNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Terei um limite máximo para transações por dia?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terei um limite máximo para transações por dia?')]")
    private MobileElement botaoTereiUmLimiteMaximoParaTransacoesPorDia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Posso usar minha grana de emergência?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Posso usar minha grana de emergência?')]")
    private MobileElement botaoPossoUsarMinhaGranaDeEmergencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Posso enviar o Pix para qualquer Banco?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Posso enviar o Pix para qualquer Banco?')]")
    private MobileElement botaoPossoEnviarPixParaQualquerBanco;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Como gerar a \"chave aleatória\" ?')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como gerar a \"chave aleatória\"?')]")
    private MobileElement botaoComoGerarChaveAleatoria;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que é Portabilidade no Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que é Portabilidade no Pix?')]")
    private MobileElement botaoOQueEPortabilidadeNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que é Reivindicação no Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que é Reivindicação no Pix?')]")
    private MobileElement botaoOQueEReivindicacaoNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Como contestar um Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como contestar um Pix?')]")
    private MobileElement botaoComoContestarUmPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Como funciona a contestação de um Pix?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Como funciona a contestação de um Pix?')]")
    private MobileElement botaoComoFuncionaContestarUmPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='O que é Pix Saque e Pix Troco?']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'O que é Pix Saque e Pix Troco?')]")
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
     * Tocar botão 'o que é Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'O que é Pix?'")
    public AjudaPixTela tocarBotaoOQueEPix() throws Exception {
        aguardarCarregamentoElemento(botaoOQueEPix);
        salvarEvidencia("Tocar no botão 'O que é Pix?'");
        tocarElemento(botaoOQueEPix, "Não foi possível Tocar no botão 'O que é Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'o que é Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'o que é Pix?'")
    public AjudaPixTela validarPerguntaOQueEPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'O que é Pix?'");
        salvarEvidencia("validar pergunta 'O que é Pix?'");
        return this;
    }

    /**
     * Tocar botão 'o que é uma chave Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'O que é uma chave Pix?'")
    public AjudaPixTela tocarBotaoOQueEChavePix() throws Exception {
        aguardarCarregamentoElemento(botaoOQueEChavePix);
        salvarEvidencia("Tocar no botão 'O que é uma chave Pix?'");
        tocarElemento(botaoOQueEChavePix, "Não foi possível Tocar no botão 'O que é uma chave Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'O que é uma chave Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que é uma chave Pix?'")
    public AjudaPixTela validarPerguntaOQueEChavePix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEChavePix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'O que é uma chave Pix?'");
        salvarEvidencia("validar pergunta 'O que é uma chave Pix?'");
        return this;
    }

    /**
     * Tocar botão 'Como funciona o Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Tocar botão 'Como funciona o Pix?'")
    public AjudaPixTela tocarBotaoComoFuncionaPix() throws Exception {
        aguardarCarregamentoElemento(botaoComoFuncionaPix);
        salvarEvidencia("Tocar no botão 'Como funciona o Pix?'");
        tocarElemento(botaoComoFuncionaPix, "Não foi possível Tocar no botão 'Como funciona o Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Como funciona o Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona o Pix?'")
    public AjudaPixTela validarPerguntaComoFuncionaPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Como funciona o Pix?'");
        salvarEvidencia("validar pergunta 'Como funciona o Pix?'");
        return this;
    }

    /**
     * Tocar botão 'Quais os benefícios do Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Quais os benefícios do Pix?'")
    public AjudaPixTela tocarQuaisBeneficiosDoPix() throws Exception {
        aguardarCarregamentoElemento(botaoQuaisBeneficiosDoPix);
        salvarEvidencia("Tocar no botão 'Quais os benefícios do Pix?'");
        tocarElemento(botaoQuaisBeneficiosDoPix, "Não foi possível Tocar no botão 'Quais os benefícios do Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Quais os benefícios do Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Quais os benefícios do Pix?'")
    public AjudaPixTela validarPerguntaQuaisBeneficiosDoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoQuaisBeneficiosDoPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Quais os benefícios do Pix?'");
        salvarEvidencia("validar pergunta 'Quais os benefícios do Pix?'");
        return this;
    }


    /**
     * Tocar botão 'Sou obrigado a aderir ao Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Sou obrigado a aderir ao Pix?'")
    public AjudaPixTela tocarSouObrigadoAderirAoPix() throws Exception {
        aguardarCarregamentoElemento(botaoSouObrigadoAderirAoPix);
        salvarEvidencia("Tocar no botão 'Sou obrigado a aderir ao Pix?'");
        tocarElemento(botaoSouObrigadoAderirAoPix, "Não foi possível Tocar no botão 'Sou obrigado a aderir ao Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Sou obrigado a aderir ao Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Sou obrigado a aderir ao Pix?'")
    public AjudaPixTela validarPerguntaSouObrigadoAderirAoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoSouObrigadoAderirAoPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Sou obrigado a aderir ao Pix?'");
        salvarEvidencia("validar pergunta 'Sou obrigado a aderir ao Pix?'");
        return this;
    }


    /**
     * Tocar botão 'Preciso da chave para usar o Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Preciso da chave para usar o Pix?'")
    public AjudaPixTela tocarPrecisoDaChaveParaUsarPix() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDaChaveParaUsarPix);
        salvarEvidencia("Tocar no botão 'Preciso da chave para usar o Pix?'");
        tocarElemento(botaoPrecisoDaChaveParaUsarPix, "Não foi possível Tocar no botão 'Preciso da chave para usar o Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Preciso da chave para usar o Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Preciso da chave para usar o Pix?'")
    public AjudaPixTela validarPerguntaPrecisoDaChaveParaUsarPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoPrecisoDaChaveParaUsarPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Preciso da chave para usar o Pix?'");
        salvarEvidencia("validar pergunta 'Preciso da chave para usar o Pix?'");
        return this;
    }

    /**
     * Tocar botão 'O que são transações Pix via QR code?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'O que são transações Pix via QR code?'")
    public AjudaPixTela tocarOQueSaoTransacoesPixViaQrCode() throws Exception {
        if (ios) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueSaoTransacoesPixViaQrCode, "Não foi possível Tocar no botão 'O que são transações Pix via QR code?'");
            aguardarCarregamentoElemento(botaoOQueSaoTransacoesPixViaQrCode);
            salvarEvidencia("Tocar no botão 'O que são transações Pix via QR code?'");
            tocarElemento(botaoOQueSaoTransacoesPixViaQrCode, "Não foi possível Tocar no botão 'O que são transações Pix via QR code?'");
        } else {
            aguardarCarregamentoElemento(botaoOQueSaoTransacoesPixViaQrCode);
            salvarEvidencia("Tocar no botão 'O que são transações Pix via QR code?'");
            tocarElemento(botaoOQueSaoTransacoesPixViaQrCode, "Não foi possível Tocar no botão 'O que são transações Pix via QR code?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'O que são transações Pix via QR code?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que são transações Pix via QR code?'")
    public AjudaPixTela validarPerguntaOQueSaoTransacoesPixViaQrCode() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueSaoTransacoesPixViaQrCode), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'O que são transações Pix via QR code?'");
        salvarEvidencia("validar pergunta 'O que são transações Pix via QR code?'");
        return this;
    }

    /**
     * Tocar botão 'Posso agendar um Pix?'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Posso agendar um Pix?'")
    public AjudaPixTela tocarPossoAgendarUmPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPossoAgendarUmPix, "Não foi possível Tocar no botão 'Posso agendar um Pix?'");
        salvarEvidencia("Tocar no botão 'Posso agendar um Pix?'");
        tocarElemento(botaoPossoAgendarUmPix, "Não foi possível Tocar no botão 'Posso agendar um Pix?'");
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
        validarCondicaoBooleana(verificarPresencaElemento(botaoPossoAgendarUmPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Posso agendar um Pix?'");
        salvarEvidencia("validar pergunta 'Posso agendar um Pix?'");
        return this;
    }

    /**
     * Tocar botão 'Terei um limite diário de valor no Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Terei um limite diário de valor no Pix?'")
    public AjudaPixTela tocarTereiUmLimiteDiarioDeValorNoPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTereiUmLimiteDiarioDeValorNoPix, "Não foi possível Tocar no botão 'Terei um limite diário de valor no Pix?'");
        salvarEvidencia("Tocar no botão 'Terei um limite diário de valor no Pix?'");
        tocarElemento(botaoTereiUmLimiteDiarioDeValorNoPix, "Não foi possível Tocar no botão 'Terei um limite diário de valor no Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Terei um limite diário de valor no Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Terei um limite diário de valor no Pix?'")
    public AjudaPixTela validarPerguntaTereiUmLimiteDiarioDeValorNoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoTereiUmLimiteDiarioDeValorNoPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Terei um limite diário de valor no Pix?'");
        salvarEvidencia("validar pergunta 'Terei um limite diário de valor no Pix?'");
        return this;
    }

    /**
     * Tocar botão 'Terei um limite máximo para transações por dia?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Terei um limite máximo para transações por dia?'")
    public AjudaPixTela tocarTereiUmLimiteMaximoParaTransacoesPorDia() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTereiUmLimiteMaximoParaTransacoesPorDia, "Não foi possível encontrar o botão 'Terei um limite máximo para transações por dia?'");
        salvarEvidencia("Tocar no botão 'Terei um limite máximo para transações por dia?'");
        tocarElemento(botaoTereiUmLimiteMaximoParaTransacoesPorDia, "Não foi possível Tocar no botão 'Terei um limite máximo para transações por dia?'");
        return this;
    }

    /**
     * Validar pergunta 'Terei um limite máximo para transações por dia?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Terei um limite máximo para transações por dia?'")
    public AjudaPixTela validarPerguntaTereiUmLimiteMaximoParaTransacoesPorDia() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoTereiUmLimiteMaximoParaTransacoesPorDia), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Terei um limite máximo para transações por dia?'");
        salvarEvidencia("validar pergunta 'Terei um limite máximo para transações por dia?'");
        return this;
    }

    /**
     * Tocar botão 'Posso usar minha grana de emergência?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Posso usar minha grana de emergência?'")
    public AjudaPixTela tocarPossoUsarMinhaGranaDeEmergencia() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoPossoUsarMinhaGranaDeEmergencia);
            salvarEvidencia("Tocar no botão 'Posso usar minha grana de emergência?'");
            tocarElemento(botaoPossoUsarMinhaGranaDeEmergencia, "Não foi possível Tocar no botão 'Posso usar minha grana de emergência?'");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPossoUsarMinhaGranaDeEmergencia, "Não foi possível Tocar no botão 'Posso usar minha grana de emergência?'");
            salvarEvidencia("Tocar no botão 'Posso usar minha grana de emergência?'");
            tocarElemento(botaoPossoUsarMinhaGranaDeEmergencia, "Não foi possível Tocar no botão 'Posso usar minha grana de emergência?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'Posso usar minha grana de emergência?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Posso usar minha grana de emergência?'")
    public AjudaPixTela validarPerguntaPossoUsarMinhaGranaDeEmergencia() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoPossoUsarMinhaGranaDeEmergencia), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Posso usar minha grana de emergência?'");
        salvarEvidencia("validar pergunta 'Posso usar minha grana de emergência?'");
        return this;
    }

    /**
     * Tocar botão 'Posso enviar o Pix para qualquer banco?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Posso enviar o Pix para qualquer banco?'")
    public AjudaPixTela tocarPossoEnviarPixParaQualquerBanco() throws Exception {
        aguardarCarregamentoElemento(botaoPossoEnviarPixParaQualquerBanco);
        salvarEvidencia("Tocar no botão 'Posso enviar o Pix para qualquer banco?'");
        tocarElemento(botaoPossoEnviarPixParaQualquerBanco, "Não foi possível Tocar no botão 'Posso enviar o Pix para qualquer banco?'");
        return this;
    }

    /**
     * Validar pergunta 'Posso enviar o Pix para qualquer banco?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Posso enviar o Pix para qualquer banco?'")
    public AjudaPixTela validarPerguntaPossoEnviarPixParaQualquerBanco() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoPossoEnviarPixParaQualquerBanco), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Posso enviar o Pix para qualquer banco?'");
        salvarEvidencia("validar pergunta 'Posso enviar o Pix para qualquer banco?'");
        return this;
    }

    /**
     * Tocar botão 'Como gerar a chave aleatória?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Como gerar a chave aleatória?'")
    public AjudaPixTela tocarComoGerarChaveAleatoria() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoGerarChaveAleatoria, "Não foi possível encontrar o botão 'Como gerar a chave aleatória?'");
        salvarEvidencia("Tocar no botão 'Como gerar a chave aleatória?'");
        tocarElemento(botaoComoGerarChaveAleatoria, "Não foi possível Tocar no botão 'Como gerar a chave aleatória?'");
        return this;
    }

    /**
     * Validar pergunta 'Como gerar a chave aleatória?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como gerar a chave aleatória?'")
    public AjudaPixTela validarPerguntaComoGerarChaveAleatoria() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoGerarChaveAleatoria), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Como gerar a chave aleatória?'");
        salvarEvidencia("validar pergunta 'Como gerar a chave aleatória?'");
        return this;
    }

    /**
     * Tocar botão 'O que é Portabilidade no Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'O que é Portabilidade no Pix?'")
    public AjudaPixTela tocarOQueEPortabilidadeNoPix() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoOQueEPortabilidadeNoPix);
            salvarEvidencia("Tocar no botão 'O que é Portabilidade no Pix?'");
            tocarElemento(botaoOQueEPortabilidadeNoPix, "Não foi possível Tocar no botão 'O que é Portabilidade no Pix?'");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueEPortabilidadeNoPix, "Não foi possível Tocar no botão 'O que é Portabilidade no Pix?'");
            salvarEvidencia("Tocar no botão 'O que é Portabilidade no Pix?'");
            tocarElemento(botaoOQueEPortabilidadeNoPix, "Não foi possível Tocar no botão 'O que é Portabilidade no Pix?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'O que é Portabilidade no Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que é Portabilidade no Pix?'")
    public AjudaPixTela validarPerguntaOQueEPortabilidadeNoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEPortabilidadeNoPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'O que é Portabilidade no Pix?'");
        salvarEvidencia("validar pergunta 'O que é Portabilidade no Pix?'");
        return this;
    }

    /**
     * Tocar botão 'O que é Reivindicação no Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'O que é Reivindicação no Pix?'")
    public AjudaPixTela tocarOQueEReivindicacaoNoPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueEReivindicacaoNoPix, "Não foi possível Tocar no botão 'O que é Reivindicação no Pix?'");
        salvarEvidencia("Tocar no botão 'O que é Reivindicação no Pix?'");
        tocarElemento(botaoOQueEReivindicacaoNoPix, "Não foi possível Tocar no botão 'O que é Reivindicação no Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'O que é Reivindicação no Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que é Reivindicação no Pix?'")
    public AjudaPixTela validarPerguntaOQueEReivindicacaoNoPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEReivindicacaoNoPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'O que é Reivindicação no Pix?'");
        salvarEvidencia("validar pergunta 'O que é Reivindicação no Pix?'");
        return this;
    }

    /**
     * Tocar botão 'Como contestar um Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Como contestar um Pix?'")
    public AjudaPixTela tocarComoContestarUmPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoContestarUmPix, "Não foi possível tocar no botão 'Como contestar um Pix?'");
        salvarEvidencia("Tocar no botão 'Como contestar um Pix?'");
        tocarElemento(botaoComoContestarUmPix, "Não foi possível Tocar no botão 'Como contestar um Pix?'");
        return this;
    }

    /**
     * Validar pergunta 'Como contestar um Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como contestar um Pix?'")
    public AjudaPixTela validarPerguntaComoContestarUmPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoContestarUmPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Como contestar um Pix?'");
        salvarEvidencia("validar pergunta 'Como contestar um Pix?'");
        return this;
    }

    /**
     * Tocar botão 'Como funciona a contestação de um Pix?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Como funciona a contestação de um Pix?'")
    public AjudaPixTela tocarComoFuncionaContestacaoDeUmPix() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoComoFuncionaContestarUmPix);
            salvarEvidencia("Tocar no botão 'Como funciona a contestação de um Pix?'");
            tocarElemento(botaoComoFuncionaContestarUmPix, "Não foi possível Tocar no botão 'Como funciona a contestação de um Pix?'");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoFuncionaContestarUmPix, "Não foi possível Tocar no botão 'Como funciona a contestação de um Pix?'");
            salvarEvidencia("Tocar no botão 'Como funciona a contestação de um Pix?'");
            tocarElemento(botaoComoFuncionaContestarUmPix, "Não foi possível Tocar no botão 'Como funciona a contestação de um Pix?'");
        }
        return this;
    }

    /**
     * Validar pergunta 'Como funciona a contestação de um Pix?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona a contestação de um Pix?'")
    public AjudaPixTela validarPerguntaComoFuncionaContestacaoDeUmPix() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaContestarUmPix), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Como funciona a contestação de um Pix?'");
        salvarEvidencia("validar pergunta 'Como funciona a contestação de um Pix?'");
        return this;
    }


    /**
     * Tocar botão 'O que é Pix Saque e Pix Troco?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'O que é Pix Saque e Pix Troco?'")
    public AjudaPixTela tocarOQueEPixSaqueEPixTroco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOQueEPixSaqueEPixTroco, "Não foi possível encontrar o botão 'O que é Pix Saque e Pix Troco?'");
        salvarEvidencia("Tocar no botão 'O que é Pix Saque e Pix Troco?'");
        tocarElemento(botaoOQueEPixSaqueEPixTroco, "Não foi possível Tocar no botão 'O que é Pix Saque e Pix Troco?'");
        return this;
    }

    /**
     * Validar pergunta 'O que é Pix Saque e Pix Troco?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'O que é Pix Saque e Pix Troco?'")
    public AjudaPixTela validarPerguntaOQueEPixSaqueEPixTroco() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoOQueEPixSaqueEPixTroco), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'O que é Pix Saque e Pix Troco?'");
        salvarEvidencia("validar pergunta 'O que é Pix Saque e Pix Troco?'");
        return this;
    }

    /**
     * Tocar botão 'Como funciona o Pix Saque?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Como funciona o Pix Saque?'")
    public AjudaPixTela tocarComoFuncionaPixSaque() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoFuncionaPixSaque, "Não foi possível encontrar o botão 'Como funciona o Pix Saque?'");
        salvarEvidencia("Tocar no botão 'Como funciona o Pix Saque?'");
        tocarElemento(botaoComoFuncionaPixSaque, "Não foi possível Tocar no botão 'Como funciona o Pix Saque?'");
        return this;
    }

    /**
     * Validar pergunta 'Como funciona o Pix Saque?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona o Pix Saque?'")
    public AjudaPixTela validarPerguntaComoFuncionaPixSaque() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaPixSaque), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Como funciona o Pix Saque?'");
        salvarEvidencia("validar pergunta 'Como funciona o Pix Saque?'");
        return this;
    }

    /**
     * Tocar botão 'Como funciona o Pix Troco?'
     *
     * @return AjudaPixTela
     * @throws Exception
     */
    @Step("Tocar botão 'Como funciona o Pix Troco?'")
    public AjudaPixTela tocarComoFuncionaPixTroco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComoFuncionaPixTroco, "Não foi possível encontrar o botão 'Como funciona o Pix Troco?");
        salvarEvidencia("Tocar no botão 'Como funciona o Pix Troco?'");
        tocarElemento(botaoComoFuncionaPixTroco, "Não foi possível Tocar no botão 'Como funciona o Pix Troco?'");
        return this;
    }

    /**
     * Validar pergunta 'Como funciona o Pix Troco?'
     *
     * @return AjudaPixTela
     */
    @Step("Validar pergunta 'Como funciona o Pix Troco?'")
    public AjudaPixTela validarPerguntaComoFuncionaPixTroco() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoComoFuncionaPixSaque), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar pergunta 'Como funciona o Pix Troco?'");
        salvarEvidencia("validar pergunta 'Como funciona o Pix Troco?'");
        return this;
    }
}
