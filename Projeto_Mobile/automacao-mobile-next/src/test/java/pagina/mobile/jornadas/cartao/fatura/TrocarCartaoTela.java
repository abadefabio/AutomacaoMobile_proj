package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class TrocarCartaoTela extends PaginaBase {

    public TrocarCartaoTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_others_plans")
    private MobileElement botaoVerPropostas;

    /**
     * Tocar em "Ver Propostas"
     *
     *
     * @throws Exception
     */
    @Step("Tocar em \"Ver Propostas\"")
    public TrocarCartaoTela tocarBotaoVerPropostas() throws Exception {
        salvarEvidencia("Tocar em \"Ver Propostas\"");
        tocarElemento(botaoVerPropostas, "N�o foi poss�vel tocar em \"Ver Propostas\"");
        return this;
    }
}
