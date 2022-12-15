package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencialTelefones;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TelefonesUteisResidencialTela extends PaginaBase {

    public TelefonesUteisResidencialTela(AppiumDriver driver) {
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
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"11 3003 1022\"]")
    private MobileElement textoTelefonesUteis1;

    // Texto TELEFONES UTEIS 2
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"4004 2757\"]")
    private MobileElement textoTelefonesUteis2;

    // Texto TELEFONES UTEIS 3
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"0800 701 2757\"]")
    private MobileElement textoTelefonesUteis3;

    // Texto TELEFONES UTEIS 4
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"0800 727 9966\"]")
    private MobileElement textoTelefonesUteis4;

    /**
     * Método para validar a tela TELEFONES ÚTEIS
     *
     * @param textoTelefones1
     * @param textoTelefones2
     * @param textoTelefones3
     * @param textoTelefones4
     * @return TelefonesUteisResidencialTela
     * @throws Exception
     */
    @Step("Validar Tela de Telefones Úteis - RESIDENCIAL")
    public TelefonesUteisResidencialTela validarTelaTelefonesUteisResidencial(SegurosResidencialTelefones textoTelefones1, SegurosResidencialTelefones textoTelefones2, SegurosResidencialTelefones textoTelefones3, SegurosResidencialTelefones textoTelefones4) throws Exception {
        compararElementoTexto(textoTelefonesUteis1, textoTelefones1, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis2, textoTelefones2, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis3, textoTelefones3, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis4, textoTelefones4, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar Tela de Informações - RESIDENCIAL");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return TelefonesUteisResidencialTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public TelefonesUteisResidencialTela tocarBotaoVoltarTelaTelefonesUteis() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarTelefonesUteis);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarTelefonesUteis, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
