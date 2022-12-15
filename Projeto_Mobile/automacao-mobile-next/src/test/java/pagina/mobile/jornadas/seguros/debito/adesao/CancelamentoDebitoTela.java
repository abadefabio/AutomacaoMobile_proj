package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.seguros.CancelamentoDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CancelamentoDebitoTela extends PaginaBase {

    public CancelamentoDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela CANCELAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/logo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"brandImageView\"]")
    private MobileElement headerTituloTelaCancelamento;

    // bot�o VOLTAR da tela de CANCELAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarCancelamento;

    // Bot�o VOLTAR AO SEGURO D�BITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonBack\"]")
    private MobileElement botaoVoltarAoSeguroDebito;

    // Bot�o CONTINUAR PARA CANCELAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoContinuarParaCancelar;

    /**
     * M�todo para validar Tela de Cancelamento - D�bito
     * @return CancelamentoDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela de Cancelamento - D�BITO")
    public CancelamentoDebitoTela validaTelaCancelamentoDebito() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCancelamento);
        verificarPresencaElemento(CancelamentoDebito.TEXTO_CANCELAMENTO_1);
        verificarPresencaElemento(CancelamentoDebito.TEXTO_CANCELAMENTO_2);
        verificarPresencaElemento(CancelamentoDebito.TEXTO_CANCELAMENTO_3);
        verificarPresencaElemento(CancelamentoDebito.TEXTO_CANCELAMENTO_4);
        salvarEvidencia("Tela de Cancelamento - D�BITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     *
     * @return CancelamentoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public CancelamentoDebitoTela tocarBotaoVoltarCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarCancelamento);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarCancelamento, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }

    /**
     * M�todo para Tocar no bot�o Continuar para Cancelar
     *
     * @return CancelamentoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Continuar para Cancelar")
    public CancelamentoDebitoTela tocarBotaoContinuarParaCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuarParaCancelar,"bot�o Continuar para Cancelar n�o encontrado");
        aguardarCarregamentoElemento(botaoContinuarParaCancelar);
        salvarEvidencia("Tocar no bot�o Continuar para Cancelar");
        tocarElemento(botaoContinuarParaCancelar, "N�o foi poss�vel tocar no bot�o Continuar para Cancelar");
        return this;
    }
}
