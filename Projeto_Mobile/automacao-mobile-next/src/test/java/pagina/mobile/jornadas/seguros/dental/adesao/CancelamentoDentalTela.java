package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.seguros.CancelamentoDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CancelamentoDentalTela extends PaginaBase {

    public CancelamentoDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela CANCELAMENTO DENTAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/logo")
    @iOSXCUITFindBy(xpath = "br.com.bradesco.next:id/logo")
    private MobileElement tituloCancelamento;

    // Bot�o Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Bot�o VOLTAR AO SEGURO DENTAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonBack\"]")
    private MobileElement botaoVoltarAoSeguroDebito;

    // Bot�o CONTINUAR PARA CANCELAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoContinuarParaCancelar;

    /**
     * M�todo para Validar CANCELAMENTO DENTAL
     *
     * @return CancelamentoDentalTela
     * @throws Exception
     */
    @Step("Validar tela CANCELAMENTO DENTAL")
    public CancelamentoDentalTela validaTelaCancelamentoDental() throws Exception {
        aguardarCarregamentoElemento(tituloCancelamento);
        verificarPresencaElemento(CancelamentoDental.TEXTO_CANCELAMENTO_1);
        verificarPresencaElemento(CancelamentoDental.TEXTO_CANCELAMENTO_2);
        verificarPresencaElemento(CancelamentoDental.TEXTO_CANCELAMENTO_3);
        verificarPresencaElemento(CancelamentoDental.TEXTO_CANCELAMENTO_4);
        salvarEvidencia("Validar tela CANCELAMENTO DENTAL");
        return this;
    }

    /**
     * M�todo para tocar bot�o Voltar "<"
     *
     * @return CancelamentoDentalTela
     * @throws Exception
     */
    @Step("Tocar Bot�o Voltar")
    public CancelamentoDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("TOCAR BOT�O VOLTAR");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o Voltar");
        return this;
    }

    /**
     * M�todo para Tocar no bot�o 'Continuar para Cancelar'
     *
     * @return CancelamentoDentalTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Continuar para Cancelar")
    public CancelamentoDentalTela tocarBotaoContinuarParaCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuarParaCancelar, "bot�o 'Continuar para Cancelar' n�o encontrado");
        aguardarCarregamentoElemento(botaoContinuarParaCancelar);
        salvarEvidencia("Tocar no bot�o 'Continuar para Cancelar'");
        tocarElemento(botaoContinuarParaCancelar, "N�o foi poss�vel tocar no bot�o 'Continuar para Cancelar'");
        return this;
    }

}
