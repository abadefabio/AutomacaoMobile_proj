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
    // Título da tela CANCELAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/logo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"brandImageView\"]")
    private MobileElement headerTituloTelaCancelamento;

    // botão VOLTAR da tela de CANCELAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarCancelamento;

    // Botão VOLTAR AO SEGURO CRÉDITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonBack\"]")
    private MobileElement botaoVoltarAoSeguroCredito;

    // Botão CONTINUAR PARA CANCELAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoContinuarParaCancelar;

    /**
     * Método para validar Tela de Cancelamento - Débito
     * @return CancelamentoCreditoTela
     * @throws Exception
     */
    @Step("Validar Tela de Cancelamento - DÉBITO")
    public CancelamentoCreditoTela validaTelaCancelamentoCredito() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCancelamento);
        verificarPresencaElemento(CancelamentoCredito.TEXTO_CANCELAMENTO_1);
        verificarPresencaElemento(CancelamentoCredito.TEXTO_CANCELAMENTO_2);
        verificarPresencaElemento(CancelamentoCredito.TEXTO_CANCELAMENTO_3);
        salvarEvidencia("Tela de Cancelamento - DÉBITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     *
     * @return CancelamentoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public CancelamentoCreditoTela tocarBotaoVoltarCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarCancelamento);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarCancelamento, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }

    /**
     * Método para Tocar no botão Continuar para Cancelar
     *
     * @return CancelamentoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no botão Continuar para Cancelar")
    public CancelamentoCreditoTela tocarBotaoContinuarParaCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuarParaCancelar,"botão Continuar para Cancelar não encontrado");
        aguardarCarregamentoElemento(botaoContinuarParaCancelar);
        salvarEvidencia("Tocar no botão Continuar para Cancelar");
        tocarElemento(botaoContinuarParaCancelar, "Não foi possível tocar no botão Continuar para Cancelar");
        return this;
    }
}
