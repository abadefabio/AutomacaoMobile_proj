package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosCredito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SucessoContratacaoCreditoTela extends PaginaBase {

    public SucessoContratacaoCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Texto numero do protocolo da tela SUCESSO DE CONTRATA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_protocol_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"protocolLabel\"]")
    private MobileElement labelNumeroProtocolo;

    // bot�o VER DETALHES DO PLANO da tela SUCESSO DE CONTRATA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_conclude")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'finishButton')]")
    private MobileElement btnVerDetalhesPlanoTelaSucessoContratacao;
    /*     *************************     */

    /*
    M�todo para Valida tela SUCESSO DE CONTRATA��O
    */
    @Step("Valida tela SUCESSO DE CONTRATA��O")
    public SucessoContratacaoCreditoTela validaTelaSucessoContratacao() throws Exception {
        aguardarCarregamentoElemento(labelNumeroProtocolo);
        compararElementoTexto(labelNumeroProtocolo, SegurosCredito.TEXTO_NUMERO_PROTOCOLO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SUCESSO DE CONTRATA��O");
        return this;
    }
    /*
    M�todo para Tocar no bot�o <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O
    */
    @Step("Tocar no bot�o <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O")
    public SucessoContratacaoCreditoTela tocarBtnVerDetalhesPlanoCredito() throws Exception {
        aguardarCarregamentoElemento(btnVerDetalhesPlanoTelaSucessoContratacao);
        salvarEvidencia("Tocar no bot�o <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O");
        tocarElemento(btnVerDetalhesPlanoTelaSucessoContratacao, "N�o foi poss�vel tocar no bot�o <VER DETALHES DO PLANO> da tela de SUCESSO DE CONTRATA��O.");
        return this;
    }
}
