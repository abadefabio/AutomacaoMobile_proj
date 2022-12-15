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
    // Título da tela CANCELAMENTO DENTAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/logo")
    @iOSXCUITFindBy(xpath = "br.com.bradesco.next:id/logo")
    private MobileElement tituloCancelamento;

    // Botão Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Botão VOLTAR AO SEGURO DENTAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonBack\"]")
    private MobileElement botaoVoltarAoSeguroDebito;

    // Botão CONTINUAR PARA CANCELAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoContinuarParaCancelar;

    /**
     * Método para Validar CANCELAMENTO DENTAL
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
     * Método para tocar botão Voltar "<"
     *
     * @return CancelamentoDentalTela
     * @throws Exception
     */
    @Step("Tocar Botão Voltar")
    public CancelamentoDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("TOCAR BOTÃO VOLTAR");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão Voltar");
        return this;
    }

    /**
     * Método para Tocar no botão 'Continuar para Cancelar'
     *
     * @return CancelamentoDentalTela
     * @throws Exception
     */
    @Step("Tocar no botão Continuar para Cancelar")
    public CancelamentoDentalTela tocarBotaoContinuarParaCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuarParaCancelar, "botão 'Continuar para Cancelar' não encontrado");
        aguardarCarregamentoElemento(botaoContinuarParaCancelar);
        salvarEvidencia("Tocar no botão 'Continuar para Cancelar'");
        tocarElemento(botaoContinuarParaCancelar, "Não foi possível tocar no botão 'Continuar para Cancelar'");
        return this;
    }

}
