package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ComprovanteTela  extends PaginaBase {
    public ComprovanteTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/pdfView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeWebView)[1]")
    private MobileElement pdfComprovante;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_share_receipt")
    @iOSXCUITFindBy(accessibility = "COMPARTILHAR COMPROVANTE")
    private MobileElement botaoCompartilharComprovante;

    @AndroidFindBy(id = "android:id/title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ActivityListView']")
    private MobileElement popUpCompartilhamento;

    /**
     * Validar comprovante na tela
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Validar comprovante na tela")
    public ComprovanteTela validarComprovanteNaTela() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(pdfComprovante), MetodoComparacaoBooleano.VERDADEIRO,"Comprovante n�o est� presente na tela!");
        salvarEvidencia("Valido a presen�a do comprovante na tela");
        return this;

    }

    /**
     * Tocar bot�o 'Compartilhar Comprovante'
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Compartilhar Comprovante'")
    public ComprovanteTela tocarBotaoCompartilharComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilharComprovante);
        salvarEvidencia("Tocar bot�o 'Compartilhar Comprovante'");
        tocarElemento(botaoCompartilharComprovante, "N�o foi poss�vel tocar no bot�o 'Compartilhar Comprovante'");
        return this;
    }

    /**
     * Validar compartilhamento do comprovante
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Validar compartilhamento do comprovante")
    public ComprovanteTela validarCompartilhamentoDoComprovante() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(popUpCompartilhamento), MetodoComparacaoBooleano.VERDADEIRO,"Compartilhamento do Comprovante n�o est� presente na tela!");
        salvarEvidencia("Valido a presen�a do compartilhamento do comprovante");
        return this;

    }

}
