package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.seguros.CancelamentoResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CancelamentoResidencialTela extends PaginaBase {

    public CancelamentoResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela CANCELAMENTO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/logo")
    @iOSXCUITFindBy(xpath = "br.com.bradesco.next:id/logo")
    private MobileElement tituloCancelamento;

    // Botão Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Botão VOLTAR AO SEGURO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonBack\"]")
    private MobileElement botaoVoltarAoSeguroResidencial;

    // Botão CONTINUAR PARA CANCELAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoContinuarParaCancelar;

    /**
     * Método para Validar 'CANCELAMENTO RESIDENCIAL'
     *
     * @return CancelamentoResidencialTela
     * @throws Exception
     */
    @Step("Validar tela 'CANCELAMENTO RESIDENCIAL'")
    public CancelamentoResidencialTela validaTelaCancelamentoResidencial() throws Exception {
        aguardarCarregamentoElemento(tituloCancelamento);
        verificarPresencaElemento(CancelamentoResidencial.TEXTO_CANCELAMENTO_1);
        verificarPresencaElemento(CancelamentoResidencial.TEXTO_CANCELAMENTO_2);
        verificarPresencaElemento(CancelamentoResidencial.TEXTO_CANCELAMENTO_3);
        salvarEvidencia("Validar tela 'CANCELAMENTO RESIDENCIAL'");
        return this;
    }

    /**
     * Método para tocar botão 'Voltar "<"'
     *
     * @return CancelamentoResidencialTela
     * @throws Exception
     */
    @Step("Tocar Botão 'Voltar'")
    public CancelamentoResidencialTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar Botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Método para Tocar no botão 'Continuar para Cancelar'
     *
     * @return CancelamentoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Continuar para Cancelar'")
    public CancelamentoResidencialTela tocarBotaoContinuarParaCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuarParaCancelar, "botão Continuar para 'Cancelar não encontrado'");
        aguardarCarregamentoElemento(botaoContinuarParaCancelar);
        salvarEvidencia("Tocar no botão Continuar para Cancelar");
        tocarElemento(botaoContinuarParaCancelar, "Não foi possível tocar no botão 'Continuar para Cancelar'");
        return this;
    }

}
