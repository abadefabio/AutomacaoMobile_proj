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
     * Tocar botão 'Sim, Excluir Agendamento'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Sim, Excluir Agendamento'")
    public PixAgendadoTela tocarBotaoSimExcluirAgendamento() throws Exception {
        aguardarCarregamentoElemento(botaoSimExcluirAgendamento);
        salvarEvidencia("Tocar no botão 'Sim, Excluir Agendamento'");
        tocarElemento(botaoSimExcluirAgendamento, "Não foi possível Tocar no botão 'Sim, Excluir Agendamento'");
        return this;
    }

    /**
     * Tocar no botão 'OK'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'OK'")
    public PixAgendadoTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar botão 'Ok'");
        tocarElemento(botaoOk, "Não foi possível tocar no botão 'Ok'");
        return this;
    }
}
