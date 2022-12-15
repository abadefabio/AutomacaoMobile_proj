package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EscolherDadosTela extends PaginaBase {

    public EscolherDadosTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Dados cadastrais\")]/parent::*/preceding-sibling::*")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dados cadastrais\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxDadosCadastrais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Informa��es complementares\")]/parent::*/preceding-sibling::*")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Informa��es complementares\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxInformacoesComplementares;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Saldo\")]/parent::*/preceding-sibling::*")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Saldo\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxSaldo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Limites\")]/parent::*/preceding-sibling::*")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Limites\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxLimites;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Extratos\")]/parent::*/preceding-sibling::*")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Extratos\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxExtratos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[contains(@text,\"Limite\")]/parent::*/preceding-sibling::*)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Limite\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxLimiteCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[contains(@text,\"Transa��es\")]/parent::*/preceding-sibling::*)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Transa��es\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxTransacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Faturas\")]/parent::*/preceding-sibling::*")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Faturas\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxFaturas;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Contratos de cr�dito\")]/parent::*/preceding-sibling::*")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Contratos de cr�dito\"]/parent::*/following-sibling::*")
    private MobileElement checkBoxContratosCreditos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nc_checkbox_permission")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`value == \"Selecionado\"`][1]")
    private MobileElement desmarcarCheckBox;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_selected_period")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Por quanto tempo quer compartilhar os dados?\"")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Por quanto')]")
    private MobileElement comboBoxPorQuantoTempoQuerCompartilharDados;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//*[contains(@text,'CONTINUAR')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONTINUAR\"]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'OK, CONTINUAR')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK, CONTINUAR\"]")
    @iOSXCUITFindBy(accessibility = "OK, CONTINUAR")
    private MobileElement botaoOkContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'OK, CONTINUAR')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VOLTAR AO IN�CIO\"]")
    @iOSXCUITFindBy(accessibility = "VOLTAR AO IN�CIO")
    private MobileElement botaoVoltarInicio;

    /**
     * Tocar check box  "Dados Cadastrais"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Dados Cadastrais\"")
    public EscolherDadosTela tocarCheckBoxDadosCadastrais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxDadosCadastrais,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Dados Cadastrais\"");
        tocarElemento(checkBoxDadosCadastrais, "N�o foi possivel tocar check box \"Dados Cadastrais\"");
        return this;
    }


    /**
     * Tocar check box  "Informacoes Complementares"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Informacoes Complementares\"")
    public EscolherDadosTela tocarCheckBoxInformacoesComplementares() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxInformacoesComplementares,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Informacoes Complementares\"");
        tocarElemento(checkBoxInformacoesComplementares, "N�o foi possivel tocar check box \"Informacoes Complementares\"");
        return this;
    }


    /**
     * Tocar check box  "Saldo"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Saldo\"")
    public EscolherDadosTela tocarCheckBoxSaldo() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxSaldo,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Saldo\"");
        tocarElemento(checkBoxSaldo, "N�o foi possivel tocar check box \"Saldo\"");
        return this;
    }

    /**
     * Tocar check box  "Limites"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Limites\"")
    public EscolherDadosTela tocarCheckBoxLimites() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxLimites,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Limites\"");
        tocarElemento(checkBoxLimites, "N�o foi possivel tocar check box \"Limites\"");
        return this;
    }

    /**
     * Tocar check box  "Extratos"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Extratos\"")
    public EscolherDadosTela tocarCheckBoxExtratos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxExtratos,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Extratos\"");
        tocarElemento(checkBoxExtratos, "N�o foi possivel tocar check box \"Extratos\"");
        return this;
    }

    /**
     * Tocar check box  "Limite Cartao"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Limite Cartao\"")
    public EscolherDadosTela tocarCheckBoxLimiteCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxLimiteCartao,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Limite Cartao\"");
        tocarElemento(checkBoxLimiteCartao, "N�o foi possivel tocar check box \"Limite Cartao\"");
        return this;
    }

    /**
     * Tocar check box  "Transacoes"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Transacoes\"")
    public EscolherDadosTela tocarCheckBoxTransacoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxTransacoes,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Transacoes\"");
        tocarElemento(checkBoxTransacoes, "N�o foi possivel tocar check box \"Transacoes\"");
        return this;
    }

    /**
     * Tocar check box  "Faturas"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Dados Cadastrais\"")
    public EscolherDadosTela tocarCheckBoxFaturas() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxFaturas,"N�o foi possivel rolar a tela ate o elemento.");
        tocarElemento(checkBoxFaturas, "N�o foi possivel tocar check box \"Faturas\"");
        return this;
    }

    /**
     * Tocar check box  "Contratos Creditos"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar Check box \"Contratos Creditos\"")
    public EscolherDadosTela tocarCheckBoxContratosCreditos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxContratosCreditos,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar check box \"Contratos Creditos\"");
        tocarElemento(checkBoxContratosCreditos, "N�o foi possivel tocar check box \"Contratos Creditos\"");
        return this;
    }

    /**
     * Tocar "botao Continuar"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar \"botao Continuar\"")
    public EscolherDadosTela tocarBotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar \"botao Continuar\"");
        tocarElemento(botaoContinuar, "N�o foi possivel tocar \"botao Continuar\"");
        return this;
    }

    /**
     * Tocar "botao Ok Continuar"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar \"botao Continuar\"")
    public EscolherDadosTela tocarBotaoOkContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOkContinuar,"N�o foi possivel rolar a tela ate o elemento.");
        salvarEvidencia("Tocar \"botao Ok Continuar\"");
        tocarElemento(botaoOkContinuar, "N�o foi possivel tocar \"botao OK Continuar\"");
        return this;
    }

    /**
     * Tocar em  um check box  "Contratos Creditos"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar em um Check box \"seguir fluxo\"")
    public EscolherDadosTela tocarCheckBoxParaRetirarSelecao() throws Exception {
        for (int i=0;i<9;i++) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(desmarcarCheckBox, "N�o foi possivel rolar a tela ate o elemento.");
            salvarEvidencia("Tocar check box para desmarcar");
            tocarElemento(desmarcarCheckBox, "N�o foi possivel tocar check box para retirar a sele��o.");
        }
        return this;
    }
}
