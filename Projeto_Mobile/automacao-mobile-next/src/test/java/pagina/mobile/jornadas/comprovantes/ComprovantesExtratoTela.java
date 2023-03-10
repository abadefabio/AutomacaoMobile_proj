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

    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneServišo")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\",Lista suspensa,SelecioneServišo\"]\n")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon expansible cell\"])[1]")
    private MobileElement selecionarServicos;

    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement confirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Transferŕncias\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transferŕncias\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Transferŕncias\"`]\n")
    private MobileElement escolherServico;

    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneTransašŃo")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon expansible cell\"])[2]")
    private MobileElement selecionarTransacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Transferŕncia Interbancßria\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transferŕncia Interbancßria\"")
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TRANSFER╩NCIA\"]")
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

    @iOSXCUITFindBy(xpath = "//*[@name='Servišo']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nfpc_receipt_service")
    private MobileElement comboServico;

    @iOSXCUITFindBy(xpath = "//*[@name='TransašŃo']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nfpc_receipt_transaction")
    private MobileElement comboTransacao;

    @AndroidFindBy(xpath = "//*[@text=\"Ixi, nŃo temos comprovante pra essa busca que vocŕ fez\"]")
    private MobileElement mensagemTela;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VOLTAR']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @AndroidFindBy(accessibility = "Voltar, BotŃo")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(xpath = "//*[contains(@text, 'VOLTAR') or contains(@text, 'voltar')]")
    private MobileElement botaoVoltar;

    public ComprovantesExtratoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar Ýcone "Comprovantes"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar Ýcone \"Comprovantes\"")
    public ComprovantesExtratoTela tocarBotaoComprovantes() throws Exception {
        aguardarCarregamentoElemento(botaoComprovantes);
        tocarElemento(botaoComprovantes, "NŃo foi possÝvel tocar no Ýcone \"Comprovantes\"");
        salvarEvidencia("Tocar no Ýcone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar Ýcone "Extratos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar Ýcone \"Extratos\"")
    public ComprovantesExtratoTela tocarBotaoExtratos() throws Exception {
        aguardarCarregamentoElemento(botaoExtratos);
        tocarElemento(botaoExtratos, "NŃo foi possÝvel tocar no Ýcone \"Comprovantes\"");
        salvarEvidencia("Tocar no Ýcone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar Ýcone "Informe de Rendimentos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar Ýcone \"Informe de Rendimentos\"")
    public ComprovantesExtratoTela tocarBotaoInformeRendimentos() throws Exception {
        aguardarCarregamentoElemento(botaoInformeRendimentos);
        tocarElemento(botaoInformeRendimentos, "NŃo foi possÝvel tocar no Ýcone \"Comprovantes\"");
        salvarEvidencia("Tocar no Ýcone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar Ýcone "Objetivos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar Ýcone \"Objetivos\"")
    public ComprovantesExtratoTela tocarBotaoObjetivos() throws Exception {
        aguardarCarregamentoElemento(botaoObjetivos);
        tocarElemento(botaoObjetivos, "NŃo foi possÝvel tocar no Ýcone \"Comprovantes\"");
        salvarEvidencia("Tocar no Ýcone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar Ýcone "Investimentos"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar Ýcone \"Investimentos\"")
    public ComprovantesExtratoTela tocarBotaoInvestimentos() throws Exception {
        aguardarCarregamentoElemento(botaoInvestimentos);
        salvarEvidencia("Tocar no Ýcone \"Investimentos\"");
        tocarElemento(botaoInvestimentos, "NŃo foi possÝvel tocar no Ýcone \"Investimentos\"");
        return this;
    }

    /**
     * Tocar Ýcone "Pix"
     *
     * @return ComprovantesTela
     * @throws Exception
     */
    @Step("Tocar Ýcone \"Pix\"")
    public ComprovantesExtratoTela tocarBotaoPix() throws Exception {
        aguardarCarregamentoElemento(botaoPix);
        tocarElemento(botaoPix, "NŃo foi possÝvel tocar no Ýcone \"Comprovantes\"");
        salvarEvidencia("Tocar no Ýcone \"Comprovantes\"");
        return this;
    }

    /**
     * Tocar em "Servišos"
     *
     * @throws Exception
     */
    @Step("Tocar opšŃo \"Servicos\"")
    public ComprovantesExtratoTela selecionarServicos() throws Exception {
        aguardarCarregamentoElemento(selecionarServicos);
        salvarEvidencia("Tocar em \"Servišos\"");
        tocarElemento(selecionarServicos, "NŃo foi possÝvel tocar em \"Servišos\"");
        return this;
    }

    /**
     * Selecionar "Servišo"
     *
     * @param s
     * @throws Exception
     */
    @Step("Tocar no \"Servicos\"")
    public ComprovantesExtratoTela escolherServico(String s) throws Exception {
        if (getDriver() instanceof IOSDriver) {
            rolarTelaAteFinal();
            tocarElemento(confirmar, "NŃo foi possÝvel tocar em \"Confirmar\"");
            salvarEvidencia("Tocar no \"Servišo\"");
        } else {
            aguardarCarregamentoElemento(escolherServico);
            salvarEvidencia("Tocar no \"Servišo\"");
            tocarElemento(escolherServico, "NŃo foi possÝvel tocar no \"Servišo\"");
        }
        return this;
    }


    /**
     * Tocar na "TransašŃo"
     *
     * @throws Exception
     */
    @Step("Tocar em \"TransašŃo\"")
    public ComprovantesExtratoTela selecionarTransacao() throws Exception {
        aguardarCarregamentoElemento((selecionarTransacao));
        salvarEvidencia("Tocar em \"TransašŃo\"");
        tocarElemento(selecionarTransacao, "NŃo foi possÝvel tocar em \"transašŃo\"");
        return this;
    }


    /**
     * Selecionar "TransašŃo"
     *
     * @param transferenciaInterbancaria
     * @throws Exception
     */
    @Step("Tocar na \"TransašŃo\"")
    public ComprovantesExtratoTela escolherTransacao(ConsultaTransacao transferenciaInterbancaria) throws Exception {
        if (getDriver() instanceof IOSDriver) {
            rolarTelaAteFinal();
            tocarElemento(confirmar, "NŃo foi possÝvel tocar em \"Confirmar\"");
            salvarEvidencia("Tocar na \"TransašŃo\"");
        } else {
            aguardarCarregamentoElemento(escolherTransacao);
            salvarEvidencia("Tocar na \"TransašŃo\"");
            tocarElemento(escolherTransacao, "NŃo foi possÝvel tocar na \"transašŃo\"");
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
        tocarElemento(dataInicial, "NŃo foi possÝvel tocar na \"data inicial\"");
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
        tocarElemento(dataFinal, "NŃo foi possÝvel tocar na \"data final\"");
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
        tocarElemento(continuar, "NŃo foi possÝvel tocar em \"continuar\"");
        return this;
    }

    /**
     * Tocar em "Transferŕncias"
     *
     * @throws Exception
     */
    @Step("Tocar em \"Transferŕncias\"")
    public ComprovantesExtratoTela tocarTransferencia() throws Exception {
        aguardarCarregamentoElemento(tocarTransferencia);
        salvarEvidencia("Tocar em \"Transferŕncia\"");
        tocarElemento(tocarTransferencia, "NŃo foi possÝvel tocar em \"Transferŕncia\"");
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
        tocarElemento(tocarVisualizar, "NŃo foi possÝvel tocar em \"Visualizar\"");
        return this;
    }

    /**
     * Tocar botŃo 'Compartilhar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botŃo \"Compartilhar\"")
    public ComprovantesExtratoTela tocarBotaoCompartilhar() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilhar);
        tocarElemento(botaoCompartilhar, "NŃo foi possÝvel clicar no botŃo Compartilhar");
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
     * Tocar na combo 'Servišos'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar na combo 'Servišos'")
    public ComprovantesExtratoTela tocarComboServico() throws NextException {
        salvarEvidencia("Tocar na combo 'Servišo'");
        tocarElemento(comboServico, "Erro ao tocar na combo 'Servišo'");
        return this;
    }

    /**
     * Tocar na combo 'TransašŃo'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar na combo 'TransašŃo'")
    public ComprovantesExtratoTela tocarComboTransacao() throws NextException {
        salvarEvidencia("Tocar na combo 'TransašŃo'");
        tocarElemento(comboTransacao, "Erro ao tocar na combo 'TransašŃo'");
        return this;
    }

    /**
     * Tocar botŃo (header) 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botŃo (header) 'Voltar'")
    public ComprovantesExtratoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botŃo (header) 'Voltar'");
        tocarElemento(botaoVoltar, "NŃo foi possÝvel tocar botŃo (header) 'Voltar'");
        return this;
    }
}
