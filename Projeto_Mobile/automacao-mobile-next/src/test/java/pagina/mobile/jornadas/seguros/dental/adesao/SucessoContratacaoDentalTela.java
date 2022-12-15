package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SucessoContratacaoDentalTela extends PaginaBase {

    public SucessoContratacaoDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Texto numero do protocolo da tela SUCESSO DE CONTRATAÇÃO
    @AndroidFindBy(id = "br.com.bradesco.next:id/label_protocol_number")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'protocolLabel')]")
    private MobileElement labelNumeroProtocolo;

    // botão CONCLUIR da tela SUCESSO DE CONTRATAÇÃO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_conclude")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'finishButton')]")
    private MobileElement btnConcluirTelaSucessoContratacao;
    /*     *************************     */

    /*
    Método para Valida tela SUCESSO DE CONTRATAÇÃO
     */
    @Step("Valida tela SUCESSO DE CONTRATAÇÃO")
    public SucessoContratacaoDentalTela validaTelaSucessoContratacaoDental() throws Exception {
        aguardarCarregamentoElemento(labelNumeroProtocolo);
        compararElementoTexto(labelNumeroProtocolo, SegurosDental.TEXTO_NUMERO_PROTOCOLO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SUCESSO DE CONTRATAÇÃO");
        return this;
    }
    /*
    Método para Tocar no botão <CONCLUIR>
     */
    @Step("Tocar no botão <CONCLUIR>")
    public SucessoContratacaoDentalTela tocarBtnConcluirContratacaoDental() throws Exception {
        aguardarCarregamentoElemento(btnConcluirTelaSucessoContratacao);
        salvarEvidencia("Tocar no botão <CONCLUIR>");
        tocarElemento(btnConcluirTelaSucessoContratacao, "Não foi possível tocar no botão <CONCLUIR>.");
        return this;
    }
}
