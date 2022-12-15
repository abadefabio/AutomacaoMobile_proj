package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagem;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class FaturaTela extends PaginaBase {

    // botão mês
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/ctv_month' and @selected='true']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Selecione para navegar para a fatura de')]")
    private MobileElement botaoMes;

    // clicar botao Gerar Boleto
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_generate_billet")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Gerar Boleto\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_pay_invoice")
    @iOSXCUITFindBy(accessibility = "GERAR BOLETO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"GERAR BOLETO\"`]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"GERAR BOLETO\")]")
    @iOSXCUITFindBy(xpath = "//*[@name='Selecione para abrir o pagamento da fatura']")
    private MobileElement botaoGerarBoleto;

    // clicar em compartilhar para selecionar aplicativos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Enviar por e-mail\"]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Compartilhar\"`]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"FATURA\"])[1]/XCUIElementTypeButton[2]")
    private MobileElement tocarCompartilharSelecionarApp;

    // clicar botao fatura em PDF
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_see_receipt")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Fatura em PDF\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Selecione para abrir o PDF da fatura\"`]")
    @iOSXCUITFindBy(accessibility = "Selecione para abrir o PDF da fatura")
    private MobileElement botaoFaturaEmPdf;

    // validar apresentacao da fatura em PDF
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/pdfView")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"Não é possível acessar o comprovante.\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private MobileElement visualizarFaturaEmPdf;

    // validar apresentacao da tela webView PDF
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/pdfView")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"Não é possível acessar o comprovante.\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeWebView\"")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeWebView)[1]")
    private MobileElement visualizacaoWebViewPDF;

    // Label do Valor da Fatura a ser selecionada
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_invoice_amount")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name, 'Vencimento')]/preceding-sibling::XCUIElementTypeStaticText[contains(@name,'R$ ')][@value])[1]")
    private MobileElement labelValorFatura;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"FATURA\"])[1]")
    private MobileElement labelFatura;

    public FaturaTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botao "Compartilhar Selecionar App"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Compartilhar Selecionar App\"")
    public FaturaTela tocarCompartilhar() throws Exception {
       salvarEvidencia("Tocar no botao \"Compartilhar Selecionar App\"");
        tocarElemento(tocarCompartilharSelecionarApp, "Não foi possível tocar no botao \"Compartilhar Selecionar App\"");
        salvarEvidencia("botao \"Compartilhar Selecionado\"");
        return this;
    }

    /**
     * validar titulo tela "Fatura"
     *
     * @return FaturaTela
     * @throws Exception
     */
    @Step("validar titulo tela \"Fatura\"")
    public FaturaTela validarTituloTela() throws Exception {
        esperarCarregando();
        boolean telaPresente = (ios ? verificarPresencaElemento(labelFatura) : aguardarPaginaConterTodosTextos(TituloTela.FATURA.toString()));
        validarCondicaoBooleana(telaPresente, MetodoComparacaoBooleano.VERDADEIRO,"Título 'Fatura' não está presente na tela!");
        salvarEvidencia("validar titulo tela \"Fatura\"");
        return this;
    }

    /**
     * Tocar "Direita Mês Anterior"
     *
     * @return FaturaTela
     * @throws Exception
     */
    private FaturaTela tocarDireitaMesAnterior() throws Exception {
        if (ios) {
            deslizar(botaoMes, Direcao.DIREITA, 30, 80);
        }
        else {
            String mesAnterior;
            String textoBotaoMes = retornarTexto(botaoMes, "Erro ao recuperar o atributo texto do botão mês");
            List<String> mesesAno = Arrays.asList("JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ");

            for (int i = 0; i< mesesAno.size(); i++) {
                if (textoBotaoMes.contains(mesesAno.get(i))) {
                    if (!textoBotaoMes.contains("JAN")) {
                        mesAnterior = mesesAno.get(i - 1);
                    }
                    else {
                        mesAnterior = "DEZ";
                    }

                    By elementoMesAnterior = By.xpath("//*[@resource-id='br.com.bradesco.next:id/ctv_month' and contains(@text, '"+mesAnterior+"')]");
                    tocarElemento(elementoMesAnterior,"Não foi possível tocar no elemento '"+mesAnterior+"'");
                    break;
                }
            }
            salvarEvidencia("Selecionar 'Mês Anterior'");
        }
        return this;
    }

    /**
     * Tocar botao "Gerar Boleto"
     *FR
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Gerar Boleto/Pagar'")
    public FaturaTela tocarGerarBoleto() throws Exception {
        salvarEvidencia("Tocar no botao 'Gerar Boleto/Pagar'");
        tocarElemento(botaoGerarBoleto, "Não foi possível tocar no botao 'Gerar Boleto/Pagar'");
        return this;
    }

    /**
     * validar Texto da tela "Complete acao usando"
     * FR
     *
     * @throws Exception
     */
    @Step("validar titulo tela \"Complete acao usando\"")
    public FaturaTela validarTextoCompartilhamentoAplicativo() throws Exception {
        salvarEvidencia("validar tela \"Compartilhamento\"");
        if(android) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagem.COMPLETE_ACAO_USANDO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Complete acao usando:' não está presente na tela!");
        } else {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagem.CANCELAR.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Botao 'Cancelar' não está presente na tela!");
        }
        salvarEvidencia("validar texto da tela \"Complete acao usando:\"");
        return this;
    }

    /**
     * Tocar "Botao fatura em PDF"
     *FR
     *
     * @throws Exception
     */
    @Step("Tocar botao \"fatura em PDF\"")
    public FaturaTela tocarBotaoFaturaEmPdf() throws Exception {
        salvarEvidencia("Tocar no botao \"fatura em PDF\"");
        tocarElemento(botaoFaturaEmPdf, "Não foi possível tocar no botao \"fatura em PDF\"");
        return this;
    }

    /**
     * validar Apresentacao Fatura em Pdf
     *FR
     *
     * @throws Exception
     */
    @Step("validar Apresentacao Fatura em Pdf - webView")
    public FaturaTela validarApresentacaoWebViewFaturaEmPdf() throws Exception {
        validarCondicaoBooleana( verificarPresencaElemento(visualizacaoWebViewPDF), MetodoComparacaoBooleano.VERDADEIRO, "erro ao validar apresentacao webView fatura em PDF");
        salvarEvidencia("validar Apresentacao Fatura em Pdf - WebView");
        return this;
    }

    /**
     * validar Apresentacao botao compratilhar
     *FR
     *
     * @throws Exception
     */
    @Step("validar Apresentacao botao compartilhar")
    public FaturaTela validarApresencaBotaoCompartilhar() throws Exception {
        validarCondicaoBooleana( verificarPresencaElemento(tocarCompartilharSelecionarApp), MetodoComparacaoBooleano.VERDADEIRO, "erro ao validar Apresentacao botao compartilhar.");
        salvarEvidencia("validar Apresentacao botao compartilhar");
        return this;
    }

    /**
     * Buscar a presença do botão 'Gerar Boleto/Pagar'
     *
     * @return FaturaTela
     * @throws Exception
     */
    @Step("Buscar a presença do botão 'Gerar Boleto/Pagar'")
    public FaturaTela buscarPresencaBotaoBoleto() throws Exception {
        if (!verificarPresencaElemento(botaoGerarBoleto)) {
            tocarDireitaMesAnterior();
        }
        return this;
    }

    /**
     * Buscar a presença do botão 'Fatura em PDF'
     *
     * @return FaturaTela
     * @throws Exception
     */
    @Step("Buscar a presença do botão 'Fatura em PDF'")
    public FaturaTela buscarPresencaBotaoFaturaEmPdf() throws Exception {
        if (!aguardarElementoHabilitado(botaoFaturaEmPdf)) {
            tocarDireitaMesAnterior();
        }
        return this;
    }

    /**
     * Recuperar o valor da fatura a ser selecionada
     *
     * @return Valor da Fatura
     * @throws Exception
     */
    @Step("Recuperar valor da fatura")
    public String retornarValorDaFatura() throws Exception {
        aguardarCarregamentoElemento(labelFatura);
        return retornarTexto(labelValorFatura, "Não foi possível recuperar o texto do campo 'Valor' da fatura");
    }
}
