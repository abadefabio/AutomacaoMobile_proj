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

    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneServiço")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\",Lista suspensa,SelecioneServiço\"]\n")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon expansible cell\"])[1]")
    private MobileElement selecionarServicos;

    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement confirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Transferências\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transferências\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Transferências\"`]\n")
    private MobileElement escolherServico;

    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneTransação")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon expansible cell\"])[2]")
    private MobileElement selecionarTransacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Transferência Interbancária\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transferência Interbancária\"")
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TRANSFERÊNCIA\"]")
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

    @iOSXCUITFindBy(xpath = "//*[@name='Serviço']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nfpc_receipt_service")
    private MobileElement comboServico;

    @iOSXCUITFindBy(xpath = "//*[@name='Transação']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nfpc_receipt_transaction")
    private MobileElement comboTransacao;

    @AndroidFindBy(xpath = "//*[@text=\"Ixi, não temos comprovante pra essa busca que você fez\"]")
    private MobileElement mensagemTela;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VOLTAR']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @AndroidFindBy(accessibility = "Voltar, Botão")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(xpath = "//*[contains(@text, 'VOLTAR') or contains(@text, 'voltar')]")
    private MobileElement botaoVoltar;

    public ComprovantesExtratoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar ícone "Comprovantes"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Comprovantes\"")
    public ComprovantesExtratoTela tocarBotaoComprovantes() throws Exception {
        aguardarCarregamentoElemento(botaoComprovantes);
        tocarElemento(botaoComprovantes, "Não foi possível tocar no ícone \"Comprovantes\"");
        salvarEvidencia("Tocar no ícone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar ícone "Extratos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Extratos\"")
    public ComprovantesExtratoTela tocarBotaoExtratos() throws Exception {
        aguardarCarregamentoElemento(botaoExtratos);
        tocarElemento(botaoExtratos, "Não foi possível tocar no ícone \"Comprovantes\"");
        salvarEvidencia("Tocar no ícone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar ícone "Informe de Rendimentos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Informe de Rendimentos\"")
    public ComprovantesExtratoTela tocarBotaoInformeRendimentos() throws Exception {
        aguardarCarregamentoElemento(botaoInformeRendimentos);
        tocarElemento(botaoInformeRendimentos, "Não foi possível tocar no ícone \"Comprovantes\"");
        salvarEvidencia("Tocar no ícone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar ícone "Objetivos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Objetivos\"")
    public ComprovantesExtratoTela tocarBotaoObjetivos() throws Exception {
        aguardarCarregamentoElemento(botaoObjetivos);
        tocarElemento(botaoObjetivos, "Não foi possível tocar no ícone \"Comprovantes\"");
        salvarEvidencia("Tocar no ícone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar ícone "Investimentos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Investimentos\"")
    public ComprovantesExtratoTela tocarBotaoInvestimentos() throws Exception {
        aguardarCarregamentoElemento(botaoInvestimentos);
        salvarEvidencia("Tocar no ícone \"Investimentos\"");
        tocarElemento(botaoInvestimentos, "Não foi possível tocar no ícone \"Investimentos\"");
        return this;
    }

    /**
     * Tocar ícone "Pix"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Pix\"")
    public ComprovantesExtratoTela tocarBotaoPix() throws Exception {
        aguardarCarregamentoElemento(botaoPix);
        tocarElemento(botaoPix, "Não foi possível tocar no ícone \"Comprovantes\"");
        salvarEvidencia("Tocar no ícone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar em "Serviços"
     *
     * @throws Exception
     */
    @Step("Tocar opção \"Servicos\"")
    public ComprovantesExtratoTela selecionarServicos() throws Exception {
        aguardarCarregamentoElemento(selecionarServicos);
        salvarEvidencia("Tocar em \"Serviços\"");
        tocarElemento(selecionarServicos, "Não foi possível tocar em \"Serviços\"");
        return this;
    }

    /**
     * Selecionar "Serviço"
     *
     * @param s
     * @throws Exception
     */
    @Step("Tocar no \"Servicos\"")
    public ComprovantesExtratoTela escolherServico(String s) throws Exception {
        if (getDriver() instanceof IOSDriver) {
            rolarTelaAteFinal();
            tocarElemento(confirmar, "Não foi possível tocar em \"Confirmar\"");
            salvarEvidencia("Tocar no \"Serviço\"");
        } else {
            aguardarCarregamentoElemento(escolherServico);
            salvarEvidencia("Tocar no \"Serviço\"");
            tocarElemento(escolherServico, "Não foi possível tocar no \"Serviço\"");
        }
        return this;
    }


    /**
     * Tocar na "Transação"
     *
     * @throws Exception
     */
    @Step("Tocar em \"Transação\"")
    public ComprovantesExtratoTela selecionarTransacao() throws Exception {
        aguardarCarregamentoElemento((selecionarTransacao));
        salvarEvidencia("Tocar em \"Transação\"");
        tocarElemento(selecionarTransacao, "Não foi possível tocar em \"transação\"");
        return this;
    }


    /**
     * Selecionar "Transação"
     *
     * @param transferenciaInterbancaria
     * @throws Exception
     */
    @Step("Tocar na \"Transação\"")
    public ComprovantesExtratoTela escolherTransacao(ConsultaTransacao transferenciaInterbancaria) throws Exception {
        if (getDriver() instanceof IOSDriver) {
            rolarTelaAteFinal();
            tocarElemento(confirmar, "Não foi possível tocar em \"Confirmar\"");
            salvarEvidencia("Tocar na \"Transação\"");
        } else {
            aguardarCarregamentoElemento(escolherTransacao);
            salvarEvidencia("Tocar na \"Transação\"");
            tocarElemento(escolherTransacao, "Não foi possível tocar na \"transação\"");
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
        tocarElemento(dataInicial, "Não foi possível tocar na \"data inicial\"");
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
        tocarElemento(dataFinal, "Não foi possível tocar na \"data final\"");
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
        tocarElemento(continuar, "Não foi possível tocar em \"continuar\"");
        return this;
    }

    /**
     * Tocar em "Transferências"
     *
     * @throws Exception
     */
    @Step("Tocar em \"Transferências\"")
    public ComprovantesExtratoTela tocarTransferencia() throws Exception {
        aguardarCarregamentoElemento(tocarTransferencia);
        salvarEvidencia("Tocar em \"Transferência\"");
        tocarElemento(tocarTransferencia, "Não foi possível tocar em \"Transferência\"");
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
        tocarElemento(tocarVisualizar, "Não foi possível tocar em \"Visualizar\"");
        return this;
    }

    /**
     * Tocar botão 'Compartilhar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Compartilhar\"")
    public ComprovantesExtratoTela tocarBotaoCompartilhar() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilhar);
        tocarElemento(botaoCompartilhar, "Não foi possível clicar no botão Compartilhar");
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
     * Tocar na combo 'Serviços'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar na combo 'Serviços'")
    public ComprovantesExtratoTela tocarComboServico() throws NextException {
        salvarEvidencia("Tocar na combo 'Serviço'");
        tocarElemento(comboServico, "Erro ao tocar na combo 'Serviço'");
        return this;
    }

    /**
     * Tocar na combo 'Transação'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar na combo 'Transação'")
    public ComprovantesExtratoTela tocarComboTransacao() throws NextException {
        salvarEvidencia("Tocar na combo 'Transação'");
        tocarElemento(comboTransacao, "Erro ao tocar na combo 'Transação'");
        return this;
    }

    /**
     * Tocar botão (header) 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão (header) 'Voltar'")
    public ComprovantesExtratoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botão (header) 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar botão (header) 'Voltar'");
        return this;
    }
}
