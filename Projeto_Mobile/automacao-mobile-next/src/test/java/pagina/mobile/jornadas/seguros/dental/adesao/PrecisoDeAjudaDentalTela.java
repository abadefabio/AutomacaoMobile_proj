package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PrecisoDeAjudaDentalTela extends PaginaBase {

    public PrecisoDeAjudaDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela PRECISO DE AJUDA
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/me.next.uikit.NextLabel[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelTitle\"])[1]")
    private MobileElement headerPrecisoDeAjudaDental;

    // Botão Voltar "<"
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    /**
     * Método para validar tela PRECISO DE AJUDA
     * @return PrecisoDeAjudaDentalTela
     * @throws Exception
     */
    @Step("Validar tela PRECISO DE AJUDA")
    public PrecisoDeAjudaDentalTela validaTelaPrecisoDeAjudaDental() throws Exception {
        aguardarCarregamentoElemento(headerPrecisoDeAjudaDental);
        salvarEvidencia("Validar a tela Preciso de Ajuda");
        compararElementoTexto(headerPrecisoDeAjudaDental, SegurosDental.TITULO_TELA_TELEFONES_UTEIS,MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * Método para tocar botão Voltar "<"
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Tocar Botão Voltar")
    public PrecisoDeAjudaDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar no botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }
}
