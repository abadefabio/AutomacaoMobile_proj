package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TelefonesUteisDentalTela extends PaginaBase {

    public TelefonesUteisDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela TELEFONES UTEIS
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/me.next.uikit.NextLabel[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelTitle\"])[1]")
    private MobileElement tituloTelefonesUteisDental;

    // Botão Voltar "<"
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;


    /**
     * Método para validar tela TELEFONES UTEIS
     * @return TelefonesUteisDentalTela
     * @throws Exception
     */
    @Step("Validarr tela TELEFONES UTEIS")
    public TelefonesUteisDentalTela validaTelaTelefonesUteisDental() throws Exception {
        aguardarCarregamentoElemento(tituloTelefonesUteisDental);
        salvarEvidencia("Tela TELEFONES UTEIS");
        compararElementoTexto(tituloTelefonesUteisDental, SegurosDental.TITULO_TELA_TELEFONES_UTEIS,MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * Método para tocar botão Voltar "<"
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Toca Botão Voltar")
    public TelefonesUteisDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar BOTÃO VOLTAR");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    public MobileElement getHeaderTituloTelefonesUteis() {
        return tituloTelefonesUteisDental;
    }

    public MobileElement getBotaoVoltar() {
        return botaoVoltar;
    }
}
