package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDebitoTelefones;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TelefonesUteisDebitoTela extends PaginaBase {

    public TelefonesUteisDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela TELEFONES UTEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelTitle\"])[1]")
    private MobileElement headerTituloTelaTelefonesUteis;

    // botão VOLTAR da tela TELEFONES UTEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarTelefonesUteis;

    // Texto TELEFONES UTEIS 1
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/me.next.uikit.NextLabel[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"phoneLabel\"])[1]")
    private MobileElement textoTelefonesUteis1;

    // Texto TELEFONES UTEIS 2
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/me.next.uikit.NextLabel[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"phoneLabel\"])[2]")
    private MobileElement textoTelefonesUteis2;

    // Texto TELEFONES UTEIS 3
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/me.next.uikit.NextLabel[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"phoneLabel\"])[3]")
    private MobileElement textoTelefonesUteis3;

    // Texto TELEFONES UTEIS 4
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/me.next.uikit.NextLabel[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"phoneLabel\"])[4]")
    private MobileElement textoTelefonesUteis4;

    /**
     * Método para validar a Tela de Telefones Úteis
     * @param textoTelefones1
     * @param textoTelefones2
     * @param textoTelefones3
     * @param textoTelefones4
     * @return TelefonesUteisDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela de Telefones Úteis - DÉBITO")
    public TelefonesUteisDebitoTela validaTelaTelefonesUteisDebito(SegurosDebitoTelefones textoTelefones1, SegurosDebitoTelefones textoTelefones2, SegurosDebitoTelefones textoTelefones3, SegurosDebitoTelefones textoTelefones4) throws Exception {
        compararElementoTexto(textoTelefonesUteis1, textoTelefones1, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis2, textoTelefones2, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis3, textoTelefones3, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis4, textoTelefones4, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela TELEFONES ÚTEIS - DÉBITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return TelefonesUteisDebitoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public TelefonesUteisDebitoTela tocarBotaoVoltarTelaTelefonesUteis() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarTelefonesUteis);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarTelefonesUteis, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
