package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class VisaoGeralDentalTela extends PaginaBase {

    public VisaoGeralDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela VISAO GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VISÃO GERAL\"]")
    private MobileElement tituloVisaoGeral;

    // Botão Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Botão Meus Documentos
    @AndroidFindBy(id = "br.com.bradesco.next:id/cv_my_documents")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonMyDocuments\"]")
    private MobileElement botaoMeusDocumentos;

    // Botão Preciso de Ajuda!
    @AndroidFindBy(id = "br.com.bradesco.next:id/cv_need_help")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonWantHelp\"]")
    private MobileElement botaoPrecisoDeAjuda;

    // Botão CANCELAR SEGURO "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_cancel_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoCancelarSeguro;

    /**
     * Método para Validar tela VISAO GERAL
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Validar tela VISAO GERAL")
    public VisaoGeralDentalTela validaTelaVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(tituloVisaoGeral);
        salvarEvidencia("Validar tela visão Geral");
        compararElementoTexto(tituloVisaoGeral, SegurosDental.TITULO_TELA_VISAO_GERAL, MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * Método para tocar botão Voltar "<"
     *
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Tocar Botão Voltar")
    public VisaoGeralDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("TOCAR BOTÃO VOLTAR");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão Voltar");
        return this;
    }

    /**
     * Método para tocar botão Meus Documentos
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar Botão Meus Documentos")
    public VisaoGeralDentalTela tocarBotaoMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoMeusDocumentos);
        salvarEvidencia("'Tocar no botão 'Meus Documentos'");
        tocarElemento(botaoMeusDocumentos, "Impossível Tocar Botão Meus Documentos");
        return this;
    }

    /**
     * Método para tocar botão Preciso De Ajuda
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar Botão Preciso de Ajuda")
    public VisaoGeralDentalTela tocarBotaoPrecisoDeAjuda() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDeAjuda);
        salvarEvidencia("Tocar no botão 'Preciso de Ajuda'");
        tocarElemento(botaoPrecisoDeAjuda, "Não foi possível tocar no botão 'Preciso de Ajuda'");
        return this;
    }

    /**
     * Método para tocar botão Cancelar Seguro
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar Botão Cancelar Seguro")
    public VisaoGeralDentalTela tocarBotaoCancelarSeguro() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no botão 'Cancelar Seguro'");
        tocarElemento(botaoCancelarSeguro, "Não foi possível tocar no botão Cancelar Seguro");
        return this;
    }
}
