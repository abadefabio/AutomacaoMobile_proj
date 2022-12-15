package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagem;
import constantes.cartao.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class OfertaDeCartaoTela extends PaginaBase {

    public OfertaDeCartaoTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"OFERTA DE CART�O\"]")
    private MobileElement tituloOfertaDeCartao;

    @iOSXCUITFindBy(accessibility = "banner_credit_unavailable")
    @AndroidFindBy(id ="br.com.bradesco.next:id/banner")
    private MobileElement bannerOfertaDeCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Ainda n�o temos cr�dito dispon�vel pra voc�, mas veja como � f�cil aumentar suas chances!")
    @AndroidFindBy(id ="br.com.bradesco.next:id/nl_title_body")
    private MobileElement fraseAindaTemosCredito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "A aprova��o do cr�dito estar� sujeita a an�lise")
    @AndroidFindBy(id ="br.com.bradesco.next:id/nl_subtitle")
    private MobileElement aprovacaoDoCreditoEstaraSijeitaAAnalise;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Traga seu sal�rio para o next")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'sal�rio')]")
    private MobileElement tragaSeuSalarioParaONext;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Cadastre suas chaves no PIX")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'chaves')]")
    private MobileElement cadastreSuasChavesNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Adicione seu cart�o no Apple Pay")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'Adicione')]")
    private MobileElement adicioneSeuCartaoNoSamsungPay;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Pague suas contas no next")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'Pague')]")
    private MobileElement pagueSuasContasNoNext;

    /**
     * Validar presen�a da tela 'CART�O' com informa��es sobre solicita��o de cart�o de cr�dito
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'CART�O' com informa��es sobre solicita��o de cart�o de cr�dito")
    public OfertaDeCartaoTela validarTelaOfertaDeCartao() throws Exception {

        validarCondicaoBooleana(
                !aguardarPaginaConterQualquerTexto(
                        (Mensagens.MENSAGENS_SOLICITACAO_CARTAO_CREDITO)).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO, "Tela 'CART�O' com informa��es sobre solicita��o de cart�o de cr�dito");
        salvarEvidencia("Validado presen�a da tela 'CART�O' com informa��es sobre solicita��o de cart�o de cr�dito.");
        return this;
    }

    /**
     * Tocar botao "Voltar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Voltar\"")
    public OfertaDeCartaoTela tocarNoBotaoVoltar() throws Exception {
        tocarElemento(tocarNoBotaoVoltar(), "N�o foi poss�vel tocar no botao \"Voltar\"");
        salvarEvidencia("Tocar no botao \"Voltar\"");
        return this;
    }

    /**
     * Validar mensagem 'Limite pr�-aprovado'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem 'Limite pr�-aprovado'")
    public OfertaDeCartaoTela validarLimitePreAprovado() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.MENSAGEM_LIMITE_PRE_APROVADO)), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Limite pr�-aprovado' n�o est� presente na tela!");
        salvarEvidencia("Validada mensagem 'Limite pr�-aprovado'");
        return this;
    }
}
