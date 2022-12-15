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
     * Tocar no botão 'Compartilhar'
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Compartilhar'")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        aguardarElementoHabilitado(botaoCompartilhar);
        salvarEvidencia("Tocar no botão 'Compartilhar'");
        tocarElemento(botaoCompartilhar, "Não foi possível tocar no botão 'Compartilhar'");
        return this;
    }

    /**
     * Tocar no botão 'Voltar' (<)
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Voltar' (<)")
    public ComprovanteTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botão 'Voltar' (<)");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar' (<)");
        return this;
    }
}
