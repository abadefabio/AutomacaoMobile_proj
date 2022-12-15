package pagina.mobile.jornadas.investimentos.comprovantes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ComprovanteTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @iOSXCUITFindBy(accessibility = "Compartilhar")
    private MobileElement botaoCompartilhar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    public ComprovanteTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Compartilhar'
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Compartilhar'")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        aguardarElementoHabilitado(botaoCompartilhar);
        salvarEvidencia("Tocar no bot�o 'Compartilhar'");
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel tocar no bot�o 'Compartilhar'");
        return this;
    }

    /**
     * Tocar no bot�o 'Voltar' (<)
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Voltar' (<)")
    public ComprovanteTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Voltar' (<)");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar' (<)");
        return this;
    }
}
