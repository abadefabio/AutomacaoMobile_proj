package pagina.mobile.jornadas.ajuda;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AtalhosTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ATALHOS\"]")
    private MobileElement tituloTelaAtalhos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/quotation_dollar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para tela de cotação do dólar\"]")
    private MobileElement botaoCotacaoDoDolar;

    public AtalhosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Método para verificar título da tela
     * @return AtalhosTela
     */
    @Step("Método para verificar o título da tela Atalhos")
    public AtalhosTela validarTituloTelaAtalhos() {
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaAtalhos), MetodoComparacaoBooleano.VERDADEIRO, "Título 'ATALHOS' não está presente na tela!");
        salvarEvidencia("Validar título da tela 'ATALHOS'");
        return this;
    }

    /**
     * Método para tocar no botão Cotação do dólar
     * @return AtalhosTela
     */
    @Step("Método para tocar no botão Cotação do Dólar")
    public AtalhosTela tocarBotaoCotacaoDoDolar() throws NextException {
        aguardarCarregamentoElemento(botaoCotacaoDoDolar);
        salvarEvidencia("Tocar no botao 'Cotação do dólar'");
        tocarElemento(botaoCotacaoDoDolar, "Não foi possível tocar no botão 'Cotação do dólar'!");
        return this;
    }
}
