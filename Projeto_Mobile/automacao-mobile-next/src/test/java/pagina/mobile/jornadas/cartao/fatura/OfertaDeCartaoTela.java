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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"OFERTA DE CARTÃO\"]")
    private MobileElement tituloOfertaDeCartao;

    @iOSXCUITFindBy(accessibility = "banner_credit_unavailable")
    @AndroidFindBy(id ="br.com.bradesco.next:id/banner")
    private MobileElement bannerOfertaDeCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Ainda não temos crédito disponível pra você, mas veja como é fácil aumentar suas chances!")
    @AndroidFindBy(id ="br.com.bradesco.next:id/nl_title_body")
    private MobileElement fraseAindaTemosCredito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "A aprovação do crédito estará sujeita a análise")
    @AndroidFindBy(id ="br.com.bradesco.next:id/nl_subtitle")
    private MobileElement aprovacaoDoCreditoEstaraSijeitaAAnalise;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Traga seu salário para o next")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'salário')]")
    private MobileElement tragaSeuSalarioParaONext;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Cadastre suas chaves no PIX")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'chaves')]")
    private MobileElement cadastreSuasChavesNoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Adicione seu cartão no Apple Pay")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'Adicione')]")
    private MobileElement adicioneSeuCartaoNoSamsungPay;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Pague suas contas no next")
    @AndroidFindBy(xpath ="//*[@resource-id='br.com.bradesco.next:id/nl_item_name'and contains(@text,'Pague')]")
    private MobileElement pagueSuasContasNoNext;

    /**
     * Validar presença da tela 'CARTÃO' com informações sobre solicitação de cartão de crédito
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'CARTÃO' com informações sobre solicitação de cartão de crédito")
    public OfertaDeCartaoTela validarTelaOfertaDeCartao() throws Exception {

        validarCondicaoBooleana(
                !aguardarPaginaConterQualquerTexto(
                        (Mensagens.MENSAGENS_SOLICITACAO_CARTAO_CREDITO)).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO, "Tela 'CARTÃO' com informações sobre solicitação de cartão de crédito");
        salvarEvidencia("Validado presença da tela 'CARTÃO' com informações sobre solicitação de cartão de crédito.");
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
        tocarElemento(tocarNoBotaoVoltar(), "Não foi possível tocar no botao \"Voltar\"");
        salvarEvidencia("Tocar no botao \"Voltar\"");
        return this;
    }

    /**
     * Validar mensagem 'Limite pré-aprovado'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem 'Limite pré-aprovado'")
    public OfertaDeCartaoTela validarLimitePreAprovado() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.MENSAGEM_LIMITE_PRE_APROVADO)), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Limite pré-aprovado' não está presente na tela!");
        salvarEvidencia("Validada mensagem 'Limite pré-aprovado'");
        return this;
    }
}
