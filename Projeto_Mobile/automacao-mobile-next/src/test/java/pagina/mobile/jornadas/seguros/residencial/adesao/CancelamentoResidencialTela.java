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
    // T�tulo da tela CANCELAMENTO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/logo")
    @iOSXCUITFindBy(xpath = "br.com.bradesco.next:id/logo")
    private MobileElement tituloCancelamento;

    // Bot�o Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Bot�o VOLTAR AO SEGURO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonBack\"]")
    private MobileElement botaoVoltarAoSeguroResidencial;

    // Bot�o CONTINUAR PARA CANCELAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoContinuarParaCancelar;

    /**
     * M�todo para Validar 'CANCELAMENTO RESIDENCIAL'
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
     * M�todo para tocar bot�o 'Voltar "<"'
     *
     * @return CancelamentoResidencialTela
     * @throws Exception
     */
    @Step("Tocar Bot�o 'Voltar'")
    public CancelamentoResidencialTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar Bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * M�todo para Tocar no bot�o 'Continuar para Cancelar'
     *
     * @return CancelamentoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Continuar para Cancelar'")
    public CancelamentoResidencialTela tocarBotaoContinuarParaCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuarParaCancelar, "bot�o Continuar para 'Cancelar n�o encontrado'");
        aguardarCarregamentoElemento(botaoContinuarParaCancelar);
        salvarEvidencia("Tocar no bot�o Continuar para Cancelar");
        tocarElemento(botaoContinuarParaCancelar, "N�o foi poss�vel tocar no bot�o 'Continuar para Cancelar'");
        return this;
    }

}
