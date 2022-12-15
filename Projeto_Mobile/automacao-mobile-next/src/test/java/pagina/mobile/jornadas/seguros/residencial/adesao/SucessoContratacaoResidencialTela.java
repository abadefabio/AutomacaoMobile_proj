package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SucessoContratacaoResidencialTela extends PaginaBase {

    public SucessoContratacaoResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Texto numero do protocolo da tela SUCESSO DE CONTRATA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/label_protocol_number")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"protocolLabel\"]")
    private MobileElement labelNumeroProtocolo;

    // bot�o CONCLUIR da tela SUCESSO DE CONTRATA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_conclude")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"finishButton\"]")
    private MobileElement btnConcluirTelaSucessoContratacao;
    /*     *************************     */

    /*
    M�todo para Valida tela SUCESSO DE CONTRATA��O
     */
    @Step("Valida tela SUCESSO DE CONTRATA��O")
    public SucessoContratacaoResidencialTela validaTelaSucessoContratacaoResidencial() throws Exception {
        aguardarCarregamentoElemento(labelNumeroProtocolo);
        compararElementoTexto(labelNumeroProtocolo, SegurosResidencial.TEXTO_NUMERO_PROTOCOLO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SUCESSO DE CONTRATA��O");
        return this;
    }
    /*
    M�todo para Tocar no bot�o <CONCLUIR>
     */
    @Step("Tocar no bot�o <CONCLUIR>")
    public SucessoContratacaoResidencialTela tocarBtnConcluirContratacaoResidencial() throws Exception {
        aguardarCarregamentoElemento(btnConcluirTelaSucessoContratacao);
        salvarEvidencia("Tocar no bot�o <CONCLUIR>");
        tocarElemento(btnConcluirTelaSucessoContratacao, "N�o foi poss�vel tocar no bot�o <CONCLUIR>.");
        return this;
    }
}
