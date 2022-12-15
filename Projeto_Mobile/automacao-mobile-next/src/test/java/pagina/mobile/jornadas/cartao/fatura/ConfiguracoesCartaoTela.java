package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class ConfiguracoesCartaoTela extends PaginaBase{

    @AndroidFindBy(xpath = "//*[@text = 'CONFIGURA��ES DO CART�O']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"CONFIGURA��ES DO CART�O\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFIGURA��ES DO CART�O\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[contains(@name,\"CONFIGURA��ES DO CART�O\")]")
    private MobileElement tituloTelaConfiguracoesCartao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Senha do cart�o\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Senha do cart�o. Veja a senha do seu cart�o\"`]")
    private MobileElement senhaDoCartao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Trocar Cart�o\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Trocar cart�o. Fazer Upgrade ou Downgrade\"`]")
    private MobileElement trocarCartao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Cota��o do dolar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Cota��o do d�lar. Para compras internacionais\"`]")
    private MobileElement cotacaoDoDolar;

    public ConfiguracoesCartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar em "Senha do Cartao"
     *
     *
     * @throws Exception
     */
    @Step("Tocar em \"Senha do Cartao\"")
    public ConfiguracoesCartaoTela tocarSenhaCartao() throws Exception {
        tocarElemento(senhaDoCartao, "N�o foi poss�vel tocar em \"Senha do Cartao\"");
        salvarEvidencia("Tocar em \"Senha do Cartao\"");
        return this;
    }

    /**
     * Tocar em "Trocar Cartao"
     *
     *
     * @throws Exception
     */
    @Step("Tocar em \"Trocar Cartao\"")
    public ConfiguracoesCartaoTela tocarTrocarCartao() throws Exception {
        tocarElemento(trocarCartao, "N�o foi poss�vel tocar em \"Trocar Cartao\"");
        salvarEvidencia("Tocar em \"Trocar Cartao\"");
        return this;
    }

    /**
     * Tocar em "Cotacao do Dolar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar em \"Cotacao do Dolar\"")
    public ConfiguracoesCartaoTela tocarCotacaoDoDolar() throws Exception {
        tocarElemento(cotacaoDoDolar, "N�o foi poss�vel tocar em \"Cotacao do Dolar\"");
        salvarEvidencia("Tocar em \"Cotacao do Dolar\"");
        return this;
    }

    /**
     *
     * Validar estar na tela "Configuracoes Cart�o"
     *
     */
    @Step("Validar estar na tela \"Configuracoes Cart�o\"")
    public ConfiguracoesCartaoTela validarTelaConfiguracoesCartao() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTelaConfiguracoesCartao), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o titulo da tela");
        salvarEvidencia("Validar estar na tela \"Configuracoes Cart�o\"");
        return this;
    }

    /**
     * Validar n�o conter op��o "Solicitar 2� via"
     *
     * @throws Exception
     */
    @Step("Validar n�o conter op��o \"Solicitar 2� via\"")
    public ConfiguracoesCartaoTela validarSolicitarSegundaVia() throws Exception{
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos("Solicitar 2� via"),MetodoComparacaoBooleano.FALSO,"N�o foi poss�vel validar a op��o 'Solicitar 2� via'");
        salvarEvidencia("Validar n�o conter op��o \"Solicitar 2� Via\"");
        return this;
    }




}
