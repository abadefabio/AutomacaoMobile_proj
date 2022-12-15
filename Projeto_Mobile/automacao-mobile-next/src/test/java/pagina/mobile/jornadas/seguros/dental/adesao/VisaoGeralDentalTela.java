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
    // T�tulo da tela VISAO GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VIS�O GERAL\"]")
    private MobileElement tituloVisaoGeral;

    // Bot�o Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Bot�o Meus Documentos
    @AndroidFindBy(id = "br.com.bradesco.next:id/cv_my_documents")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonMyDocuments\"]")
    private MobileElement botaoMeusDocumentos;

    // Bot�o Preciso de Ajuda!
    @AndroidFindBy(id = "br.com.bradesco.next:id/cv_need_help")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonWantHelp\"]")
    private MobileElement botaoPrecisoDeAjuda;

    // Bot�o CANCELAR SEGURO "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_cancel_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoCancelarSeguro;

    /**
     * M�todo para Validar tela VISAO GERAL
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Validar tela VISAO GERAL")
    public VisaoGeralDentalTela validaTelaVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(tituloVisaoGeral);
        salvarEvidencia("Validar tela vis�o Geral");
        compararElementoTexto(tituloVisaoGeral, SegurosDental.TITULO_TELA_VISAO_GERAL, MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * M�todo para tocar bot�o Voltar "<"
     *
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Tocar Bot�o Voltar")
    public VisaoGeralDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("TOCAR BOT�O VOLTAR");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o Voltar");
        return this;
    }

    /**
     * M�todo para tocar bot�o Meus Documentos
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar Bot�o Meus Documentos")
    public VisaoGeralDentalTela tocarBotaoMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoMeusDocumentos);
        salvarEvidencia("'Tocar no bot�o 'Meus Documentos'");
        tocarElemento(botaoMeusDocumentos, "Imposs�vel Tocar Bot�o Meus Documentos");
        return this;
    }

    /**
     * M�todo para tocar bot�o Preciso De Ajuda
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar Bot�o Preciso de Ajuda")
    public VisaoGeralDentalTela tocarBotaoPrecisoDeAjuda() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDeAjuda);
        salvarEvidencia("Tocar no bot�o 'Preciso de Ajuda'");
        tocarElemento(botaoPrecisoDeAjuda, "N�o foi poss�vel tocar no bot�o 'Preciso de Ajuda'");
        return this;
    }

    /**
     * M�todo para tocar bot�o Cancelar Seguro
     *
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar Bot�o Cancelar Seguro")
    public VisaoGeralDentalTela tocarBotaoCancelarSeguro() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no bot�o 'Cancelar Seguro'");
        tocarElemento(botaoCancelarSeguro, "N�o foi poss�vel tocar no bot�o Cancelar Seguro");
        return this;
    }
}
