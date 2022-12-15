package pagina.mobile.jornadas.comprovantes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.comprovantes.ConsultaTransacao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ComprovantesExtratoTela extends PaginaBase {

    @AndroidFindBy(accessibility = "Comprovantes")
    @iOSXCUITFindBy(accessibility = "COMPROVANTES")
    private MobileElement botaoComprovantes;

    @AndroidFindBy(accessibility = "Extratos")
    @iOSXCUITFindBy(accessibility = "EXTRATOS")
    private MobileElement botaoExtratos;

    @AndroidFindBy(accessibility = "Informe de Rendimentos")
    @iOSXCUITFindBy(accessibility = "INFORME DE RENDIMENTOS")
    private MobileElement botaoInformeRendimentos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Objetivos")
    @iOSXCUITFindBy(accessibility = "OBJETIVOS")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-category-goals\"]")
    private MobileElement botaoObjetivos;

    @AndroidFindBy(accessibility = "Investimentos")
    @iOSXCUITFindBy(accessibility = "INVESTIMENTOS")
    private MobileElement botaoInvestimentos;

    @AndroidFindBy(accessibility = "PIX")
    @iOSXCUITFindBy(accessibility = "PIX")
    private MobileElement botaoPix;

    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneServi�o")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\",Lista suspensa,SelecioneServi�o\"]\n")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon expansible cell\"])[1]")
    private MobileElement selecionarServicos;

    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement confirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Transfer�ncias\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transfer�ncias\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Transfer�ncias\"`]\n")
    private MobileElement escolherServico;

    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneTransa��o")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon expansible cell\"])[2]")
    private MobileElement selecionarTransacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Transfer�ncia Interbanc�ria\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transfer�ncia Interbanc�ria\"")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Pagamentos\"`]")
    private MobileElement escolherTransacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneData inicial")
    @AndroidFindBy(xpath = "//*[contains(@text,'Data inicial')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Data inicial\"]/android.widget.RelativeLayout/android.widget.TextView")
    @AndroidFindBy(id = "br.com.bradesco.next:id/npb_receipt_date_start")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Data inicial']")
    @iOSXCUITFindBy(xpath = "//*[@name='Data inicial']")
    private MobileElement dataInicial;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneData final")
    @AndroidFindBy(xpath = "//*[contains(@text,'Data final')]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nfpc_receipt_date_end")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Data final']")
    @iOSXCUITFindBy(xpath = "//*[@name='Data final']")
    private MobileElement dataFinal;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement continuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"TED-T ELET DISP\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name")
    @iOSXCUITFindBy(accessibility = "TED-T ELET DISP")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TRANSFER�NCIA\"]")
    private MobileElement tocarTransferencia;

    @AndroidFindBy(xpath = "//*[@text=\"Visualizar\"]")
    @iOSXCUITFindBy(accessibility = "Visualizar")
    private MobileElement tocarVisualizar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @iOSXCUITFindBy(accessibility = "Compartilhar")
    private MobileElement botaoCompartilhar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[3]")
    private MobileElement itemListaOutrosGastos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='COMPROVANTES']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"COMPROVANTES\"]")
    private MobileElement tituloComprovanteTela;

    @iOSXCUITFindBy(xpath = "//*[@name='Servi�o']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nfpc_receipt_service")
    private MobileElement comboServico;

    @iOSXCUITFindBy(xpath = "//*[@name='Transa��o']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nfpc_receipt_transaction")
    private MobileElement comboTransacao;

    @AndroidFindBy(xpath = "//*[@text=\"Ixi, n�o temos comprovante pra essa busca que voc� fez\"]")
    private MobileElement mensagemTela;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VOLTAR']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @AndroidFindBy(accessibility = "Voltar, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(xpath = "//*[contains(@text, 'VOLTAR') or contains(@text, 'voltar')]")
    private MobileElement botaoVoltar;

    public ComprovantesExtratoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar �cone "Comprovantes"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Comprovantes\"")
    public ComprovantesExtratoTela tocarBotaoComprovantes() throws Exception {
        aguardarCarregamentoElemento(botaoComprovantes);
        tocarElemento(botaoComprovantes, "N�o foi poss�vel tocar no �cone \"Comprovantes\"");
        salvarEvidencia("Tocar no �cone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar �cone "Extratos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Extratos\"")
    public ComprovantesExtratoTela tocarBotaoExtratos() throws Exception {
        aguardarCarregamentoElemento(botaoExtratos);
        tocarElemento(botaoExtratos, "N�o foi poss�vel tocar no �cone \"Comprovantes\"");
        salvarEvidencia("Tocar no �cone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar �cone "Informe de Rendimentos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Informe de Rendimentos\"")
    public ComprovantesExtratoTela tocarBotaoInformeRendimentos() throws Exception {
        aguardarCarregamentoElemento(botaoInformeRendimentos);
        tocarElemento(botaoInformeRendimentos, "N�o foi poss�vel tocar no �cone \"Comprovantes\"");
        salvarEvidencia("Tocar no �cone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar �cone "Objetivos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Objetivos\"")
    public ComprovantesExtratoTela tocarBotaoObjetivos() throws Exception {
        aguardarCarregamentoElemento(botaoObjetivos);
        tocarElemento(botaoObjetivos, "N�o foi poss�vel tocar no �cone \"Comprovantes\"");
        salvarEvidencia("Tocar no �cone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar �cone "Investimentos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Investimentos\"")
    public ComprovantesExtratoTela tocarBotaoInvestimentos() throws Exception {
        aguardarCarregamentoElemento(botaoInvestimentos);
        salvarEvidencia("Tocar no �cone \"Investimentos\"");
        tocarElemento(botaoInvestimentos, "N�o foi poss�vel tocar no �cone \"Investimentos\"");
        return this;
    }

    /**
     * Tocar �cone "Pix"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Pix\"")
    public ComprovantesExtratoTela tocarBotaoPix() throws Exception {
        aguardarCarregamentoElemento(botaoPix);
        tocarElemento(botaoPix, "N�o foi poss�vel tocar no �cone \"Comprovantes\"");
        salvarEvidencia("Tocar no �cone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar em "Servi�os"
     *
     * @throws Exception
     */
    @Step("Tocar op��o \"Servicos\"")
    public ComprovantesExtratoTela selecionarServicos() throws Exception {
        aguardarCarregamentoElemento(selecionarServicos);
        salvarEvidencia("Tocar em \"Servi�os\"");
        tocarElemento(selecionarServicos, "N�o foi poss�vel tocar em \"Servi�os\"");
        return this;
    }

    /**
     * Selecionar "Servi�o"
     *
     * @param s
     * @throws Exception
     */
    @Step("Tocar no \"Servicos\"")
    public ComprovantesExtratoTela escolherServico(String s) throws Exception {
        if (getDriver() instanceof IOSDriver) {
            rolarTelaAteFinal();
            tocarElemento(confirmar, "N�o foi poss�vel tocar em \"Confirmar\"");
            salvarEvidencia("Tocar no \"Servi�o\"");
        } else {
            aguardarCarregamentoElemento(escolherServico);
            salvarEvidencia("Tocar no \"Servi�o\"");
            tocarElemento(escolherServico, "N�o foi poss�vel tocar no \"Servi�o\"");
        }
        return this;
    }


    /**
     * Tocar na "Transa��o"
     *
     * @throws Exception
     */
    @Step("Tocar em \"Transa��o\"")
    public ComprovantesExtratoTela selecionarTransacao() throws Exception {
        aguardarCarregamentoElemento((selecionarTransacao));
        salvarEvidencia("Tocar em \"Transa��o\"");
        tocarElemento(selecionarTransacao, "N�o foi poss�vel tocar em \"transa��o\"");
        return this;
    }


    /**
     * Selecionar "Transa��o"
     *
     * @param transferenciaInterbancaria
     * @throws Exception
     */
    @Step("Tocar na \"Transa��o\"")
    public ComprovantesExtratoTela escolherTransacao(ConsultaTransacao transferenciaInterbancaria) throws Exception {
        if (getDriver() instanceof IOSDriver) {
            rolarTelaAteFinal();
            tocarElemento(confirmar, "N�o foi poss�vel tocar em \"Confirmar\"");
            salvarEvidencia("Tocar na \"Transa��o\"");
        } else {
            aguardarCarregamentoElemento(escolherTransacao);
            salvarEvidencia("Tocar na \"Transa��o\"");
            tocarElemento(escolherTransacao, "N�o foi poss�vel tocar na \"transa��o\"");
        }
        return this;
    }

    /**
     * Tocar "Data inicial"
     *
     * @throws Exception
     */
    @Step("Tocar na \"Data inicial\"")
    public ComprovantesExtratoTela dataInicial() throws Exception {
        aguardarCarregamentoElemento(dataInicial);
        salvarEvidencia("Tocar em \"Data inicial\"");
        tocarElemento(dataInicial, "N�o foi poss�vel tocar na \"data inicial\"");
        return this;
    }

    /**
     * Tocar "Data final"
     *
     * @throws Exception
     */
    @Step("Tocar na \"Data final\"")
    public ComprovantesExtratoTela dataFinal() throws Exception {
        aguardarCarregamentoElemento(dataInicial);
        salvarEvidencia("Tocar em \"Data final\"");
        tocarElemento(dataFinal, "N�o foi poss�vel tocar na \"data final\"");
        return this;
    }

    /**
     * Tocar em "Continuar"
     *
     * @throws Exception
     */
    @Step("Tocar em \"Continuar\"")
    public ComprovantesExtratoTela continuar() throws Exception {
        aguardarCarregamentoElemento(continuar);
        salvarEvidencia("Tocar em \"Continuar\"");
        tocarElemento(continuar, "N�o foi poss�vel tocar em \"continuar\"");
        return this;
    }

    /**
     * Tocar em "Transfer�ncias"
     *
     * @throws Exception
     */
    @Step("Tocar em \"Transfer�ncias\"")
    public ComprovantesExtratoTela tocarTransferencia() throws Exception {
        aguardarCarregamentoElemento(tocarTransferencia);
        salvarEvidencia("Tocar em \"Transfer�ncia\"");
        tocarElemento(tocarTransferencia, "N�o foi poss�vel tocar em \"Transfer�ncia\"");
        return this;
    }

    /**
     * Tocar em "Visualizar"
     *
     * @throws Exception
     */
    @Step("Tocar em \"Visualizar\"")
    public ComprovantesExtratoTela tocarVisualizar() throws Exception {
        aguardarCarregamentoElemento(tocarVisualizar);
        salvarEvidencia("Tocar em \"Visualizar\"");
        tocarElemento(tocarVisualizar, "N�o foi poss�vel tocar em \"Visualizar\"");
        return this;
    }

    /**
     * Tocar bot�o 'Compartilhar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Compartilhar\"")
    public ComprovantesExtratoTela tocarBotaoCompartilhar() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilhar);
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel clicar no bot�o Compartilhar");
        return this;
    }

    /**
     * Validar titulo da tela : 'Comprovante'
     *
     * @return
     */
    @Step("Validar titulo da tela : 'Comprovante'")
    public ComprovantesExtratoTela validarComprovantesTela() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloComprovanteTela), MetodoComparacaoBooleano.VERDADEIRO, "");
        salvarEvidencia("Validou da tela 'Comprovantes'");
        return this;
    }

    /**
     * Selecionar a Conta na Lista
     *
     * @return
     * @throws NextException
     */
    @Step("Selecionar a Conta na Lista")
    public ComprovantesExtratoTela selecionarPrimeiraContaNaLista() throws NextException {
        tocarElemento(itemListaOutrosGastos, "Erro ao selecionar o item da lista");
        salvarEvidencia("Selecionar a Conta na Lista");
        return this;
    }

    /**
     * Tocar na combo 'Servi�os'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar na combo 'Servi�os'")
    public ComprovantesExtratoTela tocarComboServico() throws NextException {
        salvarEvidencia("Tocar na combo 'Servi�o'");
        tocarElemento(comboServico, "Erro ao tocar na combo 'Servi�o'");
        return this;
    }

    /**
     * Tocar na combo 'Transa��o'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar na combo 'Transa��o'")
    public ComprovantesExtratoTela tocarComboTransacao() throws NextException {
        salvarEvidencia("Tocar na combo 'Transa��o'");
        tocarElemento(comboTransacao, "Erro ao tocar na combo 'Transa��o'");
        return this;
    }

    /**
     * Tocar bot�o (header) 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o (header) 'Voltar'")
    public ComprovantesExtratoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no bot�o (header) 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar bot�o (header) 'Voltar'");
        return this;
    }
}
