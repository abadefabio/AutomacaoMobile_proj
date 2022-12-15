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
        validarCondicaoBooleana(verificarPresencaElemento(pdfComprovante), MetodoComparacaoBooleano.VERDADEIRO,"Comprovante não está presente na tela!");
        salvarEvidencia("Valido a presença do comprovante na tela");
        return this;

    }

    /**
     * Tocar botão 'Compartilhar Comprovante'
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Tocar botão 'Compartilhar Comprovante'")
    public ComprovanteTela tocarBotaoCompartilharComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilharComprovante);
        salvarEvidencia("Tocar botão 'Compartilhar Comprovante'");
        tocarElemento(botaoCompartilharComprovante, "Não foi possível tocar no botão 'Compartilhar Comprovante'");
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
        validarCondicaoBooleana(verificarPresencaElemento(popUpCompartilhamento), MetodoComparacaoBooleano.VERDADEIRO,"Compartilhamento do Comprovante não está presente na tela!");
        salvarEvidencia("Valido a presença do compartilhamento do comprovante");
        return this;

    }

}
