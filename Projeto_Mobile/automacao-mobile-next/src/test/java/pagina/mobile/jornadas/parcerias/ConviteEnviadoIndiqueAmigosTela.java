package pagina.mobile.jornadas.parcerias;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.parcerias.Parcerias;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConviteEnviadoIndiqueAmigosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Convite enviado!")
    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS \"Convite enviado\"")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS \"Convite enviado!\"")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_title")
    private MobileElement mensagemConviteEnviado;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeStaticText' AND label CONTAINS 'produto Jequiti'")
    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS \"produto Jequiti\"")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_description")
    private MobileElement campoMensagemConsultorJequiti;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[not(contains(@name, \"Convite enviado\"))]")
    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS \"Convite\"")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_description")
    private MobileElement mensagemSucessoIndicacaoAmigo;

    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"OK\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    private MobileElement botaoOK;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"INDICAR NOVO AMIGO\"")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_secondary_button")
    private MobileElement botaoIndicarNovoAmigo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"INDIQUE AMIGOS\"]")
    @AndroidFindBy(id = "//*[@text = \"INDIQUE AMIGOS\"]")
    private MobileElement barraNavegacaoTela;

    public ConviteEnviadoIndiqueAmigosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Valida Exibição de mensagem esperada de convite enviado com sucesso
     * @param mensagemEsperada
     * @return ConviteEnviadoIndiqueAmigosTela
     * @throws Exception
     */
    @Step("Valida Exibição de mensagem esperada de convite enviado com sucesso")
    public ConviteEnviadoIndiqueAmigosTela validarMensagemEsperada(Enum mensagemEsperada) throws Exception {
        aguardarCarregamentoElemento(mensagemSucessoIndicacaoAmigo);
        compararElementoTexto(mensagemSucessoIndicacaoAmigo, mensagemEsperada, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar exibição de mensagem: \"" + mensagemEsperada.toString() + "\"");
        return this;
    }

    /**
     * Valida a exibição da mensagem "Convite Enviado"
     * @return
     * @throws Exception
     */
    @Step("Valida a exibição da mensagem \"Convite Enviado\"")
    public ConviteEnviadoIndiqueAmigosTela validarMensagemConviteEnviado() throws Exception {

        aguardarCarregamentoElemento(mensagemConviteEnviado);
        compararElementoTexto(mensagemConviteEnviado, Parcerias.MENSAGEM_CONVITE_ENVIADO , MetodoComparacao.CONTEM);
        salvarEvidencia("Validar exibição de mensagem: \"" + Parcerias.MENSAGEM_CONVITE_ENVIADO.toString() + "\"");
        return this;
    }

    /**
     * Validar mensagem exibida ao indicar amigo com sucesso (CPF é consultor Jequiti)
     *
     * @param mensagem
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem tela")
    public ConviteEnviadoIndiqueAmigosTela validarMensagemConsultorJequiti(Enum mensagem) throws Exception {
        aguardarCarregamentoElemento(campoMensagemConsultorJequiti);
        compararElementoTexto(campoMensagemConsultorJequiti, mensagem, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar mensagem tela");
        return this;
    }

    /**
     * Tocar botão "OK"
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"OK\"")
    public ConviteEnviadoIndiqueAmigosTela tocarBotaoOK() throws Exception{
        salvarEvidencia("Tocar botão \"OK\"");
        tocarElemento(botaoOK, "Erro ao tocar botão \"OK\"");
        return this;
    }

    /**
     * Tocar botão "INDICAR NOVOS AMIGOS"
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"INDICAR NOVOS AMIGOS\"")
    public ConviteEnviadoIndiqueAmigosTela tocarBotaoIndicarNovoAmigo() throws Exception{
        salvarEvidencia("Tocar botão \"INDICAR NOVOS AMIGOS\"");
        tocarElemento(botaoIndicarNovoAmigo, "Erro ao tocar botão \"INDICAR NOVOS AMIGOS\"");
        return this;
    }
}
