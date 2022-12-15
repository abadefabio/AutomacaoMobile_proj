package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.seguros.CancelamentoCredito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CancelamentoCreditoTela extends PaginaBase {

    public CancelamentoCreditoTela(AppiumDriver driver) {
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

    // Bot�o VOLTAR AO SEGURO CR�DITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonBack\"]")
    private MobileElement botaoVoltarAoSeguroCredito;

    // Bot�o CONTINUAR PARA CANCELAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoContinuarParaCancelar;

    /**
     * M�todo para validar Tela de Cancelamento - D�bito
     * @return CancelamentoCreditoTela
     * @throws Exception
     */
    @Step("Validar Tela de Cancelamento - D�BITO")
    public CancelamentoCreditoTela validaTelaCancelamentoCredito() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCancelamento);
        verificarPresencaElemento(CancelamentoCredito.TEXTO_CANCELAMENTO_1);
        verificarPresencaElemento(CancelamentoCredito.TEXTO_CANCELAMENTO_2);
        verificarPresencaElemento(CancelamentoCredito.TEXTO_CANCELAMENTO_3);
        salvarEvidencia("Tela de Cancelamento - D�BITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     *
     * @return CancelamentoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public CancelamentoCreditoTela tocarBotaoVoltarCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarCancelamento);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarCancelamento, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }

    /**
     * M�todo para Tocar no bot�o Continuar para Cancelar
     *
     * @return CancelamentoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Continuar para Cancelar")
    public CancelamentoCreditoTela tocarBotaoContinuarParaCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuarParaCancelar,"bot�o Continuar para Cancelar n�o encontrado");
        aguardarCarregamentoElemento(botaoContinuarParaCancelar);
        salvarEvidencia("Tocar no bot�o Continuar para Cancelar");
        tocarElemento(botaoContinuarParaCancelar, "N�o foi poss�vel tocar no bot�o Continuar para Cancelar");
        return this;
    }
}
