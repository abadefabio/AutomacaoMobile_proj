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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para tela de cota��o do d�lar\"]")
    private MobileElement botaoCotacaoDoDolar;

    public AtalhosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * M�todo para verificar t�tulo da tela
     * @return AtalhosTela
     */
    @Step("M�todo para verificar o t�tulo da tela Atalhos")
    public AtalhosTela validarTituloTelaAtalhos() {
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaAtalhos), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'ATALHOS' n�o est� presente na tela!");
        salvarEvidencia("Validar t�tulo da tela 'ATALHOS'");
        return this;
    }

    /**
     * M�todo para tocar no bot�o Cota��o do d�lar
     * @return AtalhosTela
     */
    @Step("M�todo para tocar no bot�o Cota��o do D�lar")
    public AtalhosTela tocarBotaoCotacaoDoDolar() throws NextException {
        aguardarCarregamentoElemento(botaoCotacaoDoDolar);
        salvarEvidencia("Tocar no botao 'Cota��o do d�lar'");
        tocarElemento(botaoCotacaoDoDolar, "N�o foi poss�vel tocar no bot�o 'Cota��o do d�lar'!");
        return this;
    }
}
