package pagina.mobile.jornadas.recarga;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class    InformacoesTela extends PaginaBase {

    @AndroidFindBy(accessibility = "Voltar, Bot�o")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    public InformacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em 'Voltar'
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public InformacoesTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Clicar no bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel clicar no bot�o 'Voltar'");
        return this;
    }
}
