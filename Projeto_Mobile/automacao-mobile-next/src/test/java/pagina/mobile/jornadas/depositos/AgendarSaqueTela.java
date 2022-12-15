package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AgendarSaqueTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_btn_continue")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuar;

    public AgendarSaqueTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public AgendarSaqueTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar em 'continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar  em Continuar");
        return this;
    }
}
