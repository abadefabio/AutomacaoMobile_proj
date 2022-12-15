package pagina.mobile.jornadas.pix;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PixAgendadoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "SIM, EXCLUIR AGENDAMENTO")
    private MobileElement botaoSimExcluirAgendamento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOk;

    public PixAgendadoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o 'Sim, Excluir Agendamento'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Sim, Excluir Agendamento'")
    public PixAgendadoTela tocarBotaoSimExcluirAgendamento() throws Exception {
        aguardarCarregamentoElemento(botaoSimExcluirAgendamento);
        salvarEvidencia("Tocar no bot�o 'Sim, Excluir Agendamento'");
        tocarElemento(botaoSimExcluirAgendamento, "N�o foi poss�vel Tocar no bot�o 'Sim, Excluir Agendamento'");
        return this;
    }

    /**
     * Tocar no bot�o 'OK'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'OK'")
    public PixAgendadoTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar bot�o 'Ok'");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no bot�o 'Ok'");
        return this;
    }
}
