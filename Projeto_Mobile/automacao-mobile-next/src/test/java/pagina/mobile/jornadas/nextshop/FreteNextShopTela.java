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

    @AndroidFindBy(accessibility = "Selecionado R$ 0,52 Entrega Normal Em até 1 dia útil")
    @iOSXCUITFindBy(accessibility = "Selecionado R$ 0,52 Entrega Normal Em até 1 dia útil")
    private MobileElement cardFrete;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CONTINUAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;


    /**
     * Realiza o toque no botão de voltar no header da tela do Frete do Marketplace
     *
     * @return FreteMarketpalce
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public FreteNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar no botão 'Voltar' - Tela de Frete");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }

    /**
     * Realiza o toque no card de frete.
     *
     * @return FreteMarketpalce
     * @throws Exception
     */
    @Step("Tocar botão \"Frete\"")
    public FreteNextShopTela tocarCardFrete() throws Exception {
        aguardarCarregamentoElemento(cardFrete);
        salvarEvidencia("Tocar na opção 'Frete'");
        tocarElemento(cardFrete, "Houve um erro ao executar a acao de tocar o elemento botao \"Frete\"");
        return this;
    }

    /**
     * Realiza o toque no botão continuar.
     *
     * @return FreteMarketpalce
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
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
                MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar a tela Frete");
        salvarEvidencia("Validada tela Frete");
        return this;
    }

}
