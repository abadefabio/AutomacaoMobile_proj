package pagina.mobile.jornadas.recarga.confirmacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConfirmacaoRecargaCelularTela  extends PaginaBase {

    @AndroidFindBy(accessibility = "CONFIRMAR")
    @iOSXCUITFindBy(accessibility = "CONFIRMAR")
    private MobileElement botaoConfirmar;

    public ConfirmacaoRecargaCelularTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar bot�o 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Confirmar\"")
    public ConfirmacaoRecargaCelularTela tocarBotaoConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar, "N�o foi poss�vel clicar no bot�o Confirmar");
        salvarEvidencia("Clicar no bot�o 'Confirmar'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel clicar no bot�o Confirmar");
        return this;
    }
}
