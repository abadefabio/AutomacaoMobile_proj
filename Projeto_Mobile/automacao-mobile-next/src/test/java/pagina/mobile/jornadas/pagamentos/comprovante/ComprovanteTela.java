package pagina.mobile.jornadas.pagamentos.comprovante;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.Normaliza;
import constantes.pagamentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.util.Strings;

import static br.com.next.automacao.core.constantes.MetodoComparacaoBooleano.VERDADEIRO;

public class ComprovanteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_receipts_visualize")
    @AndroidFindBy(xpath = "//*[contains(@text, \"Visualizar\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Visualizar\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Visualizar\"])[1]")
    private MobileElement linkVisualizar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Fechar, Bot�o")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "COMPROVANTE")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"COMPROVANTE\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"COMPROVANTE\"]")
    private MobileElement tituloComprovante;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @AndroidFindBy(accessibility = "Voltar, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Voltar, Bot�o\"]")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(id = "br.com.bradesco.next:id/pdfView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"COMPROVANTE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"COMPROVANTE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]")
    private MobileElement comprovantePdf;

    public ComprovanteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Comprovante'")
    public ComprovanteTela validarPresencaComprovanteTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.COMPROVANTE), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Comprovante' e mensagem 'Transa��o feita' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Comprovante'");
        return this;
    }

    /**
     * Validar dados na tela
     *
     * @param data
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Validar dados na tela")
    public ComprovanteTela validarDadosNaTela(String valor, String data) {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, String.format("Valor '%s' n�o est� presente na tela", valor));
        validarCondicaoBooleana(aguardarPaginaConterQualquerTexto(data, data.replaceAll("([a-z]{3})", "$1.")).isEmpty(), MetodoComparacaoBooleano.FALSO, "N�o est�o presentes todos os dados buscados na tela!");
        salvarEvidencia("Dados na tela validados");
        return this;
    }

    /**
     * Tocar link 'Visualizar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar link 'Visualizar'")
    public ComprovanteTela tocarLinkVisualizar() throws Exception {
        esperarCarregando();
        salvarEvidencia("Tocar link 'Visualizar'");
        tocarElemento(linkVisualizar, "N�o foi poss�vel tocar no link 'Visualizar'");
        return this;
    }

    /**
     * Tocar bot�o 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public ComprovanteTela tocarBotaoFechar() throws Exception {
        esperarCarregando();
        salvarEvidencia("Tocar bot�o 'Fechar'");
        if (ios) {
            By elemento = new By.ByXPath("//XCUIElementTypeNavigationBar[contains(@name,'COMPROVANTE')]");
            MobileElement barraTitulo = retornarElemento(elemento, "Erro ao retornar barra de titulo ");
            tocarCoordenadaProporcional(barraTitulo, 12, 65);

        } else {
            tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o 'Fechar'");
        }
        return this;
    }

    /**
     * Validou a tela: 'Comprovante'
     *
     * @return
     * @throws InterruptedException
     */
    @Step("Validou a tela: 'Comprovante'")
    public ComprovanteTela validarComprovanteTela() throws InterruptedException {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloComprovante) || aguardarPaginaConterTodosTextos("COMPROVANTE"),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao aguardar o carregamento da tela: 'Comprovante'");
        salvarEvidencia("Validou a tela: 'Comprovante'");
        return this;
    }

    /**
     * Tocar bot�o (header) 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o (header) 'Voltar'")
    public ComprovanteTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no bot�o (header) 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar bot�o (header) 'Voltar'");
        return this;
    }

    /**
     * Validar a presen�a do Comprovante em PDF na Tela.
     *
     * @return
     * @throws Exception
     */
    @Step("Validar a presen�a do Comprovante em PDF na Tela.")
    public ComprovanteTela validarComprovanteEmPdf() throws Exception {
        boolean pdfEstaPresente = Boolean.logicalOr(aguardarCarregamentoElemento(comprovantePdf), Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto("NEXT")));
        validarCondicaoBooleana(pdfEstaPresente, MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar presen�a do Comprovante em PDF na Tela.");
        salvarEvidencia("Validou a presen�a do Comprovante em PDF na Tela.");
        return this;

    }

    /**
     * Validar Textos no comprovante
     *
     * @param valor
     * @param tributo
     * @return
     * @throws Exception
     */
    @Step("Validar dados na tela")
    public ComprovanteTela validarTributoValor(String tributo, String valor) {
          validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Normaliza.String,tributo, valor), MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel encontrar os texto na tela!");
        salvarEvidencia("Validado tributo " + tributo + " e valor " + valor);
        return this;
    }

    /**
     * Validar dados do comprovante
     *
     * @param codigoDeBarras
     * @param valor
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Validar dados do comprovante")
    public ComprovanteTela validarDadosComprovante(String codigoDeBarras, String valor) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigoDeBarras, valor), VERDADEIRO, "Erro ao localizar o c�digo de barras '" + codigoDeBarras + "' e o valor '" + valor);
        salvarEvidencia("Validado o c�digo de barras '" + codigoDeBarras + "' e o valor '" + valor + "' informados no comprovante");
        return this;
    }

}
