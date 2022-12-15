package pagina.mobile.jornadas.credito.limite;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConfirmacaoAntecipacaoPagamentoTela extends PaginaBase {

    @AndroidFindBy(xpath="(//*[@content-desc=\"Continuar com pagamento.\"])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]")
    private MobileElement botaoProximaParcela;

    @iOSXCUITFindBy(accessibility = "credito parcelado param")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_description")
    private MobileElement textoDescricaoParcela;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PAGAR\"]")
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout)[4]/android.widget.TextView")
    private MobileElement textoTituloParcelas;

    public ConfirmacaoAntecipacaoPagamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /** Tocar Proxima Parcela para Antecipacao
     * @return
     */
    @Step("Tocar Proxima Parcela para Antecipacao")
    public ConfirmacaoAntecipacaoPagamentoTela tocarProximaParcela() throws Exception {
        tocarElemento(botaoProximaParcela,"Nao foi possivel tocar na 'Proxima Parcela'");
        salvarEvidencia("Tocar Proxima Parcela para Antecipacao");
        return this;
    }

    /** Validar texto de descricao da parcela
     * @param texto
     * @return
     */
    @Step("Validado texto de descricao da parcela")
    public ConfirmacaoAntecipacaoPagamentoTela verificarTextoDescricao(String texto) throws Exception {

        validarCondicaoBooleana(retornarTexto(textoDescricaoParcela,"Nao foi possivel encontrar o texto").contains(texto), MetodoComparacaoBooleano.VERDADEIRO, "Nao foi possivel validar o texto");
        salvarEvidencia("Validado texto de descricao da parcela");
        return this;
    }

    /** Validar texto Titulo Lista de lista da parcelas
     * @param texto
     * @return
     */
    @Step("Validado texto Titulo Lista de lista da parcelas")
    public ConfirmacaoAntecipacaoPagamentoTela verificarTextoListaParcelas(String texto) {
        validarCondicaoBooleana(aguardarPaginaConterQualquerTexto(texto).contains(texto), MetodoComparacaoBooleano.VERDADEIRO, "Nao foi possivel validar o texto");
        salvarEvidencia("Validado texto Titulo Lista de lista da parcelas");
        return this;
    }
}
