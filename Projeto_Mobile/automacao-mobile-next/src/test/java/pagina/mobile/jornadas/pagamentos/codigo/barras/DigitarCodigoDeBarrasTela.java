package pagina.mobile.jornadas.pagamentos.codigo.barras;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pagamentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class DigitarCodigoDeBarrasTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_barcode")
    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    private MobileElement campoCodigoDeBarras;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @AndroidFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(id = "**/XCUIElementTypeButton[`label == \"Confirmar\"`]")
    private MobileElement botaoConfirmar;

    public DigitarCodigoDeBarrasTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Digitar Código de Barras'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Digitar Código de Barras'")
    public DigitarCodigoDeBarrasTela validarPresencaDigitarCodigoDeBarrasTela() {
        if (android && !aguardarPaginaConterTodosTextos(TituloTela.DIGITAR_CODIGO_BARRAS)) {
            voltarTelaAnterior();
        }
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.DIGITAR_CODIGO_BARRAS), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Digitar Código de Barras' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'Digitar Código de Barras'");
        return this;
    }

    /**
     * Preencher o campo 'Código de Barras'
     *
     * @param codigoDeBarras
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo 'Código de Barras'")
    public DigitarCodigoDeBarrasTela preencherCampoCodigoDeBarras(String codigoDeBarras) throws Exception {
        escreverTexto(campoCodigoDeBarras,codigoDeBarras,"Não foi possível preencher o campo 'Código de Barras'");
        salvarEvidencia("Preenchido campo 'Código de Barras' com : " + codigoDeBarras);
        return this;
    }

    /**
     * Tocar botão 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar'")
    public DigitarCodigoDeBarrasTela tocarbotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }
}
