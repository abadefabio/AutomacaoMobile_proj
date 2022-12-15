package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class ConfiguracoesCartaoTela extends PaginaBase{

    @AndroidFindBy(xpath = "//*[@text = 'CONFIGURAÇÕES DO CARTÃO']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"CONFIGURAÇÕES DO CARTÃO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFIGURAÇÕES DO CARTÃO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[contains(@name,\"CONFIGURAÇÕES DO CARTÃO\")]")
    private MobileElement tituloTelaConfiguracoesCartao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Senha do cartão\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Senha do cartão. Veja a senha do seu cartão\"`]")
    private MobileElement senhaDoCartao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Trocar Cartão\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Trocar cartão. Fazer Upgrade ou Downgrade\"`]")
    private MobileElement trocarCartao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Cotação do dolar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Cotação do dólar. Para compras internacionais\"`]")
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
        tocarElemento(senhaDoCartao, "Não foi possível tocar em \"Senha do Cartao\"");
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
        tocarElemento(trocarCartao, "Não foi possível tocar em \"Trocar Cartao\"");
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
        tocarElemento(cotacaoDoDolar, "Não foi possível tocar em \"Cotacao do Dolar\"");
        salvarEvidencia("Tocar em \"Cotacao do Dolar\"");
        return this;
    }

    /**
     *
     * Validar estar na tela "Configuracoes Cartão"
     *
     */
    @Step("Validar estar na tela \"Configuracoes Cartão\"")
    public ConfiguracoesCartaoTela validarTelaConfiguracoesCartao() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTelaConfiguracoesCartao), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o titulo da tela");
        salvarEvidencia("Validar estar na tela \"Configuracoes Cartão\"");
        return this;
    }

    /**
     * Validar não conter opção "Solicitar 2º via"
     *
     * @throws Exception
     */
    @Step("Validar não conter opção \"Solicitar 2º via\"")
    public ConfiguracoesCartaoTela validarSolicitarSegundaVia() throws Exception{
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos("Solicitar 2ª via"),MetodoComparacaoBooleano.FALSO,"Não foi possível validar a opção 'Solicitar 2º via'");
        salvarEvidencia("Validar não conter opção \"Solicitar 2º Via\"");
        return this;
    }




}
