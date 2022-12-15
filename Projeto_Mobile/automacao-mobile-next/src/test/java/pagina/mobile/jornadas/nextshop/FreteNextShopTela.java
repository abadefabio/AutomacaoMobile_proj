package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.nextShop.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class FreteNextShopTela extends PaginaBase {

    public FreteNextShopTela(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(accessibility = "systemControlArrowBack\\nsystemControlArrowBack")
    @iOSXCUITFindBy(accessibility = "systemControlArrowBack\\nsystemControlArrowBack")
    private MobileElement botaoVoltarHeader;

    @AndroidFindBy(accessibility = "Selecionado R$ 0,52 Entrega Normal Em at� 1 dia �til")
    @iOSXCUITFindBy(accessibility = "Selecionado R$ 0,52 Entrega Normal Em at� 1 dia �til")
    private MobileElement cardFrete;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CONTINUAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;


    /**
     * Realiza o toque no bot�o de voltar no header da tela do Frete do Marketplace
     *
     * @return FreteMarketpalce
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public FreteNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar no bot�o 'Voltar' - Tela de Frete");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }

    /**
     * Realiza o toque no card de frete.
     *
     * @return FreteMarketpalce
     * @throws Exception
     */
    @Step("Tocar bot�o \"Frete\"")
    public FreteNextShopTela tocarCardFrete() throws Exception {
        aguardarCarregamentoElemento(cardFrete);
        salvarEvidencia("Tocar na op��o 'Frete'");
        tocarElemento(cardFrete, "Houve um erro ao executar a acao de tocar o elemento botao \"Frete\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o continuar.
     *
     * @return FreteMarketpalce
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public FreteNextShopTela tocarBotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar no botao 'Continuar' - Tela de Frete");
        tocarElemento(botaoContinuar, "Houve um erro ao executar a acao de tocar o elemento botao \"Continuar\"");
        return this;
    }

    /**
     *
     * Validar tela frete
     * @throws Exception
     */
    @Step("Validar tela frete")
    public FreteNextShopTela validarTelaFrete() throws Exception{
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(TituloTela.FRETE),
                MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar a tela Frete");
        salvarEvidencia("Validada tela Frete");
        return this;
    }

}
